DROP DATABASE IF EXISTS panaderia_db;
CREATE DATABASE panaderia_db;
USE panaderia_db;

-- =========================
-- EMPLEADO
-- =========================
CREATE TABLE Empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni CHAR(8) NOT NULL UNIQUE,
    contrasenia VARCHAR(255) NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(15),
    rol ENUM('Administrador','Empleado') NOT NULL,
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion DATETIME DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =========================
-- CLIENTE
-- =========================

CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dni CHAR(8) UNIQUE,
    direccion VARCHAR(250),
    telefono VARCHAR(15),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion DATETIME DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =========================
-- PRODUCTO
-- =========================

CREATE TABLE Producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria ENUM('Panes','Bocaditos','Bebidas','Tortas') NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    precio DECIMAL(10,2) NOT NULL,
    unid_medida VARCHAR(50) DEFAULT 'unid.',
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion DATETIME DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

-- =========================
-- CAJA
-- =========================

CREATE TABLE Caja (
    id_caja INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado_apertura INT NOT NULL,
    id_empleado_cierre INT NULL,
    fecha DATE NOT NULL,
    hora_apertura TIME NOT NULL,
    hora_cierre TIME,
    monto_apertura DECIMAL(10,2) NOT NULL,
    monto_cierre DECIMAL(10,2),
    estado ENUM('Abierta','Cerrada') DEFAULT 'Abierta',

    CONSTRAINT fk_caja_apertura
        FOREIGN KEY (id_empleado_apertura)
        REFERENCES Empleado(id_empleado),

    CONSTRAINT fk_caja_cierre
        FOREIGN KEY (id_empleado_cierre)
        REFERENCES Empleado(id_empleado)
);

-- =========================
-- VENTA
-- =========================

CREATE TABLE Venta (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado INT NOT NULL,
    id_caja INT NOT NULL,
    id_cliente INT,
    fecha_venta DATE DEFAULT  (CURRENT_DATE()),
    hora_venta TIME DEFAULT (CURRENT_TIME()),
    tipo_despacho ENUM('Aquí','Llevar','Delivery') DEFAULT 'Aquí',
    nota_adicional VARCHAR(255),
    subtotal_venta DECIMAL (10,2) NOT NULL,
    igv_venta DECIMAL(10,2) NOT NULL,
    total_venta DECIMAL(10,2) NOT NULL,
    metodo_pago ENUM('Efectivo','Yape','Tarjeta') NOT NULL,

    CONSTRAINT fk_venta_empleado
        FOREIGN KEY (id_empleado)
        REFERENCES Empleado(id_empleado),

    CONSTRAINT fk_venta_caja
        FOREIGN KEY (id_caja)
        REFERENCES Caja(id_caja),
        
	CONSTRAINT fk_venta_cliente
        FOREIGN KEY (id_cliente)
        REFERENCES Cliente(id_cliente)
);

-- =========================
-- DETALLE VENTA
-- =========================

CREATE TABLE Detalle_Venta (
    id_detalle_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    precio_total DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_detalle_venta
        FOREIGN KEY (id_venta)
        REFERENCES Venta(id_venta)
        ON DELETE CASCADE,

    CONSTRAINT fk_detalle_producto
        FOREIGN KEY (id_producto)
        REFERENCES Producto(id_producto)
);