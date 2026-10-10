-- ==========================================================================
-- Alpha Technology - Script de inserción de datos de prueba
-- Requiere que la base de datos alpha_technology ya exista (script de estructura).
-- Ejecutar en orden: respeta las dependencias de claves foráneas.
-- ==========================================================================

USE alpha_technology;

SET NAMES utf8mb4;

-- ==========================================================================
-- 1. CATEGORIA (20 registros, con jerarquía)
-- ==========================================================================
INSERT INTO categoria (id_categoria, id_categoria_padre, nombre_categoria, descripcion) VALUES
(1,  NULL, 'Tecnología',                    'Productos tecnológicos en general'),
(2,  1,    'Computadoras',                  'Equipos de cómputo de escritorio y todo en uno'),
(3,  2,    'Laptops',                       'Computadoras portátiles'),
(4,  2,    'Monitores',                     'Pantallas y monitores de computadora'),
(5,  1,    'Componentes',                   'Partes internas para armar o reparar equipos'),
(6,  5,    'Almacenamiento',                'Discos, memorias y unidades de almacenamiento'),
(7,  1,    'Periféricos',                   'Accesorios de entrada y salida para computadora'),
(8,  7,    'Audio',                         'Audífonos, parlantes y equipos de sonido'),
(9,  1,    'Redes',                         'Equipos de conectividad y redes'),
(10, NULL, 'Electrodomésticos',             'Artefactos para el hogar'),
(11, 10,   'Línea Blanca',                  'Refrigeradoras, lavadoras y similares'),
(12, 10,   'Pequeños Electrodomésticos',    'Artefactos de cocina y uso doméstico menor'),
(13, NULL, 'Accesorios',                    'Accesorios complementarios de tecnología'),
(14, 13,   'Cables y Adaptadores',          'Cables, adaptadores y cargadores'),
(15, 13,   'Fundas y Protectores',          'Fundas, micas y protectores'),
(16, NULL, 'Iluminación',                   'Focos y paneles LED'),
(17, NULL, 'Oficina',                       'Equipos y suministros de oficina'),
(18, 17,   'Papelería',                     'Papel y útiles de escritorio'),
(19, NULL, 'Gaming',                        'Productos orientados a videojuegos'),
(20, NULL, 'Smart Home',                    'Dispositivos inteligentes para el hogar');

-- ==========================================================================
-- 2. MARCA (15 registros)
-- ==========================================================================
INSERT INTO marca (id_marca, nombre_marca, descripcion, pais_origen) VALUES
(1,  'HP',             'Hewlett-Packard, fabricante de computadoras e impresoras', 'Estados Unidos'),
(2,  'Dell',           'Fabricante de equipos de cómputo',                        'Estados Unidos'),
(3,  'Lenovo',         'Fabricante de computadoras y dispositivos',                'China'),
(4,  'Asus',           'Fabricante de componentes y equipos',                      'Taiwán'),
(5,  'Acer',           'Fabricante de computadoras portátiles',                    'Taiwán'),
(6,  'Samsung',        'Electrónica de consumo y electrodomésticos',               'Corea del Sur'),
(7,  'LG',             'Electrónica de consumo y electrodomésticos',               'Corea del Sur'),
(8,  'Logitech',       'Periféricos y accesorios de computadora',                  'Suiza'),
(9,  'Kingston',       'Memorias, discos y almacenamiento',                        'Estados Unidos'),
(10, 'Western Digital','Almacenamiento y discos duros',                            'Estados Unidos'),
(11, 'TP-Link',        'Equipos de redes y conectividad',                          'China'),
(12, 'Xiaomi',         'Tecnología de consumo y smart home',                       'China'),
(13, 'Epson',          'Impresoras y suministros de impresión',                    'Japón'),
(14, 'Philips',        'Iluminación y pequeños electrodomésticos',                 'Países Bajos'),
(15, 'Genérica',       'Productos sin marca registrada o de marca libre',          'China');

