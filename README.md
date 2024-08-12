# Projeto de Lista de Itens

## Visão Geral
Este projeto tem como objetivo criar uma API para gerenciar uma lista de itens. Ela permite a realização de operações básicas de criação, leitura, atualização e exclusão (CRUD) de itens.

## Funcionalidades
- Criação de novos itens
- Listagem de todos os itens
- Atualização de itens existentes
- Exclusão de itens

## Requisitos
- Java 11 ou superior
- Banco de dados relacional (por exemplo, PostgreSQL, MySQL)
- Maven para gerenciamento de dependências

## Tecnologias Utilizadas
- Spring Boot
- Spring Data JPA
- Jackson (para serialização JSON)
- Banco de dados relacional

## Como Executar
1. Clone o repositório do projeto:
   ```
   git clone https://github.com/seu-usuario/projeto-lista-itens.git
   ```
2. Abra o projeto em sua IDE de preferência.
3. Configure a conexão com o banco de dados no arquivo `application.properties`.
4. Execute o projeto usando o comando:
   ```
   mvn spring-boot:run
   ```
5. A API estará disponível em `http://localhost:8080/api/items`.

## Endpoints da API
- `POST /api/items`: Cria um novo item
- `GET /api/items`: Retorna a lista de todos os itens
- `PUT /api/items/{id}`: Atualiza um item existente
- `DELETE /api/items/{id}`: Exclui um item

## Exemplo de Uso
Aqui está um exemplo de como enviar uma requisição para criar um novo item usando o Postman:

![Exemplo de Criação de Item no Postman][]

A resposta da API será um JSON com o item criado:```json
{
  "id": 1,
  "item": "Novo Item"
}
```

## Próximos Passos
- Implementar testes automatizados para a API
- Adicionar autenticação e autorização para a API
- Melhorar a documentação da API usando ferramentas como Swagger

Qualquer dúvida ou sugestão, por favor, entre em contato!