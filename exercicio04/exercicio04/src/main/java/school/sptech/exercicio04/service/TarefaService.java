package school.sptech.exercicio04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.exercicio04.dto.TarefaDTO;
import school.sptech.exercicio04.model.Tarefa;
import school.sptech.exercicio04.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public TarefaDTO salvar(TarefaDTO dto) {
        Tarefa tarefa = new Tarefa(
                dto.getId(),
                dto.getDescricao(),
                dto.getConcluido()
        );
        Tarefa salva = repository.save(tarefa);
        return toDTO(salva);
    }

    public List<TarefaDTO> listarTodas() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TarefaDTO> buscarPorId(Integer id) {
        return repository.findById(id).map(this::toDTO);
    }

    public TarefaDTO atualizar(Integer id, TarefaDTO dto) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setDescricao(dto.getDescricao());
            tarefa.setConcluido(dto.getConcluido());
            return toDTO(repository.save(tarefa));
        }).orElse(null);
    }

    public boolean deletar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private TarefaDTO toDTO(Tarefa tarefa) {
        return new TarefaDTO(
                tarefa.getId(),
                tarefa.getDescricao(),
                tarefa.getConcluido()
        );
    }
}
