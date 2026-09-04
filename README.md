# Nombre del Proyecto
Sistema de gestión de inventario para la tienda de cómputo Alpha Technology

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
- Juan Diego, Melon Ango


## Requisitos para correr el proyecto
- NetBeans
- JDK 8 o superior
- MySQL instalado
- Ejecutar el script `base-de-datos/2_esquema/DDL_alpha_technology` para crear la base de datos

## Estructura del proyecto
- `src/` → código fuente Java


# Computo App — Estructura del Proyecto

Sistema de escritorio para gestión de inventario de una tienda de cómputo, desarrollado en **Java + Swing + JDBC**.

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
PROY_Algoritmos/
└── src/
    └── tiendaComputo/
        ├── PROY_Algoritmos/
        ├── conexion/
        ├── controlador/
        ├── dao/
        ├── interfaces/
        ├── modelo/
        ├── util/
        └── vista/
```


## Resumen

| Si estás haciendo...                  | Va en...       |
| ------------------------------------- | -------------- |
| Una entidad o modelo de datos         | `modelo`       |
| Una interfaz para operaciones CRUD    | `interfaces`   |
| Una implementación JDBC con SQL       | `dao`          |
| Una conexión a la base de datos       | `conexion`     |
| Una ventana o formulario Swing        | `vista`        |
| Una validación o regla de negocio     | `controlador`  |
| Funciones auxiliares reutilizables    | `util`         |
| Recursos gráficos                     | `vista/imagenes`     |
| Clase principal de ejecución          | `PROY_Algoritmos` |

## Flujo de trabajo con Git

Cada integrante desarrollará su funcionalidad en una rama propia siguiendo la nomenclatura:

```bash
feature/nombre-modulo
```

Una vez finalizado el desarrollo, se deberá crear un Pull Request hacia la rama `develop` para su revisión e integración con el proyecto principal.
