# Sistema de Gestión Hotelera

Este proyecto es una **API RESTful** diseñada para la gestión de usuarios, habitaciones y reservas de un hotel. Utilizando **Spring Boot**, esta aplicación permite realizar operaciones como registrar usuarios, gestionar habitaciones, realizar reservas y eliminarlas, todo a través de una interfaz de servicios web.

## Características

- Registro y gestión de **usuarios** con roles (admin, user).
- **Autenticación** básica utilizando Spring Security.
- Gestión de **habitaciones** (crear, eliminar, obtener por ID).
- Creación y eliminación de **reservas** de habitaciones para los usuarios.
- Base de datos integrada con **H2** (en memoria) que puede ser cambiada fácilmente a **MySQL** o **PostgreSQL**.

## Tecnologías utilizadas

- **Spring Boot**: Framework principal para construir la API RESTful.
- **Spring Security**: Implementación de autenticación y autorización de usuarios.
- **Spring Data JPA**: Interacción con la base de datos a través de repositorios.
- **H2 Database**: Base de datos en memoria para pruebas.
- **Lombok**: Para la generación automática de getters, setters, constructores, etc.
- **Postman**: Herramienta utilizada para probar los endpoints de la API.
- **Maven**: Para la gestión de dependencias y construcción del proyecto.

## Endpoints de la API

### 1. Gestión de Usuarios

- **POST /api/usuarios/registrar**: Registra un nuevo usuario.
- **GET /api/usuarios/**: Obtiene todos los usuarios registrados.
- **GET /api/usuarios/{id}**: Obtiene un usuario por su ID.
- **DELETE /api/usuarios/{id}**: Elimina un usuario por su ID.

### 2. Gestión de Habitaciones

- **GET /api/habitaciones/**: Obtiene todas las habitaciones disponibles.
- **GET /api/habitaciones/{id}**: Obtiene una habitación por su ID.
- **POST /api/habitaciones/guardar**: Guarda una nueva habitación.
- **DELETE /api/habitaciones/{id}**: Elimina una habitación por su ID.

### 3. Gestión de Reservas

- **GET /api/reservas/**: Obtiene todas las reservas existentes.
- **GET /api/reservas/{id}**: Obtiene una reserva por su ID.
- **POST /api/reservas/crear**: Crea una nueva reserva.
- **DELETE /api/reservas/{id}**: Elimina una reserva por su ID.

