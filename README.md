# POC JavaEE 8

## Descrição

Esse projeto foi concebido em uma arquitetura monolítica multimódulos contendo diversas tecnologias consideradas padrão de mercado 
dentro do mundo da tecnologia, pois são amplamente utilizadas em projetos empresariais e corporativos.

Dentro desse projeto Java com JavaEE contém as principais funcionalidades e configurações para gerar um EAR funcional contendo todos os módulos do projeto
podendo ser disponibilizado em servidores de aplicações on-premise como JBoss, WildFly, Glassfish, dentre outros.


## Design

O projeto contém 4 módulos onde estão distribuídas as respectivas responsabilidades, sendo eles:
- api (WAR): Responsável por conter os Controladores REST, Filters e configurações da camada de infraestrutura;
- core (EJB-JAR): Responsável por conter as regras de negócio e acesso a dados;
- libs (JAR): Responsável por conter classes utilitárias, bibliotecas do projeto e configurações globais;
- ear: Responsável por criar o pacote EAR contendo os pacotes dos módulos compilados e as bibliotecas.


## Soluções

### Orientação a Objetos
Foram aplicados os conceitos básicos de orientação a objetos como:
- Abstração;
- Herança;
- Polimorfismo;
- Encapsulamento.

### SOLID
Também foram aplicados Princípios SOLID como:
- Simple Responsability Principal;
- Open Closed Principal;
- Liskov Substitution Principal;
- Interface Segregation Principal;
- Dependency Inversion Principal.

### Design Patterns
Também foram aplicados soluções de Design Patterns como:
- Handlers de Exceções Globais utilizando ExceptionMapper;
- DTO para validações e trafego de dados entre as camadas da aplicação;
- Bean Validations para validações de campos;
- Repository para acesso aos dados.


### Tecnologias

- JavaEE 8 (CDI, EJB, JAX-RS/RestEasy, JPA/Hibernate);
- Java 8;
- JBoss EAP 7.4.x;
- PostgreSQL;
- Jackson;
- Maven;
- Git;
- Lombok
- Slf4J;
- ModelMapper
- JUnit;
- Mockito;
- SonarQube.
