-- MySQL Script generated by MySQL Workbench
-- Sun Jan 28 15:51:52 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ingrossoPiante
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ingrossoPiante
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ingrossoPiante` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci ;
USE `ingrossoPiante` ;

-- -----------------------------------------------------
-- Table `ingrossoPiante`.`contatto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`contatto` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`contatto` (
  `email` VARCHAR(45) NOT NULL,
  `IVArivenditaContatto` VARCHAR(11) NOT NULL,
  `telefono` VARCHAR(9) NULL,
  `cellulare` VARCHAR(10) NULL,
  PRIMARY KEY (`email`, `IVArivenditaContatto`),
  UNIQUE INDEX `telefono_UNIQUE` (`telefono` ASC) VISIBLE,
  UNIQUE INDEX `cellulare_UNIQUE` (`cellulare` ASC) VISIBLE,
  INDEX `fkContatto_idx` (`IVArivenditaContatto` ASC) VISIBLE,
  CONSTRAINT `fkContatto`
    FOREIGN KEY (`IVArivenditaContatto`)
    REFERENCES `ingrossoPiante`.`rivendita` (`IVA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`contenuto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`contenuto` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`contenuto` (
  `CodOrdineCont` VARCHAR(10) NOT NULL,
  `nomeLatinoSpecieCont` VARCHAR(45) NOT NULL,
  `qta_ordinata` INT NOT NULL,
  PRIMARY KEY (`CodOrdineCont`, `nomeLatinoSpecieCont`),
  INDEX `fkSpecie_idx` (`nomeLatinoSpecieCont` ASC) VISIBLE,
  CONSTRAINT `fkOrdine`
    FOREIGN KEY (`CodOrdineCont`)
    REFERENCES `ingrossoPiante`.`ordine` (`Codice_ordine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkSpecie`
    FOREIGN KEY (`nomeLatinoSpecieCont`)
    REFERENCES `ingrossoPiante`.`specie` (`nome_latino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`effettua`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`effettua` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`effettua` (
  `IVAeff` VARCHAR(11) NOT NULL,
  `codOrdineEff` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`IVAeff`, `codOrdineEff`),
  INDEX `fkOrdine_idx` (`codOrdineEff` ASC) VISIBLE,
  CONSTRAINT `fkRivendita`
    FOREIGN KEY (`IVAeff`)
    REFERENCES `ingrossoPiante`.`rivendita` (`IVA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkOrdine`
    FOREIGN KEY (`codOrdineEff`)
    REFERENCES `ingrossoPiante`.`ordine` (`Codice_ordine`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`fornitore`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`fornitore` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`fornitore` (
  `CF` VARCHAR(16) NOT NULL,
  `nomeFornitore` VARCHAR(45) NOT NULL,
  `cognomeFornitore` VARCHAR(45) NOT NULL,
  `Cfornitore` VARCHAR(10) NOT NULL,
  `sedePos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CF`),
  UNIQUE INDEX `Cfornitore_idx` (`Cfornitore` ASC) VISIBLE,
  UNIQUE INDEX `sedePos_idx` (`sedePos` ASC) VISIBLE,
  CONSTRAINT `fkFornitrice`
    FOREIGN KEY (`Cfornitore`)
    REFERENCES `ingrossoPiante`.`fornitrice` (`Codice_fornitore`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`fornitrice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`fornitrice` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`fornitrice` (
  `Codice_fornitore` VARCHAR(10) NOT NULL,
  `sede_f` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Codice_fornitore`),
  UNIQUE INDEX `sede_f_UNIQUE` (`sede_f` ASC) VISIBLE,
  CONSTRAINT `fkSede`
    FOREIGN KEY (`sede_f`)
    REFERENCES `ingrossoPiante`.`sede` (`sede_a`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`indirizzo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`indirizzo` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`indirizzo` (
  `fatturazione` VARCHAR(45) NOT NULL,
  `IVArivendita` VARCHAR(11) NOT NULL,
  `spedizione` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`fatturazione`, `IVArivendita`),
  INDEX `fkRivendita_idx` (`IVArivendita` ASC) VISIBLE,
  CONSTRAINT `fkRivendita`
    FOREIGN KEY (`IVArivendita`)
    REFERENCES `ingrossoPiante`.`rivendita` (`IVA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`ordine`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`ordine` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`ordine` (
  `Codice_ordine` VARCHAR(10) NOT NULL,
  `recapito` VARCHAR(45) NOT NULL,
  `nomeOrdine` VARCHAR(45) NOT NULL,
  `cognomeOrdine` VARCHAR(45) NULL,
  `stato` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Codice_ordine`),
  INDEX `nomeOrdine_idx` (`cognomeOrdine` ASC) VISIBLE,
  INDEX `cognomeOrdine_udx` (`cognomeOrdine` ASC) VISIBLE,
  INDEX `ordine_info` (`stato` ASC, `recapito` ASC) VISIBLE,
  CONSTRAINT `fkNome`
    FOREIGN KEY (`cognomeOrdine`)
    REFERENCES `ingrossoPiante`.`referente` (`cognomeReferente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`pianta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`pianta` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`pianta` (
  `codice` VARCHAR(10) NOT NULL,
  `nomeLatinoSpeciePianta` VARCHAR(45) NOT NULL,
  `quantita` INT NOT NULL,
  PRIMARY KEY (`codice`, `nomeLatinoSpeciePianta`),
  INDEX `fkSpecie_idx` (`nomeLatinoSpeciePianta` ASC) VISIBLE,
  CONSTRAINT `fkSpecie`
    FOREIGN KEY (`nomeLatinoSpeciePianta`)
    REFERENCES `ingrossoPiante`.`specie` (`nome_latino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`prezzo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`prezzo` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`prezzo` (
  `costo` FLOAT NOT NULL,
  `nomeLatinoSpeciePrezzo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`costo`, `nomeLatinoSpeciePrezzo`),
  INDEX `fkSpecie_idx` (`nomeLatinoSpeciePrezzo` ASC) VISIBLE,
  CONSTRAINT `fkSpecie`
    FOREIGN KEY (`nomeLatinoSpeciePrezzo`)
    REFERENCES `ingrossoPiante`.`specie` (`nome_latino`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`referente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`referente` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`referente` (
  `cognomeReferente` VARCHAR(45) NOT NULL,
  `IVArivenditaReferente` VARCHAR(11) NOT NULL,
  `nomeReferente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cognomeReferente`, `IVArivenditaReferente`),
  INDEX `fkRivendita_idx` (`IVArivenditaReferente` ASC) VISIBLE,
  CONSTRAINT `fkRivendita`
    FOREIGN KEY (`IVArivenditaReferente`)
    REFERENCES `ingrossoPiante`.`rivendita` (`IVA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`rifornisce`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`rifornisce` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`rifornisce` (
  `codFornitriceRif` VARCHAR(10) NOT NULL,
  `codicePiantaRif` VARCHAR(10) NOT NULL,
  `specieRif` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codFornitriceRif`, `codicePiantaRif`, `specieRif`),
  INDEX `fkPianta_idx` (`codicePiantaRif` ASC) VISIBLE,
  CONSTRAINT `fkFornitore`
    FOREIGN KEY (`codFornitriceRif`)
    REFERENCES `ingrossoPiante`.`fornitore` (`CF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkPianta`
    FOREIGN KEY (`codicePiantaRif`)
    REFERENCES `ingrossoPiante`.`pianta` (`codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`rivendita`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`rivendita` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`rivendita` (
  `IVA` VARCHAR(11) NOT NULL,
  `sede_rivendita` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IVA`),
  UNIQUE INDEX `sede_rivendita_idx` (`sede_rivendita` ASC) INVISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`sede`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`sede` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`sede` (
  `sede_a` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sede_a`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`specie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`specie` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`specie` (
  `nome_latino` VARCHAR(45) NOT NULL,
  `nome_comune` VARCHAR(45) NOT NULL,
  `colore` VARCHAR(45) NULL,
  `dataAggPrezzo` DATETIME NOT NULL,
  `tipoGenetica` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nome_latino`),
  INDEX `tipoGenetica_idx` (`tipoGenetica` ASC) VISIBLE,
  CONSTRAINT `fkTipo`
    FOREIGN KEY (`tipoGenetica`)
    REFERENCES `ingrossoPiante`.`tipo` (`tipo_a`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingrossoPiante`.`tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ingrossoPiante`.`tipo` ;

CREATE TABLE IF NOT EXISTS `ingrossoPiante`.`tipo` (
  `tipo_a` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_a`))
ENGINE = InnoDB;

USE `ingrossoPiante`;

DELIMITER $$

USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`contatto_BEFORE_INSERT` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`contatto_BEFORE_INSERT` BEFORE INSERT ON `contatto` FOR EACH ROW
BEGIN
	if not NEW.email regexp '^[A-Za-z0-9+_.-]+@(.+)$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`contatto_BEFORE_INSERT_1` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`contatto_BEFORE_INSERT_1` BEFORE INSERT ON `contatto` FOR EACH ROW
BEGIN
	if not NEW.telefono regexp '^[0-9]{4,15}$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`contatto_BEFORE_INSERT_2` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`contatto_BEFORE_INSERT_2` BEFORE INSERT ON `contatto` FOR EACH ROW
BEGIN
	if not NEW.telefono regexp '^[0-9]{4,16}$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`contatto_BEFORE_UPDATE` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`contatto_BEFORE_UPDATE` BEFORE UPDATE ON `contatto` FOR EACH ROW
BEGIN
	if not NEW.email regexp '^[A-Za-z0-9+_.-]+@(.+)$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`contatto_BEFORE_UPDATE_1` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`contatto_BEFORE_UPDATE_1` BEFORE UPDATE ON `contatto` FOR EACH ROW
BEGIN
	if not NEW.telefono regexp '^[0-9]{4,15}$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`contatto_BEFORE_UPDATE_2` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`contatto_BEFORE_UPDATE_2` BEFORE UPDATE ON `contatto` FOR EACH ROW
BEGIN
	if not NEW.telefono regexp '^[0-9]{4,16}$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`contenuto_BEFORE_INSERT` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`contenuto_BEFORE_INSERT` BEFORE INSERT ON `contenuto` FOR EACH ROW 
BEGIN
	DECLARE piantaOrdinata VARCHAR(45);
    SELECT nomeLatinoSpeciePianta FROM pianta WHERE NEW.nomeLatinoSpecieCont = nomeLatinoSpeciePianta INTO piantaOrdinata;
	if (NEW.qta_ordinata > (SELECT quantita FROM pianta WHERE piantaOrdinata = nomeLatinoSpeciePianta)) then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`fornitore_BEFORE_INSERT` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`fornitore_BEFORE_INSERT` BEFORE INSERT ON `fornitore` FOR EACH ROW
BEGIN
	if not NEW.CF regexp '^[A-Z]{6,6}[0-9]{2,2}[A-Z][0-9]{2,2}[A-Z][0-9]{3,3}[A-Z]$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`fornitrice_BEFORE_INSERT` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`fornitrice_BEFORE_INSERT` BEFORE INSERT ON `fornitrice` FOR EACH ROW
BEGIN
	if not NEW.Codice_fornitore regexp '^[A-Za-z0-9]+$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`ordine_BEFORE_INSERT` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`ordine_BEFORE_INSERT` BEFORE INSERT ON `ordine` FOR EACH ROW
BEGIN
	if not NEW.Codice_ordine regexp '^[A-Za-z0-9]+$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`ordine_BEFORE_INSERT_1` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`ordine_BEFORE_INSERT_1` BEFORE INSERT ON `ordine` FOR EACH ROW
BEGIN
	if (NEW.stato != 'aperto$') then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`ordine_BEFORE_UPDATE` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`ordine_BEFORE_UPDATE` BEFORE UPDATE ON `ordine` FOR EACH ROW
BEGIN
	if (NEW.stato != 'aperto$' and NEW.stato != 'finalizzato$' and NEW.stato != 'in consegna$' and NEW.stato != 'consegnato$') then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`pianta_BEFORE_INSERT` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`pianta_BEFORE_INSERT` BEFORE INSERT ON `pianta` FOR EACH ROW
BEGIN
	if not NEW.codice regexp '^[A-Za-z0-9]+$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`prezzo_AFTER_INSERT` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`prezzo_AFTER_INSERT` AFTER INSERT ON `prezzo` FOR EACH ROW
BEGIN
	UPDATE specie SET dataAggPrezzo = GETDATE() WHERE NEW.nomeLatinoSpeciePrezzo = nome_latino;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`rivendita_BEFORE_INSERT` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`rivendita_BEFORE_INSERT` BEFORE INSERT ON `rivendita` FOR EACH ROW
BEGIN
	if not NEW.IVA regexp '^[0-9]{11}$' then
		signal sqlstate '45000';
	end if;
END$$


USE `ingrossoPiante`$$
DROP TRIGGER IF EXISTS `ingrossoPiante`.`rivendita_BEFORE_UPDATE` $$
USE `ingrossoPiante`$$
CREATE DEFINER = CURRENT_USER TRIGGER `ingrossoPiante`.`rivendita_BEFORE_UPDATE` BEFORE UPDATE ON `rivendita` FOR EACH ROW
BEGIN
	if not NEW.IVA regexp '^[0-9]{11}$' then
		signal sqlstate '45000';
	end if;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
