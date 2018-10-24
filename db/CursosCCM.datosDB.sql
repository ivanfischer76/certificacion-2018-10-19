/* 
 * Script SQL de llenado de datos de prueba de la base de datos
 * cursosCCM
 */
/**
 * Author:  ivan
 * Created: 24/10/2018
 */

-- -----------------------------------------------------
-- Table `cursosCCM`.`tematicas`
-- -----------------------------------------------------
INSERT INTO `cursosCCM`.`tematicas` (`tematica`) VALUES ('Literatura');
INSERT INTO `cursosCCM`.`tematicas` (`tematica`) VALUES ('Manualidades');
INSERT INTO `cursosCCM`.`tematicas` (`tematica`) VALUES ('Cocina');
INSERT INTO `cursosCCM`.`tematicas` (`tematica`) VALUES ('Dibujo');
INSERT INTO `cursosCCM`.`tematicas` (`tematica`) VALUES ('Música');

-- -----------------------------------------------------
-- Table `cursosCCM`.`cursos`
-- -----------------------------------------------------
INSERT INTO `cursosCCM`.`cursos` (`idcursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `cargaHoraria`, `cupo`, `tematica`) 
VALUES (1, 'Literatura Moderna', 'Haruki Murakami', 23, '2 meses', '6 hs/semana', 10, 1);
INSERT INTO `cursosCCM`.`cursos` (`idcursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `cargaHoraria`, `cupo`, `tematica`) 
VALUES (2, 'Taller Literario', 'Paul Auster', 1, '6 meses', '2 hs/semana', 2, 1);
INSERT INTO `cursosCCM`.`cursos` (`idcursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `cargaHoraria`, `cupo`, `tematica`) 
VALUES (3, 'Guitarra para Principiantes', 'Iván Fischer', 9, '8 meses', '2 hs/semana', 5, 5);
INSERT INTO `cursosCCM`.`cursos` (`idcursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `cargaHoraria`, `cupo`, `tematica`) 
VALUES (4, 'Acompañamiento Folclorico', 'Iván Fischer', 10, '4 meses', '1 hs/semana', 10, 5);
INSERT INTO `cursosCCM`.`cursos` (`idcursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `cargaHoraria`, `cupo`, `tematica`) 
VALUES (5, 'Dibujo de caricaturas', 'Gustavo Luna', 2, '5 meses', '3 hs/semana', 15, 4);
INSERT INTO `cursosCCM`.`cursos` (`idcursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `cargaHoraria`, `cupo`, `tematica`) 
VALUES (6, 'Decoupage', 'Leticia Martinez', 7, '3 meses', '2 hs/semana', 10, 2);
INSERT INTO `cursosCCM`.`cursos` (`idcursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `cargaHoraria`, `cupo`, `tematica`) 
VALUES (7, 'Masas básicas', 'Osvaldo Gross', 14, '7 meses', '3 hs/semana', 7, 3);

-- -----------------------------------------------------
-- Table `cursosCCM`.`participantes`
-- -----------------------------------------------------
INSERT INTO `cursosCCM`.`participantes` (`idparticipantes`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fechaNac`, `nombreTutor`) 
VALUES (1, 'Figueroa', 'Osvaldo', 'los alamos 173', '422300', 'osvaldofigueroa89@gmail.com', '1998-7-24', '');
INSERT INTO `cursosCCM`.`participantes` (`idparticipantes`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fechaNac`, `nombreTutor`) 
VALUES (2, 'Figueroa', 'Susana', 'los alamos 173', '422300', 'susifigueroa1238@gmail.com', '2000-3-15', '');
INSERT INTO `cursosCCM`.`participantes` (`idparticipantes`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fechaNac`, `nombreTutor`) 
VALUES (3, 'Ramos', 'Juan Carlos', 'rio dulce 400', '423450', 'juancarlosramos23@gmail.com', '1980-8-23', '');
INSERT INTO `cursosCCM`.`participantes` (`idparticipantes`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fechaNac`, `nombreTutor`) 
VALUES (4, 'Ramos', 'Martin', 'rio dulce 400', '423450', 'martinchoramos53@hotmail.com', '2005-2-18', 
'Ramos JuanCarlos');
INSERT INTO `cursosCCM`.`participantes` (`idparticipantes`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fechaNac`, `nombreTutor`) 
VALUES (5, 'Ramos', 'Valeria', 'rio dulce 400', '423450', 'valeramos28@hotmail.com', '2005-2-18', 
'Ramos JuanCarlos');
INSERT INTO `cursosCCM`.`participantes` (`idparticipantes`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fechaNac`) 
VALUES (6, 'Perez', 'Juan', 'los andes 256', '423789', 'juanperez@gmail.com', '1980-10-17');

-- -----------------------------------------------------
-- Table `cursosCCM`.`inscripcion`
-- -----------------------------------------------------
INSERT INTO `cursosCCM`.`inscripcion` (`idinscripcion`, `curso`, `participante`, `condicional`, `fechahora`) 
VALUES (1, 3, 1, false, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`idinscripcion`, `curso`, `participante`, `condicional`, `fechahora`) 
VALUES (2, 2, 1, false, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`idinscripcion`, `curso`, `participante`, `condicional`, `fechahora`) 
VALUES (3, 5, 1, false, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`idinscripcion`, `curso`, `participante`, `condicional`, `fechahora`) 
VALUES (4, 2, 2, false, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`idinscripcion`, `curso`, `participante`, `condicional`, `fechahora`) 
VALUES (5, 2, 4, true, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`idinscripcion`, `curso`, `participante`, `condicional`, `fechahora`) 
VALUES (6, 5, 4, false, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`idinscripcion`, `curso`, `participante`, `condicional`, `fechahora`) 
VALUES (7, 3, 4, false, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`idinscripcion`, `curso`, `participante`, `condicional`, `fechahora`) 
VALUES (8, 7, 5, false, '2018-10-20 8:30:00');