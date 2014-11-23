-- MySQL Script generated by MySQL Workbench
-- 11/23/14 17:31:33
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema odgersberndtson
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema odgersberndtson
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `odgersberndtson` DEFAULT CHARACTER SET utf8 ;
USE `odgersberndtson` ;

-- -----------------------------------------------------
-- Table `odgersberndtson`.`branch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`branch` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`branch` (
  `mainCode` VARCHAR(45) NOT NULL,
  `subCode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`mainCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`company` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`company` (
  `companyName` VARCHAR(45) NOT NULL,
  `mainCode` VARCHAR(45) NOT NULL,
  `companyAddress` VARCHAR(45) NOT NULL,
  `companyPhone` VARCHAR(45) NOT NULL,
  `CEO` VARCHAR(45) NOT NULL,
  `CFO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`companyName`),
  INDEX `mainCode_idx` (`mainCode` ASC),
  CONSTRAINT `mainCode`
    FOREIGN KEY (`mainCode`)
    REFERENCES `odgersberndtson`.`branch` (`mainCode`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`partner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`partner` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`partner` (
  `partnerId` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `job` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`partnerId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`case`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`case` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`case` (
  `CaseName` VARCHAR(45) NOT NULL,
  `companyName` VARCHAR(45) NOT NULL,
  `candidateId` INT(11) NOT NULL,
  `partnerId` INT(11) NOT NULL,
  PRIMARY KEY (`CaseName`),
  INDEX `companyName_idx` (`companyName` ASC),
  INDEX `candidateId_idx` (`candidateId` ASC),
  INDEX `partnerId_idx` (`partnerId` ASC),
  CONSTRAINT `candidateId`
    FOREIGN KEY (`candidateId`)
    REFERENCES `odgersberndtson`.`candidate` (`candidateId`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `companyName`
    FOREIGN KEY (`companyName`)
    REFERENCES `odgersberndtson`.`company` (`companyName`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `partnerId`
    FOREIGN KEY (`partnerId`)
    REFERENCES `odgersberndtson`.`partner` (`partnerId`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`person` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`person` (
  `personId` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `education` VARCHAR(45) NOT NULL,
  `currentJob` VARCHAR(45) NOT NULL,
  `personPhone` VARCHAR(45) NOT NULL,
  `companyMail` VARCHAR(45) NOT NULL,
  `privateMail` VARCHAR(45) NOT NULL,
  `personCell` VARCHAR(45) NOT NULL,
  `note` VARCHAR(100) NOT NULL,
  `birthYear` DATE NOT NULL,
  `salary` INT(11) NOT NULL,
  PRIMARY KEY (`personId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`candidate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`candidate` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`candidate` (
  `candidateId` INT(11) NOT NULL,
  `CaseName` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `personId` INT(11) NOT NULL,
  PRIMARY KEY (`candidateId`),
  INDEX `CaseName_idx` (`CaseName` ASC),
  INDEX `personId_idx` (`personId` ASC),
  CONSTRAINT `CaseName`
    FOREIGN KEY (`CaseName`)
    REFERENCES `odgersberndtson`.`case` (`CaseName`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `personIdCandidate`
    FOREIGN KEY (`personId`)
    REFERENCES `odgersberndtson`.`person` (`personId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`contactperson`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`contactperson` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`contactperson` (
  `contactId` INT(11) NOT NULL,
  `caseName` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `contactPhone` VARCHAR(45) NOT NULL,
  `contactCell` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`contactId`),
  INDEX `caseName_idx` (`caseName` ASC),
  INDEX `caseName1_idx` (`caseName` ASC),
  CONSTRAINT `caseName1`
    FOREIGN KEY (`caseName`)
    REFERENCES `odgersberndtson`.`case` (`CaseName`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`personpjla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`personpjla` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`personpjla` (
  `personId` INT(11) NOT NULL,
  `previousJobs` VARCHAR(45) NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  INDEX `personId_idx` (`personId` ASC),
  CONSTRAINT `personId`
    FOREIGN KEY (`personId`)
    REFERENCES `odgersberndtson`.`person` (`personId`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`researcher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`researcher` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`researcher` (
  `employeeId` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `job` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`employeeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `odgersberndtson`.`researcheroncase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `odgersberndtson`.`researcheroncase` ;

CREATE TABLE IF NOT EXISTS `odgersberndtson`.`researcheroncase` (
  `researcherId` INT(11) NOT NULL,
  `CaseName` VARCHAR(45) NULL DEFAULT NULL,
  INDEX `researcherId_idx` (`researcherId` ASC),
  INDEX `caseName2_idx` (`CaseName` ASC),
  CONSTRAINT `caseName2`
    FOREIGN KEY (`CaseName`)
    REFERENCES `odgersberndtson`.`case` (`CaseName`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `researcherId`
    FOREIGN KEY (`researcherId`)
    REFERENCES `odgersberndtson`.`researcher` (`employeeId`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
