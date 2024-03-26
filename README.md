# TodoList
Project for Federal University - NPI

Este projeto é uma aplicação de lista de tarefas (TodoList) desenvolvida como parte de um estágio. Ele utiliza as seguintes tecnologias:

- Vue.js 3 para o frontend
- Spring Boot para o backend
- Docker para a containerização

Para ver mais sobre o processo de desenvolvimento abra a sessão de <span style="color: blue;">Issues</span> e <span style="color: green;">Milestones</span>

## Funcionalidades

Este projeto implementa um CRUD (Create, Read, Update, Delete) para gerenciar as tarefas. As funcionalidades incluem:

- Adicionar uma nova tarefa.
- Visualizar as tarefas existentes.
- Atualizar o status de uma tarefa para concluída.
- Excluir uma tarefa.

## Como Executar o Projeto

1. Clone este repositório.
2. Navegue até a pasta do projeto.
3. Execute o comando `docker-compose up`.

## Requisitos do Projeto TodoList

### 1. Frontend (Vue3)

- O usuário deve ser capaz de visualizar todas as tarefas existentes.
- O usuário deve ser capaz de adicionar uma nova tarefa.
- O usuário deve ser capaz de marcar uma tarefa como concluída.
- O usuário deve ser capaz de excluir uma tarefa.
- A interface do usuário deve ser intuitiva e fácil de usar.

### 2. Backend (Spring Boot)

- Deve haver endpoints para criar, ler, atualizar e deletar (CRUD) tarefas.
- Os dados devem ser persistidos, ou seja, se o servidor for reiniciado, as tarefas não devem ser perdidas.

### 3. Docker

- O aplicativo deve ser empacotado em um contêiner Docker.
- Deve haver um Dockerfile que define como construir a imagem Docker.
- Deve haver um docker-compose.yml que define como executar o aplicativo.

![Representação visual dos componentes da aplicação]([(https://bezkoder.com/wp-content/uploads/2019/12/spring-boot-vue-js-crud-example-architecture.png)https://bezkoder.com/wp-content/uploads/2019/12/spring-boot-vue-js-crud-example-architecture.png])

