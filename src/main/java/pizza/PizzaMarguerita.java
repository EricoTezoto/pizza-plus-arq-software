package pizza;

public class PizzaMarguerita implements Pizza {

    @Override
    public String getNome() {
        return "Pizza Marguerita";
    }

    @Override
    public double getPreco() {
        return 42.0;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando massa e adicionando muçarela, tomate e manjericão.");
    }

    @Override
    public void assar() {
        System.out.println("Assando a pizza marguerita em forno elétrico por 12 minutos.");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando a pizza marguerita em 6 fatias.");
    }

    @Override
    public void embalar() {
        System.out.println("Embalando a pizza marguerita para retirada.");
    }
}
