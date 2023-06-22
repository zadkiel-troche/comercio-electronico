## Objetivo del Trabajo 
El objetivo de este trabajo grupal es desarrollar un panel de control para una aplicación de comercio electrónico utilizando Spring Boot, Spring JPA, Spring Security, Thymeleaf, Bootstrap y Font Awesome en conjunto con MariaDB. 
El panel de control permitirá a los usuarios, que están asociados a una empresa, cargar y gestionar los datos de sus productos, en este caso, teléfonos móviles. Los usuarios pueden modificar los datos de su empresa y los productos asociados a su empresa, pero no pueden ver ni modificar los datos introducidos por otras empresas. 
Además, habrá un usuario con un rol de administrador que no está asociado a ninguna empresa. Este usuario puede modificar todos los datos de las empresas y es el único que puede crear usuarios y empresas en la aplicación.

**Estructura Tentativa de las Entidades:**
1. Usuario: id (clave primaria), nombre, correo electrónico, contraseña, empresa (relación muchos a uno con Empresa), roles (relación muchos a muchos con Rol).
2. Empresa: id (clave primaria), nombre, dirección, teléfono, usuarios (relación uno a muchos con Usuario), productos (relación uno a muchos con Producto).
3. Producto: id (clave primaria), nombre, descripción, marca (relación muchos a uno con Marca), empresa (relación muchos a uno con Empresa), tamaño de pantalla, memoria de almacenamiento, memoria RAM, sistema operativo, procesador, y cualquier otro campo que sea relevante para describir las características del producto.
4. Marca: id (clave primaria), nombre, productos (relación uno a muchos con Producto).
5. Rol: id (clave primaria), nombre, usuarios (relación muchos a muchos con Usuario).

**Fecha de Entrega y Defensa Oral:** 
La entrega del trabajo debe realizarse el 27 de junio, fecha en la que también se llevará a cabo una defensa oral del proyecto.

**Criterios de Evaluación para el Trabajo de Programación:**
1. Correcta implementación de las funcionalidades requeridas.
2. Correcta utilización de las tecnologías especificadas.
3. Calidad del código (claridad, organización, eficiencia).
4. Estética y usabilidad de la interfaz de usuario.
5. Colaboración efectiva dentro del grupo.
6. Presentación de un informe detallado que incluya una descripción de las contribuciones de cada miembro del grupo.

## Versiones de Compatibilidad
> Version de Java: 17

## Dependencias
> Spring Boot DevTools

> Spring Security

> Spring Web

> Thymeleaf

> Spring Data JPA

> MariaDB Driver

> Bootstrap

> FontAwesome

> WebJars Locator

### Integrantes
> Lizandro Britto

> Jeremias Ojeda

> Jonhatan Lopez

> Zadkiel Troche

> Rodrigo Bogado

> Nicolas Hein
