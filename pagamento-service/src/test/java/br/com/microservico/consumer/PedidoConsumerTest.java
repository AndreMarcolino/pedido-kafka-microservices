package br.com.microservico.consumer;

import br.com.microservico.model.PedidoEvent;
import br.com.microservico.service.PedidoStatusProducer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class PedidoConsumerTest {

    @Test
    void deveConsumirEPagarPedido() {
        PedidoStatusProducer mockProducer = mock(PedidoStatusProducer.class);
        PedidoConsumer consumer = new PedidoConsumer(mockProducer);

        PedidoEvent event = new PedidoEvent("1", "Pedido", "CRIADO");

        consumer.consumir(event);

        verify(mockProducer, times(1)).enviarStatus(event);
    }
}