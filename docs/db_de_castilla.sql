/*__________________________________________________________

    CREACIÓN DE LA BASE DE DATOS
__________________________________________________________*/-- Creación de la base de datos
DROP DATABASE IF EXISTS db_de_castilla;
CREATE DATABASE IF NOT EXISTS db_de_castilla;
USE db_de_castilla;-- -----------------------------------------------------
-- Tabla estadopedido
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estadopedido (
    id_estado_pedido INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_estado VARCHAR(255),
    PRIMARY KEY (id_estado_pedido)
    );

-- -----------------------------------------------------
-- Tabla rol
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rol (
    id_rol INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_rol VARCHAR(255),
    PRIMARY KEY (id_rol)
    );

-- -----------------------------------------------------
-- Tabla usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
    no_documento_usuario BIGINT NOT NULL AUTO_INCREMENT,
    apellido_usuario VARCHAR(255),
    celular_usuario BIGINT,
    email VARCHAR(255),
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_usuario VARCHAR(255),
    password VARCHAR(255),
    id_rol_fk INT,
    PRIMARY KEY (no_documento_usuario),
    FOREIGN KEY (id_rol_fk) REFERENCES rol (id_rol)
    );

-- -----------------------------------------------------
-- Tabla pedido
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pedido (
    id_pedido INT NOT NULL AUTO_INCREMENT,
    descripcion_pedido VARCHAR(255),
    estado BIT(1) NOT NULL DEFAULT 1,
    fecha_pedido DATE,
    id_estado_pedido_fk INT,
    no_documento_usuario_fk BIGINT,
    PRIMARY KEY (id_pedido),
    FOREIGN KEY (id_estado_pedido_fk) REFERENCES estadopedido (id_estado_pedido),
    FOREIGN KEY (no_documento_usuario_fk) REFERENCES usuario (no_documento_usuario)
    );

-- -----------------------------------------------------
-- Tabla proveedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS proveedor (
    id_proveedor INT NOT NULL AUTO_INCREMENT,
    celular_proveedor BIGINT,
    celular_respaldo_proveedor BIGINT,
    correo_proveedor VARCHAR(255),
    empresa_proveedor VARCHAR(255),
    estado BIT(1) NOT NULL DEFAULT 1,
    estado_proveedor BIT(1),
    nit_proveedor BIGINT,
    nombre_proveedor VARCHAR(255),
    PRIMARY KEY (id_proveedor)
    );

-- -----------------------------------------------------
-- Tabla calificacion
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS calificacion (
    id_calificacion INT NOT NULL AUTO_INCREMENT,
    comentario_calificacion VARCHAR(255),
    estado BIT(1) NOT NULL DEFAULT 1,
    estrallas_calificacion INT,
    id_pedido_fk INT,
    id_proveedor_fk INT,
    PRIMARY KEY (id_calificacion),
    FOREIGN KEY (id_pedido_fk) REFERENCES pedido (id_pedido),
    FOREIGN KEY (id_proveedor_fk) REFERENCES proveedor (id_proveedor)
    );
-- -----------------------------------------------------
-- Tabla categoria
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categoria (
    id_categoria INT NOT NULL AUTO_INCREMENT,
    descripcion_categoria VARCHAR(255),
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_categoria VARCHAR(255),
    PRIMARY KEY (id_categoria)
    );

-- -----------------------------------------------------
-- Tabla producto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS producto (
    id_producto INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_producto VARCHAR(255),
    imagen_producto VARCHAR(255),
    precio_producto INT,
    id_categoria_fk INT,
    PRIMARY KEY (id_producto),
    FOREIGN KEY (id_categoria_fk) REFERENCES categoria (id_categoria)
    );

-- -----------------------------------------------------
-- Tabla venta
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS venta (
    id_venta INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    fecha_venta DATE,
    hora_venta TIME,
    total_venta BIGINT,
    id_pedido_fk INT,
    no_documento_usuario_fk BIGINT,
    PRIMARY KEY (id_venta),
    FOREIGN KEY (id_pedido_fk) REFERENCES pedido (id_pedido),
    FOREIGN KEY (no_documento_usuario_fk) REFERENCES usuario (no_documento_usuario)
    );

