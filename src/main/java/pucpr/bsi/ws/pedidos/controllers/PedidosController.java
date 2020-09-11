package pucpr.bsi.ws.pedidos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pucpr.bsi.ws.pedidos.models.Pedido;
import pucpr.bsi.ws.pedidos.services.PedidosService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/pedidos")
    public List<Pedido> getPedidos() {
        return pedidosService.getPedidos();
    }

    @GetMapping("/pedidos/{idPedido}")
    public Pedido getPedido(@PathVariable Long idPedido) {
        Pedido pedido = null;
        for (Pedido p : pedidosService.getPedidos()) {
            if (p.getId().equals(idPedido)) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado");
        }
        return pedido;
    }

    @PostMapping("/pedidos")
    public ResponseEntity addPedidos(@RequestBody Pedido pedido) throws URISyntaxException {
        long id = pedidosService.getPedidos().size() + 1;
        pedido.setId(id);
        pedidosService.getPedidos().add(pedido);

        return ResponseEntity.created(new URI("/pedidos/" + id)).build();
    }

    @PutMapping("/pedidos/{idPedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePedido(@PathVariable Long idPedido,
                             @RequestBody Pedido pedido) {

        List<Pedido> pedidos = pedidosService.getPedidos();
        for (int i=0; i<pedidos.size(); i++) {
            if (pedidos.get(i).getId().equals(idPedido)) {

                pedido.setId(idPedido);
                pedidos.set(i, pedido);
                return;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Pedido não encontrado");
    }

}
