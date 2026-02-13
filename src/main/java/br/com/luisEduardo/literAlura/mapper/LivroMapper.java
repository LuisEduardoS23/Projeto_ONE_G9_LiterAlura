package br.com.luisEduardo.literAlura.mapper;

import br.com.luisEduardo.literAlura.dto.ApiResponse;
import br.com.luisEduardo.literAlura.dto.LivroApiResponse;
import br.com.luisEduardo.literAlura.exceptions.NenhumLivroEncontradoException;
import br.com.luisEduardo.literAlura.model.Autor;
import br.com.luisEduardo.literAlura.model.Livro;

public class LivroMapper {


    public Livro converterPrimeiroLivroApiResponse(ApiResponse apiResponse) {
            if(apiResponse.results() == null || apiResponse.results().isEmpty()){
                throw new NenhumLivroEncontradoException();
            }

            LivroApiResponse primeiroLivroApi = apiResponse.results().get(0);
            Autor primeiroAutor = new Autor(primeiroLivroApi.autor().getFirst());

            Livro livro = new Livro(primeiroLivroApi.titulo(),
                                    primeiroLivroApi.idioma().getFirst(),
                                    primeiroLivroApi.numeroDownloads());

            livro.setAutor(primeiroAutor);

            return livro;

    }

}
