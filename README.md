# Servicio de Autenticación con Clean Architecture & DDD

Este repositorio contiene un sistema robusto de autenticación (Login, Logout y Sign Up) construido bajo los principios de **Clean Architecture**, y **Domain-Driven Design (DDD)** con **Test-Driven Development (TDD)**.

### 🚀 Origen del Proyecto
Este servicio nació originalmente como una pieza central de un proyecto personal de mayor envergadura en el que me encuentro trabajando actualmente. He decidido extraerlo y abrirlo como un repositorio independiente para demostrar mis habilidades en el diseño de sistemas escalables, el manejo de seguridad con JWT y la implementación de arquitecturas desacopladas.

---

### 🏗️ Arquitectura y Diseño
El proyecto sigue una estructura de **Arquitectura Hexagonal (Puertos y Adaptadores)** para asegurar que el núcleo de negocio sea independiente de los frameworks y agentes externos. La arquitectura no solo busca la separación de intereses (Clean Architecture), sino que integra un enfoque DevOps desde su concepción, priorizando la observabilidad, la eficiencia en la persistencia con PostgreSQL y la preparación para entornos de CI/CD. El uso en conjunto de la filosofía DDD ayuda a manejar al dominio (reglas de negocio) como el eje central de toda la aplicación. De esta manera, la aplicación se vuelve mantenible y continua.

* **Capa de dominio:** Contiene el "cerebro" de la aplicación. Implementa Entidades, Value Objects e Invariantes de negocio (reglas de integridad) sin dependencias externas.
* **Capa de aplicación** Define los Casos de Uso (Sign Up, Login, Logout) que orquestan el flujo de datos.
* **Capa de infraestructura:** Implementa los detalles técnicos como la persistencia en PostgreSQL, la seguridad con Spring Security y la generación de tokens.
* **Capa de controladores:** Aunque la capa de controladores pertenece a la capa de infraestructura, se ha decidido mantenerla afuera como una capa independiente.

### 🚦Adapters
Comúnmente, los adaptadores son la pieza más compleja de asimilar al inicio. Sin embargo, la mejor analogía para comprenderlos es pensando en ellos como un traductor. La lógica de negocio necesita hablar en un lenguaje que no comprende del exterior. Por lo tanto, tenemos a los adaptadores encargados de manejar servicios externos o de guiar el flujo de la aplicación. Existen dos tipos de adaptadores:

* **Driving (Primarios):** Estos adaptadores controlan el flujo de la aplicación. Los controladores REST son un ejemplo de estos adaptadores, ya que son los encargados de iniciar el proceso de solicitud del exterior a la aplicación.
* **Driven (Secundarios):** Estos adaptadores son los encargados de manejar los servicios externos que la lógica de negocio necesita para lograr sus objetivos. Dentro se encuentran dos tipos de driven adapters: Persistencia y los externos. Los de persistencia son los que utilizan los servicios de la base de datos, y los externos son aquellos que usan una librería como JWT.

### 🔌 Ports
Los puertos son los encargados de conectar a las capas dentro de la arquitectura limpia. Estos puertos son las interfaces (abstracciones) que serán inyectados a las implementaciones gracias a la inyección de dependencias y a la inversión de control que se maneja dentro de spring-boot. Existen dos tipos de puertos:
* **Entradas:** Los puertos de entrada son el punto de acceso a la lógica de negocio.
* **Salidas:** Los puertos de salida son los contratos para las dependencias externas que el negocio necesita para funcionar.

---
### ↪️ Integración continua
Consiste en automatizar la verificación de cada cambio subido al repositorio remoto por los desarrolladores. Con **GitHub Actions** se levantó un pipeline que verifica cada *push* o cada *pull_request* realizado a la rama principal. 

---

### ↩️ Despliegue continuo
Próximamente...

---


### 🛠️ Tecnologías Utilizadas
* **Java 21** como lenguaje principal.
* **Spring Boot 3** (Spring Security, Spring Data JPA).
* **PostgreSQL** como base de datos relacional.
* **JWT (JSON Web Tokens)** para autenticación Stateless.
* **Docker** para la contenedorización y despliegue de la base de datos.
* **JUnit 5 / Mockito** para asegurar la calidad mediante pruebas unitarias.
* **GitHub Actions** para la implementación de la integración continua (Próximamente despliegue continuo en AWS)

---

### 🔐 Características Destacadas
* **Manejo de Refresh Tokens:** Implementación segura de tokens de acceso y de refresco con almacenamiento en base de datos.
* **Seguridad Extensible:** Uso de filtros personalizados y `AuthenticationEntryPoint` para estandarizar las respuestas de error.
* **Persistencia Optimizada:** Uso de índices estratégicos en PostgreSQL para búsquedas de tokens de alta velocidad.
* **Clean Code:** Código autodocumentado, siguiendo principios SOLID y patrones de diseño.

---

### ⚙️ Instalación y Uso
Existen dos formas de levantar esta aplicación en tu computadora:

* **Ejecución del artefacto:** Descargas el artefacto que se encuentra en la zona de **Releases** del repositorio. Es necesario tener instalador Java 21.
* **Levantamiento en Docker:** Usa el comando `docker-compose -f docker-compose-db.yaml up -d`, y la aplicación se levantará sola con Docker. No es necesario tener instalado Java 21. Son los beneficios del IaC.

---

**Autor:** Ricardo Garcia Sedano  
*Full Stack Developer | Ingeniero en Sistemas Digitales y Robótica* | Máster en DevOps
