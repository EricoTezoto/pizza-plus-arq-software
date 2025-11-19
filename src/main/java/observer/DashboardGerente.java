package observer;

public class DashboardGerente implements Observer {

    @Override
    public void atualizar(String statusPedido) {
        System.out.println("Dashboard do Gerente: Pedido status atualizado para: " + statusPedido);
    }
}
