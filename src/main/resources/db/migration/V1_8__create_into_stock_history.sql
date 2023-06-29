CREATE TABLE stock_history (
    id_stock_history BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    id_stock BIGINT(20),
    id_material BIGINT(20),
    qt_stock DECIMAL(10, 2),
    dt_updated DATETIME
);