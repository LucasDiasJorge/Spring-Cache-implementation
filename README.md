# Caching em Spring Boot

## Descrição

Este projeto demonstra como implementar caching em uma aplicação Spring Boot. O foco é otimizar o cálculo de Pi, reduzindo a latência em chamadas repetidas para obter o valor mais rapidamente.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Gradle ou Maven** (dependendo da sua preferência para gerenciamento de dependências)

## Como Funciona

- O service PiService calcula do valor de Pi e salva o valor encontrado após a entrega da Request.
- Com a anotação `@Cacheable`, os dígitos decimais de Pi são armazenadas em cache após a primeira chamada, permitindo que chamadas subsequentes sejam atendidas rapidamente sem a latência inicial.
- A classe `CacheApplication` habilita o caching por meio da anotação `@EnableCaching`.

_[Caching documentation](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-features-caching.html)_

_[Caffeine documentation](https://github.com/ben-manes/caffeine)_

### Curiosidades

- Métodos anotados com @Scheduled são ignorados em chamadas dentro da própria classe (self-invocation). Para mais detalhes, veja a documentação sobre _[Taredas Agendadas](https://www.baeldung.com/spring-scheduled-tasks)_
- Para possibilitar o "pré-processamento" dos dados com o valor de precision = 1500, foi necessário criar o CachedPiService, garantindo que o caching seja aplicado corretamente.