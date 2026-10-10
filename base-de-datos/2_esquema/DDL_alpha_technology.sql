-- ==========================================================================
-- Alpha Technology - Base de datos completa (11 tablas)
-- ==========================================================================
-- Requiere MySQL 8.0.16 o superior (aplica las restricciones CHECK).
--
-- USO: instalacion limpia. Si ya tienes la base del Avance 1 con datos,
-- NO ejecutes este archivo: usa migracion_avance1_a_avance2.sql.
--
-- Convenciones: snake_case, id_xxx, estado TINYINT(1) para eliminacion logica,
-- FK con ON UPDATE CASCADE ON DELETE RESTRICT, prefijos uq_ / fk_ / chk_ / idx_ / trg_.
-- Las restricciones CHECK no usan columnas de FK porque MySQL no lo permite
-- cuando la FK tiene ON UPDATE CASCADE.

CREATE DATABASE IF NOT EXISTS alpha_technology
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE alpha_technology;

-- ==========================================================================
-- TABLAS MAESTRAS (eliminacion logica con estado)
-- ==========================================================================

-- Tabla categoria: Catálogo de categorías de producto. Puede formar jerarquía (categoría > subcategoría)
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria_padre INT NULL,
    nombre_categoria VARCHAR(80) NOT NULL,
    descripcion VARCHAR(255) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_categoria_nombre UNIQUE (nombre_categoria),
    CONSTRAINT fk_categoria_padre FOREIGN KEY (id_categoria_padre) REFERENCES categoria(id_categoria)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB;

-- Tabla marca: Catálogo de marcas de producto
CREATE TABLE marca (
    id_marca INT AUTO_INCREMENT PRIMARY KEY,
    nombre_marca VARCHAR(80) NOT NULL,
    descripcion VARCHAR(255) NULL,
    pais_origen VARCHAR(60) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_marca_nombre UNIQUE (nombre_marca)
) ENGINE=InnoDB;

-- Tabla empleado: Personal de la tienda que usa el sistema (incluye usuario y contraseña de acceso)
CREATE TABLE empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    dni CHAR(8) NOT NULL,
    nombres VARCHAR(80) NOT NULL,
    apellidos VARCHAR(80) NOT NULL,
    correo VARCHAR(100) NULL,
    telefono VARCHAR(15) NULL,
    rol VARCHAR(20) NOT NULL DEFAULT 'VENDEDOR',
    usuario VARCHAR(30) NOT NULL,
    contrasena VARCHAR(255) NOT NULL COMMENT 'Hash de la contrasena, nunca texto plano',
    estado TINYINT(1) NOT NULL DEFAULT 1,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_empleado_dni UNIQUE (dni),
    CONSTRAINT uq_empleado_usuario UNIQUE (usuario),
    CONSTRAINT chk_empleado_dni CHECK (dni REGEXP '^[0-9]{8}$'),
    CONSTRAINT chk_empleado_rol CHECK (rol IN ('ADMINISTRADOR', 'VENDEDOR', 'ALMACENERO'))
) ENGINE=InnoDB;

-- Tabla proveedor: Empresas a las que la tienda les compra mercadería
CREATE TABLE proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    ruc CHAR(11) NOT NULL,
    razon_social VARCHAR(120) NOT NULL,
    contacto VARCHAR(100) NULL,
    telefono VARCHAR(15) NULL,
    correo VARCHAR(100) NULL,
    direccion VARCHAR(150) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_proveedor_ruc UNIQUE (ruc),
    CONSTRAINT chk_proveedor_ruc CHECK (ruc REGEXP '^[0-9]{11}$')
) ENGINE=InnoDB;

-- Tabla cliente: Personas o empresas que compran en la tienda
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    tipo_documento VARCHAR(3) NOT NULL DEFAULT 'DNI',
    numero_documento VARCHAR(11) NOT NULL,
    nombre_razon_social VARCHAR(120) NOT NULL,
    telefono VARCHAR(15) NULL,
    correo VARCHAR(100) NULL,
    direccion VARCHAR(150) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_cliente_documento UNIQUE (numero_documento),
    CONSTRAINT chk_cliente_tipo_documento CHECK (tipo_documento IN ('DNI', 'RUC')),
    CONSTRAINT chk_cliente_documento CHECK (numero_documento REGEXP '^[0-9]+$' AND ((tipo_documento = 'DNI' AND CHAR_LENGTH(numero_documento) = 8) OR (tipo_documento = 'RUC' AND CHAR_LENGTH(numero_documento) = 11)))
) ENGINE=InnoDB;

