package school.sptech.exercicio04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exercicio04.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
