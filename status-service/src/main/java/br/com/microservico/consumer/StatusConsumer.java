package br.com.microservico.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import br.com.microservico.model.Pedido;
import br.com.microservico.model.PedidoEvent;
import br.com.microservico.repository.PedidoRepository;

@Component
public class StatusConsumer {
    private final PedidoRepository repository;

    public StatusConsumer(PedidoRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "status-pedidos", groupId = "grupo-status")
    public void atualizarStatus(PedidoEvent event) {
        Pedido pedido = repository.findById(event.getId()).orElse(new Pedido());
        pedido.setId(event.getId());
        pedido.setDescricao(event.getDescricao());
        pedido.setStatus(event.getStatus());
        repository.save(pedido);
    }
}