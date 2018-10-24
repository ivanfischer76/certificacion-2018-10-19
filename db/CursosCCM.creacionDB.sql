/* 
 * Script SQL de cración de la base de datos cursosCCM
 */
/**
 * Author:  ivan
 * Created: 24/10/2018
 */

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `cursosCCM` DEFAULT CHARACTER SET latin1 ;
USE `cursosCCM` ;

-- -----------------------------------------------------
-- Table `cursosCCM`.`participantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`participantes` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`participantes` (
  `idparticipantes` INT NOT NULL ,
  `apellido` VARCHAR(50) NOT NULL ,
  `nombre` VARCHAR(50) NOT NULL ,
  `direccion` VARCHAR(100) NOT NULL ,
  `telefono` VARCHAR(15) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `fechaNac` DATE NOT NULL ,
  `nombreTutor` VARCHAR(100) NULL ,
  PRIMARY KEY (`idparticipantes`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cursosCCM`.`tematicas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`tematicas` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`tematicas` (
  `idtematicas` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `tematica` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`idtematicas`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cursosCCM`.`cursos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`cursos` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`cursos` (
  `idcursos` INT NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `profesor` VARCHAR(70) NOT NULL ,
  `aula` INT NOT NULL ,
  `duracion` VARCHAR(45) NOT NULL ,
  `cargaHoraria` VARCHAR(45) NOT NULL ,
  `cupo` INT NOT NULL ,
  `tematica` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`idcursos`) ,
  INDEX `fk_cursos_tematicas` (`tematica` ASC) ,
  CONSTRAINT `fk_cursos_tematicas`
    FOREIGN KEY (`tematica` )
    REFERENCES `cursosCCM`.`tematicas` (`idtematicas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cursosCCM`.`inscripcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cursosCCM`.`inscripcion` ;

CREATE  TABLE IF NOT EXISTS `cursosCCM`.`inscripcion` (
  `idinscripcion` INT NOT NULL ,
  `curso` INT NOT NULL ,
  `participante` INT NOT NULL ,
  `condicional` INT NOT NULL ,
  `fechahora` DATETIME NOT NULL ,
  PRIMARY KEY (`idinscripcion`) ,
  INDEX `fk_inscripcion_cursos` (`curso` ASC) ,
  INDEX `fk_inscripcion_participantes` (`participante` ASC) ,
  CONSTRAINT `fk_inscripcion_cursos`
    FOREIGN KEY (`curso` )
    REFERENCES `cursosCCM`.`cursos` (`idcursos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_inscripcion_participantes`
    FOREIGN KEY (`participante` )
    REFERENCES `cursosCCM`.`participantes` (`idparticipantes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;