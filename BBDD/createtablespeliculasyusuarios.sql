SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP DATABASE IF EXISTS `movieflix`;
CREATE DATABASE IF NOT EXISTS `movieflix`;

CREATE SCHEMA IF NOT EXISTS `movieflix` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `movieflix`;

-- -----------------------------------------------------
-- Table `movieflix`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movieflix`.`usuarios` ;

CREATE  TABLE IF NOT EXISTS `movieflix`.`usuarios` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `apellido` VARCHAR(45) NULL ,
   `fechaNacimiento` YEAR(4) NULL ,
  PRIMARY KEY (`idUsuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movieflix`.`peliculas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movieflix`.`peliculas` ;

CREATE  TABLE IF NOT EXISTS `movieflix`.`peliculas` (
  `idPelicula` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `fechaEstreno` YEAR(4) NULL ,
  `categoria` VARCHAR(45) NULL ,
  PRIMARY KEY (`idPelicula`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