-- -----------------------------------------------------
-- Tabla detalle_venta
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS detalle_venta (
    id_detalle_venta INT NOT NULL AUTO_INCREMENT,
    cantidad_producto INT,
    estado BIT(1) NOT NULL DEFAULT 1,
    subtotal_detalle_venta BIGINT,
    id_producto_fk INT,
    id_venta_fk INT,
    PRIMARY KEY (id_detalle_venta),
    FOREIGN KEY (id_producto_fk) REFERENCES producto (id_producto),
    FOREIGN KEY (id_venta_fk) REFERENCES venta (id_venta)
    );

-- -----------------------------------------------------
-- Tabla estado_oc
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estado_oc (
    id_estado_oc INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_estado_oc VARCHAR(255),
    PRIMARY KEY (id_estado_oc)
    );

-- -----------------------------------------------------
-- Tabla orden_compra
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS orden_compra (
    id_orden_compra INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    fecha_oc DATE,
    hora_oc TIME,
    id_estado_oc_fk INT,
    PRIMARY KEY (id_orden_compra),
    FOREIGN KEY (id_estado_oc_fk) REFERENCES estado_oc (id_estado_oc)
    );

-- -----------------------------------------------------
-- Tabla estado_insumo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estado_insumo (
    id_estado_insumo INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_estado_insumo VARCHAR(255),
    PRIMARY KEY (id_estado_insumo)
    );

-- -----------------------------------------------------
-- Tabla insumo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS insumo (
    id_insumo INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_insumo VARCHAR(255),
    id_estado_insumo INT,
    PRIMARY KEY (id_insumo),
    FOREIGN KEY (id_estado_insumo) REFERENCES estado_insumo (id_estado_insumo)
    );

-- -----------------------------------------------------
-- Tabla detalleoc
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS detalleoc (
    id_detalle_oc INT NOT NULL AUTO_INCREMENT,
    cantidad_insumo INT,
    estado BIT(1) NOT NULL DEFAULT 1,
    id_insumo_fk INT,
    id_orden_compra_fk INT,
    PRIMARY KEY (id_detalle_oc),
    FOREIGN KEY (id_orden_compra_fk) REFERENCES orden_compra (id_orden_compra),
    FOREIGN KEY (id_insumo_fk) REFERENCES insumo (id_insumo)
    );

-- -----------------------------------------------------
-- Tabla tipo_movimiento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipo_movimiento (
    id_tipo_movimiento INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_tipo_movimiento VARCHAR(255),
    PRIMARY KEY (id_tipo_movimiento)
    );

-- -----------------------------------------------------
-- Tabla historico
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS historico (
    id_historico INT NOT NULL AUTO_INCREMENT,
    cantidad_historico INT,
    estado BIT(1) NOT NULL DEFAULT 1,
    fecha_caducidad DATE,
    fecha_movimiento DATE,
    tipo_historico VARCHAR(255),
    id_insumo_fk INT,
    id_producto_fk INT,
    id_tipo_movimiento_fk INT,
    PRIMARY KEY (id_historico),
    FOREIGN KEY (id_producto_fk) REFERENCES producto (id_producto),
    FOREIGN KEY (id_tipo_movimiento_fk) REFERENCES tipo_movimiento (id_tipo_movimiento),
    FOREIGN KEY (id_insumo_fk) REFERENCES insumo (id_insumo)
    );

-- -----------------------------------------------------
-- Tabla inventario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS inventario (
    id_inventario INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    stock_inventario INT,
    tipo_inventario VARCHAR(255),
    id_insumo_fk INT,
    id_producto_fk INT,
    PRIMARY KEY (id_inventario),
    FOREIGN KEY (id_producto_fk) REFERENCES producto (id_producto),
    FOREIGN KEY (id_insumo_fk) REFERENCES insumo (id_insumo)
    );

-- -----------------------------------------------------
-- Tabla oc_has_proveedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS oc_has_proveedor (
    id_oc_has_proveedor INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    id_orden_compra_fk INT,
    id_proveedor_fk INT,
    PRIMARY KEY (id_oc_has_proveedor),
    FOREIGN KEY (id_orden_compra_fk) REFERENCES orden_compra (id_orden_compra),
    FOREIGN KEY (id_proveedor_fk) REFERENCES proveedor (id_proveedor)
    );

