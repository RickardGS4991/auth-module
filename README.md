# Servicio de Autenticación con Clean Architecture & DDD

Este repositorio contiene un sistema robusto de autenticación (Login, Logout y Sign Up) construido bajo los principios de **Clean Architecture**, **Domain-Driven Design (DDD)** y **Test-Driven Design (TDD)**.

### 🚀 Origen del Proyecto
Este servicio nació originalmente como una pieza central de un proyecto personal de mayor envergadura en el que me encuentro trabajando actualmente. He decidido extraerlo y abrirlo como un repositorio independiente para demostrar mis habilidades en el diseño de sistemas escalables, el manejo de seguridad con JWT y la implementación de arquitecturas desacopladas.

---

### 🏗️ Arquitectura y Diseño
El proyecto sigue una estructura de **Arquitectura Hexagonal (Puertos y Adaptadores)** para asegurar que el núcleo de negocio sea independiente de los frameworks y agentes externos. La arquitectura no solo busca la separación de intereses (Clean Architecture), sino que integra un enfoque DevOps desde su concepción, priorizando la observabilidad, la eficiencia en la persistencia con PostgreSQL y la preparación para entornos de CI/CD.

* **Capa de dominio:** Contiene el "cerebro" de la aplicación. Implementa Entidades, Value Objects e Invariantes de negocio (reglas de integridad) sin dependencias externas.
* **Capa de aplicación** Define los Casos de Uso (Sign Up, Login, Logout) que orquestan el flujo de datos.
* **Capa de infraestructura:** Implementa los detalles técnicos como la persistencia en PostgreSQL, la seguridad con Spring Security y la generación de tokens.

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

---

**Autor:** Ricardo Garcia Sedano  
*Full Stack Developer | Ingeniero en Sistemas Digitales y Robótica* | Máster en DevOps
