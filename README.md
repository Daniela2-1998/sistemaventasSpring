<h1 align="center"> Sistema de ventas - Microservicios. </h1>

> [!IMPORTANT]\
> Actualmente, el README y el proyecto se encuentran en desarrollo por lo que podrán encontrar funcionalidades faltantes o sin mencionar en el actual documento.

## :computer: Descripción del proyecto:
Sistema de ventas desarrollador con Java, Spring, Maven y PostgreSQL bajo una arquitectura de microservicios dividida en varios subproyectos, de forma tal que facilite la estructura, dinamismo y funcionalidad 
del código al dividir responsabilidades según temática y función. De esta forma, en este mismo proyecto encontrarás varias carpetas correspondientes a cada una de estas APIs. 

### Tecnologías usadas:
- Maven
- Java
- Spring
- PostgreSQL
- Postman (testing)

#### Objetivos:
- Proporcionar una solución eficiente para la gestión de ventas.
- Mejorar el registro de usuarios, empleados, clientes, proveedores, stock y logística de empresas.
- Demostrar la implementación práctica de una arquitectura de microservicios.
- Facilitar la escalabilidad y el mantenimiento del sistema.

### Instalación: 
1. Hacer click en el botón verde "Code".
![image](https://github.com/user-attachments/assets/2c0106b2-577c-4d84-a09c-e05a212459ae)
2. Elegimos la opción más cómoda de descarga de código, pudiendo elegir entre: HTTPS, SSH, abrir con GitHub Desktop o descargarlo como ZIP.

![image](https://github.com/user-attachments/assets/7c228deb-3f13-425d-b61d-fb777a49c8c5)

### Uso de APIs: 
Se recomienda acceder a la documentación Swagger correspondiente para cada uno:
- **Sistema ventas:** http://localhost:5050/swagger-ui/index.html#/
- **Registros sistema de ventas:** http://localhost:5051/swagger-ui/index.html#/


### Microservicios:
- **Servidor Eureka:** contiene un servidor al cuál se conectan los microservicios.
- **Sistema ventas:** pendiente del cambio de nombre, este microservicio abarca el manejo de la mercadería en sí. Permite administrar información relativa a la mercadería (ID o código de producto, nombre,
descripción, cantidad, precio, y su relación con una marca y una categoría), marca y categoría.
- **Registros sistema de ventas:** permite el manejo de los registros personales, es decir, de usuarios, empleados, clientes y proveedores de una empresa. Los empleados registrados se vinculan a un usuario
 existente.


