package pucpr.bsi.ws.pedidos.services;

import org.springframework.stereotype.Component;
import pucpr.bsi.ws.pedidos.models.Pedido;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidosService {
    private List<Pedido> pedidos;

    public PedidosService() {
        pedidos = new ArrayList<Pedido>();
        pedidos.add(new Pedido(1L, "fulano"));
        pedidos.add(new Pedido(2L, "josé"));
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
