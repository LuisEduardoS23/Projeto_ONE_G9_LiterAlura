package br.com.luisEduardo.literAlura.repository;

import br.com.luisEduardo.literAlura.model.Autor;
import br.com.luisEduardo.literAlura.model.Idioma;
import br.com.luisEduardo.literAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT a FROM Livro l JOIN l.autor a")
    List<Autor> retornarAutoresRegistrados();

    @Query("SELECT a FROM Livro l JOIN l.autor a WHERE a.anoNascimento <= :ano AND a.anoMorte >= :ano")
    List<Autor> retornarAutoresVivosEm(Long ano);

    @Query("SELECT l FROM Livro l ORDER BY l.NumeroDownloads DESC")
    List<Livro> retornarTop3LivrosBaixados();

    Optional<Livro> findLivroByTitulo(String titulo);

    @Query("SELECT l FROM Livro l WHERE l.idioma = :linguagem")
    List<Livro> retornarLivrosPorIdioma(Idioma linguagem);
}
