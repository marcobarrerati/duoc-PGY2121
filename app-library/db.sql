create databse app_db;
use app_db;

CREATE TABLE `appdb_libro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `editorial` varchar(45) DEFAULT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `fecha_de_ingreso` date NOT NULL,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `appdb_libro_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `editorial` varchar(45) DEFAULT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `fecha_de_ingreso` date NOT NULL,
  `idold` int DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;



CREATE TRIGGER `add_book` AFTER INSERT ON `appdb_libro` FOR EACH ROW insert into appdb_libro_history (nombre,editorial,autor,cantidad,fecha_de_ingreso,idold, estado) values(new.nombre,new.editorial,new.autor,new.cantidad,new.fecha_de_ingreso, new.id,"registrado");

CREATE TRIGGER `update_book` AFTER UPDATE ON `appdb_libro` FOR EACH ROW insert into appdb_libro_history (nombre,editorial,autor,cantidad,fecha_de_ingreso,idold, estado) values(old.nombre,old.editorial,old.autor,old.cantidad,old.fecha_de_ingreso, old.id,"actualizado");

CREATE TRIGGER `delete_book` AFTER DELETE ON `appdb_libro` FOR EACH ROW insert into appdb_libro_history (nombre,editorial,autor,cantidad,fecha_de_ingreso,idold, estado) values(old.nombre,old.editorial,old.autor,old.cantidad,old.fecha_de_ingreso, old.id,"eliminado");


