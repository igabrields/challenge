### Estrutura do Projeto
    .
    ├── com.igor.br.challenge                    
    │   ├── api                             # Responsável por receber as requisicões HTTP.
    |   ├── core                            # Responsável por conter as regras específicas para a validacão de senha
    │   │   ├── entities                    # Responsável por conter as entidades necessárias para receber e responder às requisicoes 
    │   │   ├── factory                     # Responsável pela criacão das classes que executa a regra específica 
    │   │   ├── service                     # Responsável por conter todas as regras de validacáo
    │   │   ├── utils                       # Responsável por conter alguns extensios e constantes utilizadas no core
    
### Tecnologias utilizadas
- Kotlin
- Spring-Boot (Java 15)
- Gradle build tools (6.7.1)
- JUnit

### Premissas do projeto
    Para a criacão do projeto foquei bastante em Clean Code e desacoplamento, por isso para cada regra eu utilizo uma 
    abstracáo específica, dessa forma entendo que o código fica mais legível para qualquer que precise dar manutencão 
    futuramente, com essa premissa eu evitei utilizacão de regex porque entendo que regex é de difícil leitura.
    
    Apesar de ter construído apenas um módulo, eu pensei em utilizar o clean architecure, mas isso ia aumentar
    consideravelmente minhas preocupacões com o build, o que eu achei que não faria sentido dada a complexidade do 
    projeto. No cenário atual o package core poderia se tornar um módulo apartado, mas não achei necessário fazer essa
    quebra, caso eu tivesse outras camadas como Data Access, talvez comecasse a fazer sentido quebrar em outros módulos.
    
### Testes
    Os testes estão cobrindo todas as regras criadas no projeto para validacão da senha. Sempre que criou o teste eu me
    preocupo em adequar as necessidade do teste à abstracão das classes de validacão e não às implementacões.

### Execucão do Projeto
    Para execucão dos comanddos abaixo é necessário estar na raiz do projeto

#### Comando para subir a aplicacão Spring Boot utilizando o Tomcat
> gradlew bootRun

#### Comando para compilar a aplicacão Spring Boot
> gradlew build

#### Comando para executar a aplicacão a partir da compilacão gerada
> java -jar build\libs\challenge-0.0.1-SNAPSHOT.jar

#### Comando para executar os teste de integracão e unidade
> gradlew test

###### Observacão: o reporte dos testes fica em: projetct_folder\build\reports\tests\test\index.html

#### Parametros de entrada para a requisicão de validacão
```
POST http://localhost:8080/validator/password/
{
   "password" : "your_password"
}
````

#### Retorno da requisicão
    Para facilitar o entendimento das validacões eu aumentei um pouco o escopo da resposta que foi solicitada no 
    desafio e acrescentei dois campos a mais: a própria senha enviada na requisicão e uma lista de inconsistência.

###### Validacão de senha com inconsistencias:
```
POST http://localhost:8080/validator/password/
{ "password" : "your_password" }

Reponse Body
{
    "password": "your_password",
    "isValid": false,
    "inconsistencies": [
        "A senha não pode conter espaços em branco",
        "A senha deve conter ao menos 1 letra minúscula",
        "A senha deve conter ao menos 1 caractere especial: !@#$%^&*()-+"
    ]
}
```
###### Validacão de senha sem inconsistencias:
```
POST http://localhost:8080/validator/password/
{ "password" : "TBP9YfX!c" }

Reponse Body
{
    "password": "TBP9YfX!c",
    "isValid": true,
    "inconsistencies": []
}
```
