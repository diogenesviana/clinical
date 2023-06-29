package br.com.clinical.project.domain.repository.stockHistory;


import br.com.clinical.project.domain.model.stockHistory.StockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockHistoryRepository extends JpaRepository <StockHistory, Long> {
}
