package br.edu.fatec.springweb.repository;

import br.edu.fatec.springweb.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