-- ==========================================================================
-- 3. EMPLEADO (1 administrador + 5 empleados)
-- Contraseña de todos: 1234  (almacenada como hash SHA-256)
-- ==========================================================================
INSERT INTO empleado (id_empleado, dni, nombres, apellidos, correo, telefono, rol, usuario, contrasena) VALUES
(1, '11111111', 'Carlos',   'Ramírez Soto',      'admin@alphatech.pe',     '987654321', 'ADMINISTRADOR', 'admin',     SHA2('1234', 256)),
(2, '22222222', 'Jorge',    'Vargas Lujan',      'jvargas@alphatech.pe',   '987654322', 'VENDEDOR',      'jvargas',   SHA2('1234', 256)),
(3, '33333333', 'María',    'Fernández Ríos',    'mfernandez@alphatech.pe','987654323', 'VENDEDOR',      'mfernandez',SHA2('1234', 256)),
(4, '44444444', 'Lucía',    'Paredes Chávez',    'lparedes@alphatech.pe',  '987654324', 'VENDEDOR',      'lparedes',  SHA2('1234', 256)),
(5, '55555555', 'Ricardo',  'Salas Mendoza',     'rsalas@alphatech.pe',    '987654325', 'ALMACENERO',    'rsalas',    SHA2('1234', 256)),
(6, '66666666', 'Patricia', 'Núñez Cabrera',     'pnunez@alphatech.pe',    '987654326', 'ALMACENERO',    'pnunez',    SHA2('1234', 256));

-- ==========================================================================
-- 4. PROVEEDOR (10 registros)
-- ==========================================================================
INSERT INTO proveedor (id_proveedor, ruc, razon_social, contacto, telefono, correo, direccion) VALUES
(1,  '20100000001', 'HP Perú S.A.C.',                        'Alberto Ruiz',    '014567890', 'ventas@hpperu.com.pe',        'Av. Javier Prado Este 4200, Lima'),
(2,  '20100000002', 'Dell Technologies Perú S.A.',           'Sandra Molina',   '014567891', 'ventas@dellperu.com.pe',      'Av. República de Panamá 3535, Lima'),
(3,  '20100000003', 'Lenovo Perú S.A.C.',                    'Marco Antonio Lay','014567892','ventas@lenovoperu.com.pe',    'Av. El Derby 254, Santiago de Surco'),
(4,  '20100000004', 'Asus Perú Import S.A.C.',               'Rocío Delgado',   '014567893', 'ventas@asusperu.com.pe',      'Calle Chinchón 890, San Isidro'),
(5,  '20100000005', 'Samsung Electronics Perú S.A.',         'Iván Cárdenas',   '014567894', 'ventas@samsungperu.com.pe',   'Av. Andrés Reyes 420, San Isidro'),
(6,  '20100000006', 'Logitech Perú Distribuciones S.A.C.',   'Elena Bustamante','014567895', 'ventas@logitechperu.com.pe',  'Av. Universitaria 1850, San Miguel'),
(7,  '20100000007', 'TP-Link Perú S.A.C.',                   'Gustavo Pinto',   '014567896', 'ventas@tplinkperu.com.pe',    'Av. Arequipa 4650, Miraflores'),
(8,  '20100000008', 'LG Electronics Perú S.A.',              'Karina Solís',    '014567897', 'ventas@lgperu.com.pe',        'Av. Víctor A. Belaunde 147, San Isidro'),
(9,  '20100000009', 'Philips Perú S.A.C.',                   'Raúl Bermúdez',   '014567898', 'ventas@philipsperu.com.pe',   'Av. La Marina 2355, San Miguel'),
(10, '20100000010', 'Xiaomi Import Perú S.A.C.',             'Fiorella Rojas',  '014567899', 'ventas@xiaomiperu.com.pe',    'Av. Paseo de la República 3505, Lima');

-- ==========================================================================
-- 5. CLIENTE (10 registros, incluye el Cliente General id = 1)
-- ==========================================================================
INSERT INTO cliente (id_cliente, tipo_documento, numero_documento, nombre_razon_social, telefono, correo, direccion) VALUES
(1,  'DNI', '00000000',   'CLIENTES VARIOS',                              NULL,         NULL,                          NULL),
(2,  'DNI', '45871236',   'María Fernanda Quispe Rojas',                  '987111222', 'mfquispe@gmail.com',          'Jr. Los Álamos 145, Surquillo'),
(3,  'DNI', '10254789',   'Juan Carlos Mendoza Vega',                     '987222333', 'jcmendoza@hotmail.com',       'Av. Brasil 1180, Jesús María'),
(4,  'DNI', '73952146',   'Ana Lucía Torres Campos',                      '987333444', 'anatorres@gmail.com',         'Calle Los Nogales 233, San Borja'),
(5,  'DNI', '28415963',   'Luis Alberto Chávez Paredes',                  '987444555', 'lchavezp@yahoo.com',          'Av. Universitaria 3455, Comas'),
(6,  'DNI', '61528397',   'Rosa Elena Villanueva Díaz',                   '987555666', 'rvillanueva@gmail.com',       'Jr. Puno 780, Cercado de Lima'),
(7,  'RUC', '20548763921','Distribuidora San Martín S.A.C.',              '987666777', 'compras@dsanmartin.pe',       'Av. Argentina 2560, Callao'),
(8,  'DNI', '41236598',   'Pedro Antonio Salazar Núñez',                  '987777888', 'psalazar@gmail.com',          'Calle Las Begonias 320, Surco'),
(9,  'DNI', '09874563',   'Carmen Julia Espinoza Ramos',                  '987888999', 'cespinoza@outlook.com',       'Av. Aviación 2890, San Borja'),
(10, 'RUC', '20987654321','Inversiones del Norte E.I.R.L.',               '987999000', 'contacto@invnorte.pe',        'Av. Túpac Amaru 4320, Independencia');