-- Tabla producto: Productos que vende la tienda. Guarda el stock actual
CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(30) NULL,
    nombre_producto VARCHAR(120) NOT NULL,
    descripcion VARCHAR(255) NULL,
    id_categoria INT NOT NULL,
    id_marca INT NOT NULL,
    precio_compra DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    precio DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    stock INT NOT NULL DEFAULT 0,
    stock_minimo INT NOT NULL DEFAULT 0,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_producto_codigo UNIQUE (codigo),
    CONSTRAINT fk_producto_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_producto_marca FOREIGN KEY (id_marca) REFERENCES marca(id_marca)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT chk_producto_precio CHECK (precio >= 0),
    CONSTRAINT chk_producto_stock CHECK (stock >= 0),
    CONSTRAINT chk_producto_precio_compra CHECK (precio_compra >= 0),
    CONSTRAINT chk_producto_stock_minimo CHECK (stock_minimo >= 0)
) ENGINE=InnoDB;

-- ==========================================================================
-- CABECERAS DE TRANSACCION (no se eliminan; se anulan)
-- ==========================================================================

-- Tabla compra: Pedido de mercadería a un proveedor. Al recibirse, sube el stock
CREATE TABLE compra (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    id_empleado INT NOT NULL,
    fecha_compra TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_recepcion TIMESTAMP NULL DEFAULT NULL,
    total DECIMAL(12,2) NOT NULL DEFAULT 0.00,
    estado VARCHAR(10) NOT NULL DEFAULT 'PENDIENTE',
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_compra_estado_fecha (estado, fecha_compra),
    CONSTRAINT fk_compra_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_compra_empleado FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT chk_compra_total CHECK (total >= 0),
    CONSTRAINT chk_compra_estado CHECK (estado IN ('PENDIENTE', 'RECIBIDA', 'ANULADA')),
    CONSTRAINT chk_compra_recepcion CHECK (estado <> 'RECIBIDA' OR fecha_recepcion IS NOT NULL)
) ENGINE=InnoDB;

-- ==========================================================================
-- DETALLES Y KARDEX (inmutables)
-- ==========================================================================

