package br.com.microservico.model;

public class PedidoEvent {
    private String id;
    private String descricao;
    private String status;

    public PedidoEvent() {}

    public PedidoEvent(String id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}