-- -----------------------------------------------------
-- Tabla permiso
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS permiso (
    id_permiso INT NOT NULL AUTO_INCREMENT,
    descripcion_permiso VARCHAR(255),
    estado BIT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id_permiso)
    );

-- -----------------------------------------------------
-- Tabla rol_has_permiso
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rol_has_permiso (
    id_rol_has_permiso INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    id_permiso_fk INT,
    id_rol_fk INT,
    PRIMARY KEY (id_rol_has_permiso),
    FOREIGN KEY (id_rol_fk) REFERENCES rol (id_rol),
    FOREIGN KEY (id_permiso_fk) REFERENCES permiso (id_permiso)
    );

-- -----------------------------------------------------
-- Tabla sabor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS sabor (
    id_sabor INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    nombre_sabor VARCHAR(255),
    PRIMARY KEY (id_sabor)
    );

-- -----------------------------------------------------
-- Tabla sabor_has_producto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS sabor_has_producto (
    id_sabor_has_producto INT NOT NULL AUTO_INCREMENT,
    estado BIT(1) NOT NULL DEFAULT 1,
    id_producto_fk INT,
    id_sabor_fk INT,
    PRIMARY KEY (id_sabor_has_producto),
    FOREIGN KEY (id_sabor_fk) REFERENCES sabor (id_sabor),
    FOREIGN KEY (id_producto_fk) REFERENCES producto (id_producto)
    );

/*__________________________________________________________

    TRIGGERS
__________________________________________________________*/

/*---Agregar registro a la tabla Inventario por cada insert en la tabla Insumo ---*/
DELIMITER $$
CREATE TRIGGER TG_agregarInsumo_AI AFTER INSERT ON insumo
FOR EACH ROW
BEGIN
    INSERT INTO inventario (stock_inventario, id_insumo_fk, tipo_inventario) VALUES (0, NEW.id_insumo, "INSUMO");
    INSERT INTO historico (fecha_movimiento, cantidad_historico, id_insumo_fk, id_tipo_movimiento_fk, tipo_historico) 
    VALUES (NOW(), 0, NEW.id_insumo, 2, "INSUMO");
END$$
DELIMITER ;

/*---Agregar registro a la tabla Inventario por cada insert en la tabla Producto ---*/
DELIMITER $$
CREATE TRIGGER TG_agregarProducto_AI AFTER INSERT ON producto 
FOR EACH ROW 
BEGIN
    INSERT INTO inventario (stock_inventario, id_producto_fk, tipo_inventario) VALUES (0, NEW.id_producto, "PRODUCTO");
    INSERT INTO historico (fecha_movimiento, cantidad_historico, id_producto_fk, id_tipo_movimiento_fk, tipo_historico) 
    VALUES (NOW(), 0, NEW.id_producto, 2, "PRODUCTO");
END$$
DELIMITER ;

/*---Actualizar la tabla Inventario por cada insert en la tabla Historico ---*/
DELIMITER $$
CREATE TRIGGER TG_SetStock_AI AFTER INSERT ON historico
FOR EACH ROW
BEGIN
    -- Actualizar stock 
    IF (NEW.id_tipo_movimiento_fk = 1) THEN
        IF (NEW.tipo_historico = "PRODUCTO") THEN
            UPDATE inventario SET 
                stock_inventario = stock_inventario + NEW.cantidad_historico 
            WHERE id_producto_fk = NEW.id_producto_fk;
        ELSEIF (NEW.tipo_historico = "INSUMO") THEN
            UPDATE inventario SET 
                stock_inventario = stock_inventario + NEW.cantidad_historico 
            WHERE id_insumo_fk = NEW.id_insumo_fk;
        END IF;
    ELSEIF (NEW.id_tipo_movimiento_fk = 2) THEN
        IF (NEW.tipo_historico = "PRODUCTO") THEN
            UPDATE inventario SET 
                stock_inventario = stock_inventario - NEW.cantidad_historico 
            WHERE id_producto_fk = NEW.id_producto_fk;
        ELSEIF (NEW.tipo_historico = "INSUMO") THEN
            UPDATE inventario SET 
                stock_inventario = stock_inventario - NEW.cantidad_historico 
            WHERE id_insumo_fk = NEW.id_insumo_fk;
        END IF;
    END IF;
END$$

