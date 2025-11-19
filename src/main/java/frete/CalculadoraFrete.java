package frete;

public class CalculadoraFrete {

    private FreteStrategy estrategia;

    public void setEstrategia(FreteStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(double distanciaKm, double valorPedido) {
        if (estrategia == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete definida.");
        }
        return estrategia.calcular(distanciaKm, valorPedido);
    }

    public String getNomeEstrategiaAtual() {
        return (estrategia != null) ? estrategia.getNome() : "Nenhuma estratégia definida";
    }
}
