# Integrador_Backend

### **Funcionamiento:** 

**Se pretende instaurar un procedimiento que posibilite regular la organización de la programación de citas en una clínica odontológica.**
#### **Entre los requisitos necesarios se encuentran:**

- Control de los datos de los pacientes: listar, agregar, modificar y eliminar pacientes. Almacenar el nombre, el apellido, el domicilio, el DNI y la fecha de alta de cada uno de ellos.
- Control de los datos de los especialistas en odontología: listar, agregar, modificar y eliminar los registros de los profesionales de la odontología. Registrar el apellido, el nombre y la matrícula de los mismos.
- Incluir las citas en el sistema: seControl de los datos de los pacientes: listar, agregar, modificar y eliminar pacientes. Almacenar el nombre, el apellido, el domicilio, el DNI y la fecha de alta de cada uno de ellos. debe tener la capacidad de asignar a un paciente una cita con un odontólogo en una fecha y hora específicas.
- Acceso al sistema: validar la entrada al programa mediante un acceso con nombre de usuario y contraseña. Todos los usuarios logueados (ROLE_USER) podrán registrar una cita, pero solo aquellos con un rol de administración (ROLE_ADMIN) podrán manejar los datos de los profesionales y los pacientes. Cada usuario podrá tener un solo rol, y los roles se añadirán directamente en la base de datos.

#### Tecnologias a utilizar:
La aplicación debe ser desarrollada en capas:
- Capa de entidades de negocio: son las clases Java de nuestro negocio modelado a través del paradigma orientado a objetos.
- Capa de acceso a datos (Repository): son las clases que se encargarán de acceder a la base de datos.
- Capa de datos (base de datos): es la base de datos de nuestro sistema modelado a través de un modelo entidad-relación. Utilizaremos la base H2 por su practicidad.
- Capa de negocio: son las clases service que se encargan de desacoplar el acceso a datos de la vista.
- Capa de presentación: son las pantallas web que tendremos que desarrollar utilizando el framework de Spring Boot MVC con los controladores y alguna de estas dos opciones: HTML+JavaScript o React para la vista. Es importante realizar el manejo de excepciones logueando cualquier excepción que se pueda generar y la realización de test unitarios para garantizar la calidad de los desarrollos.
