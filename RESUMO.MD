# RESUMO DE PADRÕES DE PROJETO  
## Base teórica: Refactoring.Guru  
## Projeto: PizzaPlus – Sistema de Pedidos de Pizzaria Online

---

## 1. Introdução

Este documento apresenta um resumo teórico e aplicado de alguns padrões de projeto de software estudados com base no material do site Refactoring.Guru, bem como a justificativa de sua utilização na aplicação **PizzaPlus**, um sistema de pedidos de pizzaria online desenvolvido em Java.

O objetivo é demonstrar:
- a compreensão conceitual dos padrões,
- os problemas que eles resolvem,
- o contexto de uso recomendado,
- e a forma como foram incorporados à arquitetura do sistema.

Os padrões utilizados na aplicação são:
- **Factory Method**
- **Strategy**
- **Singleton**
- **Observer**

Eles foram escolhidos por se encaixarem de forma natural em cenários típicos de um sistema de pedidos (criação de produtos, estratégias de frete/pagamento, gerenciamento centralizado e notificação de mudanças de estado).

---

## 2. Padrões de Projeto Utilizados

### 2.1 Factory Method

**Propósito**  
O Factory Method define uma interface para criar objetos, mas permite que as subclasses decidam qual classe concreta será instanciada. O padrão delega a lógica de criação a métodos “fábrica”, evitando a criação direta de objetos com `new` espalhada pelo código.

**Problema que resolve**  
- Evitar código com muitos `if/else` ou `switch` para decidir “qual classe instanciar”.
- Facilitar a inclusão de novos tipos de produtos sem modificar o código cliente.
- Reduzir acoplamento entre quem usa o objeto e a implementação concreta do objeto.

**Estrutura conceitual**  
- **Creator (criador)**: classe que declara o método fábrica, geralmente `criarProduto()`.
- **ConcreteCreator(s)**: implementam o método fábrica e devolvem tipos concretos.
- **Product (produto)**: interface ou classe abstrata comum para os produtos.
- **ConcreteProduct(s)**: implementações específicas do produto.

**Quando usar**  
- Quando houver **várias subclasses** de um mesmo tipo de produto.
- Quando a lógica de criação dos objetos for complexa ou variar conforme o contexto.
- Quando se deseja facilitar a extensão do sistema com novos tipos sem alterar código existente.

**Vantagens**  
- Centraliza e organiza a criação de objetos.
- Reduz acoplamento entre código cliente e classes concretas.
- Facilita a extensão (Open/Closed Principle).

**Desvantagens**  
- Pode aumentar o número de classes (mais criadores/concretos).
- Introduz um nível extra de indireção.

---

### 2.2 Strategy

**Propósito**  
O Strategy define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis em tempo de execução. O padrão permite que o algoritmo varie independentemente dos clientes que o utilizam.

**Problema que resolve**  
- Código com muitos `if/else` para decidir qual lógica aplicar (“se frete rápido, calcula assim; se frete econômico, calcula assado…”).
- Necessidade de trocar o comportamento em tempo de execução sem alterar a estrutura do objeto.
- Lógicas de cálculo/política que podem se multiplicar com o tempo.

**Estrutura conceitual**  
- **Strategy (estratégia)**: interface que define o método comum (por exemplo, `calcularFrete()`).
- **ConcreteStrategy(s)**: implementações diferentes da mesma operação.
- **Context (contexto)**: objeto que usa uma Strategy e delega a ela o comportamento variável.

**Quando usar**  
- Quando existirem várias formas de executar uma mesma operação.
- Quando se quiser evitar condicionais extensas para selecionar o comportamento.
- Quando for desejável alterar o comportamento de um objeto em tempo de execução.

**Vantagens**  
- Elimina grandes blocos de condicionais.
- Facilita a inclusão de novas estratégias.
- Promove baixo acoplamento e alta coesão.

**Desvantagens**  
- Aumenta o número de classes.
- Pode ser exagero para cenários com poucas variações de comportamento.

---

### 2.3 Singleton

**Propósito**  
O Singleton garante que uma classe tenha **apenas uma instância** e fornece um ponto de acesso global bem definido para essa instância.

