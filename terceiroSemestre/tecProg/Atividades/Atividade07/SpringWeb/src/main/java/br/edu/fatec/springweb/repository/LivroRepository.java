package br.edu.fatec.springweb.repository;

import br.edu.fatec.springweb.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
