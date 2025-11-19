package observer;

public class AppCliente implements Observer {

    @Override
    public void atualizar(String statusPedido) {
        System.out.println("App do Cliente: Pedido status atualizado para: " + statusPedido);
    }
}
