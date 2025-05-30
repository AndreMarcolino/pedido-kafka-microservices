package br.com.microservico.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import br.com.microservico.model.Pedido;
import br.com.microservico.model.PedidoEvent;

@Service
public class PedidoProducer {
    private final KafkaTemplate<String, PedidoEvent> kafkaTemplate;

    public PedidoProducer(KafkaTemplate<String, PedidoEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarPedido(Pedido pedido) {
        PedidoEvent event = new PedidoEvent(pedido.getId(), pedido.getDescricao(), "CRIADO");
        kafkaTemplate.send("pedidos", event);
    }
}