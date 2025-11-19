package observer;

public class PainelCozinha implements Observer {

    @Override
    public void atualizar(String statusPedido) {
        System.out.println("Painel da Cozinha: Pedido status atualizado para: " + statusPedido);
    }
}
