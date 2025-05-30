package br.com.microservico.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import br.com.microservico.model.PedidoEvent;

@Service
public class PedidoStatusProducer {
    private final KafkaTemplate<String, PedidoEvent> kafkaTemplate;

    public PedidoStatusProducer(KafkaTemplate<String, PedidoEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarStatus(PedidoEvent event) {
        kafkaTemplate.send("status-pedidos", event);
    }
}