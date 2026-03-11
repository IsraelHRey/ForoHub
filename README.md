# ForoHub - Challenge Back End 🚀

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000f?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

ForoHub es una API Rest diseñada para replicar el funcionamiento de un foro de discusión. Este proyecto fue desarrollado como parte del **Challenge Back End de Alura Latam**, enfocándose en la persistencia de datos y la seguridad de la información.

## 📋 Características

- **CRUD de Tópicos:** Crear, listar, visualizar, actualizar y eliminar tópicos de discusión.
- **Autenticación:** Sistema de login para usuarios registrados.
- **Seguridad:** Protección de rutas mediante **Spring Security**.
- **Autorización:** Implementación de **JSON Web Tokens (JWT)** para el acceso a endpoints protegidos.
- **Base de Datos:** Migraciones gestionadas con Flyway.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Security**
- **Maven** (Gestión de dependencias)
- **MySQL** (Base de Datos)
- **Auth0 JWT** (Generación y validación de tokens)

## 🔐 Seguridad

La API utiliza un esquema de seguridad **Stateless**. Para acceder a los recursos protegidos (Tópicos), el flujo es el siguiente:

1. El usuario realiza una petición `POST` a `/login` con sus credenciales.
2. La API valida las credenciales y devuelve un **Token JWT**.
3. El usuario debe incluir este token en el encabezado de sus futuras peticiones:
   `Authorization: Bearer <tu_token_aquí>`



## 🚀 Cómo empezar

### Requisitos previos
- JDK 17 o superior.
- MySQL Server.
- Una herramienta para pruebas de API (Postman o Insomnia).

### Instalación
1. Clona el repositorio:
   ```bash
   git clone [https://github.com/tu-usuario/forohub.git](https://github.com/tu-usuario/forohub.git)
