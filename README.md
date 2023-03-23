# Sistema RU

## Integrantes do grupo

* Luiz Filipe Albuquerque Gomes - luizgomes.prog@gmail.com
* Raphael Barbosa de Melo - rm80838@gmail.com
* Ana Beatriz Vieira Santos Silva - Beatriz0103s@gmail.com
* Diogo Fontes de França - fontesdgfranca@gmail.com

## Descrição geral do projeto

1. Quem vai usar o programa?

      - O sistema possui clientes e funcionários.

2. Que serviços são “necessários” (leia-se: importantes para os clientes e usuários)?

      - Serviços para efetuar o cadastro, autenticação da conta e visualização de cardápio.

3. Quais serviços cada usuário pode executar

      - Os clientes podem comprar fichas , visualizar o cardápio e depositar dinheiro no saldo da sua conta.<br />
      - Os funcionarios podem adicionar e remover pratos do cardápio, além de organizar os pratos baseados em seus atributos, podem visualizar as informações dos clientes, além de poder ver compras recentes realizadas.<br />
  
## Requisitos do Projeto

* **REQ1** - o sistema deve permitir ao Funcionario o gerenciamento do CRUD (Create, Read, Update, Delete) de Pratos, onde um Prato só pode ser adicionado ou atualizado se não houver pratos iguais a ele, e só podera ser removido se houver o prato para remoção.
* **REQ2** - O Sistema deve permitir ao funcionario gerenciar os pratos que aparecem no cardápio e possibilitar tanto ao cliente quanto aos funcionários a visualização do cardápio, onde apenas os pratos com a visibilidade marcada devem ser exibidos no cardapio.
* **REQ3** - O sistema deve permitir que o funcionario visualize as informações de clientes e possa remove-los, a vizualização e remoção só serão possiveis se o cliente existir.
* **REQ4** - O sistema deve permitir que o cliente gerencie (CRUD - Create, Recover, Update, Delete) a sua conta, a criação da conta só será possivel se não houver outra conta igual, e a atualização apenas ocorrera se a conta com os novos dados não existir e o funcionario deve ter acesso a todas as informações não sigilosas do cliente(nome, fichas, etc.).
* **REQ5** - O sistema deve permitir o cadastramento e autenticação de contas de Clientes e Funcionários através de login e senha para clientes e login, senha e id para funcionarios.
* **REQ6** - O sistema deve permitir que o Cliente visualize seu saldo, deposite dinheiro na sua conta e compre fichas, em quantidade e tipo escolhida pelo cliente, onde ele verá o total a ser gasto na compra, onde a compra sera possivel apenas se o saldo na conta for maior que o preço total das fichas.
* **REQ7** - O sistema deve permitir o consumo das fichas pelo Cliente para liberar o acesso ao restaurante universitario.
<pre />

