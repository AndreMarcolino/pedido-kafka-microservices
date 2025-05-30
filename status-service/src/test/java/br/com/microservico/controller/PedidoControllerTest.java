package br.com.microservico.controller;

import br.com.microservico.model.Pedido;
import br.com.microservico.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoControllerTest {

    @Test
    void deveRetornarStatusPedidoExistente() {
        Pedido pedido = new Pedido("1", "Teste", "PAGO");
        PedidoRepository repo = mock(PedidoRepository.class);
        when(repo.findById("1")).thenReturn(Optional.of(pedido));

        PedidoController controller = new PedidoController(repo);
        ResponseEntity<Pedido> response = controller.getStatus("1");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("PAGO", response.getBody().getStatus());
    }

    @Test
    void deveRetornarNotFoundSePedidoNaoExiste() {
        PedidoRepository repo = mock(PedidoRepository.class);
        when(repo.findById("2")).thenReturn(Optional.empty());

        PedidoController controller = new PedidoController(repo);
        ResponseEntity<Pedido> response = controller.getStatus("2");

        assertEquals(404, response.getStatusCodeValue());
    }
}