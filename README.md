# API de Soporte Tecnico de Clientes, Técnicos y Solicitudes

## Descripción del Proyecto

Esta API REST permite dar soporte clientes, técnicos y solicitudes de servicio, dentro de un sistema de soporte técnico.
El sistema permite registrar clientes, asignar técnicos y crear solicitudes de servicio para atender diferentes incidencias.

La API está desarrollada utilizando **Spring Boot** y sigue una arquitectura REST, devolviendo respuestas en formato **JSON**.

---

## Tecnologías Utilizadas

* Java 21
* Spring Boot
* Spring Web
* Maven
* Postman para pruebas de endpoints
* Git y GitHub para control de versiones

---

## Estructura del Proyecto

```
proyecto-api/
│
├── src/
│   ├── main/
│   │   ├── java/pe.edu.idat.proyecto.gestion
│   │   │   ├── controller
│   │   │   ├── Config
│   │   │   ├── dto
│   │   │   ├── service
│   │   │   ├── repository
│   │   │   └── model
│   │   │
│   │   └── resources
│   │       └── application.properties
│
├── postman/
│   └── api-collection.json
│
├── README.md
└── pom.xml
```

---

## Instalación del Proyecto

### 1. Clonar el repositorio

```bash
https://github.com/josuelmb/ComponentesJAVA
```

### 2. Entrar al proyecto

```bash
cd ComponentesJAVA
```

### 3. Instalar dependencias

```bash
mvn clean install
```

### 4. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación se ejecutará en:

```
http://localhost:8080
```

---

# Endpoints de la API

Base URL:

```
http://localhost:8080
```

---

# Clientes

Ruta base:

```
/v1/clientes
```

| Método | Endpoint          | Descripción                |
| ------ | ----------------- | -------------------------- |
| GET    | /v1/clientes      | Obtener todos los clientes |
| GET    | /v1/clientes/{id} | Obtener cliente por ID     |
| POST   | /v1/clientes      | Crear un nuevo cliente     |
| PUT    | /v1/clientes/{id} | Actualizar cliente         |
| DELETE | /v1/clientes/{id} | Eliminar cliente           |

### Ejemplo Crear Cliente

POST

```
/v1/clientes
```

Body:

```json
  {"dni" : "12345678",
  "nombre": "Maria",
  "ApellidoPaterno": "Manzanedo",
  "ApellidoMaterno": "Puelles",
  "Correo": "Mpuelles@gmail.com"
}
```

Respuesta:

```json
  {
        "idCliente": 2,
        "dni": "12345678",
        "nombre": "Maria",
        "ApellidoPaterno": "Manzanedo",
        "ApellidoMaterno": "Puelles",
        "Correo": "Mpuelles@gmail.com",
        "fechaRegistro": "2026-03-11T05:26:23.359Z"
    }
```
### Obtener todos los clientes

GET /v1/clientes

Respuesta:

```json
  {
  {
    "idCliente": 1,
    "dni": "12345678",
    "nombre": "Maria",
    "ApellidoPaterno": "Manzanedo",
    "ApellidoMaterno": "Puelles"
  }
```

# Técnicos

Ruta base:

```
/v1/tecnicos
```

| Método | Endpoint          | Descripción                |
| ------ | ----------------- | -------------------------- |
| GET    | /v1/tecnicos      | Obtener todos los técnicos |
| GET    | /v1/tecnicos/{id} | Obtener técnico por ID     |
| POST   | /v1/tecnicos      | Crear técnico              |
| PUT    | /v1/tecnicos/{id} | Actualizar técnico         |
| DELETE | /v1/tecnicos/{id} | Eliminar técnico           |

### Ejemplo Crear Técnico

```json
{
    "dni" : "98678541",
    "nombre": "Anthony",
    "apellido": "Casanova",
    "especialidad": "Android"
}
```
Respuesta:

```json
{
  "id": 1,
  "dni": "98678541",
  "nombre": "Anthony",
  "apellido": "Casanova",
  "especialidad": "Android"
}
```

---

# Solicitudes

Ruta base:

```
/solicitudes
```

| Método | Endpoint          | Descripción                   |
| ------ | ----------------- | ----------------------------- |
| GET    | /solicitudes      | Obtener todas las solicitudes |
| GET    | /solicitudes/{id} | Obtener solicitud por ID      |
| POST   | /solicitudes      | Crear solicitud               |
| PUT    | /solicitudes/{id} | Actualizar solicitud          |
| DELETE | /solicitudes/{id} | Eliminar solicitud            |

### Ejemplo Crear Solicitud

```json
{
    "descripcion" : "mi iphone no reconoce el faceid",
    "estado" : "Activo",
    "dniCliente" : "12345678",
    "dniTecnico": "98678541"
}
```
Respuesta:

```json
{
    "idSolicitud": 1,
    "descripcion": "mi iphone no reconoce el faceid",
    "estado": "Activo",
    "fechaRegistro": "2026-03-11T06:35:00.250Z",
    "cliente": {
        "idCliente": 1,
        "dni": "12345678",
        "nombre": "Maria",
        "ApellidoPaterno": "Manzanedo",
        "ApellidoMaterno": "Puelles",
        "Correo": "Mpuelles@gmail.com",
        "fechaRegistro": "2026-03-11T06:34:35.334Z"
    },
    "tecnico": {
        "idTecnico": 1,
        "dni": "98678541",
        "nombre": "Anthony",
        "apellido": "Casanova",
        "especialidad": "Android"
    }
}
```
---

# Comportamiento de la API

La API sigue principios **RESTful** y maneja tres entidades principales:

* Clientes
* Técnicos
* Solicitudes de servicio

Las solicitudes pueden estar asociadas a un cliente y a un técnico responsable.

Todas las respuestas se devuelven en formato **JSON** y utilizan códigos de estado HTTP estándar.

| Código | Significado                |
| ------ | -------------------------- |
| 200    | Operación exitosa          |
| 201    | Recurso creado             |
| 404    | Recurso no encontrado      |
| 500    | Error interno del servidor |

---

# Pruebas de la API

Las pruebas de los endpoints se realizaron utilizando la aplicación **Postman**.

Para probar la API:

1. Abrir Postman
2. Importar la colección ubicada en:

```
/postman/api-collection.json
```

3. Ejecutar cada endpoint.

---
Repositorio del proyecto:

https://github.com/josuelmb/ComponentesJAVA

# Autor

Josue Manzanedo
Anthony Puelles
Diego Casanova

Proyecto académico
Año: 2026

---

# Licencia
Proyecto Soporte Tecnico a clientes

Este proyecto fue desarrollado con fines educativos.
