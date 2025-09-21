package school.sptech.exercicio03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.exercicio03.dto.PedidoDTO;
import school.sptech.exercicio03.model.Pedido;
import school.sptech.exercicio03.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public PedidoDTO salvar(PedidoDTO dto) {
        Pedido pedido = new Pedido(
                dto.getId(),
                dto.getDescricao(),
                dto.getValorTotal(),
                dto.getDataPedido()
        );
        Pedido salvo = repository.save(pedido);
        return toDTO(salvo);
    }

    public List<PedidoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PedidoDTO> buscarPorId(Integer id) {
        return repository.findById(id).map(this::toDTO);
    }

    public PedidoDTO atualizar(Integer id, PedidoDTO dto) {
        return repository.findById(id).map(pedido -> {
            pedido.setDescricao(dto.getDescricao());
            pedido.setValorTotal(dto.getValorTotal());
            pedido.setDataPedido(dto.getDataPedido());
            return toDTO(repository.save(pedido));
        }).orElse(null);
    }

    public boolean deletar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private PedidoDTO toDTO(Pedido pedido) {
        return new PedidoDTO(
                pedido.getId(),
                pedido.getDescricao(),
                pedido.getValorTotal(),
                pedido.getDataPedido()
        );
    }
}
