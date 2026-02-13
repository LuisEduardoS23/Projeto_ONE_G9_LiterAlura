package br.com.luisEduardo.literAlura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Long NumeroDownloads;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro() {}

    public Livro(String titulo, String linguagem, Long numeroDownloads) {
        this.titulo = titulo;
        this.idioma = Idioma.fromCodigo(linguagem);
        NumeroDownloads = numeroDownloads;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma.getCodigo();
    }

    public Long getNumeroDownloads() {
        return NumeroDownloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\n Livro = " + titulo +
                "\n Idioma =" + idioma.getCodigo() +
                "\n Numero de Downloads = " + NumeroDownloads +
                "\n Autor = " + autor.getNome();
    }
}
