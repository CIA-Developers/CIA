/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Create database StockCia;

use StockCia;

CREATE TABLE productos (
    codigo_producto VARCHAR(13) NOT NULL PRIMARY KEY,
    nom_producto VARCHAR(25) NOT NULL,
    tipo_producto VARCHAR(25) NOT NULL,
    marca VARCHAR(15) NOT NULL,
    precio_unitario_venta FLOAT NOT NULL,
    Unidad VARCHAR(15) NOT NULL,
    descripcion VARCHAR(25) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    existencia_total INT(25) NOT NULL,
    status_prod VARCHAR(15) NOT NULL);
    
    insert into productos values
        (1651,"lamina galvanizada calibre 16 de 4 x 8","construccion","Vimar",105.00,"pza","Lamina de acero con recubrimiento de zinc",2018-05-01,727,"promocion"),
        (1722,"Tuerca hexagonal de 5/8","ferreteria","Fastenere",0.00,"kg","Tuerca con una insercion de collar de nylon que resiste el giro.",2018-03-02,1308,"normal"),
        (1658,"Tubo rectangular aluminio","construccion","Bosch",389.00,"pza","Tubo de 1m de lago y 12 mm de ancho ",2018-06-23,1098,"normal"),
        (1321,"Clavos","ferreteria","Sithl",50.00,"kg","Clavos Estandar 3-2-1",2018-07-20,3330,"normal"),
        (8170,"Motosierra" ,"jardin","Truper",500.00,"pza","Motosierra Electrica 18 pulgadas",2018-04-15,27,"promocion");
    
CREATE TABLE sucursal (
    no_sucursal INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    calle VARCHAR(50) NOT NULL,
    colonia VARCHAR(50) NOT NULL,
    numero VARCHAR(5) NOT NULL,
    telefono INT(12) NOT NULL);
    
    insert into sucursal values 
        (1,"Vicente Guerrero","Tulancingo",213,7757532101),
        (2,"Gabriel Garcia marquez","Magisterio",333,5575123047),
        (3,"Santa clara","Jaltepec",152,7757712362),
        (4,"Cipres","La Morena",122,7751236547),
        (5,"Verla Bartoc","Jardines del Sur",200,5575896300);
    
CREATE TABLE sucursal_productos (
    id_sucursal_productos INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    no_sucursal INT(15) NOT NULL,
    codigo_producto VARCHAR(10) NOT NULL,
    existencias INT(6) NOT NULL,
    limite_maximo INT(6) NOT NULL,
    limite_minimo INT(6) NOT NULL,
    FOREIGN KEY (no_sucursal) REFERENCES sucursal (no_sucursal),
    FOREIGN KEY (codigo_producto) REFERENCES productos (codigo_producto));
    
    insert into sucursal_productos values 
        (1,1,1651,25,200,20),
        (2,1,1722,100,800,99),
        (3,1,1658,480,500,40),
        (4,1,1321,1000,2000,500),
        (5,1,8170,5,8,3),
        (6,2,1651,30,200,20),
        (7,2,1722,100,800,99),
        (8,2,1658,300,500,40),
        (9,2,1321,500,2000,500),
        (10,2,8170,10,8,3),
        (11,3,1651,320,200,20),
        (12,3,1722,123,800,99),
        (13,3,1658,154,500,40),
        (14,3,1321,1200,2000,500),
        (15,3,8170,5,8,3),
        (16,4,1651,152,200,20),
        (17,4,1722,785,800,99),
        (18,4,1658,124,500,40),
        (19,4,1321,600,2000,500),
        (20,4,8170,3,8,3),
        (21,5,1651,154,200,20),
        (22,5,1722,200,800,99),
        (23,5,1658,40,500,40),
        (24,5,1321,530,2000,500),
        (25,5,8170,4,8,3);
    
