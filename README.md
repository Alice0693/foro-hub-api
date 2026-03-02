# foro-hub-api

🛡️ Foro Hub API - Solución al Desafío📝 

📝 Descripción del Proyecto
Este proyecto es una API RESTful desarrollada como parte de un desafío de backend. El objetivo principal es gestionar tópicos de un foro de discusión, permitiendo realizar operaciones CRUD (Create, Read, Update, Delete) completas. La API garantiza la integridad de los datos y, fundamentalmente, la seguridad mediante un sistema de autenticación basado en tokens JWT (JSON Web Tokens).

🛠️ Tecnologías y Herramientas
Lenguaje: Java 17

Framework: Spring Boot 3

Persistencia: Spring Data JPA / Hibernate

Base de Datos: MySQL

Seguridad: Spring Security con JWT

Documentación: OpenAPI / Swagger (opcional, si lo agregaste)

Testing de API: Insomnia 

🔐 Seguridad y Autenticación (JWT)

El acceso a los endpoints está protegido para asegurar que solo usuarios autorizados puedan manipular los datos. El flujo de seguridad implementado es:

Autenticación (POST /login): El usuario envía sus credenciales (email y password). Si son correctas, el servidor genera un token JWT firmado y lo devuelve en la respuesta.

Validación de Token: Para cada petición posterior a endpoints protegidos, el cliente debe incluir el token en el Header de la petición usando el esquema Bearer:

Authorization: Bearer <TU_TOKEN_AQUI>

Filtro de Seguridad: Un filtro personalizado (SecurityFilter) intercepta cada solicitud, valida el token, extrae el usuario y autoriza el acceso al recurso solicitado, manteniendo la arquitectura Stateless (sin estado).

🚀 Endpoints de la API
Método       Endpoint         Descripción                                 Requiere Auth
POST         /login           Iniciar sesión y obtener token JWT            No
POST         /topicos         Registrar un nuevo tópico                     Sí
GET          /topicos         Listar todos los tópicos                      Sí
GET          /topicos/{id}    Ver detalles de un tópico específico          Sí
PUT          /topicos/{id}    Actualizar información de un tópico           Sí
DELETE       /topicos/{id}    Eliminar un tópico                            Sí

📋 Requisitos para Ejecución

JDK 17 o superior instalado.

MySQL Server configurado localmente.

Crear la base de datos foro_hub antes de ejecutar la aplicación.

Configurar las credenciales de base de datos en el archivo src/main/resources/application.properties:

Properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

💡 Instrucciones de Uso

Clona el repositorio a tu máquina local.

Importa el proyecto en tu IDE (IntelliJ IDEA recomendado).

Asegúrate de que las dependencias de Maven se descarguen correctamente.

Inicia la aplicación.

Utiliza Insomnia para importar la colección de endpoints y comenzar a probar la API enviando el token generado tras el login.

