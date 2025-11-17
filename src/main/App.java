package main;

import main.pizza.Pizza;
import main.pizza.PizzaFactory;
import main.pizza.PizzaTipo;

public class App {
    public static void main(String[] args) {
        System.out.println("=== PizzaPlus iniciado ===");

        Pizza pizza = PizzaFactory.criarPizza(PizzaTipo.CALABRESA);

        System.out.println("\nPedido recebido: " + pizza.getNome());
        System.out.println("Preço: R$ " + pizza.getPreco());

        pizza.preparar();
        pizza.assar();
        pizza.cortar();
        pizza.embalar();

        System.out.println("\nPedido finalizado!");
    }
}