CREATE TABLE promociones (
    id_promociones INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    causa_promocion VARCHAR(25) NOT NULL,
    desc_promocion INT(5) NOT NULL,
    precio_descuento FLOAT NOT NULL,
    unidad_medida INT(15) NOT NULL);
    
    insert into promociones values 
        (1,"producto con danios",30,73.5,"pza"),
        (2,"producto menos vendido",15,425,"pza");
    
CREATE TABLE promocion_prod (
    id_promocion_d INT(15) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    codigo_producto VARCHAR(10) NOT NULL,
    id_promociones INT(15) NOT NULL,
    FOREIGN KEY (codigo_producto) REFERENCES productos (codigo_producto),
    FOREIGN KEY (id_promociones) REFERENCES promociones (id_promociones));
    
    insert into promocion_prod values 
        (1,1651,1),
        (2,8170,2);

CREATE TABLE empleados_compras (
    RFC_empl_comp CHAR(13) NOT NULL PRIMARY KEY,
    nombre_empl_comp VARCHAR(25) NOT NULL,
    ap_pat_comp VARCHAR(25) NOT NULL,
    ap_mat_comp VARCHAR(25) NOT NULL,
    sexo_comp VARCHAR(7) NOT NULL,
    estado_civil_comp VARCHAR(15) NOT NULL,
    telefono_comp Varchar(12) NOT NULL,
    correo_comp VARCHAR(30) NOT NULL,
    usuario_comp VARCHAR(25) NOT NULL,
    passwd_comp VARCHAR(25) NOT NULL,
    fecha_ingreso_comp timestamp NOT NULL);
    
    insert into empleados_compras values 
        ("BAFJ701213SB1","Juan","Barrios","Fernández","hombre","casado",5557542100,"juan@email.com","barrios69",1234,2018-01-01),
        ("MAHM670102N01","Manuel","Martinez","Hernández","hombre","divorciado",5547896332,"manu@outlook.com","manu15",1234,2018-05-03),
        ("RASL75112LM50","Maria Luisa","Ramirez","Sanchez","mujer","soltero",7755896412,"luisa12@hotmail.com","mariaR",1234,2018-02-02),
        ("ADD7808121G80","Dolores","San Martín","Davilos","mujer","soltero",7751200145,"dolores@hotmail.com","doloresMart",1234,2018-03-15),
        ("CALF750228LK7","Felipe","Camargo","Lozano","hombre","soltero",7756632114,"felipelozano@gmail.com","FelipeC",1234,2018-08-12);


CREATE TABLE proveedores (
    id_proveedor INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_prov VARCHAR(100) NOT NULL,
    ap_pat_prov VARCHAR(100) NOT NULL,
    ap_mat_prov VARCHAR(100) NOT NULL,
    telefono_prov Varchar(12) NOT NULL,
    calle_prov VARCHAR(100) NOT NULL,
    colonia_prov VARCHAR(100) NOT NULL,
    numero_prov INT(15) NOT NULL,
    provincia_prov VARCHAR(25) NOT NULL,
    correo_prov VARCHAR(100) NOT NULL);
    
    insert into proveedores values 
       ( 1,"Diana","gayosso","octaviano",7751247896,"jacarandas","2 de enero",7,"santiago","diana_gayosso@gmail.com"),
       ( 2,"luisa","octaviano","sebastian",7754120314,"girasoles","las rosas",502,"tulancingo","luisa245@hotmail.com"),
       ( 3,"Jose luis","octaviano","sebastian",7754012377,"nicolas bravo","5 de mayo",20,"cuautepec","jose_luis142@gmail.com"),
       ( 4,"Mario","nieto","lopez",7754100256,"tlalpan","rio balsas",536,"mexico","mario142@hotmail.com"),
       ( 5,"Diego","bolaños","pardo",7757583652,"tepeapulco","lindavista",358,"sagun","diegopardo24@gmail.com");

