import pizza.Pizza;
import pizza.PizzaFactory;
import pizza.PizzaTipo;
import frete.CalculadoraFrete;
import frete.FreteRapido;
import observer.Pedido;
import observer.PainelCozinha;
import observer.AppCliente;
import observer.DashboardGerente;
import config.ConfigSistema;

public class App {
    public static void main(String[] args) {
        ConfigSistema config = ConfigSistema.getInstance();

        System.out.println("=== " + config.getNomeLoja() + " iniciado ===");
        System.out.println("Taxa de Desconto: " + (config.getTaxaDesconto() * 100) + "%");

        Pizza pizza = PizzaFactory.criarPizza(PizzaTipo.CALABRESA);

        System.out.println("\nPedido recebido: " + pizza.getNome());
        System.out.println("Preço: R$ " + pizza.getPreco());

        pizza.preparar();
        pizza.assar();
        pizza.cortar();
        pizza.embalar();

        double distanciaKm = 8.0;
        CalculadoraFrete calculadora = new CalculadoraFrete();

        calculadora.setEstrategia(new FreteRapido());
        double freteRapido = calculadora.calcular(distanciaKm, pizza.getPreco());
        System.out.println("\nEstratégia: " + calculadora.getNomeEstrategiaAtual());
        System.out.println("Distância: " + distanciaKm + " km");
        System.out.println("Frete: R$ " + freteRapido);

        Pedido pedido = new Pedido();
        pedido.adicionarObservador(new PainelCozinha());
        pedido.adicionarObservador(new AppCliente());
        pedido.adicionarObservador(new DashboardGerente());

        pedido.setStatus("Em Preparação");
        pedido.setStatus("Saiu para Entrega");
        pedido.setStatus("Entregue");

        System.out.println("\nPedido finalizado!");
    }
}
