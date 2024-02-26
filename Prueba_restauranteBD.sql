drop database if exists Prueba_Restaurante;
create database Prueba_Restaurante;
use Prueba_Restaurante;

create table MESAS(
	ID INT(19) AUTO_INCREMENT,
    CAPACIDAD INT(19),
    PRIMARY KEY(ID)
);

INSERT INTO MESAS (CAPACIDAD) VALUES (4);
INSERT INTO MESAS (CAPACIDAD) VALUES (4);
INSERT INTO MESAS (CAPACIDAD) VALUES (5);
INSERT INTO MESAS (CAPACIDAD) VALUES (6);
INSERT INTO MESAS (CAPACIDAD) VALUES (6);
INSERT INTO MESAS (CAPACIDAD) VALUES (4);
INSERT INTO MESAS (CAPACIDAD) VALUES (4);
INSERT INTO MESAS (CAPACIDAD) VALUES (5);

create table RESERVACIONES(
	ID INT(19) AUTO_INCREMENT,
    PERSONA VARCHAR(50),
    DUI_PERSONA VARCHAR(12),
    FECHA_RESERVACION DATETIME,
    FECHA_RESERVA DATE,
    HORA_RESERVA VARCHAR(12),
    NUM_PERSONAS INT(19),
    ACTIVA BOOLEAN,
    PRIMARY KEY(ID)
);
create table RESERVACIONES_MESAS(
	ID INT(19) AUTO_INCREMENT,
    RESERVACION_ID INT(19),
    MESA_ID INT(19),
    PRIMARY KEY(ID),
    FOREIGN KEY (RESERVACION_ID) REFERENCES RESERVACIONES (ID),
    FOREIGN KEY (MESA_ID) REFERENCES MESAS (ID)
);



