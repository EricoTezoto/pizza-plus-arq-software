package main.pizza;

public class PizzaCalabresa implements Pizza {

    @Override
    public String getNome() {
        return "Pizza de Calabresa";
    }

    @Override
    public double getPreco() {
        return 45.0;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando massa e adicionando calabresa, cebola e muçarela.");
    }

    @Override
    public void assar() {
        System.out.println("Assando a pizza de calabresa em forno a lenha por 15 minutos.");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando a pizza de calabresa em 8 fatias.");
    }

    @Override
    public void embalar() {
        System.out.println("Embalando a pizza de calabresa para entrega.");
    }
}
