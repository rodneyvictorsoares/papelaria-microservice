# PapelariaMS

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)

## Sobre o Projeto

O **PapelariaMS** é um microserviço para auxiliar o gerenciamento de pedidos para uma papelaria, desenvolvido utilizando Spring Boot. O projeto realiza a integração com RabbitMQ e usa suas mesnagens para persistir dados de vendas em base MongoDB.

## Funcionalidades

- **Gerenciamento de Pedidos:**
  - Criação de pedidos
  
- **Mensageria com RabbitMQ:**
  - Recebimento de mensagens relacionadas a eventos de pedidos

- **Persistência de Dados:**
  - Utilização do Data MongoDB para operações CRUD

## Estrutura do Projeto

```plaintext
papelariams
├── .idea/
├── .mvn/
│   └── wrapper/
├── local/
│   └── docker-compose.yml
├── src/
│   ├── main/
│   │   ├── java/com/rodneycom/papelaria/papelariams/
│   │   │   ├── config/
│   │   │   │   └── RabbitMqConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── dto/
│   │   │   │   ├── OrderController.java
│   │   │   ├── entity/
│   │   │   │   ├── OrderEntity.java
│   │   │   │   ├── OrderItem.java
│   │   │   ├── listener/
│   │   │   │   ├── dto/
│   │   │   │   ├── OrderCreatedListener.java
│   │   │   ├── repository/
│   │   │   │   └── OrderRepository.java
│   │   │   ├── service/
│   │   │   │   └── OrderService.java
│   │   │   └── PapelariamsApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/rodneycom/papelaria/papelariams/
│           └── PapelariamsApplicationTests.java
├── target/
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── samplePayload.txt
```


## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Maven**
- **RabbitMQ**
- **Docker**

## Como Executar

### Pré-requisitos

- Java 11+
- Maven
- Docker (para RabbitMQ)

### Passos

1. Clone o repositório:
    ```bash
    git clone https://github.com/rodneyvictorsoares/papelaria-microservice.git
    cd papelariams
    ```

2. Configure e inicie os serviços Docker:
    ```bash
    docker-compose up -d
    ```

3. Compile e execute a aplicação:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

- **GET /papelaria/{clienteId}/orders: Lista todos os pedidos de um cliente.

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Faça o push para a branch (`git push origin feature/nova-feature`)
5. Crie um novo Pull Request

## Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

---

Feito por Rodney Victor (https://github.com/rodneyvictorsoares)
