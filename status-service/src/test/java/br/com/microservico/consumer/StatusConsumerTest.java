package br.com.microservico.consumer;

import br.com.microservico.model.Pedido;
import br.com.microservico.model.PedidoEvent;
import br.com.microservico.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.mockito.Mockito.*;

class StatusConsumerTest {

    @Test
    void deveAtualizarStatusPedido() {
        PedidoRepository repository = mock(PedidoRepository.class);
        when(repository.findById("1")).thenReturn(Optional.empty());

        StatusConsumer consumer = new StatusConsumer(repository);
        PedidoEvent event = new PedidoEvent("1", "Pedido", "PAGO");

        consumer.atualizarStatus(event);

        verify(repository).save(any(Pedido.class));
    }
}