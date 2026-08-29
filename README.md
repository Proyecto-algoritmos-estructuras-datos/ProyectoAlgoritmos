# Nombre del Proyecto
Sistema de gestión de ventas e inventario para la Panaderia Marcela

## Descripción
Sistema desarrollado en Java como proyecto universitario para el curso de Algoritmos y Estructuras de datos.


## Tecnologías
- Java con Apache Ant
- MySQL (JDBC)
- Swing (IGU)

## Equipo
- Bryan Alexander Luque Serna — Líder / GitHub
- Ayay Palomino, Diego Alvaro
- Segura Pizarro, Isabella
- Alarcon Maza, Misael


## Requisitos para correr el proyecto
- NetBeans
- JDK 8 o superior
- MySQL instalado
- Ejecutar el script `base-de-datos/2_esquema/1_creacion-tablas.sql` y `base-de-datos/2_esquema/2_insercion_datos.sql` para crear la base de datos

## Estructura del proyecto
- `src/` → código fuente Java


# Panadería App — Estructura del Proyecto

Sistema de escritorio para gestión de ventas e inventario de una panadería, desarrollado en **Java + Swing + JDBC**.

Este documento explica qué hace cada carpeta (`package`) del proyecto, para que todo el equipo sepa dónde ubicar su código y evitemos mezclar responsabilidades.

## Arquitectura general

El proyecto sigue una arquitectura MVC + DAO. La idea es que cada parte del código tenga una sola responsabilidad y no se mezcle con las demás:

```
Vista (Swing)  →  Controlador  →  DAO  →  Base de datos
```

- La **Vista** solo muestra pantallas y captura lo que hace el usuario.
- El **Controlador** valida que esos datos tengan sentido (reglas de negocio).
- El **DAO** es el único que habla con la base de datos (SQL puro).
- El **Modelo** son las clases que representan nuestras tablas como objetos Java.

> [!info] IMPORTANTE
> Ninguna capa debería saltarse a otra. Por ejemplo, la Vista nunca debe ejecutar SQL directamente, y el DAO nunca debe validar reglas de negocio.


## Estructura de carpetas

```text
PanaderiaApp/
└── src/
    └── panaderia/
        ├── conexion/
        ├── controlador/
        ├── dao/
        ├── imagenes/
        ├── interfaces/
        ├── modelo/
        ├── proyecto_poo/
        ├── utilidades/
        └── vista/
```

### `modelo/`

Contiene las clases que representan las entidades del sistema y las tablas de la base de datos. Estas clases almacenan los datos mediante atributos, constructores, getters y setters.

Ejemplos: `Empleado.java`, `Caja.java`, `Venta.java`, `DetalleVenta.java`, `Producto.java`.

**Regla:** las clases de este paquete no deben contener código SQL ni componentes de interfaz gráfica.

---

### `interfaces/`

Contiene las interfaces que definen las operaciones de acceso a datos que deberán implementar los DAO.

Ejemplos:

```java
public interface IEmpleadoDAO {
    void registrarEmpleado(Empleado empleado);
    void actualizarEmpleado(Empleado empleado);
    void cambiarEstadoEmpleado(int id);
    List<Empleado> verTodosLosEmpleados();
}
```

Archivos: `IEmpleadoDAO.java`, `IProductoDAO.java`, etc.

**Regla:** aquí solo se declaran métodos; la implementación se realiza en el paquete `dao`.

---

### `dao/`

Contiene las clases encargadas de acceder a la base de datos mediante JDBC.

Cada DAO implementa una interfaz del paquete `interfaces` y se encarga de ejecutar consultas SQL (SELECT, INSERT, UPDATE y DELETE), transformando los resultados en objetos del paquete `modelo`.

Ejemplos: `EmpleadoDAO.java`, `ProductoDAO.java`, `VentaDAO.java`, etc.

**Regla:** un DAO solo accede a los datos; no contiene lógica de negocio ni validaciones de la aplicación.

---

### `conexion/`

Contiene la clase `Conexion.java`, responsable de administrar la conexión con MySQL mediante el patrón Singleton.

Todos los DAO obtienen la conexión desde esta clase:

```java
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/panaderia_db";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1234";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
```

**Regla:** las conexiones a la base de datos deben centralizarse aquí para evitar duplicación de código y facilitar el mantenimiento.

---

### `vista/`

Contiene todas las interfaces gráficas desarrolladas con Swing (`JFrame`, `JDialog`, `JPanel`, etc.).

Ejemplos:

* `FormLogin.java`
* `FormTomarPedido.java`
* `FormHistorial.java`
* `FormInventario.java`
* `FormCaja.java`
* `FormAdministracion.java`

**Regla:** la vista se encarga únicamente de mostrar información y capturar acciones del usuario.

---

### `controlador/`

Actúa como intermediario entre la vista y los DAO.

Aquí se implementa la lógica de negocio de la aplicación, tales como:

* Validación de campos.
* Verificación de credenciales.
* Cálculo de totales.
* Reglas de negocio del sistema.
* Coordinación entre múltiples DAO.

Ejemplos: `EmpleadoController.java`, `ProductoController.java`, `VentaController.java`.

**Regla:** toda operación solicitada por la vista debe pasar por un controlador.

---

### `util/`

Contiene clases reutilizables que pueden ser utilizadas desde cualquier capa del sistema.

Ejemplos:

* `Constantes.java` — información fija como el monto de apertura de la caja.
* `Mensajes.java` — se guardan JOptionPane con distintos mensajes como login incorrecto, cerrar sesión, etc.

**Regla:** aquí solo deben colocarse herramientas genéricas que no pertenezcan a una entidad específica.

---

### `imagenes/`

Contiene los recursos gráficos utilizados por la interfaz de usuario, como íconos, logotipos y fotografías.

Ejemplos:

```text
imagenes/
├── logo.png
├── usuario.png
├── producto.png
└── fondo_login.jpg
```

---

### `proyecto_algoritmos/`

Contiene la clase principal encargada de iniciar la aplicación.

Ejemplo:

```java
public class Main {
    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
```

---

## Resumen rápido

| Si estás haciendo...                  | Va en...       |
| ------------------------------------- | -------------- |
| Una entidad o modelo de datos         | `modelo`       |
| Una interfaz para operaciones CRUD    | `interfaces`   |
| Una implementación JDBC con SQL       | `dao`          |
| Una conexión a la base de datos       | `conexion`     |
| Una ventana o formulario Swing        | `vista`        |
| Una validación o regla de negocio     | `controlador`  |
| Funciones auxiliares reutilizables    | `util`         |
| Recursos gráficos                     | `imagenes`     |
| Clase principal de ejecución          | `proyecto_algoritmos` |

## Flujo de trabajo con Git

Cada integrante desarrollará su funcionalidad en una rama propia siguiendo la nomenclatura:

```bash
feature/nombre-modulo
```

Una vez finalizado el desarrollo, se deberá crear un Pull Request hacia la rama `develop` para su revisión e integración con el proyecto principal.
