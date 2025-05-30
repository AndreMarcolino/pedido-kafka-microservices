package br.com.microservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.microservico.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}