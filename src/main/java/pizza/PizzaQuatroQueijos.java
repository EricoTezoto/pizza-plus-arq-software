package pizza;

public class PizzaQuatroQueijos implements Pizza {

    @Override
    public String getNome() {
        return "Pizza Quatro Queijos";
    }

    @Override
    public double getPreco() {
        return 49.0;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando massa e adicionando muçarela, parmesão, provolone e gorgonzola.");
    }

    @Override
    public void assar() {
        System.out.println("Assando a pizza quatro queijos em forno a gás por 14 minutos.");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando a pizza quatro queijos em 8 fatias.");
    }

    @Override
    public void embalar() {
        System.out.println("Embalando a pizza quatro queijos com proteção extra por causa do queijo.");
    }
}
