# 🍕 PizzaPlus – Sistema de Pedidos com Padrões de Projeto

Este repositório contém o sistema **PizzaPlus**, desenvolvido em Java como parte de uma atividade acadêmica envolvendo o estudo e aplicação de padrões de projeto utilizando como base teórica a plataforma Refactoring.Guru.

O sistema utiliza **quatro padrões principais**:

- **Factory Method** – Criação de pizzas
- **Strategy** – Cálculo de frete (e futuramente pagamento)
- **Singleton** – Configuração global do sistema ou Gerenciador de Pedidos
- **Observer** – Notificação de mudança no status do pedido

---

## 📁 Estrutura do Projeto

/src/main/
pizza/ -> Factory Method (modelos de Pizza + fábrica)
frete/ -> Strategy (cálculo de frete)
pagamento/ -> Strategy (pagamento)
observer/ -> Observer (status do pedido)
core/ -> Modelos principais (Pedido, Cliente, etc.)
config/ -> Singleton (config ou gerenciador)
App.java -> Classe principal (demonstração)

---

## 🎯 Objetivo da Aplicação

O PizzaPlus simula um sistema de pedidos de uma pizzaria online, permitindo:

- Criar pizzas de diferentes tipos
- Calcular frete utilizando estratégias distintas
- Acompanhar mudança de status dos pedidos (Observer)
- Gerenciar configurações globais (Singleton)

---

## 📚 Documentação

O arquivo **RESUMO.md** contém:
- Explicação detalhada dos padrões utilizados
- Motivações para cada padrão
- Estrutura conceitual com base no Refactoring.Guru
- Justificativa da aplicação prática no sistema

---

## ▶ Como executar

```bash
javac src/main/App.java
java src/main/App


## 📄 Licença

MIT License.