-- ==========================================================================
-- 6. PRODUCTO (50 registros)
-- ==========================================================================
INSERT INTO producto (id_producto, codigo, nombre_producto, descripcion, id_categoria, id_marca, precio_compra, precio, stock, stock_minimo) VALUES
(1,  'P001', 'Laptop HP 15 Core i5',              'Laptop HP 15, Core i5, 8GB RAM, 512GB SSD',        3,  1,  1800.00, 2399.00, 25, 5),
(2,  'P002', 'Laptop Dell Inspiron 14',           'Laptop Dell Inspiron 14, Core i5, 16GB RAM',       3,  2,  1900.00, 2499.00, 18, 5),
(3,  'P003', 'Laptop Lenovo IdeaPad 3',           'Laptop Lenovo IdeaPad 3, Ryzen 5, 8GB RAM',        3,  3,  1700.00, 2199.00, 20, 5),
(4,  'P004', 'Laptop Asus VivoBook 15',           'Laptop Asus VivoBook 15, Core i3, 8GB RAM',        3,  4,  1750.00, 2299.00, 15, 5),
(5,  'P005', 'Laptop Acer Aspire 5',              'Laptop Acer Aspire 5, Ryzen 5, 12GB RAM',          3,  5,  1650.00, 2149.00, 12, 5),
(6,  'P006', 'Computadora HP ProDesk',            'PC de escritorio HP ProDesk, Core i5, 8GB RAM',    2,  1,  2000.00, 2699.00, 10, 3),
(7,  'P007', 'Computadora Dell OptiPlex',         'PC de escritorio Dell OptiPlex, Core i5, 16GB',    2,  2,  2100.00, 2799.00,  8, 3),
(8,  'P008', 'All in One Lenovo AIO 24',          'All in One Lenovo 24" Core i5, 8GB RAM',           2,  3,  2400.00, 3199.00,  6, 2),
(9,  'P009', 'Monitor Samsung 24"',               'Monitor Samsung 24" Full HD 75Hz',                 4,  6,   550.00,  749.00, 30, 8),
(10, 'P010', 'Monitor LG 27"',                    'Monitor LG 27" Full HD IPS',                       4,  7,   750.00,  999.00, 22, 6),
(11, 'P011', 'Monitor Asus 24" 144Hz',            'Monitor Asus 24" Gaming 144Hz',                    4,  4,   800.00, 1099.00, 14, 4),
(12, 'P012', 'Procesador AMD Ryzen 5 5600',       'Procesador AMD Ryzen 5 5600, 6 núcleos',           5,  15,  600.00,  849.00, 16, 4),
(13, 'P013', 'Procesador Intel Core i5',          'Procesador Intel Core i5 12400F',                  5,  15,  650.00,  899.00, 14, 4),
(14, 'P014', 'Placa Madre Asus Prime B550',       'Placa madre Asus Prime B550M-A',                   5,  4,   450.00,  649.00, 12, 4),
(15, 'P015', 'Memoria RAM Kingston 8GB DDR4',     'Memoria RAM Kingston Fury 8GB DDR4 3200MHz',       5,  9,   130.00,  199.00, 60, 15),
(16, 'P016', 'Memoria RAM Kingston 16GB DDR4',    'Memoria RAM Kingston Fury 16GB DDR4 3200MHz',      5,  9,   240.00,  349.00, 35, 10),
(17, 'P017', 'Disco SSD Kingston 480GB',          'Disco SSD Kingston A400 480GB SATA',               6,  9,   160.00,  239.00, 45, 12),
(18, 'P018', 'Disco SSD WD 1TB NVMe',             'Disco SSD Western Digital Blue SN570 1TB NVMe',    6,  10,  320.00,  449.00, 25, 8),
(19, 'P019', 'Disco Duro Externo WD 2TB',         'Disco duro externo WD Elements 2TB USB 3.0',       6,  10,  280.00,  399.00, 20, 6),
(20, 'P020', 'Memoria USB Kingston 64GB',         'Memoria USB Kingston DataTraveler 64GB',           6,  9,    25.00,   45.00,100, 25),
(21, 'P021', 'Teclado Logitech K120',             'Teclado USB Logitech K120 español',                7,  8,    40.00,   69.00, 50, 15),
(22, 'P022', 'Mouse Logitech M170',               'Mouse inalámbrico Logitech M170',                  7,  8,    35.00,   59.00, 55, 15),
(23, 'P023', 'Combo Teclado y Mouse Logitech',    'Combo inalámbrico Logitech MK270',                 7,  8,    90.00,  139.00, 30, 10),
(24, 'P024', 'Webcam Logitech C920',              'Webcam Logitech C920 Full HD 1080p',               7,  8,   250.00,  359.00, 12, 4),
(25, 'P025', 'Audífonos con Micrófono Logitech',  'Audífonos Logitech H390 USB con micrófono',        8,  8,   120.00,  189.00, 25, 8),
(26, 'P026', 'Parlante Bluetooth Xiaomi',         'Parlante Bluetooth Xiaomi Mi Compact',             8,  12,   90.00,  149.00, 30, 10),
(27, 'P027', 'Audífonos Inalámbricos Xiaomi',     'Audífonos inalámbricos Xiaomi Redmi Buds 4',       8,  12,  110.00,  179.00, 28, 8),
(28, 'P028', 'Router TP-Link Archer C6',          'Router inalámbrico TP-Link Archer C6 AC1200',      9,  11,  130.00,  199.00, 24, 6),
(29, 'P029', 'Repetidor WiFi TP-Link',            'Repetidor WiFi TP-Link RE200 AC750',               9,  11,   85.00,  139.00, 20, 6),
(30, 'P030', 'Switch TP-Link 8 Puertos',          'Switch TP-Link TL-SG108 8 puertos Gigabit',        9,  11,  110.00,  169.00, 15, 5),
(31, 'P031', 'Refrigeradora LG 300L',             'Refrigeradora LG 300L No Frost',                  11,  7,  1800.00, 2499.00,  7, 2),
(32, 'P032', 'Lavadora Samsung 18kg',             'Lavadora Samsung 18kg carga superior',            11,  6,  1500.00, 2099.00,  6, 2),
(33, 'P033', 'Microondas LG 25L',                 'Horno microondas LG 25L',                         12,  7,   350.00,  499.00, 12, 4),
(34, 'P034', 'Licuadora Philips',                 'Licuadora Philips 600W vaso de vidrio',           12,  14,  150.00,  229.00, 18, 6),
(35, 'P035', 'Cafetera Philips',                  'Cafetera Philips Daily 1.2L',                     12,  14,  180.00,  269.00, 14, 5),
(36, 'P036', 'Freidora de Aire Xiaomi',           'Freidora de aire Xiaomi Smart 3.5L',              12,  12,  300.00,  429.00, 10, 4),
(37, 'P037', 'Cable HDMI 2m',                     'Cable HDMI 2.0 de 2 metros 4K',                   14,  15,   12.00,   25.00,120, 30),
(38, 'P038', 'Cable USB-C 1m',                    'Cable USB-C a USB-A de 1 metro',                  14,  15,   10.00,   22.00,130, 30),
(39, 'P039', 'Adaptador USB a HDMI',              'Adaptador USB 3.0 a HDMI Full HD',                14,  15,   45.00,   79.00, 40, 12),
(40, 'P040', 'Cargador Rápido 20W',               'Cargador rápido 20W con puerto USB-C',            14,  12,   35.00,   65.00, 60, 20),
(41, 'P041', 'Funda para Laptop 15"',             'Funda neopreno para laptop de 15 pulgadas',       15,  15,   25.00,   49.00, 45, 15),
(42, 'P042', 'Mica Protectora para Monitor',      'Mica protectora antirreflejo para monitor 24"',   15,  15,   30.00,   55.00, 35, 10),
(43, 'P043', 'Foco LED Philips 9W',               'Foco LED Philips 9W luz blanca',                  16,  14,    8.00,   18.00,200, 50),
(44, 'P044', 'Panel LED Philips 18W',             'Panel LED Philips 18W redondo',                   16,  14,   22.00,   42.00, 80, 20),
(45, 'P045', 'Impresora Epson L3250',             'Impresora multifuncional Epson L3250 WiFi',       17,  13,  650.00,  899.00,  9, 3),
(46, 'P046', 'Tóner Epson 664',                   'Botella de tinta Epson 664 negra',                17,  13,   45.00,   79.00, 40, 12),
(47, 'P047', 'Papel Bond A4 500 hojas',           'Papel bond A4 75g, paquete de 500 hojas',         18,  15,   12.00,   22.00,150, 40),
(48, 'P048', 'Silla Gamer',                       'Silla gamer reclinable con soporte lumbar',       19,  15,  400.00,  649.00,  8, 3),
(49, 'P049', 'Mousepad Gamer',                    'Mousepad gamer 80x30 cm',                         19,  15,   20.00,   39.00, 50, 15),
(50, 'P050', 'Cámara de Seguridad Xiaomi',        'Cámara de seguridad Xiaomi 360° 2K WiFi',         20,  12,  120.00,  189.00, 22, 8);