-- Tabla detalle_compra: Líneas de una compra: qué productos, cuántos y a qué precio
CREATE TABLE detalle_compra (
    id_detalle_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_compra INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(12,2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED,
    CONSTRAINT uq_detalle_compra_producto UNIQUE (id_compra, id_producto),
    CONSTRAINT fk_detalle_compra_compra FOREIGN KEY (id_compra) REFERENCES compra(id_compra)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_detalle_compra_producto FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT chk_detalle_compra_cantidad CHECK (cantidad > 0),
    CONSTRAINT chk_detalle_compra_precio CHECK (precio_unitario >= 0)
) ENGINE=InnoDB;

-- ==========================================================================
-- CABECERAS DE TRANSACCION (no se eliminan; se anulan)
-- ==========================================================================

-- Tabla venta: Venta realizada a un cliente. Al registrarse, baja el stock
CREATE TABLE venta (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(15) NULL,
    id_cliente INT NOT NULL,
    id_empleado INT NOT NULL,
    fecha_venta TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(12,2) NOT NULL DEFAULT 0.00,
    estado VARCHAR(10) NOT NULL DEFAULT 'COMPLETADA',
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_venta_numero UNIQUE (numero),
    INDEX idx_venta_fecha (fecha_venta),
    CONSTRAINT fk_venta_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_venta_empleado FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT chk_venta_total CHECK (total >= 0),
    CONSTRAINT chk_venta_estado CHECK (estado IN ('COMPLETADA', 'ANULADA'))
) ENGINE=InnoDB;

-- ==========================================================================
-- DETALLES Y KARDEX (inmutables)
-- ==========================================================================

-- Tabla detalle_venta: Líneas de una venta: qué productos, cuántos y a qué precio
CREATE TABLE detalle_venta (
    id_detalle_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(12,2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED,
    CONSTRAINT uq_detalle_venta_producto UNIQUE (id_venta, id_producto),
    CONSTRAINT fk_detalle_venta_venta FOREIGN KEY (id_venta) REFERENCES venta(id_venta)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_detalle_venta_producto FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT chk_detalle_venta_cantidad CHECK (cantidad > 0),
    CONSTRAINT chk_detalle_venta_precio CHECK (precio_unitario >= 0)
) ENGINE=InnoDB;

-- Tabla movimiento_inventario: Kardex: historial de cada entrada, salida o ajuste de stock
CREATE TABLE movimiento_inventario (
    id_movimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_producto INT NOT NULL,
    id_empleado INT NOT NULL,
    tipo_movimiento VARCHAR(10) NOT NULL,
    cantidad INT NOT NULL,
    stock_anterior INT NOT NULL,
    stock_nuevo INT NOT NULL,
    motivo VARCHAR(150) NULL,
    id_compra INT NULL,
    id_venta INT NULL,
    fecha_movimiento TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_movimiento_producto_fecha (id_producto, fecha_movimiento),
    CONSTRAINT fk_movimiento_producto FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_movimiento_empleado FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_movimiento_compra FOREIGN KEY (id_compra) REFERENCES compra(id_compra)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_movimiento_venta FOREIGN KEY (id_venta) REFERENCES venta(id_venta)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT chk_movimiento_tipo CHECK (tipo_movimiento IN ('ENTRADA', 'SALIDA', 'AJUSTE')),
    CONSTRAINT chk_movimiento_cantidad CHECK (cantidad > 0),
    CONSTRAINT chk_movimiento_stock_anterior CHECK (stock_anterior >= 0),
    CONSTRAINT chk_movimiento_stock_nuevo CHECK (stock_nuevo >= 0),
    CONSTRAINT chk_movimiento_coherencia CHECK (tipo_movimiento = 'AJUSTE' OR (tipo_movimiento = 'ENTRADA' AND stock_nuevo = stock_anterior + cantidad) OR (tipo_movimiento = 'SALIDA' AND stock_nuevo = stock_anterior - cantidad))
) ENGINE=InnoDB;

-- ==========================================================================
-- PROTECCION: impide UPDATE/DELETE donde no deben ocurrir
-- ==========================================================================

-- Complementa a las FK ON DELETE RESTRICT. Anular una venta o compra = UPDATE de estado
-- en la cabecera (permitido) + un movimiento de reversa en el kardex.

DELIMITER $$

CREATE TRIGGER trg_movimiento_inventario_no_update
BEFORE UPDATE ON movimiento_inventario
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El kardex (movimiento_inventario) no se puede modificar';
END$$

CREATE TRIGGER trg_movimiento_inventario_no_delete
BEFORE DELETE ON movimiento_inventario
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El kardex (movimiento_inventario) no se puede eliminar';
END$$

CREATE TRIGGER trg_detalle_compra_no_update
BEFORE UPDATE ON detalle_compra
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El detalle de una compra no se puede modificar';
END$$

CREATE TRIGGER trg_detalle_compra_no_delete
BEFORE DELETE ON detalle_compra
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El detalle de una compra no se puede eliminar';
END$$

CREATE TRIGGER trg_detalle_venta_no_update
BEFORE UPDATE ON detalle_venta
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El detalle de una venta no se puede modificar';
END$$

CREATE TRIGGER trg_detalle_venta_no_delete
BEFORE DELETE ON detalle_venta
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El detalle de una venta no se puede eliminar';
END$$

CREATE TRIGGER trg_compra_no_delete
BEFORE DELETE ON compra
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Las compras no se eliminan; cambie su estado a ANULADA';
END$$

CREATE TRIGGER trg_venta_no_delete
BEFORE DELETE ON venta
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Las ventas no se eliminan; cambie su estado a ANULADA';
END$$

DELIMITER ;