CREATE TABLE compra (
    id_compra INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT(5) NOT NULL,
    fecha_compra timestamp NOT NULL,
    importe_comp FLOAT NOT NULL,
    iva_comp FLOAT NOT NULL,
    subtotal_comp FLOAT NOT NULL,
    RFC_empleado_comp VARCHAR(25) NOT NULL,
    no_sucursal INT(5) NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES proveedores (id_proveedor),
    FOREIGN KEY ( RFC_empleado_comp) REFERENCES empleados_compras (RFC_empl_comp));
    
    insert into compra values 
        (1,2,2018-05-12,5070,316.88,5386.88,"BAFJ701213SB1",1),
        (2,1,2018-03-23,4475,279.69,4754.69,"MAHM670102N01",2),
        (3,3,2018-11-01,1440,90.00,1530.00,"RASL75112LM50",3),
        (4,5,2018-07-20,3800,237.50,4037.50,"ADD7808121G80",3),
        (5,4,2018-10-20,10825,676.56,11501.56,"CALF750228LK7",4);

CREATE TABLE detalle_compra(
    id_detalle_compra int(5) not null AUTO_INCREMENT primary key,
    id_compra INT(5) NOT NULL,
    codigo_producto_comp varchar(13) not null,
    cantidad_comp int(25) not null,
    precio_comp float not null,
    total_producto_comp float not null,
    FOREIGN KEY(id_compra) REFERENCES compra (id_compra),
    FOREIGN KEY(codigo_producto_comp) REFERENCES productos (codigo_producto));
    
    insert into detalle_compra values
        (1,1,1651,20,63.5,1270),
        (2,1,1722,20,15,300),
        (3,2,1658,10,380,3800),
        (4,2,1321,15,45,675),
        (5,3,8170,2,450,900),
        (6,3,1321,12,45,540),
        (7,4,1658,10,380,3800),
        (8,5,1651,100,63.5,6350),
        (9,5,1658,10,380,3800),
        (10,5,1321,15,45,675);

CREATE TABLE empleados_ventas (
    RFC_empl_vent CHAR(13) NOT NULL PRIMARY KEY,
    nombre_empl_vent VARCHAR(25) NOT NULL,
    ap_pat_vent VARCHAR(25) NOT NULL,
    ap_mat_vent VARCHAR(25) NOT NULL,
    sexo_vent VARCHAR(7) NOT NULL,
    estado_civil_vent VARCHAR(15) NOT NULL,
    telefono_vent Varchar(12) NOT NULL,
    correo_vent VARCHAR(30) NOT NULL,
    usuario_vent VARCHAR(25) NOT NULL,
    passwd_vent VARCHAR(100) NOT NULL,
    fecha_ingreso_vent timestamp NOT NULL);

    insert into empleados_ventas values 
        ("CAGC800503021","Cinthia","Cazarez","Garcia","mujer","soltero",5575285866,"cintia@gmail.com","cinita_garcia",1234,2018-02-05),
        ("TCHM830304102","Maria","Torres","Hernández","mujer","soltero",7538907451,"mari@email.com","Maria_torres",1234,2018-03-15),
        ("CAJJ790305145","Javier","Carrasco","Jimenez","hombre","soltero",7757536987,"javier@outlook.com","Javier_carraso",1234,2018-05-04),
        ("RIM8840305102","Benito","Rivera","Martinez","hombre","casado",7757589641,"benitoR@hotmail.com","Beniro_rivera",1234,2018-03-20),
        ("PIPL850306120","Lilia","Prieto","Perez","mujer","casado",7757541230,"lilia@hootmail.com","Lilia_prieto",1234,2018-01-01);

