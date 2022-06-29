create database if not exists controle_estoque;
use controle_estoque;
CREATE TABLE if not exists `produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(120) NOT NULL,
  `saldo` INT NOT NULL,
  `preco` DECIMAL(15,2) NOT NULL,
  `local_estoque` VARCHAR(45) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
  `updated_at` TIMESTAMP NOT NULL DEFAULT current_timestamp() on update current_timestamp(),
  PRIMARY KEY (`id`));