/*---Agregar Calificación por defecto al proveedor cuando se crea uno nuevo --*/
DELIMITER $$
CREATE TRIGGER TG_calificacionProveedor_AI AFTER INSERT ON proveedor
FOR EACH ROW
BEGIN
    INSERT INTO calificacion (estrallas_calificacion, id_proveedor_fk) 
    VALUES (5, NEW.id_proveedor);
END$$
DELIMITER ;

/*__________________________________________________________

    PROCEDIMIENTOS DE ALMACENADO
__________________________________________________________*/

/*-- Permite consultar cuáles son los productos (nombres) de una categoría. Si se pone solo '' mostrará los productos de todas las categorías. --*/
DELIMITER $$
CREATE PROCEDURE SPobtenerProductosCategoria(IN miCategoria VARCHAR(255))
BEGIN
	SELECT c.nombre_categoria AS CATEGORIA, p.nombre_producto AS PRODUCTO
	FROM categoria c
	LEFT JOIN producto p ON c.id_categoria = p.id_categoria_fk
	WHERE c.nombre_categoria LIKE CONCAT('%', miCategoria, '%') OR miCategoria = '';
END$$
DELIMITER ;

/*-- Permite consultar cuáles son los productos (nombres) de un sabor. Si se pone solo '' mostrará los productos de todos los sabores. --*/
DELIMITER $$
CREATE PROCEDURE SPobtenerProductosSabor(IN miSabor VARCHAR(255))
BEGIN
	SELECT s.nombre_sabor AS Sabor, p.nombre_producto AS PRODUCTO
	FROM sabor s
	LEFT JOIN sabor_has_producto sp ON s.id_sabor = sp.id_sabor_fk
	LEFT JOIN producto p ON sp.id_producto_fk = p.id_producto
	WHERE s.nombre_sabor LIKE CONCAT('%', miSabor, '%') OR miSabor = '';
END$$
DELIMITER ;

/*-- Permite consultar cuáles son los permisos y roles de un usuario buscando por número de documento, nombre, apellido. Si se pone solo '' mostrará los permisos y roles de todos los usuarios. --*/
DELIMITER $$
CREATE PROCEDURE SProlesPermisosUsuario(IN datoUsuario VARCHAR(255))
BEGIN
	SELECT u.no_documento_usuario AS DOCUMENTO, CONCAT(u.nombre_usuario, ' ', u.apellido_usuario) AS NOMBRE, r.nombre_rol AS ROL, p.descripcion_permiso AS PERMISO
	FROM usuario u
	LEFT JOIN rol r ON u.id_rol_fk = r.id_rol
	LEFT JOIN rol_has_permiso rp ON r.id_rol = rp.id_rol_fk
	LEFT JOIN permiso p ON rp.id_permiso_fk = p.id_permiso
	WHERE u.no_documento_usuario LIKE CONCAT('%', datoUsuario, '%')
		OR CONCAT(u.nombre_usuario, ' ', u.apellido_usuario) LIKE CONCAT('%', datoUsuario, '%')
		OR u.nombre_usuario LIKE CONCAT('%', datoUsuario, '%')
		OR u.apellido_usuario LIKE CONCAT('%', datoUsuario, '%')
		OR datoUsuario = '';
END$$
DELIMITER ;

/*__________________________________________________________

    VISTAS
__________________________________________________________*/

/*-----------Inventario de insumo-----------*/
CREATE VIEW VW_INVENTARIO_INSUMO AS
SELECT Inventario.id_insumo_fk AS ID,
    Insumo.nombre_insumo AS INSUMO,
    SUM(IF(Historico.id_tipo_movimiento_fk = 1, Historico.cantidad_historico, 0)) AS ENTRADAS,
    SUM(IF(Historico.id_tipo_movimiento_fk = 2, Historico.cantidad_historico, 0)) AS SALIDAS,
    Inventario.stock_inventario AS STOCK
FROM Inventario
INNER JOIN Insumo ON Inventario.id_insumo_fk = Insumo.id_insumo
INNER JOIN Historico ON Inventario.id_insumo_fk = Historico.id_insumo_fk
WHERE Insumo.estado = 1
GROUP BY Inventario.id_insumo_fk, Insumo.nombre_insumo, Inventario.stock_inventario;

-- SELECT * FROM VW_INVENTARIO_INSUMO;

