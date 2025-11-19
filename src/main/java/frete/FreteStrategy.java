package frete;

public interface FreteStrategy {
    /**
     * Calcula o valor do frete.
     *
     * @param distanciaKm Distância em quilômetros até o cliente
     * @param valorPedido Valor total do pedido
     * @return Valor do frete em reais
     */
    double calcular(double distanciaKm, double valorPedido);

    /**
     * Nome da estratégia para exibição.
     */
    String getNome();
}
