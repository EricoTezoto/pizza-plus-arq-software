package frete;

public class FreteRetiradaBalcao implements FreteStrategy {

    @Override
    public double calcular(double distanciaKm, double valorPedido) {
        return 0.0;
    }

    @Override
    public String getNome() {
        return "Retirada no Balcão";
    }
}
