# Sistema de Gestión Hotelera

Este proyecto es una **API RESTful** diseñada para la gestión de usuarios, habitaciones y reservas de un hotel. Utiliza **Spring Boot** y **MySQL** como base de datos. Implementa **Spring Security** para la gestión de autenticación y autorización de usuarios, con roles de **Admin** y **User**.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security** para la gestión de autenticación y autorización
- **JPA/Hibernate** para la gestión de la base de datos
- **MySQL** como base de datos
- **Lombok** para reducir el código repetitivo
- **Maven** para la gestión de dependencias

## Descripción de las Operaciones CRUD

### 1. Gestión de Usuarios

#### **GET /api/usuarios/**
Obtiene todos los usuarios registrados.

- **Respuesta**: Lista con todos los usuarios en la base de datos.

#### **GET /api/usuarios/{id}**
Obtiene un usuario por su ID.

- **Parámetro**: `id` (ID del usuario)
- **Respuesta**: Detalles del usuario especificado o un error 404 si no existe.

#### **POST /api/usuarios/registrar**
Registra un nuevo usuario.

- **Cuerpo de la solicitud (JSON)**:
  ```json
  {
    "email": "usuario@ejemplo.com",
    "password": "contraseña123",
    "rolesIds": [1, 2]
  }
  - ** Respuesta
   {
  "message": "Usuario registrado con éxito."
  }
  