-- ==========================================================================
-- 7. COMPRA (25 registros)
-- ==========================================================================
INSERT INTO compra (id_compra, id_proveedor, id_empleado, fecha_compra, fecha_recepcion, total, estado) VALUES
(1,  1,  5, '2025-01-05 09:15:00', '2025-01-08 11:30:00', 16600.00, 'RECIBIDA'),
(2,  2,  6, '2025-01-07 10:00:00', '2025-01-10 15:45:00', 15500.00, 'RECIBIDA'),
(3,  3,  5, '2025-01-10 08:40:00', '2025-01-14 09:20:00', 15500.00, 'RECIBIDA'),
(4,  4,  5, '2025-01-12 14:10:00', '2025-01-15 16:00:00', 10700.00, 'RECIBIDA'),
(5,  5,  6, '2025-01-15 11:25:00', '2025-01-18 10:10:00',  7940.00, 'RECIBIDA'),
(6,  6,  5, '2025-01-18 09:00:00', '2025-01-21 12:40:00',  3400.00, 'RECIBIDA'),
(7,  7,  6, '2025-01-20 15:30:00', '2025-01-23 14:15:00',  3290.00, 'RECIBIDA'),
(8,  8,  5, '2025-01-22 10:45:00', NULL,                 15000.00, 'ANULADA'),
(9,  9,  6, '2025-01-25 08:20:00', '2025-01-28 11:00:00',  5740.00, 'RECIBIDA'),
(10, 10, 5, '2025-01-28 16:05:00', '2025-01-31 09:50:00',  4100.00, 'RECIBIDA'),
(11, 1,  5, '2025-02-02 09:35:00', '2025-02-05 13:25:00', 14300.00, 'RECIBIDA'),
(12, 2,  6, '2025-02-05 11:50:00', '2025-02-08 10:30:00', 11400.00, 'RECIBIDA'),
(13, 3,  5, '2025-02-08 08:55:00', '2025-02-11 15:05:00', 11400.00, 'RECIBIDA'),
(14, 4,  6, '2025-02-12 14:40:00', '2025-02-15 12:20:00',  2940.00, 'RECIBIDA'),
(15, 5,  5, '2025-02-15 10:15:00', NULL,                  2890.00, 'PENDIENTE'),
(16, 6,  6, '2025-02-18 09:05:00', '2025-02-21 16:45:00',  4150.00, 'RECIBIDA'),
(17, 7,  5, '2025-02-20 13:30:00', '2025-02-24 11:15:00',  2885.00, 'RECIBIDA'),
(18, 8,  6, '2025-02-24 08:45:00', '2025-02-27 14:00:00',  2750.00, 'RECIBIDA'),
(19, 9,  5, '2025-02-27 15:20:00', NULL,                  3200.00, 'PENDIENTE'),
(20, 10, 6, '2025-03-02 10:00:00', '2025-03-05 09:30:00',  2040.00, 'RECIBIDA'),
(21, 1,  5, '2025-03-05 11:10:00', '2025-03-08 15:50:00', 10500.00, 'RECIBIDA'),
(22, 2,  6, '2025-03-08 09:25:00', NULL,                  7050.00, 'ANULADA'),
(23, 3,  5, '2025-03-10 14:00:00', '2025-03-13 10:45:00',  5000.00, 'RECIBIDA'),
(24, 4,  6, '2025-03-12 08:30:00', NULL,                  1500.00, 'PENDIENTE'),
(25, 5,  5, '2025-03-15 16:20:00', NULL,                  2150.00, 'PENDIENTE');

