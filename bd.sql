CREATE database Hospitales;

CREATE TABLE Hospitales (
    idHospital int NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    direccion  varchar(255),
    telefono varchar(50),
    PRIMARY KEY (idHospital)
);

ALTER TABLE Hospitales MODIFY COLUMN telefono VARCHAR(120);

DROP TABLE Hospitales;


INSERT INTO Hospitales VALUES (null, 'Santa fe', 'Raul Perez 640 A', '4492205398');


DELETE FROM Hospitales where idHospital in (6,7,8);


CREATE TABLE Enfermos (
	idEnfermo int not null AUTO_INCREMENT,
    nombre varchar(45),
    fechaNacimiento DATE,
    sexo CHAR(1),
    direccion VARCHAR(45),
    localidad VARCHAR(45),
    provincia VARCHAR (45),
    pais VARCHAR(45),
    codigoPostal varchar(5),
    primary key (idEnfermo)
);

ALTER TABLE Enfermos MODIFY COLUMN codigoPostal VARCHAR(120);

SELECT * FROM Enfermos;

DELETE FROM Enfermos WHERE idEnfermo between 1 and 10;

INSERT INTO `Hospitales`.`Enfermos`(`idEnfermo`,`nombre`,`fechaNacimiento`,`sexo`,`direccion`,`localidad`,`provincia`,`pais`,`codigoPostal`) VALUES (null, 'Oscar', STR_TO_DATE("4 March, 2018", '%d %M, %Y'), 'M', 'Felipe de Ureña 530A', 'Ags', 'Ags', 'Mexico', '20126');

SELECT DATE_FORMAT("4 March, 2018");

SELECT DATE_FORMAT("2017-06-15", "%M %d %Y");

SELECT  STR_TO_DATE("4 March, 2018", '%d %M, %Y');

SELECT  STR_TO_DATE("4-03-2018", '%d-%m-%Y');

CREATE TABLE Especialidades (
	idEspecialidad int not null AUTO_INCREMENT,
    nombre varchar(45),
    PRIMARY KEY(idEspecialidad)
);

SELECT * FROM Especialidades where idEspecialidad = "  Cardiologo ";
INSERT INTO Especialidades VALUES(null, 'Nutriologo');

SELECT idEspecialidad FROM Especialidades WHERE nombre = "Nutriologo";



CREATE TABLE Doctores (
	idDoctor int not null AUTO_INCREMENT,
    nombre varchar(45),
	salario decimal(8,2),
    idEspecialidad int,
    idHospital int,
    PRIMARY KEY (idDoctor),
    FOREIGN KEY (idHospital) REFERENCES Hospitales(idHospital),
    FOREIGN KEY (idEspecialidad) REFERENCES Especialidades(idEspecialidad)
);

SELECT * FROM Doctores;
SELECT * FROM  Doctores WHERE idHospital = 10;

DELETE FROM Doctores WHERE idDoctor = 1;

INSERT INTO Doctores VALUES (null, 'Oscar Martínez', 8600.50, 2,10);


CREATE TABLE Ingresos (
    idIngresos int not null AUTO_INCREMENT,
    idHospital int,
    idEnfermo int,
    fecha datetime,
    causas varchar(45),
    habitacion int(3),
    PRIMARY KEY (idIngresos),
    FOREIGN KEY (idHospital) REFERENCES Hospitales(idHospital),
    FOREIGN KEY (idEnfermo) REFERENCES Enfermos(idEnfermo)
);



SELECT * FROM  Hospitales;
SELECT * FROM Enfermos;

INSERT INTO Ingresos VALUES(null,10, 9, STR_TO_DATE("4 March, 2018",'%d %M, %Y'), 'Le duele la espalda', 503 );

SELECT * FROM Ingresos where idHospital = 10;

CREATE TABLE Atencion (
	idAtencion int not null AUTO_INCREMENT,javaweb_crudl,ñ
    idDoctor int,
    idIngresos int,
    comentarios varchar(45),
    fecha datetime,
    PRIMARY KEY (idAtencion),
    FOREIGN KEY (idDoctor) REFERENCES Doctores(idDoctor),
    FOREIGN KEY (idIngresos) REFERENCES Ingresos(idIngresos)
);

SELECT * FROM Atencion;