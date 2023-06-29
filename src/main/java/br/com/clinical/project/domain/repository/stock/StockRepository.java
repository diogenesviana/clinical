package br.com.clinical.project.domain.repository.stock;

import br.com.clinical.project.domain.model.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository <Stock, Long> {
}
