SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `cursosCCM` ;
CREATE SCHEMA IF NOT EXISTS `cursosCCM` DEFAULT CHARACTER SET latin1 ;
USE `cursosCCM` ;

-- -----------------------------------------------------
-- Table `cursosCCM`.`participantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`participantes` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`participantes` (
  `id_participante` INT UNSIGNED NOT NULL ,
  `apellido` VARCHAR(50) NOT NULL ,
  `nombre` VARCHAR(50) NOT NULL ,
  `direccion` VARCHAR(100) NOT NULL ,
  `telefono` VARCHAR(15) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `fecha_nacimiento` DATE NOT NULL ,
  `nombre_tutor` VARCHAR(100) NULL ,
  PRIMARY KEY (`id_participante`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cursosCCM`.`tematicas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`tematicas` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`tematicas` (
  `id_tematicas` INT UNSIGNED NOT NULL ,
  `tematica` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id_tematicas`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cursosCCM`.`cursos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`cursos` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`cursos` (
  `id_cursos` INT UNSIGNED NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `profesor` VARCHAR(70) NOT NULL ,
  `aula` INT NOT NULL ,
  `duracion` VARCHAR(45) NOT NULL ,
  `carga_horaria` VARCHAR(45) NOT NULL ,
  `cupo` INT NOT NULL ,
  `tematica` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id_cursos`) ,
  INDEX `fk_cursos_tematicas` (`tematica` ASC) ,
  CONSTRAINT `fk_cursos_tematicas`
    FOREIGN KEY (`tematica` )
    REFERENCES `cursosCCM`.`tematicas` (`id_tematicas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cursosCCM`.`estadoInscripcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`estadoInscripcion` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`estadoInscripcion` (
  `id_estado_inscripcion` INT UNSIGNED NOT NULL ,
  `estado` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_estado_inscripcion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cursosCCM`.`inscripcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`inscripcion` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`inscripcion` (
  `id_inscripcion` INT UNSIGNED NOT NULL ,
  `curso` INT UNSIGNED NOT NULL ,
  `participante` INT UNSIGNED NOT NULL ,
  `estado_inscripcion` INT UNSIGNED NOT NULL ,
  `fecha_hora` DATETIME NOT NULL ,
  PRIMARY KEY (`id_inscripcion`) ,
  INDEX `fk_inscripcion_cursos` (`curso` ASC) ,
  INDEX `fk_inscripcion_participantes` (`participante` ASC) ,
  INDEX `fk_inscripcion_estadoInscripcion` (`estado_inscripcion` ASC) ,
  CONSTRAINT `fk_inscripcion_cursos`
    FOREIGN KEY (`curso` )
    REFERENCES `cursosCCM`.`cursos` (`id_cursos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripcion_participantes`
    FOREIGN KEY (`participante` )
    REFERENCES `cursosCCM`.`participantes` (`id_participante` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripcion_estadoInscripcion`
    FOREIGN KEY (`estado_inscripcion` )
    REFERENCES `cursosCCM`.`estadoInscripcion` (`id_estado_inscripcion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `cursosCCM`.`estadoInscripcion`
-- -----------------------------------------------------
START TRANSACTION;
USE `cursosCCM`;
INSERT INTO `cursosCCM`.`estadoInscripcion` (`id_estado_inscripcion`, `estado`) VALUES (1, 'Inscripto');
INSERT INTO `cursosCCM`.`estadoInscripcion` (`id_estado_inscripcion`, `estado`) VALUES (2, 'Condicional');
INSERT INTO `cursosCCM`.`estadoInscripcion` (`id_estado_inscripcion`, `estado`) VALUES (3, 'No Inscripto');

COMMIT;
