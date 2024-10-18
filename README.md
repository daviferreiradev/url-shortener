# Afazeres
- Utilizar variáveis de ambiente .env
- Saber lidar com exceções: @ControllerAdvice == filters httpException.filter.ts (semelhante ao filters do relax)
- Testes unitários / Junit / mockito


# Conceitos

# Dúvidas
- O que cada dependência faz?
Spring Web
Spring Data JPA
PostgreSQL Driver
Lombok
Spring Boot DevTools
Spring Boot Actuator (para monitoramento - não sei se baixei a certa)
Spring Boot Starter Test (não consegui baixar)
Swagger/OpenAPI (não consegui baixar)

___________________________________________________

- application.properties
O que cada linha faz?

___________________________________________________

- O que seria pacotes em Java?
com.example.urlshortener.model

___________________________________________________

# Lombok
@Entity
@Data
- Para que serve equals() e hashCode()?

____________________________________________________

Qual a diferença entre classe e interface?
- No repository pq extendemos a interface JpaRepository
Interfaces: UrlRepository é uma interface que estende JpaRepository, que é outra interface. Isso demonstra o uso de interfaces e polimorfismo.

____________________________________________________

# Annotations para controllers
@RequestParam
@PathVariable

Annotations
@Entity: Indica que a classe é uma entidade JPA.
Injeção de Dependência com @Autowired: O Spring injeta automaticamente a instância de UrlRepository.

- Anotations @Configuration (roda primeiro) @Service  @Component / Qual a diferença

____________________________________________________

Optional<Url>
O que é esse Optional e esse <> com um tipo dentro?

____________________________________________________

Onde foi definido que a aplicação rodaria na porta 8080?

____________________________________________________

# Swagger / OpenAI
http://localhost:8080/swagger-ui/index.html
- O que são os squemas do que aparece embaixo?

____________________________________________________

Regex
Para que serve
Como usar?

____________________________________________________

# DTO: Data transfer object
Os DTOs são usados para transferir dados entre diferentes partes da aplicação de forma segura e encapsulada.



- Diferença entre spring e spring boot
- Perguntas de java (herança, polimorfismo, interface, ORMs)
- Hibernate / implementa interface da JPA (interface, contrato)


CVC - MongoDBOntem dia de estudo
- Reunião Nelson: SonarQube - Exclusions - Rodar local
- Git flow

Termino hoje de tarde:
- Enviar PRs hotfix para dev e staging
- task Retorno do colaborador na listagem de alocações




_________________________________________________


Desafio de system design - orquestarr um sistema

- API, banco de dados, postgres, expiração de URL
- Diferença entre spring framework e spring boot
- Perguntas de java (herança, polimorfismo, interface, ORMs)
- Hibernate - ORM / implementa interface da JPA (interface, contrato) 
- SQL são mais lentos, mais engessados - 
- JVM
- Docker
___________________________________________________

Java / multithread



mvn install - atualiza as dependencias



docker run --name tesssst -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -e POSTGRES_DB=urlshortener -p 5432:5432 -d postgres:17


docker run --name my-app --link tesssst -e SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/urlshortener -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_PASSWORD=root -p 8080:8080 -d test

docker run --name my-app2 --link tesssst:db -e SPRING_DATASOURCE_URL=jdbc:postgresql://tesssst:5432/urlshortener -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_PASSWORD=root -p 8080:8080 -d test

mvn clean install   
docker build -t url-shortener .
docker run -d -p 8080:8080 url-shortener  