**Problema que resolve**  
- Situações em que apenas um objeto deve existir, por exemplo:
  - gerenciador de configuração;
  - gerenciador de pedidos;
  - conexão com um recurso centralizado (ex.: banco de dados, fila).

**Estrutura conceitual**  
- Uma classe com:
  - construtor privado;
  - atributo estático para armazenar a instância única;
  - método público estático para retornar essa instância (`getInstance()`).

**Quando usar**  
- Quando houver uma única fonte de verdade para determinado recurso/serviço.
- Quando for necessário controlar o acesso global a esse recurso.

**Vantagens**  
- Controle explícito de uma única instância.
- Facilita o acesso global ao recurso.

**Desvantagens**  
- Pode introduzir **acoplamento global** semelhante a variáveis globais.
- Dificulta testes (mock, injeção de dependência) se mal utilizado.
- Pode ser abusado para resolver qualquer problema de “acesso fácil”.

---

### 2.4 Observer

**Propósito**  
O Observer define uma relação de dependência “um-para-muitos”, em que, quando o estado de um objeto (Subject) muda, todos os seus dependentes (Observers) são notificados e atualizados automaticamente.

**Problema que resolve**  
- Necessidade de notificar vários componentes quando algo muda de estado (sem acoplá-los fortemente).
- Evitar que o objeto principal (Subject) precise conhecer diretamente todos os detalhes de quem está interessado em suas mudanças.

**Estrutura conceitual**  
- **Subject**: mantém lista de observadores e notifica todos quando seu estado muda.
- **Observer**: interface com método de atualização (ex.: `atualizar()`).
- **ConcreteSubject**: implementação real que dispara eventos de mudança.
- **ConcreteObserver(s)**: componentes que reagem às mudanças (UI, logs, relatórios etc.).

**Quando usar**  
- Quando eventos de mudança precisam ser disparados para múltiplos interessados.
- Quando se deseja baixo acoplamento entre a fonte de eventos e seus ouvintes.

**Vantagens**  
- Baixo acoplamento entre a origem do evento e os observadores.
- Fácil adicionar/remover observadores.
- Flexível para evolução (novos componentes podem ouvir o mesmo Subject).

**Desvantagens**  
- Pode ficar difícil rastrear o fluxo de notificações em sistemas grandes.
- Se mal implementado, pode gerar notificações desnecessárias ou repetidas.

---

## 3. Iterações e Variações Consideradas

### 3.1 Factory Method vs. Abstract Factory

No contexto do PizzaPlus, o **Factory Method** é utilizado para criar diferentes tipos de pizza com base em um tipo passado como parâmetro (por exemplo, `"CALABRESA"`, `"MARGHERITA"`). Em uma iteração futura, poderia ser adotado **Abstract Factory** para:

- criar “famílias” de produtos, como:
  - `PizzaCalabresa`, `BebidaCola`, `SobremesaChocolate` de uma mesma “linha promocional”;
- ou separar fábricas por **unidade da pizzaria** (Pizzaria Centro, Pizzaria Bairro).

Para esta atividade, o Factory Method é suficiente, pois o foco está na criação de **um tipo principal de produto (Pizza)** e não de famílias completas.

---

### 3.2 Strategy para Frete e para Pagamento

O padrão Strategy foi pensado de duas formas possíveis:

- **Strategy de Frete**  
  - `FreteStrategy` (interface) com implementações como:
    - `EntregaRapida`
    - `EntregaEconomica`
    - `RetiradaNoBalcao`

- **Strategy de Pagamento**  
  - `PagamentoStrategy` (interface) com implementações como:
    - `PagamentoCartao`
    - `PagamentoPix`
    - `PagamentoDinheiro`

Na versão mínima da aplicação basta utilizar Strategy para **frete**. Caso haja tempo, o mesmo padrão é reaplicado para pagamento, reforçando a flexibilidade da arquitetura.

---

### 3.3 Singleton: Eager vs. Lazy

O Singleton pode ser implementado de duas maneiras principais:

