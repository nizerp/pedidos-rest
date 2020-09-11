package pucpr.bsi.ws.pedidos.models;

public class Pedido {
    private Long id;
    private String cliente;

    public Pedido(Long id, String cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

