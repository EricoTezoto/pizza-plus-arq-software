# RESUMO DA ATIVIDADE DE PADRÕES E ARQUITETURA DE SOFTWARE
## Base teórica: Refactoring.Guru
## Aplicação prática: Sistema PizzaPlus
### Érico Conte Tezoto - 23004160
### Nicolas Keismanas - 23013693

---

## 1. Introdução

Este documento apresenta o estudo e a aplicação de quatro padrões de projeto baseados no material do site Refactoring.Guru, implementados na aplicação **PizzaPlus**, um sistema de pedidos de pizzaria desenvolvido em Java.

Os padrões utilizados foram:

- **Factory Method**
- **Strategy**
- **Singleton**
- **Observer**

O objetivo é demonstrar o entendimento conceitual de cada padrão, sua estrutura, justificativa de uso e a forma como foram incorporados à arquitetura do sistema PizzaPlus.

---

## 2. Padrões de Projeto Utilizados

---

### 2.1 Factory Method

**Propósito**  
O **Factory Method** define uma interface para criação de objetos, mas permite que as subclasses decidam qual classe concreta será instanciada. O padrão delega a lógica de criação a métodos “fábrica”, evitando a criação direta de objetos com `new` espalhada pelo código.

**Problema que resolve**
- Evita código com muitos `if/else` ou `switch` para decidir “qual classe instanciar”.
- Facilita a inclusão de novos tipos de produtos sem modificar o código cliente.
- Reduz acoplamento entre quem usa o objeto e a implementação concreta do objeto.

**Estrutura**
- **Creator (criador)**: classe que declara o método fábrica, geralmente `criarProduto()`.
- **ConcreteCreator(s)**: implementam o método fábrica e devolvem tipos concretos.
- **Product (produto)**: interface ou classe abstrata comum para os produtos.
- **ConcreteProduct(s)**: implementações específicas do produto.

**Quando usar**
- Quando houver **várias subclasses** de um mesmo tipo de produto.
- Quando a lógica de criação dos objetos for complexa ou variar conforme o contexto.
- Quando se deseja facilitar a extensão do sistema com novos tipos sem alterar código existente.

**Aplicação no PizzaPlus**  
Usado para criar pizzas a partir de um tipo informado, como `"CALABRESA"` ou `"MARGHERITA"`.

**Justificativa da aplicação**
- A pizzaria trabalha com vários sabores de pizza.
- Novos sabores podem ser adicionados com frequência.
- Centralizar a criação facilita a manutenção e a evolução da aplicação.

**Como o código ficaria diferente sem o padrão**
- Diversos trechos de código contendo `if (tipo.equals("CALABRESA")) new PizzaCalabresa() …`.
- Maior chance de erro e repetição de código.
- Dificuldade para localizar todos os pontos de criação ao alterar algo.

---

### 2.2 Strategy

**Propósito**  
O **Strategy** define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis em tempo de execução. O padrão permite que o algoritmo varie independentemente dos clientes que o utilizam.

**Problema que resolve**
- Código com muitos `if/else` para decidir qual lógica aplicar (“se frete rápido, calcula assim; se frete econômico, calcula assado…”).
- Necessidade de trocar o comportamento em tempo de execução sem alterar a estrutura do objeto.
- Lógicas de cálculo/política que podem se multiplicar com o tempo.

**Estrutura**
- **Strategy (estratégia)**: interface que define o método comum (por exemplo, `calcularFrete()`).
- **ConcreteStrategy(s)**: implementações diferentes da mesma operação.
- **Context (contexto)**: objeto que usa uma Strategy e delega a ela o comportamento variável.

**Quando usar**
- Quando existirem várias formas de executar uma mesma operação.
- Quando se quiser evitar condicionais extensas para selecionar o comportamento.
- Quando for desejável alterar o comportamento de um objeto em tempo de execução.

**Aplicação no PizzaPlus**  
Implementado para cálculo de frete:
- Entrega Rápida
- Entrega Econômica
- Retirada no Balcão

**Justificativa da aplicação**
- O cálculo de frete é uma política de negócio que pode mudar com o tempo.
- Permite que diferentes pedidos usem estratégias diferentes simultaneamente.
- Evita que o código fique cheio de condicionais.

**Como o código ficaria diferente sem o padrão**
- Um método `calcularFrete()` com vários `if/else` dentro de `Pedido`.
- Qualquer mudança no cálculo exigiria alterar esse método e recompilar tudo.
- Dificuldade para testar e reutilizar as estratégias.

---

### 2.3 Singleton

**Propósito**  
O **Singleton** garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global bem definido para essa instância.

**Problema que resolve**
- Situações em que apenas um objeto deve existir, por exemplo:
  - gerenciador de configuração;
  - gerenciador de pedidos;
  - conexão com um recurso centralizado (ex.: banco de dados, fila).

**Estrutura**
- Uma classe com:
  - construtor privado;
  - atributo estático para armazenar a instância única;
  - método público estático para retornar essa instância (`getInstance()`).

**Quando usar**
- Quando houver uma única fonte de verdade para determinado recurso/serviço.
- Quando for necessário controlar o acesso global a esse recurso.

**Aplicação no PizzaPlus**  
Para gerenciar configurações do sistema ou gerenciar a lista de pedidos.

**Justificativa da aplicação**
- Certas informações são únicas para o sistema como um todo.
- É conveniente ter um ponto de acesso único e controlado.

**Como o código ficaria diferente sem o padrão**
- Múltiplas instâncias de configuração espalhadas, com risco de divergência.
- Acesso desorganizado a dados globais.

---

### 2.4 Observer

**Propósito**  
O **Observer** define uma relação de dependência “um-para-muitos”, em que, quando o estado de um objeto (Subject) muda, todos os seus dependentes (Observers) são notificados e atualizados automaticamente.

**Problema que resolve**
- Necessidade de notificar vários componentes quando algo muda de estado (sem acoplá-los fortemente).
- Evitar que o objeto principal (Subject) precise conhecer diretamente todos os detalhes de quem está interessado em suas mudanças.

**Estrutura**
- **Subject**: mantém lista de observadores e notifica todos quando seu estado muda.
- **Observer**: interface com método de atualização (ex.: `atualizar()`).
- **ConcreteSubject**: implementação real que dispara eventos de mudança.
- **ConcreteObserver(s)**: componentes que reagem às mudanças (UI, logs, relatórios etc.).

**Quando usar**
- Quando eventos de mudança precisam ser disparados para múltiplos inter