- **Eager initialization**  
  - A instância única é criada assim que a classe é carregada.
  - Mais simples, porém inicializa mesmo que nunca seja usada.

- **Lazy initialization**  
  - A instância é criada somente quando `getInstance()` é chamado pela primeira vez.
  - Melhora o desempenho inicial, mas pode exigir cuidados com concorrência (multithreading).

Para o PizzaPlus, um Singleton simples (eager ou lazy sem múltiplas threads) é suficiente, já que o foco é didático.

---

### 3.4 Observer Sincrono x Assíncrono

Na aplicação, o uso do Observer é pensado de forma **síncrona** e simples: ao mudar o status de um pedido, o `Pedido` notifica imediatamente todos os observadores.

Em um cenário mais avançado, poderia-se evoluir para notificações **assíncronas** (por filas, eventos, mensageria), mas isso foge do escopo da disciplina e do objetivo da atividade.

---

## 4. Comparações Entre Padrões

### 4.1 Strategy vs. Template Method

Ambos lidam com variações de comportamento, mas:

- **Strategy**:
  - Encapsula comportamentos em **objetos separados**, que podem ser trocados em tempo de execução.
  - No PizzaPlus, isso faz sentido para frete/pagamento, pois o tipo de estratégia pode variar de pedido para pedido.

- **Template Method**:
  - Define o esqueleto de um algoritmo em uma classe base, permitindo que subclasses reimplementem partes específicas.
  - Seria menos adequado aqui, pois amarraria a variação de comportamento à hierarquia de classes, ao invés de deixá-la a cargo de objetos intercambiáveis.

Por isso, o **Strategy** foi escolhido.

---

### 4.2 Factory Method vs. Criar Objetos Diretamente

Criar pizzas com `new PizzaCalabresa()` diretamente espalhado no código geraria:

- alto acoplamento das camadas de negócio com classes concretas;
- dificuldade em adicionar/remover sabores;
- risco de duplicação de lógica de criação.

Com **Factory Method**:

- toda a lógica de criação fica centralizada na classe fábrica;
- o código cliente só precisa conhecer a interface `Pizza` e o método `criarPizza(tipo)`.

---

### 4.3 Singleton vs. Variáveis Globais

Em vez de um Singleton, poderia-se usar variáveis globais ou atributos estáticos acessíveis diretamente, porém:

- variáveis globais não controlam a quantidade de instâncias;
- dificultam encapsulamento e podem se espalhar sem controle.

O **Singleton**, mesmo com suas críticas, torna explícito que só deve existir uma instância controlada e fornece um ponto de acesso padronizado, o que é mais organizado para um contexto didático como o desta atividade.

---

### 4.4 Observer vs. Chamadas Diretas

Uma alternativa ao Observer seria o `Pedido` chamar diretamente métodos de:

- `PainelCozinha.atualizarStatus(pedido)`;
- `AppCliente.notificarCliente(pedido)`;
- etc.

Isso criaria forte acoplamento: o `Pedido` precisaria conhecer todas as classes que devem ser notificadas.

Com **Observer**:

- o `Pedido` só conhece a interface `Observer`;
- qualquer novo componente que deseje receber atualizações (como um “Painel do Entregador”) pode se registrar sem alterar a classe `Pedido`.

---

## 5. Justificativa da Aplicação dos Padrões no Projeto PizzaPlus

### 5.1 Factory Method no PizzaPlus

**Local no projeto (exemplo de organização):**  
`src/main/pizza/PizzaFactory.java`  
`src/main/pizza/Pizza.java`  
`src/main/pizza/PizzaCalabresa.java`, `PizzaMarguerita.java`, `PizzaQuatroQueijos.java`, etc.

**Uso**  
- O cliente ou a camada de serviço chama `PizzaFactory.criarPizza(tipo)`.
- A fábrica devolve uma instância de `Pizza` adequada ao tipo solicitado.

**Por que faz sentido?**  
- A pizzaria trabalha com vários sabores de pizza.
- Novos sabores podem ser adicionados com frequência.
- Centralizar a criação facilita a manutenção e a evolução da aplicação.

