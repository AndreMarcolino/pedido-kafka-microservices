package br.com.microservico.service;

import br.com.microservico.model.Pedido;
import br.com.microservico.model.PedidoEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;
import static org.mockito.Mockito.*;

class PedidoProducerTest {

    @Test
    void deveEnviarEventoDePedido() {
        KafkaTemplate<String, PedidoEvent> kafkaTemplate = Mockito.mock(KafkaTemplate.class);
        PedidoProducer producer = new PedidoProducer(kafkaTemplate);

        Pedido pedido = new Pedido("1", "Teste pedido", "CRIADO");

        producer.enviarPedido(pedido);

        verify(kafkaTemplate, times(1)).send(eq("pedidos"), any(PedidoEvent.class));
    }
}