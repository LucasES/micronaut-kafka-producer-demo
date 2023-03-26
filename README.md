# micronaut-kafka-producer-demo
Projeto responsável em produzir mensagens no tópico kafka, criado através do docker, utilizando uma estrutura AVRO.
A aplicação realiza a produção de mensagens por método POST ao expor um endpoint REST.

## Sobre

Este projeto tem como objetivo realizar um estudo da funcionalidade de produção de mensagens em tópico kafka utilizando schema registry.



## Criado com

* 	[Gradle](https://gradle.org/) - Dependency Management
* 	[JDK](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) - Java™ Platform, Standard Edition Development Kit
* 	[Micronaut](https://micronaut.io/) - Micronaut Framework
* 	[Postgres](https://www.postgresql.org/) - Relational Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system
* 	[Docker](https://www.docker.com/) - Docker is an open platform for developing, shipping, and running applications
* 	[Docker Compose](https://docs.docker.com/compose/) - Docker Compose


## Ferramentas externas

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download) - Java IDEA

### Pré-requisitos

Para instalar e executar a API é preciso instalar:

- [JDK 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Gradle](https://gradle.org/)
- [GIT](https://git-scm.com/downloads)
- [Docker](https://www.docker.com/)

## Executando docker

1) Na pasta do projeto abra um terminal e crie o volume do docker:
   ```sh
    docker volume create herodb
    ``` 
2) Execute o docker-compose
   ```sh
    docker-compose up 
    ``` 
   
## Executando a aplicação local

Primeiramente, deve-se realizar o clone do projeto através do comando:

```sh
git clone https://github.com/LucasES/micronaut-kafka-producer-demo.git
```

Ou acessar a URL: https://github.com/LucasES/micronaut-kafka-producer-demo e realizar o download do projeto no formato zip e realizar a extração do arquivo.

Realizar o clean build da aplicação

```shell
gradle clean build
```

Para executar a aplicação em sua máquina local podemos executar o método `main` na classe `com.example.Application.kt` no intellij.

### URL's

|  URL | Método | Descrição |
|----------|--------|-----------|
|`http://localhost:9090/hero`                           | POST   | Produz uma mensagem no tópico Kafka.
|`http://localhost:9090/hero`                           | GET    | Lista todas os registros de herois no banco de dados.

### Request e Response

Exemplo de entrada:


`{
"name": "Thor",
"power": 9.5
}`

Resposta:


`{  
"result":"Success"
}`

## Arquivos e diretórios

O projeto `micronaut-kafka-producer-demo` possui uma estrutura de diretórios específica.

Um projeto representativo é representado abaixo:

 ```
 .
 ├── Micronaut Elements
 ├── src
 │   └── main
 │       └── kotlin
 │           ├── com.example.Application.kt
 │           ├── com.example.adapter
 │                ├── endpoint
 │                ├── messaging
 │                └── persistence
 │           ├── com.example.application
 │                ├── port
 │                └── usecase
 │           └── com.example.domain
 ├── src
 │   └── main
 │       └── resources
 │           ├── avro
 │                └── hero.avsc
 │           ├── application.yml
 │           └── logback.xml
 ├── src
 │   └── test
 │       └── kotlin
 ├── .env
 ├── .gitignore
 ├── 01-init-db.sql
 ├── build.gradle.kts
 ├── docker-compose.yml
 ├── gradle.properties
 ├── gradlew
 ├── gradlew.bat
 ├── micronaut-cli.yml
 ├── postgres.dockerfile
 ├── README.md
 └── settings.gradle.kts
 ```
## Pacotes

- `adapter` - Camada responsável em centralizar todos os adapters do projeto.
- `application` - Camada responsável em centralizar a lógica do projeto.
- `domain` - Camada responsável em centralizar todas as classes de domínio trafegado no sistema.

## Contribuição

Por favor, leia [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) para obter detalhes sobre nosso código de conduta e o processo de envio de solicitações pull requests.

## Autores

* **Lucas Araújo** - *projeto inicial* - [LucasES](https://github.com/LucasES)

## Licença

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

