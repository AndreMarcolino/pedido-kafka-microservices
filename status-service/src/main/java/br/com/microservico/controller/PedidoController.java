package br.com.microservico.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import br.com.microservico.model.Pedido;
import br.com.microservico.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoRepository repository;

    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getStatus(@PathVariable String id) {
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
}