package school.sptech.exercicio03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exercicio03.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
