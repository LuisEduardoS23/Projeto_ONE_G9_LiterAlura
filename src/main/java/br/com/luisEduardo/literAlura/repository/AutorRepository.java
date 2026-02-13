package br.com.luisEduardo.literAlura.repository;

import br.com.luisEduardo.literAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    public Optional<Autor> findByNomeIgnoreCase(String nome);
}
