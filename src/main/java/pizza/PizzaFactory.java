package pizza;

public class PizzaFactory {

    public static Pizza criarPizza(PizzaTipo tipo) {
        switch (tipo) {
            case CALABRESA:
                return new PizzaCalabresa();
            case MARGHERITA:
                return new PizzaMarguerita();
            case QUATRO_QUEIJOS:
                return new PizzaQuatroQueijos();
            default:
                throw new IllegalArgumentException("Tipo de pizza não suportado: " + tipo);
        }
    }
}
