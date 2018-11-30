-- -----------------------------------------------------
-- Table `cursosCCM`.`tematicas`
-- -----------------------------------------------------
INSERT INTO `cursosCCM`.`tematicas` (`id_tematicas`, `tematica`) VALUES (1, 'Literatura');
INSERT INTO `cursosCCM`.`tematicas` (`id_tematicas`, `tematica`) VALUES (2, 'Manualidades');
INSERT INTO `cursosCCM`.`tematicas` (`id_tematicas`, `tematica`) VALUES (3, 'Cocina');
INSERT INTO `cursosCCM`.`tematicas` (`id_tematicas`, `tematica`) VALUES (4, 'Dibujo');
INSERT INTO `cursosCCM`.`tematicas` (`id_tematicas`, `tematica`) VALUES (5, 'Música');

-- -----------------------------------------------------
-- Table `cursosCCM`.`cursos`
-- -----------------------------------------------------
INSERT INTO `cursosCCM`.`cursos` (`id_cursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `carga_horaria`, `cupo`, `tematica`) 
VALUES (1, 'Literatura Moderna', 'Haruki Murakami', 23, '2 meses', '6 hs/semana', 10, 1);
INSERT INTO `cursosCCM`.`cursos` (`id_cursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `carga_horaria`, `cupo`, `tematica`) 
VALUES (2, 'Taller Literario', 'Paul Auster', 1, '6 meses', '2 hs/semana', 2, 1);
INSERT INTO `cursosCCM`.`cursos` (`id_cursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `carga_horaria`, `cupo`, `tematica`) 
VALUES (3, 'Guitarra para Principiantes', 'Iván Fischer', 9, '8 meses', '2 hs/semana', 5, 5);
INSERT INTO `cursosCCM`.`cursos` (`id_cursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `carga_horaria`, `cupo`, `tematica`) 
VALUES (4, 'Acompañamiento Folclorico', 'Iván Fischer', 10, '4 meses', '1 hs/semana', 10, 5);
INSERT INTO `cursosCCM`.`cursos` (`id_cursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `carga_Horaria`, `cupo`, `tematica`) 
VALUES (5, 'Dibujo de caricaturas', 'Gustavo Luna', 2, '5 meses', '3 hs/semana', 15, 4);
INSERT INTO `cursosCCM`.`cursos` (`id_cursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `carga_horaria`, `cupo`, `tematica`) 
VALUES (6, 'Decoupage', 'Leticia Martinez', 7, '3 meses', '2 hs/semana', 10, 2);
INSERT INTO `cursosCCM`.`cursos` (`id_cursos`, `nombre`, `profesor`, `aula`, 
`duracion`, `carga_horaria`, `cupo`, `tematica`) 
VALUES (7, 'Masas básicas', 'Osvaldo Gross', 14, '7 meses', '3 hs/semana', 7, 3);

-- -----------------------------------------------------
-- Table `cursosCCM`.`participantes`
-- -----------------------------------------------------
INSERT INTO `cursosCCM`.`participantes` (`id_participante`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fecha_nacimiento`, `nombre_tutor`) 
VALUES (1, 'Figueroa', 'Osvaldo', 'los alamos 173', '422300', 'osvaldofigueroa89@gmail.com', '1998-7-24', '');
INSERT INTO `cursosCCM`.`participantes` (`id_participante`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fecha_nacimiento`, `nombre_tutor`) 
VALUES (2, 'Figueroa', 'Susana', 'los alamos 173', '422300', 'susifigueroa1238@gmail.com', '2000-3-15', '');
INSERT INTO `cursosCCM`.`participantes` (`id_participante`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fecha_nacimiento`, `nombre_tutor`) 
VALUES (3, 'Ramos', 'Juan Carlos', 'rio dulce 400', '423450', 'juancarlosramos23@gmail.com', '1980-8-23', '');
INSERT INTO `cursosCCM`.`participantes` (`id_participante`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fecha_nacimiento`, `nombre_tutor`) 
VALUES (4, 'Ramos', 'Martin', 'rio dulce 400', '423450', 'martinchoramos53@hotmail.com', '2005-2-18', 
'Ramos JuanCarlos');
INSERT INTO `cursosCCM`.`participantes` (`id_participante`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fecha_nacimiento`, `nombre_tutor`) 
VALUES (5, 'Ramos', 'Valeria', 'rio dulce 400', '423450', 'valeramos28@hotmail.com', '2005-2-18', 
'Ramos JuanCarlos');
INSERT INTO `cursosCCM`.`participantes` (`id_participante`, `apellido`, `nombre`, `direccion`,  
`telefono`, `email`, `fecha_nacimiento`) 
VALUES (6, 'Perez', 'Juan', 'los andes 256', '423789', 'juanperez@gmail.com', '1980-10-17');

-- -----------------------------------------------------
-- Table `cursosCCM`.`inscripcion`
-- -----------------------------------------------------
INSERT INTO `cursosCCM`.`inscripcion` (`id_inscripcion`, `curso`, `participante`, `estado_inscripcion`, `fecha_hora`) 
VALUES (1, 3, 1, 1, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`id_inscripcion`, `curso`, `participante`, `estado_inscripcion`, `fecha_hora`) 
VALUES (2, 2, 1, 1, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`id_inscripcion`, `curso`, `participante`, `estado_inscripcion`, `fecha_hora`) 
VALUES (3, 5, 1, 1, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`id_inscripcion`, `curso`, `participante`, `estado_inscripcion`, `fecha_hora`) 
VALUES (4, 2, 2, 1, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`id_inscripcion`, `curso`, `participante`, `estado_inscripcion`, `fecha_hora`) 
VALUES (5, 2, 4, 2, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`id_inscripcion`, `curso`, `participante`, `estado_inscripcion`, `fecha_hora`) 
VALUES (6, 5, 4, 1, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`id_inscripcion`, `curso`, `participante`, `estado_inscripcion`, `fecha_hora`) 
VALUES (7, 3, 4, 1, '2018-10-20 8:30:00');
INSERT INTO `cursosCCM`.`inscripcion` (`id_inscripcion`, `curso`, `participante`, `estado_inscripcion`, `fecha_hora`) 
VALUES (8, 7, 5, 1, '2018-10-20 8:30:00');