CREATE TABLE clientes (
    RFC_cliente CHAR(13) NOT NULL PRIMARY KEY,
    nombre_client VARCHAR(25) NOT NULL,
    ap_pat_client VARCHAR(25) NOT NULL,
    ap_mat_client VARCHAR(25) NOT NULL,
    telefono_client VARCHAR(12) NOT NULL,
    municipio_client  VARCHAR(50) NOT NULL,
    calle_client VARCHAR(50) NOT NULL,
    colonia_client VARCHAR(50) NOT NULL,
    numero_client VARCHAR(5) NOT NULL,
    correo_client VARCHAR(50) NOT NULL,
    puntos INT NULL);
    
    insert into clientes values 
        ("CLIENTEGENERA","cliente_general","desconocido","desconocido","desconocido","desconocido","desconocido","desconocido","desconocido","desconocido",0),
        ("HEOI231DFR456","Ivan","Hernandez","Osornio",7757538907,"Tulancingo","rio balsas","Francisco villa",5,"ivan.herdez@outlook.com",50),
        ("GAOA123EDFR4","Angeles","Gayosso","Octaviano",5575285877,"Tulancingo","gomez palacio","Francisco i madero",307,"annggii199@gmail.com",200),
        ("DIRA123DFR56T","Amairani","Diaz","Ramirez",7757583454,"Tulancingo","lucerna","pajaritos",15,"171711615@utectulancingo.edu.mx",100),
        ("HERA123DFR456","Alexis","Hernandez","Ramirez",7752145689,"Tulancingo","guadalupe","guadalupe",10,"alex@email.com",50);
    
CREATE TABLE descuentos (
    codigo_descuento INT(5) NOT NULL PRIMARY KEY,
    porcentaje INT(5) NOT NULL,
    cantidad_puntos INT(15) NOT NULL);
    
    insert into descuentos values 
        (1,0,0),
        (2,5,50),
        (3,10,100),
        (4,15,200);
    
CREATE TABLE ventas(
    id_ventas int(15) not null AUTO_INCREMENT primary key,
    RFC_cliente char(13) not null,
    fecha_venta timestamp not null,
    subtotal_venta float not null,
    iva float not null,
    importe_vent float not null,
    num_factura int (159) not null,
    RFC_empleado varchar(25) not null,
    forma_pago varchar(15) not null,
    no_sucursal int(5) not null,
    codigo_descuento int(5) not null,
    puntos_ganados int(15) not null,
    FOREIGN KEY(RFC_empleado) REFERENCES empleados_ventas (RFC_empl_vent),
    FOREIGN KEY(codigo_descuento ) REFERENCES descuentos (codigo_descuento));
    
    insert into ventas values 
    (1,"CLIENTEGENERA",2018-02-10,152.47,8.96875,143.50,"null","CAGC800503021","efectivo",1,1,0),
    (2,"HEOI231DFR456",2018-05-04,63.75,3.75,60.00,1,"TCHM830304102","efectivo",2,2,10),
    (3,"GAOA123EDFR4",2018-05-15,451.56,26.5625,425.00,2,"CAJJ790305145","efectivo",4,2,10),
    (4,"DIRA123DFR56T",2018-06-01,2298.19,135.1875,2163.00,3,"RIM8840305102","efectivo",5,3,10),
    (5,"HERA123DFR456",2018-07-10,79.69,4.6875,75.00,4,"PIPL850306120","efectivo",3,4,10);

CREATE TABLE detalle_ventas (
    Id_detalle_venta INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_ventas INT(15) NOT NULL,
    codigo_producto VARCHAR(10) NOT NULL,
    cantidad INT(15) NOT NULL,
    precio_venta FLOAT NOT NULL,
    total_producto FLOAT NOT NULL,
    FOREIGN KEY (Codigo_producto) REFERENCES productos (codigo_producto));
    
    insert into detalle_ventas values 
        (1,1,1651,1,73.5,73.5),
        (2,1,1722,1,20,20),
        (3,1,1321,1,50,50),
        (4,2,1722,3,20,60),
        (5,3,8170,1,425,425),
        (6,4,1658,2,309,618),
        (7,4,1658,5,309,1545),
        (8,5,1722,5,15,75);