-- ==========================================================================
-- 8. DETALLE_COMPRA (60 registros)
-- ==========================================================================
INSERT INTO detalle_compra (id_compra, id_producto, cantidad, precio_unitario) VALUES
-- Compra 1
(1, 1, 5, 1800.00), (1, 2, 4, 1900.00),
-- Compra 2
(2, 3, 5, 1700.00), (2, 4, 4, 1750.00),
-- Compra 3
(3, 9, 10, 550.00), (3, 10, 8, 750.00), (3, 11, 5, 800.00),
-- Compra 4
(4, 15, 30, 130.00), (4, 16, 15, 240.00), (4, 17, 20, 160.00),
-- Compra 5
(5, 18, 10, 320.00), (5, 19, 8, 280.00), (5, 20, 100, 25.00),
-- Compra 6
(6, 21, 25, 40.00), (6, 22, 30, 35.00), (6, 23, 15, 90.00),
-- Compra 7
(7, 28, 12, 130.00), (7, 29, 10, 85.00), (7, 30, 8, 110.00),
-- Compra 8 (anulada)
(8, 31, 5, 1800.00), (8, 32, 4, 1500.00),
-- Compra 9
(9, 33, 8, 350.00), (9, 34, 10, 150.00), (9, 35, 8, 180.00),
-- Compra 10
(10, 36, 6, 300.00), (10, 43, 150, 8.00), (10, 44, 50, 22.00),
-- Compra 11
(11, 6, 4, 2000.00), (11, 7, 3, 2100.00),
-- Compra 12
(12, 5, 4, 1650.00), (12, 8, 2, 2400.00),
-- Compra 13
(13, 12, 8, 600.00), (13, 13, 6, 650.00), (13, 14, 6, 450.00),
-- Compra 14
(14, 24, 6, 250.00), (14, 25, 12, 120.00),
-- Compra 15 (pendiente)
(15, 26, 15, 90.00), (15, 27, 14, 110.00),
-- Compra 16
(16, 45, 5, 650.00), (16, 46, 20, 45.00),
-- Compra 17
(17, 37, 80, 12.00), (17, 38, 80, 10.00), (17, 39, 25, 45.00),
-- Compra 18
(18, 40, 40, 35.00), (18, 41, 30, 25.00), (18, 42, 20, 30.00),
-- Compra 19 (pendiente)
(19, 47, 100, 12.00), (19, 48, 5, 400.00),
-- Compra 20
(20, 49, 30, 20.00), (20, 50, 12, 120.00),
-- Compra 21
(21, 1, 3, 1800.00), (21, 3, 3, 1700.00),
-- Compra 22 (anulada)
(22, 9, 6, 550.00), (22, 10, 5, 750.00),
-- Compra 23
(23, 15, 20, 130.00), (23, 17, 15, 160.00),
-- Compra 24 (pendiente)
(24, 21, 20, 40.00), (24, 22, 20, 35.00),
-- Compra 25 (pendiente)
(25, 33, 4, 350.00), (25, 34, 5, 150.00);

