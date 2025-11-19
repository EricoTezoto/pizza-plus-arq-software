# 🍕 PizzaPlus – Sistema de Pedidos com Padrões de Projeto

Este repositório contém o sistema **PizzaPlus**, desenvolvido em Java como parte de uma atividade acadêmica envolvendo o estudo e aplicação de padrões de projeto utilizando como base teórica a plataforma Refactoring.Guru.

O sistema utiliza **quatro padrões principais**:

- **Factory Method** – Criação das pizzas de forma flexível
- **Strategy** – Cálculo de frete com comportamentos intercambiáveis
- **Singleton** – Gerenciamento de configurações globais do sistema
- **Observer** – Notificação automática quando o status do pedido muda

---

## 🧩 **Padrões de Projeto Utilizados**

Os seguintes padrões foram implementados no sistema:

1. **Factory Method**: Para a criação de diferentes tipos de pizzas (como Calabresa, Marguerita e Quatro Queijos), garantindo uma separação clara de responsabilidades e facilitando a inclusão de novos sabores.
2. **Strategy**: Para o cálculo do frete, permitindo diferentes estratégias de entrega (como frete rápido, econômico e retirada no balcão) sem alterar o código do sistema principal.
3. **Singleton**: Para a criação de uma instância única de configuração do sistema (como nome da loja e taxa de desconto), garantindo consistência e evitando múltiplas instâncias.
4. **Observer**: Para atualizar automaticamente os componentes (como painel da cozinha, app do cliente e dashboard do gerente) quando o status do pedido muda, sem acoplamento direto entre eles.

---

## 📁 **Estrutura do Projeto**


/src/main/
pizza/ -> Factory Method (pizzas e fábrica)
frete/ -> Strategy (cálculo de frete)
observer/ -> Observer (status do pedido)
core/ -> Modelos principais (Pedido, Cliente etc.)
config/ -> Singleton (configurações ou gerenciador)
App.java -> Classe principal

---

## 🎯 **Objetivo da Aplicação**

O **PizzaPlus** simula um sistema de pedidos de uma pizzaria online.

Ele permite:

- Criar pizzas de diferentes sabores usando uma fábrica.
- Calcular o valor do frete com diferentes estratégias.
- Acompanhar a mudança de status do pedido (Observer).
- Gerenciar configurações do sistema em uma única instância global (Singleton).

---

## 📚 **Documentação Teórica**

O arquivo **RESUMO.md** contém:
- Explicação detalhada dos padrões utilizados.
- Motivações para a escolha de cada padrão.
- Justificativas da aplicação de cada padrão no sistema.
- Comparações entre os padrões e variações possíveis.

---

## ▶ **Como executar o projeto**

### 🖥 Via IDE

Abra o projeto em:

IntelliJ IDEA

Eclipse

VSCode com extensão Java

E rode a classe:

App.java

### 🔧 Via terminal
```bash
javac -d out src/main/java/App.java src/main/java/pizza/*.java src/main/java/frete/*.java
java -cp out App
```
## 📄 Licença

Licenciado sob a MIT License.