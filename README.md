# 🛒 Sistema de Ventas - Microservicios

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

> [!IMPORTANT]
> Este proyecto está actualmente en desarrollo. Algunas funcionalidades pueden estar incompletas o no mencionadas en este documento.

## 📋 Índice
- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Objetivos](#-objetivos)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación](#-instalación)
- [Uso de APIs](#-uso-de-apis)
  - [Configuración de la Base de Datos](#️-configuración-de-la-base-de-datos)
- [Microservicios](#-microservicios)
- [Servidor Eureka](#-servidor-eureka)
  - [Configuración de servidores](#️-configuración-de-servidores)
  - [Pasos para configurar un servidor propio](#pasos-para-configurar-un-servidor-propio)
- [Sistema de ventas productos](#-sistema-de-ventas-productos)
  - [Métodos y endpoints](#métodos-y-endpoints)
  - [Productos](#productos)
  - [Marcas y categorías](#marcas-y-categorías)
- [Sistema de registros](#-sistema-de-registros)
  - [Métodos y endpoints](#métodos-y-endpoints-1)
  - [Usuarios](#usuarios)
  - [Empleados](#empleados)
  - [Proveedores](#proveedores)
  - [Clientes](#clientes)
- [Solución de Problemas](#-solución-de-problemas)
- [Pasos para configurar una API](#pasos-para-configurar-una-api)
- [Contacto](#-contacto)
- [Licencia](#-licencia)
- [Agradecimientos](#-agradecimientos)



## 💼 Descripción del Proyecto

Este sistema de ventas está desarrollado bajo una arquitectura de microservicios, dividida en varios subproyectos. Esta estructura facilita la organización, dinamismo y funcionalidad del código al separar responsabilidades según temática y función. El sistema de ventas surje ante la necesidad de empresas, tiendas, negocios y emprendimientos, de utilizar un sistema de gestión de negocio múltiple que 
permita gestionar los productos, marcas, categorías, stock, operaciones (compra, venta, importación, exportación, logística, contrato de empleados, reapraciones), usuarios, empleados, clientes, 
proveedores y la contabilidad (ingresos, egresos, gastos varios). 

## 🛠 Tecnologías Utilizadas

- Java 17
- Spring Boot 3.3.1
- Maven 3.8.4
- PostgreSQL 14
- Postman (para testing)

## 🎯 Objetivos

- Proporcionar una solución eficiente para la gestión de ventas.
- Mejorar el registro de usuarios, empleados, clientes, proveedores, stock y logística de empresas.
- Demostrar la implementación práctica de una arquitectura de microservicios.
- Facilitar la escalabilidad y el mantenimiento del sistema.

## 🚀 Instalación

1. Haz clic en el botón verde "Code".
   ![Botón Code](https://github.com/user-attachments/assets/2c0106b2-577c-4d84-a09c-e05a212459ae)

2. Elige la opción de descarga que prefieras: HTTPS, SSH, GitHub Desktop o ZIP.
   ![Opciones de descarga](https://github.com/user-attachments/assets/7c228deb-3f13-425d-b61d-fb777a49c8c5)

3. Clona o descarga el repositorio en tu máquina local.

4. Abre el proyecto en tu IDE favorito.

5. Ejecuta `mvn clean install` en la raíz del proyecto para instalar las dependencias.

Otra forma sencilla de clonarlo es desde la Git bash:
1. Clona el repositorio: git clone [https://github.com/Daniela2-1998/sistemaventasSpring](https://github.com/Daniela2-1998/sistemaventasSpring)
2. Navega al directorio del proyecto: `cd sistema-ventas-microservicios`
3. Compila el proyecto: `mvn clean install`

## 📋 Requisitos Previos
Antes de comenzar, asegúrate de tener instalado:

- JDK 17 o superior
- Maven 3.8.4 o superior
- PostgreSQL 14
- Docker (opcional, para contenerización)

## 📚 Uso de APIs

Se recomienda acceder a la documentación Swagger correspondiente para cada API:

- **Sistema ventas:** [http://localhost:5050/swagger-ui/index.html#/](http://localhost:5050/swagger-ui/index.html#/)
- **Registros sistema de ventas:** [http://localhost:5051/swagger-ui/index.html#/](http://localhost:5051/swagger-ui/index.html#/)

### ⚙️ Configuración de la Base de Datos
1. Crea una base de datos en PostgreSQL:
```
CREATE DATABASE sistemaventas;
```
2. Actualiza las credenciales de la base de datos en application.yml de cada microservicio.

## 🔗 Microservicios

- **Servidor Eureka:** Contiene un servidor al cual se conectan los microservicios.
- **Sistema ventas:** Abarca el manejo de la mercadería. Administra información relativa a productos, marcas y categorías.
- **Registros sistema de ventas:** Maneja los registros personales (usuarios, empleados, clientes y proveedores).

## 🖥 Servidor Eureka

El servidor Eureka aloja las APIs del sistema de microservicios.

### ⚙️ Configuración de servidores

1. Ejecuta el proyecto en tu IDE.
2. Accede a [http://localhost:8761/](http://localhost:8761/) desde tu navegador para ver las APIs activas.

### Pasos para configurar un servidor propio

1. Añade las siguientes dependencias en el `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
</dependencies>
```

2.Incluye la configuración de dependencias:
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
Crea un archivo ```application.yml``` con la siguiente configuración:
```yml
spring:
  application:
    name: eureka-server
server:
  port: 8761
eureka:
  client:
    registerWithEureka: false
    fetchRegistry: false
```
Añade la anotación ```@EnableEurekaServer``` en la clase principal de la aplicación.

## 🖥 Sistema de ventas productos
Como se mencionó previamente, se trata de un sistema que gestiona los productos de un negocio, empresa o tienda, de forma tal que se puedan incluir y modificar detalles adicionales como 
la marca y la categoría de un producto para una mejor distinción y una mejor busqueda por filtros.

Este sistema trabaja con el puerto ```5050``` - [localhost:5050/productos](http://localhost:5050/productos).
> [!IMPORTANT]
> Además de productos, actualmente se puede acceder a categorias y marcas, debiendo cambiar la palabra "productos" por la correspondiente.
> De momento es un sistema sencillo que cumple con las funciones básicas de un CRUD.
 
#### Métodos y endpoints
Antes que nada, vuelvo a mencionar la importancia de acceder y leer el Swagger para un mejor entendimiento del proyecto: 
[http://localhost:5050/swagger-ui/index.html#/](http://localhost:5050/swagger-ui/index.html#/)

```
 PRODUCTOS:
    GET:
       - http://localhost:5050/productos
       - http://localhost:5050/productos/{ID}
    POST:
        - http://localhost:5050/productos/agregar
    PUT:
        - http://localhost:5050/productos/actualizar
    DELETE:
        - http://localhost:5050/productos/eliminar/{ID}
```

```
 MARCAS:
    GET:
       - http://localhost:5050/marcas
       - http://localhost:5050/marcas/{ID}
    POST:
        - http://localhost:5050/marcas/agregar
    PUT:
        - http://localhost:5050/marcas/actualizar
    DELETE:
        - http://localhost:5050/marcas/eliminar/{ID}
```

```
 CATEGORIAS:
    GET:
       - http://localhost:5050/categorias
       - http://localhost:5050/categorias/{ID}
    POST:
        - http://localhost:5050/categorias/agregar
    PUT:
        - http://localhost:5050/categorias/actualizar
    DELETE:
        - http://localhost:5050/categorias/eliminar/{ID}
```

#### Productos:
```
GET
[
  {
    "id": 0,
    "nombre": "string",
    "descripcion": "string",
    "cantidad": 0,
    "precio": 0,
    "categoria": {
      "id": 0,
      "nombre": "string"
    },
    "marca": {
      "id": 0,
      "nombre": "string"
    }
  }
]
```

```
POST
{
  "nombre": "string",
  "descripcion": "string",
  "cantidad": 0,
  "precio": 0,
  "categoria": {
    "id": 0,
    "nombre": "string"
  },
  "marca": {
    "id": 0,
    "nombre": "string"
  }
}
```

```
PUT
{
  "id": 0,
  "nombre": "string",
  "descripcion": "string",
  "cantidad": 0,
  "precio": 0,
  "categoria": {
    "id": 0,
    "nombre": "string"
  },
  "marca": {
    "id": 0,
    "nombre": "string"
  }
}
```

#### Marcas y categorías
```
GET
[
  {
    "id": 0,
    "nombre": "string"
  }
]
```

```
POST
{
  "nombre": "string"
}
```

## 🖥 Sistema de registros
Como se mencionó previamente, se trata de un sistema que gestiona los registros personales, es decir, de usuarios, empleados, clientes y proveedores de una tienda, local, negocio, mercado o emprendimiento. 
Los empleados registrados deben vincularse a un usuario previamente ingresado en el sistema. Se trata de un proyecto experimental más robusto que el anterior ya que incluye una APIResponse para devolver respuestas personalizadas en los endpoints determinados y devolver un HttpStatus adecuado, el uso de Logs como practica y comprobación del funcionamiento, paginación para la devolución de todos los registros
en el método GET ALL, y uso de IA para sugerencias y mejores practicas. 

Este sistema trabaja con el puerto ```5051``` - [localhost:5051/usuarios](http://localhost:5051/usuarios).

> [!IMPORTANT]
> De momento es un sistema sencillo que cumple con las funciones básicas de un CRUD.
 
#### Métodos y endpoints
Antes que nada, vuelvo a mencionar la importancia de acceder y leer el Swagger para un mejor entendimiento del proyecto: 
[http://localhost:5051/swagger-ui/index.html#/](http://localhost:5051/swagger-ui/index.html#/)

```
 USUARIOS:
    GET:
       - http://localhost:5051/usuarios
       - http://localhost:5051/usuarios/{ID}
    POST:
        - http://localhost:5051/usuarios/agregar
    PUT:
        - http://localhost:5051/usuarios/actualizar
    DELETE:
        - http://localhost:5051/usuarios/eliminar/{ID}
```

```
 EMPLEADOS:
    GET:
       - http://localhost:5051/emoleados
       - http://localhost:5051/emoleados/{ID}
    POST:
        - http://localhost:5051/emoleados/agregar
    PUT:
        - http://localhost:5051/emoleados/actualizar
    DELETE:
        - http://localhost:5051/emoleados/eliminar/{ID}
```

```
 CLIENTS:
    GET:
       - http://localhost:5051/clientes
       - http://localhost:5051/clientes/{ID}
    POST:
        - http://localhost:5051/clientes/agregar
    PUT:
        - http://localhost:5051/clientes/actualizar
    DELETE:
        - http://localhost:5051/clientes/eliminar/{ID}
```

```
 PROVEEDORES:
    GET:
       - http://localhost:5051/proveedores
       - http://localhost:5051/proveedores/{ID}
    POST:
        - http://localhost:5051/proveedores/agregar
    PUT:
        - http://localhost:5051/proveedores/actualizar
    DELETE:
        - http://localhost:5051/uproveedores/eliminar/{ID}
```

#### Usuarios:
```
GET
[
  {
    "id": 0,
    "nombreUsuario": "string",
    "contraseña": "string",
    "mail": "string",
    "rol": "VISITANTE",
    "estado": "ACTIVO"
  }
]
```

```
POST
{
  "nombreUsuario": "string",
  "contraseña": "c}d1e/ YypL[%<s",
  "mail": "string",
  "rol": "VISITANTE",
  "estado": "ACTIVO"
}
```
```
PUT
{
  "id": 0,
  "nombreUsuario": "string",
  "contraseña": "O%2+LKp>{,kSRm&",
  "mail": "string",
  "rol": "VISITANTE",
  "estado": "ACTIVO"
}
```

#### Empleados:
```
GET
{
  "totalPages": 0,
  "totalElements": 0,
  "first": true,
  "last": true,
  "size": 0,
  "content": [
    {
      "id": 0,
      "nombreCompleto": "string",
      "fechaNacimiento": "2024-07-18",
      "cargo": "string",
      "telefono": "string",
      "salario": 0,
      "usuario": {
        "id": 0,
        "nombreUsuario": "string",
        "contraseña": "string",
        "mail": "string",
        "rol": "VISITANTE",
        "estado": "ACTIVO"
      }
    }
  ],
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": true,
    "unsorted": true
  },
  "numberOfElements": 0,
  "pageable": {
    "offset": 0,
    "sort": {
      "empty": true,
      "sorted": true,
      "unsorted": true
    },
    "paged": true,
    "pageNumber": 0,
    "pageSize": 0,
    "unpaged": true
  },
  "empty": true
}
```

```
POST
{
  "nombreCompleto": "string",
  "fechaNacimiento": "2024-07-18",
  "cargo": "string",
  "telefono": "677299643",
  "salario": 0,
  "usuario": {
    "id": 0,
    "nombreUsuario": "string",
    "contraseña": "string",
    "mail": "string",
    "rol": "VISITANTE",
    "estado": "ACTIVO"
  }
}
```

```
PUT
{
  "id": 0,
  "nombreCompleto": "string",
  "fechaNacimiento": "2024-07-18",
  "cargo": "string",
  "telefono": "372605211",
  "salario": 0,
  "usuario": {
    "id": 0,
    "nombreUsuario": "string",
    "contraseña": "string",
    "mail": "string",
    "rol": "VISITANTE",
    "estado": "ACTIVO"
  }
}
```

#### Proveedores:
```
GET
[
  {
    "id": 0,
    "empresa": "string",
    "identificacion": "string",
    "mail": "string",
    "telefono": "string",
    "direccion": "string",
    "contacto": "string",
    "tipo": "PRODUCTOS",
    "descripcion": "string",
    "fechaRegistro": "2024-07-18"
  }
]
```

```
POST
{
  "empresa": "string",
  "identificacion": "string",
  "mail": "string",
  "telefono": "97636663953",
  "direccion": "string",
  "contacto": "string",
  "tipo": "PRODUCTOS",
  "descripcion": "string",
  "fechaRegistro": "2024-07-18"
}
```

```
PUT
{
  "id": 0,
  "empresa": "string",
  "identificacion": "string",
  "mail": "string",
  "telefono": "+709322653",
  "direccion": "string",
  "contacto": "string",
  "tipo": "PRODUCTOS",
  "descripcion": "string",
  "fechaRegistro": "2024-07-18"
}
```

#### Clientes:
```
GET
{
  "totalPages": 0,
  "totalElements": 0,
  "first": true,
  "last": true,
  "size": 0,
  "content": [
    {
      "id": 0,
      "nombre": "string",
      "fechaNacimiento": "2024-07-18",
      "dni": "string",
      "telefono": "string",
      "direccion": "string",
      "tipo": "INDIVIDUAL"
    }
  ],
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": true,
    "unsorted": true
  },
  "numberOfElements": 0,
  "pageable": {
    "offset": 0,
    "sort": {
      "empty": true,
      "sorted": true,
      "unsorted": true
    },
    "paged": true,
    "pageNumber": 0,
    "pageSize": 0,
    "unpaged": true
  },
  "empty": true
}
```

```
POST
{
  "nombre": "string",
  "fechaNacimiento": "2024-07-18",
  "dni": "string",
  "telefono": "117142864",
  "direccion": "string",
  "tipo": "INDIVIDUAL"
}
```

```
PUT
{
  "id": 0,
  "nombre": "string",
  "fechaNacimiento": "2024-07-18",
  "dni": "string",
  "telefono": "25133293039",
  "direccion": "string",
  "tipo": "INDIVIDUAL"
}
```


## 🔧 Solución de Problemas
### Problema: No se puede conectar a Eureka Server
Solución: Verifica que Eureka Server esté en ejecución y que la configuración en application.yml sea correcta.

### Problema: Error al iniciar un microservicio
Solución: Asegúrate de que la base de datos esté en funcionamiento y las credenciales sean correctas.

### Pasos para configurar una API
Cada API es diferente y necesita diferentes dependencias para funcionar, pero en el caso de esta API, fue necesario incluir las siguientes dependencias en el **pom.xml**:

```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>jakarta.validation</groupId>
			<artifactId>jakarta.validation-api</artifactId>
			<version>3.1.0</version>
		</dependency>
		<dependency>
			<groupId>org.modelmapper</groupId>
			<artifactId>modelmapper</artifactId>
			<version>3.1.1</version>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.3.0</version>
		</dependency>

	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
```
También se debió incluir las siguientes líneas dentro del properties.yml:
```yml
  springdoc:
    api-docs:
      path: /api-docs
      enabled: true
    swagger-ui:
      path: /swagger-ui.html
      enabled: true

server:
  port: 5050

eureka:
  client:
    registerWithEureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: ${EUREKA_URI:http://localhost:8761/eureka}
    instance:
      preferIpAddress: true
```
Y finalmente, en cada API se incluye la anotación ```@EnableDiscoveryClient``` dentro del application.class.

## 📞 Contacto
Para cualquier pregunta o sugerencia, por favor abre un issue en este repositorio.

## 📄 Licencia
Este proyecto está bajo la Licencia MIT. Ver el archivo LICENSE para más detalles.

## 🙏 Agradecimientos
- Spring Boot por el framework
- PostgreSQL por el sistema de gestión de base de datos
- GitLab duo chat por las sugerencias, recomendaciones y agilizar el trabajo
