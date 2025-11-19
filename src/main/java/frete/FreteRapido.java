package frete;

public class FreteRapido implements FreteStrategy {

    @Override
    public double calcular(double distanciaKm, double valorPedido) {
        double taxaBase = 8.0;
        double custoPorKm = 2.5;
        return taxaBase + (custoPorKm * distanciaKm);
    }

    @Override
    public String getNome() {
        return "Frete Rápido";
    }
}