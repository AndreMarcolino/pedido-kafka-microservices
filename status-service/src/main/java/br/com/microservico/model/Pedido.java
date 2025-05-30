package br.com.microservico.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido {
    @Id
    private String id;
    private String status;
    private String descricao;

    public Pedido() {}

    public Pedido(String id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}