# 📌 CRUD de Usuarios - Spring Boot 3, Java 21 y JPA Hibernate

## 📖 Descripción
Este proyecto es una aplicación web desarrollada con **Spring Boot 3**, utilizando **Java 21** y **JPA Hibernate** para la gestión de usuarios. La base de datos utilizada es **MySQL**, y la arquitectura sigue el patrón **MVC (Model-View-Controller)** para mantener una estructura organizada y escalable.

## 🚀 Tecnologías Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring MVC**
- **JPA Hibernate**
- **MySQL**
- **Thymeleaf (para las vistas)**
- **Lombok**
- **Maven**
  
```

## 🔧 Configuración del Proyecto
### 1️⃣ Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instalados:
- **Java 21**
- **Maven**
- **MySQL Server**

### 2️⃣ Configuración de la Base de Datos
Crea una base de datos en MySQL:
```sql
CREATE DATABASE db_springboot;
```
Configura las credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_springboot
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Instalación y Ejecución
Clona el repositorio e instala las dependencias:
```sh
https://github.com/carpiom-dev/springboot.mvc.crud.git
cd tu-repo
mvn clean install
mvn spring-boot:run
```

Accede a la aplicación en `http://localhost:8080/users`

## 📷 Capturas de Pantalla
- **Listado de usuarios**
  ![image](https://github.com/user-attachments/assets/6943ee74-b1e0-40ad-b887-9e7d3e2b6d6a)

- **Editar Usuario**
  ![image](https://github.com/user-attachments/assets/b25ebee3-3b47-4dbe-9c2f-e2eeaf4792d2)

- **Crear Usuario**
  ![image](https://github.com/user-attachments/assets/0cbaee4f-231c-40f7-af6b-b41c828b7e28)

- **Eliminar Usuario**
  ![image](https://github.com/user-attachments/assets/d305ae1d-d8f4-450d-8bc0-24a90d51a994)

---
💡 *Desarrollado con pasión por [dev. Adrian Carpio](https://github.com/carpiom-dev/carpiom-dev)*.

