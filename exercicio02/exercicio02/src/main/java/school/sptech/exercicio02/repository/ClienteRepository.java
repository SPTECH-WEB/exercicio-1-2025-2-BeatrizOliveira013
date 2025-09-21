package school.sptech.exercicio02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exercicio02.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
