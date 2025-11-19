package config;

public class ConfigSistema {

    // Instância única da classe (Singleton)
    private static ConfigSistema instance;

    // Configurações globais
    private String nomeLoja;
    private double taxaDesconto;

    // Construtor privado (evita instância externa)
    private ConfigSistema() {
        nomeLoja = "PizzaPlus";
        taxaDesconto = 0.1;  // Exemplo de 10% de desconto
    }

    // Método para obter a instância única da classe
    public static ConfigSistema getInstance() {
        if (instance == null) {
            instance = new ConfigSistema();
        }
        return instance;
    }

    // Métodos de configuração
    public String getNomeLoja() {
        return nomeLoja;
    }

    public double getTaxaDesconto() {
        return taxaDesconto;
    }
}
