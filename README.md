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


### Resumen de lo añadido:

- **Operaciones CRUD** completas para **Usuarios**, **Habitaciones** y **Reservas**.
- **Roles de seguridad** con **Spring Security**: Diferenciación entre **Admin** y **User**.
- Configuración para conectar con una base de datos **MySQL**.


## Seguridad y Roles de Usuario
La aplicación está protegida con Spring Security. Los usuarios se pueden autenticar con el sistema, y el acceso a algunos endpoints está restringido según el rol del usuario. Los roles son los siguientes:

- **Admin**: Tiene acceso completo a todos los endpoints de la API, incluyendo la creación y eliminación de usuarios, habitaciones y reservas.
- **User**: Puede acceder solo a ciertos endpoints, como obtener información sobre habitaciones y realizar reservas, pero no puede eliminar o crear nuevos recursos.
### Roles y Autenticación
- **Admin**: Usuario con permisos completos para gestionar todos los recursos del sistema.
- **User**: Usuario regular que puede consultar recursos como habitaciones y realizar reservas.
**Los usuarios pueden autenticarse utilizando las credenciales en formato Basic Authentication (usuario y contraseña). Por ejemplo:

Username: admin@hotel.com
Password: admin123
O también puedes crear tu propio usuario utilizando el endpoint /api/usuarios/registrar.

Base de Datos
El proyecto utiliza MySQL como base de datos persistente. Para conectar tu base de datos, debes configurar las credenciales en el archivo src/main/resources/application.properties.
  