-- ==========================================================================
-- 9. VENTA (20 registros)
-- ==========================================================================
INSERT INTO venta (id_venta, numero, id_cliente, id_empleado, fecha_venta, total, estado) VALUES
(1,  'V0001', 1,  2, '2025-03-01 10:15:00',  165.00, 'COMPLETADA'),
(2,  'V0002', 2,  3, '2025-03-02 11:40:00', 2458.00, 'COMPLETADA'),
(3,  'V0003', 3,  2, '2025-03-03 16:05:00', 1616.00, 'COMPLETADA'),
(4,  'V0004', 4,  4, '2025-03-05 09:30:00',  637.00, 'COMPLETADA'),
(5,  'V0005', 5,  3, '2025-03-06 12:50:00',  800.00, 'COMPLETADA'),
(6,  'V0006', 6,  2, '2025-03-08 15:20:00',  688.00, 'COMPLETADA'),
(7,  'V0007', 1,  4, '2025-03-09 10:45:00',  109.00, 'COMPLETADA'),
(8,  'V0008', 7,  3, '2025-03-10 14:10:00', 2699.00, 'ANULADA'),
(9,  'V0009', 8,  2, '2025-03-12 11:25:00',  477.00, 'COMPLETADA'),
(10, 'V0010', 9,  4, '2025-03-13 17:00:00',  517.00, 'COMPLETADA'),
(11, 'V0011', 10, 3, '2025-03-15 09:50:00', 1057.00, 'COMPLETADA'),
(12, 'V0012', 1,  2, '2025-03-16 13:35:00',  155.00, 'COMPLETADA'),
(13, 'V0013', 2,  4, '2025-03-18 10:20:00', 2338.00, 'COMPLETADA'),
(14, 'V0014', 3,  3, '2025-03-20 16:40:00', 2499.00, 'COMPLETADA'),
(15, 'V0015', 4,  2, '2025-03-22 12:15:00', 1068.00, 'ANULADA'),
(16, 'V0016', 5,  4, '2025-03-24 09:05:00',  848.00, 'COMPLETADA'),
(17, 'V0017', 6,  3, '2025-03-26 15:55:00',  698.00, 'COMPLETADA'),
(18, 'V0018', 7,  2, '2025-03-28 11:45:00',  548.00, 'COMPLETADA'),
(19, 'V0019', 8,  4, '2025-03-30 14:30:00',  159.00, 'COMPLETADA'),
(20, 'V0020', 1,  3, '2025-04-01 10:10:00', 1198.00, 'COMPLETADA');

