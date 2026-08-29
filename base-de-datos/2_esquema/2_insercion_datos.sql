USE panaderia_db;


-- INSERCIÓN DE EMPLEADOS
INSERT INTO Empleado (nombres, apellidos, dni, contrasenia, direccion, telefono, rol, activo)
VALUES
    -- Integrantes del grupo (Administradores, contraseña 1234)
    ('Misael Martín', 'Alarcon Maza', '11111111', '1234', 'Av. Los Álamos 100', '911111111', 'Administrador', TRUE),
    ('Diego Alvaro', 'Ayay Palomino', '22222222', '1234', 'Jr. Las Rosas 200', '922222222', 'Administrador', TRUE),
    ('Bryan Alexander', 'Luque Serna', '33333333', '1234', 'Av. San Martín 300', '933333333', 'Administrador', TRUE),
    ('David Akira', 'Moquillaza Gonzales', '44444444', '1234', 'Calle Las Palmeras 400', '944444444', 'Administrador', TRUE),
    ('Isabella Valentyna', 'Segura Pizarro', '55555555', '1234', 'Av. Universitaria 500', '955555555', 'Administrador', TRUE),
    -- Otros Empleados
    ('Juan Esteban', 'Perez Gomez', '12345678', '1234', 'Av. Lima 123', '987654321', 'Administrador', TRUE),
    ('Maria Alexa', 'Lopez Diaz', '23456789', 'abcd', 'Jr. Los Olivos 456', '987654322', 'Empleado', TRUE),
    ('Carlos', 'Ramirez Soto', '34567890', 'pass1', 'Av. Brasil 789', '987654323', 'Empleado', TRUE),
    ('Ana Maria', 'Vargas Ruiz', '45678901', 'pass2', 'Av. Peru 321', '987654324', 'Empleado', TRUE),
    ('Rosa', 'Fernandez Castillo', '56789012', 'pass3', 'Jr. Amazonas 654', '987654325', 'Empleado', TRUE);

    
-- INSERCIÓN DE CLIENTES
INSERT INTO Cliente (nombre, dni, activo)
VALUES
    ('Luis', '76491376', TRUE),
    ('Pedro', '71679813', TRUE),
    ('Lucia', '06615298', TRUE),
    ('Miguel', '78958648', TRUE);

    
-- INSERCIÓN DE PRODUCTOS
INSERT INTO Producto (nombre, categoria, stock, precio, activo)
VALUES
    -- Primeros productos
    ('Pan francés', 'Panes', 50, 0.20, TRUE),
    ('Alfajor', 'Bocaditos', 20, 2.00, TRUE),
    ('Café americano', 'Bebidas', 60, 2.00, TRUE),
    ('Torta de Vainilla', 'Tortas', 10, 5.00, TRUE),
    -- Nuevos Panes
    ('Pan chapla', 'Panes', 40, 0.30, TRUE),
    ('Pan de yema', 'Panes', 30, 0.50, TRUE),
    ('Pan integral', 'Panes', 25, 0.80, TRUE),
    ('Pan de molde', 'Panes', 15, 6.50, TRUE),
    ('Pan ciabatta', 'Panes', 20, 1.20, TRUE),
    ('Pan serrano', 'Panes', 35, 0.40, TRUE),
    ('Pan campesino', 'Panes', 20, 1.00, TRUE),
    -- Nuevos Bocaditos
    ('Empanada de pollo', 'Bocaditos', 25, 3.50, TRUE),
    ('Empanada de carne', 'Bocaditos', 20, 3.50, TRUE),
    ('Croissant', 'Bocaditos', 30, 2.50, TRUE),
    ('Cachito de jamón y queso', 'Bocaditos', 20, 3.00, TRUE),
    ('Tequeños', 'Bocaditos', 40, 0.80, TRUE),
    ('Pan con pollo', 'Bocaditos', 15, 4.50, TRUE),
    ('Volován', 'Bocaditos', 18, 3.00, TRUE),
    -- Nuevas Bebidas
    ('Café con leche', 'Bebidas', 50, 3.00, TRUE),
    ('Chicha morada', 'Bebidas', 40, 2.50, TRUE),
    ('Emoliente', 'Bebidas', 30, 2.00, TRUE),
    ('Té filtrante', 'Bebidas', 45, 1.50, TRUE),
    ('Jugo de naranja', 'Bebidas', 25, 3.00, TRUE),
    ('Chocolate caliente', 'Bebidas', 20, 3.50, TRUE),
    -- Nuevas Tortas
    ('Torta de chocolate', 'Tortas', 8, 6.00, TRUE),
    ('Torta tres leches', 'Tortas', 6, 7.00, TRUE),
    ('Torta de manjar blanco', 'Tortas', 6, 6.50, TRUE),
    ('Torta de zanahoria', 'Tortas', 7, 6.50, TRUE),
    ('Cheesecake', 'Tortas', 5, 8.00, TRUE),
    ('Queque inglés', 'Tortas', 12, 4.00, TRUE);

    
