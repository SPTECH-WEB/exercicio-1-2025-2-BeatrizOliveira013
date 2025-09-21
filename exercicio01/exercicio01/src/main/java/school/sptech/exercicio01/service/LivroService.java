package school.sptech.exercicio01.service;


import org.springframework.stereotype.Service;
import school.sptech.exercicio01.dto.LivroDTO;
import school.sptech.exercicio01.model.Livro;
import school.sptech.exercicio01.repository.LivroRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public LivroDTO salvar(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setAnoPublicacao(dto.getAnoPublicacao());
        livro.setNota(dto.getNota());
        return toDTO(repository.save(livro));
    }

    public List<LivroDTO> listarTodos() {
        return repository.findAll()
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<LivroDTO> buscarPorId(Integer id) {
        return repository.findById(id).map(this::toDTO);
    }

    public Optional<LivroDTO> atualizar(Integer id, LivroDTO dto) {
        return repository.findById(id).map(livro -> {
            livro.setTitulo(dto.getTitulo());
            livro.setAutor(dto.getAutor());
            livro.setAnoPublicacao(dto.getAnoPublicacao());
            livro.setNota(dto.getNota());
            return toDTO(repository.save(livro));
        });
    }

    public boolean deletar(Integer id) {
        return repository.findById(id).map(livro -> {
            repository.delete(livro);
            return true;
        }).orElse(false);
    }

    private LivroDTO toDTO(Livro livro) {
        return new LivroDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAnoPublicacao(),
                livro.getNota()
        );
    }
}
