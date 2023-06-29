package br.com.clinical.project.domain.model.stockHistory;

import br.com.clinical.project.domain.model.material.Material;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name="stock_history")
public class StockHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock_history")
    private Long idStockHistory;

    @Column(name = "id_stock")
    private Long idStock;

    @OneToOne
    @JoinColumn (name = "id_material")
    private Material material;

    @Column (name = "qt_stock")
    private BigDecimal qtStock;

    @Column (name = "dt_updated")
    private LocalDateTime dtUpdated;
}
