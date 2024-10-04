# Caching em Spring Boot

## Descrição

Este projeto demonstra como implementar caching em uma aplicação Spring Boot. O foco é otimizar o calculo de Pi, reduzindo a latência em chamadas repetidas para obter o valor mais rapidamente.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Gradle ou Maven** (dependendo da sua preferência para gerenciamento de dependências)

## Como Funciona

- O service PiService calcula do valor de Pi e salva o valor encontrado após a entrega da Request.
- Com a anotação `@Cacheable`, os das casas decimais de pi são armazenadas em cache após a primeira chamada, permitindo que chamadas subsequentes sejam atendidas rapidamente sem a latência inicial.
- A classe `CacheApplication` habilita o caching por meio da anotação `@EnableCaching`.
