package br.com.microservico.service;

import br.com.microservico.model.PedidoEvent;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import static org.mockito.Mockito.*;

class PedidoStatusProducerTest {

    @Test
    void deveEnviarStatus() {
        KafkaTemplate<String, PedidoEvent> kafkaTemplate = mock(KafkaTemplate.class);
        PedidoStatusProducer producer = new PedidoStatusProducer(kafkaTemplate);

        PedidoEvent event = new PedidoEvent("1", "Pedido", "PAGO");

        producer.enviarStatus(event);

        verify(kafkaTemplate, times(1)).send("status-pedidos", event);
    }
}