package br.com.microservico.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import br.com.microservico.model.PedidoEvent;
import br.com.microservico.service.PedidoStatusProducer;

@Component
public class PedidoConsumer {
    private final PedidoStatusProducer statusProducer;

    public PedidoConsumer(PedidoStatusProducer statusProducer) {
        this.statusProducer = statusProducer;
    }

    @KafkaListener(topics = "pedidos", groupId = "grupo-pagamento")
    public void consumir(PedidoEvent event) {
        event.setStatus("PAGO");
        statusProducer.enviarStatus(event);
    }
}