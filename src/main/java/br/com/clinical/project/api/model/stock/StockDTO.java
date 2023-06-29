package br.com.clinical.project.api.model.stock;

import br.com.clinical.project.api.model.material.MaterialDTO;
import br.com.clinical.project.api.model.material.MaterialRequestDTO;
import br.com.clinical.project.domain.model.material.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Long idStock;
    private MaterialDTO material;
    private BigDecimal qtStock;
    private LocalDateTime dtUpdated;

    public StockDTO(Long idStock, MaterialDTO material, BigDecimal qtStock) {
        this.idStock = idStock;
        this.material = material;
        this.qtStock = qtStock;
        this.dtUpdated = LocalDateTime.now();
    }

}
