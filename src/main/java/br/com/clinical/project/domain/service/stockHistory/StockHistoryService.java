package br.com.clinical.project.domain.service.stockHistory;

import br.com.clinical.project.domain.model.material.Material;
import br.com.clinical.project.domain.model.stockHistory.StockHistory;
import br.com.clinical.project.domain.repository.stock.StockRepository;
import br.com.clinical.project.domain.repository.stockHistory.StockHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockHistoryService {

    @Autowired
    StockHistoryRepository stockHistoryRepository;

    public StockHistory save (Material material){
        StockHistory stockHistory = new StockHistory();
        stockHistory.setIdStock(material.getStock().getIdStock());
        stockHistory.setMaterial(material);
        stockHistory.setQtStock(material.getStock().getQtStock());
        stockHistory.setDtUpdated(material.getStock().getDtUpdated());
        return stockHistoryRepository.save(stockHistory);
    }
}
