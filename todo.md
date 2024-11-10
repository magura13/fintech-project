## Autenticação de Usuário

Objetivo: Garantir que apenas usuários autenticados possam acessar o sistema.
Criar o modelo User.
Implementar o UserDAO com métodos de autenticação.
Desenvolver o LoginServlet para autenticar usuários.
Criar a página login.jsp com Bootstrap para o formulário de login.
Implementar o AuthFilter para proteger páginas contra acessos não autorizados.
Criar a home.jsp com uma mensagem de boas-vindas para o usuário autenticado.


## Cadastro de Receitas e Despesas

Objetivo: Implementar o CRUD (Create, Read, Update, Delete) de transações financeiras.
Criar o modelo Transaction com propriedades básicas como amount, date, type, e description.
Desenvolver o TransactionDAO com operações de CRUD para transações.
Implementar o TransactionServlet para lidar com requisições de adicionar, editar e excluir transações.
Criar páginas add_transaction.jsp, edit_transaction.jsp e list_transactions.jsp usando Bootstrap.


## Revisão e Testes Básicos das Funcionalidades

Testar o fluxo de autenticação e CRUD de transações.
Corrigir problemas básicos e ajustar a interface, se necessário.


## Visualização e Filtro de Transações

Objetivo: Permitir que o usuário visualize todas as transações e aplique filtros.
Criar o ListTransactionsServlet para buscar todas as transações de um usuário.
Atualizar a list_transactions.jsp com filtros (ex.: tipo, data, categoria).
Adicionar classes de ajuda para formatação de data e números, se necessário.


## Dashboard

Objetivo: Exibir uma visão geral das finanças do usuário.
Desenvolver o DashboardServlet para agregar dados financeiros (saldo total, total de receitas, total de despesas).
Criar a página dashboard.jsp com gráficos utilizando Bootstrap e uma biblioteca de gráficos (como Chart.js ou Google Charts).
Exibir resumos financeiros e gráficos de distribuição por categoria.


## Revisão e Testes Básicos de Visualização e Dashboard

Testar a visualização e o filtro de transações.
Testar o dashboard para garantir que os dados estão sendo agregados corretamente e que os gráficos estão funcionando.


##  Melhorar Tratamento de Exceções
> Clean Code e melhorias

Criar uma classe personalizada de exceções, DAOException, para encapsular erros de banco de dados.
Atualizar todos os DAOs (UserDAO, TransactionDAO) para lançar DAOException com mensagens de erro mais detalhadas.
Implementar logs para registrar exceções de forma estruturada (pode-se usar System.err para logs básicos ou integrar uma biblioteca de logging como Log4j para melhor controle).


## Validação e Sanitização de Entrada

Atualizar LoginServlet e TransactionServlet para validar entradas dos usuários.
Ex.: garantir que os campos obrigatórios estejam preenchidos, que valores numéricos sejam positivos, e que o formato de data esteja correto.
Adicionar métodos de sanitização para remover caracteres indesejados, prevenir ataques de injeção e XSS (Cross-site Scripting).


## Centralizar Configurações de Banco de Dados

Mover configurações sensíveis para um arquivo de propriedades (ex.: db.properties).
Atualizar o ConnectionManager para carregar a URL do banco, nome de usuário e senha do arquivo de propriedades.
Testar para garantir que as configurações carregam corretamente.


## Implementação de Constantes e Mensagens

Criar uma classe Config para armazenar constantes, como:
Mensagens de erro e sucesso (ex.: LOGIN_ERROR_MESSAGE, SUCCESS_MESSAGE).
Caminhos de páginas e URLs.
Refatorar o código nos Servlets para usar constantes em vez de strings diretas.


## Implementação de Testes Automatizados

Objetivo: Garantir que o sistema funcione conforme o esperado.
Implementar testes unitários para UserDAO e TransactionDAO usando JUnit.
Testar cenários de sucesso e erro, como tentativas de login com credenciais inválidas.
Criar testes de integração para verificar o fluxo completo de login e transações.


## Documentação

Adicionar documentação em todas as classes principais (DAO, Servlets, e modelos).
Explicar a responsabilidade de cada classe e métodos.
Documentar parâmetros de métodos e possíveis exceções lançadas.
Criar um README.md para o projeto, incluindo:
Resumo do projeto e suas funcionalidades principais.
Instruções de configuração e execução.
Descrição das dependências (Maven, Tomcat, Banco de Dados Oracle).


## Testes Finais e Revisão Geral

Realizar uma revisão final para garantir que tudo esteja funcionando conforme esperado.
Testar o sistema em um ambiente o mais próximo possível de produção (ex.: outra máquina ou configuração semelhante).
Preparar o projeto para exportação e entrega, garantindo que todas as dependências e arquivos necessários estejam incluídos no ZIP.