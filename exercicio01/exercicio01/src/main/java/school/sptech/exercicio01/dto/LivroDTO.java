package school.sptech.exercicio01.dto;



public class LivroDTO {

    private Integer id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private Double nota;

    // Construtor vazio
    public LivroDTO() {}

    // Construtor completo
    public LivroDTO(Integer id, String titulo, String autor, Integer anoPublicacao, Double nota) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.nota = nota;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public Double getNota() {
        return nota;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
