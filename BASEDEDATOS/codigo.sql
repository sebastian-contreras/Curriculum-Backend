-- MySQL Script generated by MySQL Workbench
-- mié 11 oct 2023 11:53:37
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`USERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`USERS` (
  `idUSERS` INT NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `fullName` VARCHAR(45) NULL,
  `aboutMe` TEXT(400) NULL,
  `shortEducation` VARCHAR(45) NULL,
  `image` VARCHAR(255) NULL,
  `portraitImage` VARCHAR(255) NULL,
  PRIMARY KEY (`idUSERS`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EXPERIENCIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EXPERIENCIA` (
  `idEXPERIENCIA` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `place` VARCHAR(45) NULL,
  `date` VARCHAR(45) NULL,
  `image` VARCHAR(255) NULL,
  `USERS_idUSERS` INT NOT NULL,
  PRIMARY KEY (`idEXPERIENCIA`, `USERS_idUSERS`),
  INDEX `fk_EXPERIENCIA_USERS1_idx` (`USERS_idUSERS` ASC) VISIBLE,
  CONSTRAINT `fk_EXPERIENCIA_USERS1`
    FOREIGN KEY (`USERS_idUSERS`)
    REFERENCES `mydb`.`USERS` (`idUSERS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EDUCACION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EDUCACION` (
  `idEDUCACION` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `place` VARCHAR(45) NULL,
  `date` VARCHAR(45) NULL,
  `image` VARCHAR(255) NULL,
  `USERS_idUSERS` INT NOT NULL,
  PRIMARY KEY (`idEDUCACION`, `USERS_idUSERS`),
  INDEX `fk_EDUCACION_USERS1_idx` (`USERS_idUSERS` ASC) VISIBLE,
  CONSTRAINT `fk_EDUCACION_USERS1`
    FOREIGN KEY (`USERS_idUSERS`)
    REFERENCES `mydb`.`USERS` (`idUSERS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SKILLS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SKILLS` (
  `idSKILLS` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `percent` INT NULL,
  `USERS_idUSERS` INT NOT NULL,
  PRIMARY KEY (`idSKILLS`, `USERS_idUSERS`),
  INDEX `fk_SKILLS_USERS1_idx` (`USERS_idUSERS` ASC) VISIBLE,
  CONSTRAINT `fk_SKILLS_USERS1`
    FOREIGN KEY (`USERS_idUSERS`)
    REFERENCES `mydb`.`USERS` (`idUSERS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PROYECTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PROYECTOS` (
  `idPROYECTOS` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `text` TEXT(300) NULL,
  `url` VARCHAR(200) NULL,
  `USERS_idUSERS` INT NOT NULL,
  PRIMARY KEY (`idPROYECTOS`, `USERS_idUSERS`),
  INDEX `fk_PROYECTOS_USERS_idx` (`USERS_idUSERS` ASC) VISIBLE,
  CONSTRAINT `fk_PROYECTOS_USERS`
    FOREIGN KEY (`USERS_idUSERS`)
    REFERENCES `mydb`.`USERS` (`idUSERS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DOMICILIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DOMICILIO` (
  `idDOMICILIO` INT NOT NULL,
  `pais` VARCHAR(45) NULL,
  `provincia` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `USERS_idUSERS` INT NOT NULL,
  PRIMARY KEY (`idDOMICILIO`, `USERS_idUSERS`),
  INDEX `fk_DOMICILIO_USERS1_idx` (`USERS_idUSERS` ASC) VISIBLE,
  CONSTRAINT `fk_DOMICILIO_USERS1`
    FOREIGN KEY (`USERS_idUSERS`)
    REFERENCES `mydb`.`USERS` (`idUSERS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