-- ==========================================================================
-- 10. DETALLE_VENTA (41 registros)
-- ==========================================================================
INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_unitario) VALUES
-- Venta 1
(1, 20, 2, 45.00), (1, 37, 3, 25.00),
-- Venta 2
(2, 1, 1, 2399.00), (2, 22, 1, 59.00),
-- Venta 3
(3, 9, 2, 749.00), (3, 21, 1, 69.00), (3, 41, 1, 49.00),
-- Venta 4
(4, 15, 2, 199.00), (4, 17, 1, 239.00),
-- Venta 5
(5, 33, 1, 499.00), (5, 34, 1, 229.00), (5, 43, 4, 18.00),
-- Venta 6
(6, 48, 1, 649.00), (6, 49, 1, 39.00),
-- Venta 7
(7, 38, 2, 22.00), (7, 40, 1, 65.00),
-- Venta 8 (anulada)
(8, 6, 1, 2699.00),
-- Venta 9
(9, 28, 1, 199.00), (9, 29, 2, 139.00),
-- Venta 10
(10, 26, 1, 149.00), (10, 27, 1, 179.00), (10, 50, 1, 189.00),
-- Venta 11
(11, 45, 1, 899.00), (11, 46, 2, 79.00),
-- Venta 12
(12, 47, 5, 22.00), (12, 20, 1, 45.00),
-- Venta 13
(13, 3, 1, 2199.00), (13, 23, 1, 139.00),
-- Venta 14
(14, 31, 1, 2499.00),
-- Venta 15 (anulada)
(15, 10, 1, 999.00), (15, 21, 1, 69.00),
-- Venta 16
(16, 18, 1, 449.00), (16, 19, 1, 399.00),
-- Venta 17
(17, 36, 1, 429.00), (17, 35, 1, 269.00),
-- Venta 18
(18, 25, 1, 189.00), (18, 24, 1, 359.00),
-- Venta 19
(19, 42, 2, 55.00), (19, 41, 1, 49.00),
-- Venta 20
(20, 12, 1, 849.00), (20, 16, 1, 349.00);