-- INSERCIÓN DE CAJA
INSERT INTO Caja (id_empleado_apertura, id_empleado_cierre, fecha, hora_apertura, hora_cierre, monto_apertura, monto_cierre, estado)
VALUES
    (6, 7, '2026-06-24', '08:00:00', '18:00:00', 100.00, 500.00, 'Cerrada'),
    (8, 6, '2026-06-25', '09:00:00', '17:00:00', 100.00, 300.00, 'Cerrada'),
    (1, 2, '2026-06-26', '08:00:00', '18:00:00', 100.00, 450.00, 'Cerrada'),
    (3, 4, '2026-06-27', '08:00:00', '17:00:00', 100.00, 400.00, 'Cerrada'),
    (5, 1, '2026-06-28', '09:00:00', '18:00:00', 100.00, 470.00, 'Cerrada'),
    (9, 8, '2026-06-29', '08:00:00', '16:00:00', 100.00, 350.00, 'Cerrada'),
    (10, 9, '2026-06-30', '09:00:00', '17:00:00', 100.00, 420.00, 'Cerrada'),
    (2, 3, '2026-07-01', '08:00:00', '18:00:00', 100.00, 460.00, 'Cerrada'),
    (4, 4, '2026-07-02', '08:00:00', '19:00:00', 100.00, 340.00, 'Cerrada'),
    (7, 2, '2026-07-02', '09:00:00', '17:00:00', 100.00, 450.00, 'Cerrada');

    
-- INSERCIÓN DE VENTAS
INSERT INTO Venta (id_empleado, id_caja, id_cliente, tipo_despacho, nota_adicional, subtotal_venta, igv_venta, total_venta, metodo_pago)
VALUES
    (6, 1, 1, 'Aquí', 'Sin azúcar', ROUND(10.00 / 1.18, 2), ROUND(10.00 - (10.00 / 1.18), 2), 10.00, 'Efectivo'),
    (7, 2, 2, 'Llevar', 'Entrega rápida', ROUND(8.00 / 1.18, 2), ROUND(8.00 - (8.00 / 1.18), 2), 8.00, 'Yape'),
    (8, 1, 3, 'Delivery', 'Llamar antes', ROUND(12.00 / 1.18, 2), ROUND(12.00 - (12.00 / 1.18), 2), 12.00, 'Tarjeta'),
    (9, 2, 4, 'Aquí', '', ROUND(15.00 / 1.18, 2), ROUND(15.00 - (15.00 / 1.18), 2), 15.00, 'Efectivo'),
    (1, 3, 1, 'Aquí', 'Para llevar a casa', ROUND(20.00 / 1.18, 2), ROUND(20.00 - (20.00 / 1.18), 2), 20.00, 'Yape'),
    (2, 3, 2, 'Llevar', '', ROUND(14.00 / 1.18, 2), ROUND(14.00 - (14.00 / 1.18), 2), 14.00, 'Tarjeta'),
    (3, 4, 3, 'Delivery', 'Dejar en recepción', ROUND(24.00 / 1.18, 2), ROUND(24.00 - (24.00 / 1.18), 2), 24.00, 'Efectivo'),
    (4, 4, 4, 'Aquí', '', ROUND(9.00 / 1.18, 2), ROUND(9.00 - (9.00 / 1.18), 2), 9.00, 'Yape'),
    (5, 5, 1, 'Llevar', 'Sin bolsa', ROUND(18.00 / 1.18, 2), ROUND(18.00 - (18.00 / 1.18), 2), 18.00, 'Tarjeta'),
    (6, 5, 2, 'Aquí', '', ROUND(10.50 / 1.18, 2), ROUND(10.50 - (10.50 / 1.18), 2), 10.50, 'Efectivo'),
    (7, 6, 3, 'Delivery', 'Tocar timbre', ROUND(30.00 / 1.18, 2), ROUND(30.00 - (30.00 / 1.18), 2), 30.00, 'Yape'),
    (8, 6, 4, 'Aquí', '', ROUND(7.00 / 1.18, 2), ROUND(7.00 - (7.00 / 1.18), 2), 7.00, 'Tarjeta'),
    (9, 7, 1, 'Llevar', '', ROUND(22.00 / 1.18, 2), ROUND(22.00 - (22.00 / 1.18), 2), 22.00, 'Efectivo'),
    (10, 7, 2, 'Aquí', 'Cumpleaños', ROUND(16.00 / 1.18, 2), ROUND(16.00 - (16.00 / 1.18), 2), 16.00, 'Yape'),
    (1, 8, 3, 'Delivery', '', ROUND(28.00 / 1.18, 2), ROUND(28.00 - (28.00 / 1.18), 2), 28.00, 'Tarjeta'),
    (2, 8, 4, 'Aquí', '', ROUND(13.00 / 1.18, 2), ROUND(13.00 - (13.00 / 1.18), 2), 13.00, 'Efectivo'),
    (3, 9, 1, 'Llevar', '', ROUND(19.00 / 1.18, 2), ROUND(19.00 - (19.00 / 1.18), 2), 19.00, 'Yape'),
    (4, 9, 2, 'Aquí', '', ROUND(10.00 / 1.18, 2), ROUND(10.00 - (10.00 / 1.18), 2), 10.00, 'Tarjeta'),
    (5, 10, 3, 'Delivery', 'Con boleta', ROUND(24.00 / 1.18, 2), ROUND(24.00 - (24.00 / 1.18), 2), 24.00, 'Efectivo'),
    (6, 10, 4, 'Aquí', '', ROUND(15.00 / 1.18, 2), ROUND(15.00 - (15.00 / 1.18), 2), 15.00, 'Yape');


