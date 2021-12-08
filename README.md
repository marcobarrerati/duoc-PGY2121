# Biblioteca 
## java, mysql

### Dependencias
* mysql-connector-java-8.0.25.jar
* swingx-0.9.5-2.jar: Date Picker
### Características y Funcionalidades
* Registrar Libros
* Actualizar Libros
* Buscar Libros
* Eliminar Libros
* Patrón de Arquitectura MVC
### Iniciar base de datos
1. Instalar [docker](https://www.docker.com/), para utilizar archivo[docker compose](https://docs.docker.com/compose/) para levantar servidor de base de datos MySQL
    1. Configurar credenciales en archivo .env
    1. Ejecutar comando docker-compose up --build
 ### Iniciar proyecto netbeans
 1. Instalar librerias .jar , mysql-connector-java-8.0.25.jar y swingx-0.9.5-2.jar. La primera permite conectar java con mysql y la segunda nos aporta el datepicker
 1. Configurar archivo ConexionModel.java con las credenciales utilizadas en el archivo .env
 1. Ejecutar proyecto en netbeans

