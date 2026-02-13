package br.com.luisEduardo.literAlura.service;

import br.com.luisEduardo.literAlura.dto.ApiResponse;
import br.com.luisEduardo.literAlura.exceptions.*;
import br.com.luisEduardo.literAlura.integration.ConsumoApi;
import br.com.luisEduardo.literAlura.integration.ConverteDados;
import br.com.luisEduardo.literAlura.mapper.LivroMapper;
import br.com.luisEduardo.literAlura.model.Autor;
import br.com.luisEduardo.literAlura.model.Idioma;
import br.com.luisEduardo.literAlura.model.Livro;
import br.com.luisEduardo.literAlura.repository.AutorRepository;
import br.com.luisEduardo.literAlura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class LivroService {
    private Scanner input = new Scanner(System.in);
    private ConsumoApi api = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private LivroMapper mapper = new LivroMapper();

    @Autowired
    private LivroRepository repository;

    @Autowired
    private AutorRepository autorRepository;


    public String gerarUrlBuscaExterna(String palavraBuscada){
        palavraBuscada = palavraBuscada.replaceAll(" ", "+");
        return "https://gutendex.com/books/?search=" + palavraBuscada;
    }


    public void buscarCadastrarLivro() throws LivroRepetidoException {
        System.out.println("Insira o nome do livro que deseja buscar");
        var nomeLivro = input.nextLine();

        String json = api.consumirDados(gerarUrlBuscaExterna(nomeLivro));
        ApiResponse responseApi = conversor.converterDados(json, ApiResponse.class);

        Livro novoLivro = mapper.converterPrimeiroLivroApiResponse(responseApi);

        Optional<Livro> livroRepetido = repository.findLivroByTitulo(novoLivro.getTitulo());
        if (livroRepetido.isPresent()) {
            throw new LivroRepetidoException();
        }

        Optional<Autor> autorRepetido = autorRepository.findByNomeIgnoreCase(novoLivro.getAutor().getNome());
        if(autorRepetido.isPresent()) {
            novoLivro.setAutor(autorRepetido.get());
        }
        else{
            autorRepository.save(novoLivro.getAutor());
        }

        repository.save(novoLivro);
        System.out.println(novoLivro);
    }


    public void listarLivrosRegistrados() throws NenhumLivroRegistradoException {
        System.out.println("=========== LIVROS REGISTRADOS ==========\n");
        List<Livro> livrosRegistrados = repository.findAll();
        if(livrosRegistrados.isEmpty()){
            throw new NenhumLivroRegistradoException();
        }
        livrosRegistrados.forEach(System.out::println);
        System.out.println("\n");

    }

    public void listarAutoresRegistrados() throws NenhumAutorRegistradoException {
        System.out.println("=========== AUTORES REGISTRADOS ==========\n");
        List<Autor> autoresRegistrados = repository.retornarAutoresRegistrados();
        if(autoresRegistrados.isEmpty()){
            throw new NenhumAutorRegistradoException();
        }
        autoresRegistrados.forEach(System.out::println);
        System.out.println("\n");
    }

    public void listarAutoresVivosEmDeterminadoPeriodo() throws NenhumAutorEncontradoException {
        System.out.println("Insira o ano que deseja buscar:");
        var ano = Long.parseLong(input.nextLine());

        List<Autor> autoresEncontrados = repository.retornarAutoresVivosEm(ano);
        if(autoresEncontrados.isEmpty()){
            throw new NenhumAutorEncontradoException();
        }
        autoresEncontrados.forEach(System.out::println);
        System.out.println("\n");
    }

    public void listarLivrosEmDeterminadoIdioma() throws idiomaInvalidoException, NenhumLivroEncontradoException {
        String menuIdiomas = """
                Idiomas disponíveis para busca
                es - Espanhol
                en - Inglês
                fr - Francês
                pt - Português
                Insira o idioma para realizar a busca:
                """;
        System.out.println(menuIdiomas);
        var idioma = input.nextLine();

        Idioma idiomaEnum;

        try {
            idiomaEnum = Idioma.fromCodigo(idioma);
        } catch (IllegalArgumentException e) {
            throw new idiomaInvalidoException();
        }

        List<Livro> livrosIdioma = repository.retornarLivrosPorIdioma(idiomaEnum);
        if(livrosIdioma.isEmpty()){
            throw new NenhumLivroEncontradoException();
        }
        livrosIdioma.forEach(System.out::println);

    }

    public void listarTop3LivrosBaixados() {
        List<Livro> top3Livros = repository.retornarTop3LivrosBaixados();
        top3Livros.stream()
                .limit(3)
                .forEach(System.out::println);
        System.out.println("\n");
    }
}
