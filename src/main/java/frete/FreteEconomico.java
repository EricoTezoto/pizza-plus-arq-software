package frete;

public class FreteEconomico implements FreteStrategy {

    @Override
    public double calcular(double distanciaKm, double valorPedido) {
        double taxaBase = 5.0;
        double custoPorKm = 1.5;
        double frete = taxaBase + (custoPorKm * distanciaKm);

        if (valorPedido >= 100.0) {
            frete *= 0.85;
        }

        return frete;
    }

    @Override
    public String getNome() {
        return "Frete Econômico";
    }
}
