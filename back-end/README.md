# Project-POAA
Posts Of About Articles - La Mente es Maravillosa

## Back-end

### Configurations

### Steps
* Step 1 - Clone the [Project-POAA](https://github.com/brow-joe/Project-POAA)
* Step 2 - Create database
* Step 3 - Build the gradle flyway `gradle flywayMigrate -i`
* Step 4 - Build the gradle jooq codegen `gradle clean jooqGenerate -i`

### Technologies
* [Git](https://git-scm.com/) *(version 2.15.1)* as control version
* [Gradle](https://gradle.org/) *(version 4.4)* as a dependency manager
* [Flyway](https://flywaydb.org/) *(version 5.0.2)* as database migration tool
* [jOOQ](https://www.jooq.org/) *(version 3.10.0)* as a database toolkit
* [PostgreSQL](https://www.postgresql.org/) *(version 10.1)* as database
* [Java JRE8](http://www.oracle.com/technetwork/java/javase/downloads/server-jre8-downloads-2133154.html) *(version 1.8.0_151)* as virtual machine
* [Java JDK8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) *(version 1.8.0_151)* as Development Kit
* [Kotlin](https://kotlinlang.org/docs/reference/using-gradle.html) *(version 1.2.10)* as programming language
* [Spring Boot](https://projects.spring.io/spring-boot/) *(version 1.5.9.RELEASE)* as framework applications based in microservices
* [Spring Cloud](http://projects.spring.io/spring-cloud/) *(version Dalston.SR4)* as framework applications based in distributed applications tools