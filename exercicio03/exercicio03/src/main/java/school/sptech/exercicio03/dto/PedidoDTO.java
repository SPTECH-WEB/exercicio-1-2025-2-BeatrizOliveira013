package school.sptech.exercicio03.dto;

import java.time.LocalDate;

public class PedidoDTO {

    private Integer id;
    private String descricao;
    private Double valorTotal;
    private LocalDate dataPedido;

    public PedidoDTO() {}

    public PedidoDTO(Integer id, String descricao, Double valorTotal, LocalDate dataPedido) {
        this.id = id;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public LocalDate getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDate dataPedido) { this.dataPedido = dataPedido; }
}