/*-----------Inventario de producto-----------*/
CREATE VIEW VW_INVENTARIO_PRODUCTO AS 
SELECT Inventario.id_producto_fk AS ID,
    Producto.nombre_producto AS PRODUCTO,
    SUM(IF(Historico.id_tipo_movimiento_fk = 1, Historico.cantidad_historico, 0)) AS ENTRADAS,
    SUM(IF(Historico.id_tipo_movimiento_fk = 2, Historico.cantidad_historico, 0)) AS SALIDAS,
    Inventario.stock_inventario AS STOCK
FROM Inventario
INNER JOIN Producto ON Inventario.id_producto_fk = Producto.id_producto
INNER JOIN Historico ON Inventario.id_producto_fk = Historico.id_producto_fk
WHERE Producto.estado = 1
GROUP BY Inventario.id_producto_fk, Producto.nombre_producto, Inventario.stock_inventario;

-- SELECT * FROM VW_INVENTARIO_PRODUCTO;

/*--------Pedidos No finalizados-------*/
CREATE VIEW VW_PEDIDOS_NO_FINALIZADOS AS
SELECT p.id_pedido AS ID_PEDIDO, p.descripcion_pedido AS DESCRIPCION, p.fecha_pedido AS FECHA,
    e.nombre_estado AS ESTADO, u.no_documento_usuario AS DOC_USUARIO, u.celular_usuario AS CELULAR,
    CONCAT(u.nombre_usuario, ' ', u.apellido_usuario) AS CLIENTE
FROM pedido AS p
INNER JOIN estadopedido AS e ON p.id_estado_pedido_fk = e.id_estado_pedido
INNER JOIN usuario AS u ON p.no_documento_usuario_fk = u.no_documento_usuario
WHERE e.nombre_estado != "Finalizados"
AND e.nombre_estado != "Cancelado"
AND p.estado = 1
ORDER BY p.fecha_pedido ASC;

-- SELECT * FROM VW_PEDIDOS_NO_FINALIZADOS;

/*--------Pedidos Finalizados-------*/
CREATE VIEW VW_PEDIDOS_FINALIZADOS AS
SELECT p.id_pedido AS ID_PEDIDO, p.descripcion_pedido AS DESCRIPCION, p.fecha_pedido AS FECHA,
    e.nombre_estado AS ESTADO, u.no_documento_usuario AS DOC_USUARIO, u.celular_usuario AS CELULAR,
    CONCAT(u.nombre_usuario, ' ', u.apellido_usuario) AS CLIENTE
FROM pedido AS p
INNER JOIN estadopedido AS e ON p.id_estado_pedido_fk = e.id_estado_pedido
INNER JOIN usuario AS u ON p.no_documento_usuario_fk = u.no_documento_usuario
WHERE e.nombre_estado = "Finalizados"
OR e.nombre_estado = "Cancelado"
AND p.estado = 1
ORDER BY p.fecha_pedido ASC;


-- SELECT * FROM VW_PEDIDOS_FINALIZADOS;

/*------Listado de los proveedores con promedio de calificación-------*/
CREATE VIEW VW_PROVEEDORES_CALIFICACION_AVG AS 
SELECT proveedor.id_proveedor AS ID_PROVEEDOR, proveedor.empresa_proveedor AS EMPRESA,
    AVG(calificacion.estrallas_calificacion) AS PROMEDIO_CALIFICACION
FROM proveedor
LEFT JOIN calificacion ON proveedor.id_proveedor = calificacion.id_proveedor_fk
WHERE proveedor.estado = 1
GROUP BY proveedor.id_proveedor, proveedor.empresa_proveedor;

-- SELECT * FROM VW_PROVEEDORES_CALIFICACION_AVG;

/*------Listado de ventas con su total y vendedor que la realizó-------*/
CREATE VIEW VW_DATOS_VENTA AS 
SELECT venta.id_venta AS ID, venta.fecha_venta AS FECHA, venta.hora_venta AS HORA, 
    venta.total_venta AS TOTAL, CONCAT(usuario.nombre_usuario, ' ', usuario.apellido_usuario) AS VENDEDOR
FROM venta
INNER JOIN usuario ON venta.no_documento_usuario_fk = usuario.no_documento_usuario;

-- SELECT * FROM VW_DATOS_VENTA;
