-- ==========================================================================
-- Alpha Technology - Ventas coherentes para el grafo de "Productos relacionados"
-- ==========================================================================
-- Agrega 14 ventas COMPLETADA (V0251 a V0264) con combinaciones que tienen sentido
-- (laptop + mouse, monitor + cable HDMI, impresora + tintas, setup gamer, etc.),
-- para que el orden por "Veces juntos" se note en la demo.
--
-- USO: ejecutar UNA SOLA VEZ, sobre la base ya cargada con el script de estructura
-- y el de datos de prueba (insercion_datos). Las ventas, sus detalles y el kardex
-- no se pueden borrar (triggers), asi que si algo sale mal se usa ROLLBACK antes
-- del COMMIT o se vuelve a cargar la base completa.
--
-- El stock se descuenta igual que en el sistema: cada salida del kardex toma como
-- stock_anterior el stock actual del producto, y al final producto.stock queda
-- igual al ultimo stock_nuevo del kardex.
-- ==========================================================================
USE alpha_technology;
SET NAMES utf8mb4;

START TRANSACTION;

-- 1. VENTA (14). Fechas posteriores a la ultima venta del seed (V0250)
INSERT INTO venta (id_venta, numero, id_cliente, id_empleado, fecha_venta, total, estado, fecha_modificacion) VALUES
  (251, 'V0251', 11, 5, '2026-11-16 10:12:00', 2507, 'COMPLETADA', '2026-11-16 10:12:00'),
  (252, 'V0252', 14, 3, '2026-11-17 15:40:00', 2857, 'COMPLETADA', '2026-11-17 15:40:00'),
  (253, 'V0253', 6, 8, '2026-11-18 11:05:00', 2448, 'COMPLETADA', '2026-11-18 11:05:00'),
  (254, 'V0254', 1, 5, '2026-11-18 17:22:00', 2458, 'COMPLETADA', '2026-11-18 17:22:00'),
  (255, 'V0255', 13, 10, '2026-11-19 09:48:00', 1024, 'COMPLETADA', '2026-11-19 09:48:00'),
  (256, 'V0256', 17, 2, '2026-11-19 14:30:00', 829, 'COMPLETADA', '2026-11-19 14:30:00'),
  (257, 'V0257', 4, 10, '2026-11-20 12:15:00', 804, 'COMPLETADA', '2026-11-20 12:15:00'),
  (258, 'V0258', 18, 6, '2026-11-21 10:37:00', 1249, 'COMPLETADA', '2026-11-21 10:37:00'),
  (259, 'V0259', 9, 7, '2026-11-22 16:02:00', 1244, 'COMPLETADA', '2026-11-22 16:02:00'),
  (260, 'V0260', 16, 12, '2026-11-23 13:20:00', 6286, 'COMPLETADA', '2026-11-23 13:20:00'),
  (261, 'V0261', 19, 12, '2026-11-24 11:44:00', 427, 'COMPLETADA', '2026-11-24 11:44:00'),
  (262, 'V0262', 2, 4, '2026-11-24 18:10:00', 3457, 'COMPLETADA', '2026-11-24 18:10:00'),
  (263, 'V0263', 12, 9, '2026-11-25 10:26:00', 398, 'COMPLETADA', '2026-11-25 10:26:00'),
  (264, 'V0264', 20, 11, '2026-11-26 15:53:00', 828, 'COMPLETADA', '2026-11-26 15:53:00');

-- 2. DETALLE_VENTA (precios del catalogo)
INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_unitario) VALUES
  (251, 1, 1, 2399),
  (251, 22, 1, 59),
  (251, 41, 1, 49),
  (252, 1, 1, 2399),
  (252, 22, 1, 59),
  (252, 19, 1, 399),
  (253, 1, 1, 2399),
  (253, 41, 1, 49),
  (254, 1, 1, 2399),
  (254, 22, 1, 59),
  (255, 10, 1, 999),
  (255, 37, 1, 25),
  (256, 9, 1, 749),
  (256, 42, 1, 55),
  (256, 37, 1, 25),
  (257, 9, 1, 749),
  (257, 42, 1, 55),
  (258, 64, 1, 1099),
  (258, 66, 2, 49),
  (258, 67, 1, 52),
  (259, 64, 1, 1099),
  (259, 66, 1, 49),
  (259, 67, 1, 52),
  (259, 47, 2, 22),
  (260, 55, 1, 4799),
  (260, 11, 1, 1099),
  (260, 91, 1, 249),
  (260, 90, 1, 139),
  (261, 90, 1, 139),
  (261, 91, 1, 249),
  (261, 49, 1, 39),
  (262, 88, 1, 2799),
  (262, 89, 2, 329),
  (263, 74, 1, 219),
  (263, 75, 1, 179),
  (264, 84, 1, 649),
  (264, 85, 1, 179);

-- 3. MOVIMIENTO_INVENTARIO (kardex encadenado)
-- Una salida por cada linea. Si un producto aparece en varias ventas, la suma
-- acumulada (por id_venta) hace que cada stock_anterior sea el stock_nuevo del
-- movimiento previo del mismo producto.
INSERT INTO movimiento_inventario (id_producto, id_empleado, tipo_movimiento, cantidad, stock_anterior, stock_nuevo, motivo, id_compra, id_venta, fecha_movimiento)
SELECT d.id_producto,
       v.id_empleado,
       'SALIDA',
       d.cantidad,
       p.stock - (SUM(d.cantidad) OVER w - d.cantidad),
       p.stock - SUM(d.cantidad) OVER w,
       CONCAT('Salida por venta ', v.numero),
       NULL,
       v.id_venta,
       v.fecha_venta
FROM detalle_venta d
INNER JOIN venta v ON v.id_venta = d.id_venta
INNER JOIN producto p ON p.id_producto = d.id_producto
WHERE d.id_venta BETWEEN 251 AND 264
WINDOW w AS (PARTITION BY d.id_producto ORDER BY d.id_venta ROWS UNBOUNDED PRECEDING)
ORDER BY d.id_venta, d.id_detalle_venta;

-- 4. PRODUCTO: el stock baja lo vendido (queda igual al ultimo stock_nuevo del kardex)
UPDATE producto
SET stock = stock - (SELECT SUM(d.cantidad)
                     FROM detalle_venta d
                     WHERE d.id_venta BETWEEN 251 AND 264
                       AND d.id_producto = producto.id_producto)
WHERE id_producto IN (SELECT id_producto FROM detalle_venta WHERE id_venta BETWEEN 251 AND 264);

COMMIT;

-- ==========================================================================
-- VERIFICACION (opcional): pares de productos vendidos juntos, de mas a menos.
-- Es la misma regla del grafo: ventas COMPLETADA, peso = ventas compartidas.
-- ==========================================================================
SELECT pa.nombre_producto AS producto_a,
       pb.nombre_producto AS producto_b,
       COUNT(*) AS veces_juntos
FROM detalle_venta a
INNER JOIN detalle_venta b ON b.id_venta = a.id_venta AND a.id_producto < b.id_producto
INNER JOIN venta v ON v.id_venta = a.id_venta AND v.estado = 'COMPLETADA'
INNER JOIN producto pa ON pa.id_producto = a.id_producto
INNER JOIN producto pb ON pb.id_producto = b.id_producto
GROUP BY a.id_producto, b.id_producto, pa.nombre_producto, pb.nombre_producto
ORDER BY veces_juntos DESC, pa.nombre_producto, pb.nombre_producto
LIMIT 20;
