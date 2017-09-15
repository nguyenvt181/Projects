-- MySQL Script generated by MySQL Workbench
-- Thu Sep 14 20:38:46 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema FUForum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema FUForum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FUForum` DEFAULT CHARACTER SET utf8 ;
USE `FUForum` ;

-- -----------------------------------------------------
-- Table `FUForum`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FUForum`.`Role` (
  `roleId` INT NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roleId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FUForum`.`Account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FUForum`.`Account` (
  `accountId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL COMMENT '		',
  `name` NVARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `roleId` INT NOT NULL,
  PRIMARY KEY (`accountId`, `roleId`),
  INDEX `fk_Account_Role1_idx` (`roleId` ASC),
  CONSTRAINT `fk_Account_Role1`
    FOREIGN KEY (`roleId`)
    REFERENCES `FUForum`.`Role` (`roleId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FUForum`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FUForum`.`Group` (
  `groupId` INT NOT NULL AUTO_INCREMENT,
  `groupName` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`groupId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FUForum`.`Status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FUForum`.`Status` (
  `statusId` INT NOT NULL AUTO_INCREMENT,
  `statusName` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`statusId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FUForum`.`Post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FUForum`.`Post` (
  `postId` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` NVARCHAR(5000) NOT NULL,
  `createdDate` VARCHAR(45) NOT NULL,
  `accountId` INT NOT NULL,
  `groupId` INT NOT NULL,
  `statusId` INT NOT NULL,
  PRIMARY KEY (`postId`, `accountId`, `groupId`, `statusId`),
  INDEX `fk_Post_Account_idx` (`accountId` ASC),
  INDEX `fk_Post_Group1_idx` (`groupId` ASC),
  INDEX `fk_Post_Status1_idx` (`statusId` ASC),
  CONSTRAINT `fk_Post_Account`
    FOREIGN KEY (`accountId`)
    REFERENCES `FUForum`.`Account` (`accountId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Post_Group1`
    FOREIGN KEY (`groupId`)
    REFERENCES `FUForum`.`Group` (`groupId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Post_Status1`
    FOREIGN KEY (`statusId`)
    REFERENCES `FUForum`.`Status` (`statusId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;