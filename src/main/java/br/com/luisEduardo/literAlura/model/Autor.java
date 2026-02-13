package br.com.luisEduardo.literAlura.model;

import br.com.luisEduardo.literAlura.dto.AutorApiResponse;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long anoNascimento;
    private Long anoMorte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();

    public Autor() {}

    public Autor(AutorApiResponse autorApiResponse) {
        this.nome = autorApiResponse.nome();
        this.anoNascimento = autorApiResponse.anoNascimento();
        this.anoMorte = autorApiResponse.anoMorte();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getAnoNascimento() {
        return anoNascimento;
    }

    public Long getAnoMorte() {
        return anoMorte;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "\n Autor =" + nome+
                "\n Ano de Nascimento = " + anoNascimento +
                "\n Ano de Falecimento = " + anoMorte +
                "\n Livros Registrados = " + livros.stream().map(Livro::getTitulo).collect(Collectors.joining(", "));
    }
}
