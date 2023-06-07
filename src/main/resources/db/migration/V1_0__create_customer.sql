CREATE TABLE customer (
  id_customer BIGINT(20) NOT NULL AUTO_INCREMENT,
  tx_customer VARCHAR(100) NULL,
  tx_phone VARCHAR(45) NULL,
  tx_email VARCHAR(100) NULL,
  dt_birth DATE NULL,
  tx_observations VARCHAR(100) NULL,
  PRIMARY KEY (`id_customer`));
