package school.sptech.exercicio01.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exercicio01.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

 //  List<Livro> findByAutor(String autor);
}
