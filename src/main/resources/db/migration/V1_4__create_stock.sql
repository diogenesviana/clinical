CREATE TABLE stock (
  id_stock BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_material BIGINT(20) NOT NULL,
  qt_stock DECIMAL(10, 2),
  dt_updated TIMESTAMP,
  FOREIGN KEY (id_material) REFERENCES material (id_material)
);