-- INSERCIÓN DE DETALLE_VENTA
INSERT INTO Detalle_Venta (id_venta, id_producto, cantidad, precio_unitario, precio_total)
VALUES
    (1, 1, 2, 0.20, 0.40),
    (2, 2, 3, 2.00, 6.00),
    (3, 3, 2, 2.00, 4.00),
    (4, 4, 2, 5.00, 10.00),
    (5, 8, 2, 6.50, 13.00),
    (5, 2, 3, 2.00, 6.00),
    (6, 14, 2, 2.50, 5.00),
    (6, 19, 3, 3.00, 9.00),
    (7, 26, 1, 7.00, 7.00),
    (7, 12, 2, 3.50, 7.00),
    (7, 20, 4, 2.50, 10.00),
    (8, 1, 5, 0.20, 1.00),
    (8, 16, 10, 0.80, 8.00),
    (9, 29, 2, 8.00, 16.00),
    (9, 3, 1, 2.00, 2.00),
    (10, 17, 2, 4.50, 9.00),
    (10, 22, 1, 1.50, 1.50),
    (11, 27, 2, 6.50, 13.00),
    (11, 13, 2, 3.50, 7.00),
    (11, 21, 5, 2.00, 10.00),
    (12, 1, 10, 0.20, 2.00),
    (12, 6, 10, 0.50, 5.00),
    (13, 25, 2, 6.00, 12.00),
    (13, 14, 4, 2.50, 10.00),
    (14, 30, 2, 4.00, 8.00),
    (14, 15, 2, 3.00, 6.00),
    (14, 1, 10, 0.20, 2.00),
    (15, 28, 2, 6.50, 13.00),
    (15, 18, 5, 3.00, 15.00),
    (16, 9, 5, 1.20, 6.00),
    (16, 19, 2, 3.00, 6.00),
    (16, 1, 5, 0.20, 1.00),
    (17, 12, 2, 3.50, 7.00),
    (17, 20, 2, 2.50, 5.00),
    (17, 11, 7, 1.00, 7.00),
    (18, 2, 5, 2.00, 10.00),
    (19, 29, 3, 8.00, 24.00),
    (20, 4, 3, 5.00, 15.00);