-- ==========================================================================
-- 11. MOVIMIENTO_INVENTARIO (52 registros: kardex)
-- ==========================================================================
INSERT INTO movimiento_inventario
(id_producto, id_empleado, tipo_movimiento, cantidad, stock_anterior, stock_nuevo, motivo, id_compra, id_venta) VALUES
-- Entradas por recepción de compras
(1,  5, 'ENTRADA', 5,   20,  25,  'Recepción de compra 1', 1,  NULL),
(2,  5, 'ENTRADA', 4,   14,  18,  'Recepción de compra 1', 1,  NULL),
(3,  6, 'ENTRADA', 5,   15,  20,  'Recepción de compra 2', 2,  NULL),
(4,  6, 'ENTRADA', 4,   11,  15,  'Recepción de compra 2', 2,  NULL),
(9,  5, 'ENTRADA', 10,  20,  30,  'Recepción de compra 3', 3,  NULL),
(10, 5, 'ENTRADA', 8,   14,  22,  'Recepción de compra 3', 3,  NULL),
(11, 5, 'ENTRADA', 5,    9,  14,  'Recepción de compra 3', 3,  NULL),
(15, 5, 'ENTRADA', 30,  30,  60,  'Recepción de compra 4', 4,  NULL),
(16, 5, 'ENTRADA', 15,  20,  35,  'Recepción de compra 4', 4,  NULL),
(17, 5, 'ENTRADA', 20,  25,  45,  'Recepción de compra 4', 4,  NULL),
(18, 6, 'ENTRADA', 10,  15,  25,  'Recepción de compra 5', 5,  NULL),
(19, 6, 'ENTRADA', 8,   12,  20,  'Recepción de compra 5', 5,  NULL),
(20, 6, 'ENTRADA', 100,  0, 100,  'Recepción de compra 5', 5,  NULL),
(21, 5, 'ENTRADA', 25,  25,  50,  'Recepción de compra 6', 6,  NULL),
(22, 5, 'ENTRADA', 30,  25,  55,  'Recepción de compra 6', 6,  NULL),
(23, 5, 'ENTRADA', 15,  15,  30,  'Recepción de compra 6', 6,  NULL),
(28, 6, 'ENTRADA', 12,  12,  24,  'Recepción de compra 7', 7,  NULL),
(29, 6, 'ENTRADA', 10,  10,  20,  'Recepción de compra 7', 7,  NULL),
(30, 6, 'ENTRADA', 8,    7,  15,  'Recepción de compra 7', 7,  NULL),
(33, 6, 'ENTRADA', 8,    4,  12,  'Recepción de compra 9', 9,  NULL),
(34, 6, 'ENTRADA', 10,   8,  18,  'Recepción de compra 9', 9,  NULL),
(35, 6, 'ENTRADA', 8,    6,  14,  'Recepción de compra 9', 9,  NULL),
(36, 5, 'ENTRADA', 6,    4,  10,  'Recepción de compra 10', 10, NULL),
(43, 5, 'ENTRADA', 150, 50, 200,  'Recepción de compra 10', 10, NULL),
(44, 5, 'ENTRADA', 50,  30,  80,  'Recepción de compra 10', 10, NULL),
(6,  5, 'ENTRADA', 4,    6,  10,  'Recepción de compra 11', 11, NULL),
(7,  5, 'ENTRADA', 3,    5,   8,  'Recepción de compra 11', 11, NULL),
(5,  6, 'ENTRADA', 4,    8,  12,  'Recepción de compra 12', 12, NULL),
(8,  6, 'ENTRADA', 2,    4,   6,  'Recepción de compra 12', 12, NULL),
(12, 5, 'ENTRADA', 8,    8,  16,  'Recepción de compra 13', 13, NULL),
(13, 5, 'ENTRADA', 6,    8,  14,  'Recepción de compra 13', 13, NULL),
(14, 5, 'ENTRADA', 6,    6,  12,  'Recepción de compra 13', 13, NULL),
(24, 6, 'ENTRADA', 6,    6,  12,  'Recepción de compra 14', 14, NULL),
(25, 6, 'ENTRADA', 12,  13,  25,  'Recepción de compra 14', 14, NULL),
(45, 6, 'ENTRADA', 5,    4,   9,  'Recepción de compra 16', 16, NULL),
(46, 6, 'ENTRADA', 20,  20,  40,  'Recepción de compra 16', 16, NULL),
(37, 5, 'ENTRADA', 80,  40, 120,  'Recepción de compra 17', 17, NULL),
(38, 5, 'ENTRADA', 80,  50, 130,  'Recepción de compra 17', 17, NULL),
(39, 5, 'ENTRADA', 25,  15,  40,  'Recepción de compra 17', 17, NULL),
(40, 6, 'ENTRADA', 40,  20,  60,  'Recepción de compra 18', 18, NULL),
(41, 6, 'ENTRADA', 30,  15,  45,  'Recepción de compra 18', 18, NULL),
(42, 6, 'ENTRADA', 20,  15,  35,  'Recepción de compra 18', 18, NULL),
(49, 6, 'ENTRADA', 30,  20,  50,  'Recepción de compra 20', 20, NULL),
(50, 6, 'ENTRADA', 12,  10,  22,  'Recepción de compra 20', 20, NULL),
-- Salidas por ventas
(20, 2, 'SALIDA',  2, 100,  98,  'Salida por venta V0001', NULL, 1),
(37, 2, 'SALIDA',  3, 120, 117,  'Salida por venta V0001', NULL, 1),
(1,  3, 'SALIDA',  1,  25,  24,  'Salida por venta V0002', NULL, 2),
(22, 3, 'SALIDA',  1,  55,  54,  'Salida por venta V0002', NULL, 2),
(9,  2, 'SALIDA',  2,  30,  28,  'Salida por venta V0003', NULL, 3),
(21, 2, 'SALIDA',  1,  50,  49,  'Salida por venta V0003', NULL, 3),
-- Ajustes de inventario
(15, 5, 'AJUSTE',  2,  60,  58,  'Ajuste por merma detectada en almacén', NULL, NULL),
(43, 6, 'AJUSTE',  5, 200, 195,  'Ajuste por productos dañados en almacén', NULL, NULL);