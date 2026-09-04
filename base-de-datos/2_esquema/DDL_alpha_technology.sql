-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS alpha_technology
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE alpha_technology;

-- Tabla categoria
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(80) NOT NULL,
    descripcion VARCHAR(255) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1, -- 1 = activo, 0 = inactivo
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_categoria_nombre UNIQUE (nombre_categoria)
);

-- Tabla marca
CREATE TABLE marca (
    id_marca INT AUTO_INCREMENT PRIMARY KEY,
    nombre_marca VARCHAR(80) NOT NULL,
    descripcion VARCHAR(255) NULL,
    pais_origen VARCHAR(60) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT uq_marca_nombre UNIQUE (nombre_marca)
);

-- Tabla producto
CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(120) NOT NULL,
    id_categoria INT NOT NULL,
    id_marca INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    stock INT NOT NULL DEFAULT 0,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_producto_categoria
        FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_producto_marca
        FOREIGN KEY (id_marca) REFERENCES marca(id_marca)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT chk_producto_precio CHECK (precio >= 0),
    CONSTRAINT chk_producto_stock  CHECK (stock  >= 0)
);

-- Datos de prueba: Categorías
INSERT INTO categoria (nombre_categoria, descripcion) VALUES
('Laptops', 'Computadoras portátiles'),
('Escritorio', 'Computadoras de escritorio y todo en uno'),
('Componentes', 'Piezas internas: RAM, discos, tarjetas de video'),
('Periféricos', 'Mouse, teclados, monitores, audífonos'),
('Almacenamiento', 'Discos duros, SSD, memorias USB'),
('Redes', 'Routers, switches, cables de red'),
('Impresoras', 'Impresoras y consumibles'),
('Software', 'Licencias y programas'),
('Accesorios', 'Mochilas, bases, limpieza'),
('Gaming', 'Productos orientados a videojuegos'),
('Tablets', 'Tablets y accesorios para tablets'),
('Servidores', 'Equipos de servidor para empresas'),
('Cámaras de Seguridad', 'Cámaras y sistemas de videovigilancia'),
('Refrigeración', 'Coolers, ventiladores y bases refrigerantes'),
('Tarjetas Gráficas', 'Tarjetas de video para PC de escritorio');

-- Datos de prueba: Marcas
INSERT INTO marca (nombre_marca, descripcion, pais_origen) VALUES
('HP', 'Hewlett-Packard', 'Estados Unidos'),
('Dell', 'Dell Technologies', 'Estados Unidos'),
('Lenovo', 'Lenovo Group', 'China'),
('Asus', 'ASUSTeK Computer', 'Taiwán'),
('Acer', 'Acer Inc.', 'Taiwán'),
('Logitech', 'Logitech International', 'Suiza'),
('Kingston', 'Kingston Technology', 'Estados Unidos'),
('Samsung', 'Samsung Electronics', 'Corea del Sur'),
('Corsair', 'Corsair Gaming', 'Estados Unidos'),
('Epson', 'Seiko Epson', 'Japón'),
('Apple', 'Apple Inc.', 'Estados Unidos'),
('Intel', 'Intel Corporation', 'Estados Unidos'),
('AMD', 'Advanced Micro Devices', 'Estados Unidos'),
('MSI', 'Micro-Star International', 'Taiwán'),
('Western Digital', 'Western Digital Corporation', 'Estados Unidos');

-- Datos de prueba: Productos
INSERT INTO producto (nombre_producto, id_categoria, id_marca, precio, stock) VALUES
('Laptop HP Pavilion 15', 1, 1, 2899.90, 12),
('Laptop Dell Inspiron 14', 1, 2, 2650.00, 8),
('Laptop Lenovo IdeaPad 3', 1, 3, 2199.50, 15),
('PC Escritorio Asus Essential', 2, 4, 1899.00, 6),
('All in One HP 24', 2, 1, 3200.00, 4),
('Memoria RAM Kingston 16GB', 3, 7, 249.90, 40),
('Disco SSD Samsung 1TB', 5, 8, 389.00, 25),
('Disco SSD Kingston 500GB', 5, 7, 199.90, 30),
('Mouse Logitech G203', 4, 6, 89.90, 60),
('Teclado Mecánico Corsair K70', 4, 9, 459.00, 18),
('Monitor Asus 24 pulgadas', 4, 4, 799.00, 10),
('Router TP-Link WiFi 6', 6, 5, 349.00, 20),
('Impresora Epson EcoTank L3250', 7, 10, 899.00, 9),
('Mochila Lenovo 15.6', 9, 3, 129.90, 22),
('Audífonos Logitech H390', 4, 6, 119.00, 35),
('Laptop Asus VivoBook 15', 1, 4, 2350.00, 14),
('Laptop Acer Aspire 5', 1, 5, 2100.00, 20),
('MacBook Air M2', 1, 11, 4999.00, 6),
('PC Escritorio Lenovo ThinkCentre M70', 2, 3, 1750.00, 10),
('PC Gamer MSI Codex 5', 2, 14, 4500.00, 5),
('All in One Dell Inspiron 24', 2, 2, 3100.00, 4),
('Procesador Intel Core i7-13700K', 3, 12, 1450.00, 18),
('Procesador AMD Ryzen 7 7800X3D', 3, 13, 1650.00, 12),
('Memoria RAM Corsair Vengeance 32GB', 3, 9, 459.00, 22),
('Tarjeta Madre Asus TUF Gaming B650', 3, 4, 899.00, 9),
('Tarjeta Gráfica MSI RTX 4070', 15, 14, 3200.00, 7),
('Tarjeta Gráfica Asus RTX 4060', 15, 4, 2450.00, 11),
('Tarjeta Gráfica Intel Arc A750', 15, 12, 1350.00, 9),
('Monitor Samsung Odyssey G5', 4, 8, 1250.00, 13),
('Monitor Dell UltraSharp 27', 4, 2, 1590.00, 8),
('Teclado Logitech MX Keys', 4, 6, 389.00, 25),
('Mouse Corsair Dark Core RGB', 4, 9, 299.00, 19),
('Disco SSD Western Digital Blue 1TB', 5, 15, 349.00, 30),
('Disco SSD Western Digital Black 2TB', 5, 15, 699.00, 14),
('Memoria USB Kingston 64GB', 5, 7, 49.90, 80),
('Disco Duro Externo Samsung T7', 5, 8, 459.00, 16),
('Switch de Red HP Aruba Instant On', 6, 1, 899.00, 6),
('Router Asus RT-AX Gaming', 6, 4, 650.00, 14),
('Impresora HP LaserJet Pro M404', 7, 1, 1350.00, 10),
('Impresora Epson L4260', 7, 10, 999.00, 12),
('Tóner HP 05A Original', 7, 1, 289.00, 30),
('Licencia Office 365 Personal', 8, 3, 399.00, 50),
('Licencia Windows 11 Pro OEM', 8, 4, 699.00, 40),
('Mochila para Laptop Dell', 9, 2, 159.00, 28),
('Cooler CPU Corsair iCUE H100i', 14, 9, 549.00, 15),
('Ventilador Gabinete MSI', 14, 14, 129.00, 35),
('Silla Gamer Corsair T3 Rush', 10, 9, 899.00, 8),
('Tablet Samsung Galaxy Tab A9', 11, 8, 899.00, 20),
('Tablet Lenovo Tab M10', 11, 3, 749.00, 18),
('Servidor Dell PowerEdge T140', 12, 2, 8999.00, 3);