**Como ficaria sem o padrão?**  
- Diversos trechos de código contendo `if (tipo.equals("CALABRESA")) new PizzaCalabresa() …`.
- Maior chance de erro e repetição de código.
- Dificuldade para localizar todos os pontos de criação ao alterar algo.

---

### 5.2 Strategy no Cálculo de Frete (e Pagamento)

**Local no projeto (exemplo):**  
`src/main/frete/FreteStrategy.java`  
`src/main/frete/EntregaRapida.java`  
`src/main/frete/EntregaEconomica.java`  
`src/main/frete/RetiradaNoBalcao.java`  

  
`src/main/pagamento/PagamentoStrategy.java`  
`src/main/pagamento/PagamentoCartao.java` etc.

**Uso**  
- A classe `Pedido` ou um serviço de checkout recebe uma instância de `FreteStrategy`.
- Dependendo da escolha do cliente (rápido, econômico ou retirada), o sistema aplica o cálculo correspondente.

**Por que faz sentido?**  
- O cálculo de frete é uma política de negócio que pode mudar com o tempo.
- Permite que diferentes pedidos usem estratégias diferentes simultaneamente.
- Evita que o código fique cheio de condicionais.

**Como ficaria sem o padrão?**  
- Um método `calcularFrete()` com vários `if/else` dentro de `Pedido`.
- Qualquer mudança no cálculo exigiria alterar esse método e recompilar tudo.
- Dificuldade para testar e reutilizar as estratégias.

---

### 5.3 Singleton para Gerenciamento Global

**Local no projeto (exemplo):**  
`src/main/config/ConfigSistema.java`  
ou  
`src/main/core/GerenciadorDePedidos.java`

**Uso**  
- `ConfigSistema.getInstance()` retorna a única instância com dados de configuração (por exemplo, taxa base de frete, horário de funcionamento, etc.).
- Alternativamente, `GerenciadorDePedidos.getInstance()` pode gerenciar a lista de pedidos ativos.

**Por que faz sentido?**  
- Certas informações são únicas para o sistema como um todo.
- É conveniente ter um ponto de acesso único e controlado.

**Como ficaria sem o padrão?**  
- Múltiplas instâncias de configuração espalhadas, com risco de divergência.
- Acesso desorganizado a dados globais.

---

### 5.4 Observer para Atualização de Status de Pedido

**Local no projeto (exemplo):**  
`src/main/observer/PedidoSubject.java` (ou o próprio `Pedido` como Subject)  
`src/main/observer/Observer.java`  
`src/main/observer/PainelCozinha.java`  
`src/main/observer/AppCliente.java`  
`src/main/observer/DashboardGerente.java`

**Uso**  
- O `Pedido` mantém uma lista de observadores.
- Quando o status muda (por exemplo, de “Em preparação” para “Saiu para entrega”), o `Pedido` chama `notificarObservers()`.
- Cada observador reage da sua forma (atualiza tela, grava log, envia mensagem etc.).

**Por que faz sentido?**  
- Vários componentes precisam saber quando o estado do pedido muda.
- Não queremos acoplar o `Pedido` diretamente a cada tipo de tela ou sistema externo.

**Como ficaria sem o padrão?**  
- O `Pedido` teria referências diretas a todas as classes que precisam ser notificadas.
- Para adicionar um novo componente (ex.: painel do motoboy), seria necessário alterar a classe `Pedido`.
- Aumentaria o acoplamento e diminuiria a flexibilidade.

---

## 6. Conclusão

Os padrões **Factory Method, Strategy, Singleton e Observer**, estudados com base no material do Refactoring.Guru, foram aplicados de maneira integrada no projeto **PizzaPlus** para:

- **Organizar a criação de objetos** (Factory Method);
- **Modularizar políticas de negócio variáveis** (Strategy);
- **Centralizar recursos compartilhados** (Singleton);
- **Desacoplar notificações de alteração de estado** (Observer).

A combinação desses padrões melhora a **manutenibilidade**, a **extensibilidade** e a **clareza arquitetural** do sistema, ao mesmo tempo em que demonstra, na prática, como conceitos clássicos de design de software podem ser aplicados em um cenário realista de aplicação comercial.

