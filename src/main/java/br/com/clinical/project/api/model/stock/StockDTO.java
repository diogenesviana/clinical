package br.com.clinical.project.api.model.stock;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StockDTO {

    private Long idStock;
    private Long idMaterial;
    private BigDecimal qtStock;
    private LocalDateTime dtUpdated;

    public StockDTO(Long idStock, Long idMaterial, BigDecimal qtStock) {
        this.idStock = idStock;
        this.idMaterial = idMaterial;
        this.qtStock = qtStock;
        this.dtUpdated = LocalDateTime.now();
    }

}
