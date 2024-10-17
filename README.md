# AFAZERES
- Utilizar variáveis de ambiente .env


# URLSHORTENER DÚVIDAS
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

- Lombok
@Entity
@Data

____________________________________________________

Annotations
@Entity: Indica que a classe é uma entidade JPA.
Injeção de Dependência com @Autowired: O Spring injeta automaticamente a instância de UrlRepository.

____________________________________________________

Qual a diferença entre classe e interface?
- No repository pq extendemos a interface JpaRepository
Interfaces: UrlRepository é uma interface que estende JpaRepository, que é outra interface. Isso demonstra o uso de interfaces e polimorfismo.

____________________________________________________

Annotations para controllers
@RequestParam
@PathVariable

____________________________________________________

Optional<Url>
O que é esse Optional e esse <> com um tipo dentro?

____________________________________________________

Onde foi definido que a aplicação rodaria na porta 8080?
