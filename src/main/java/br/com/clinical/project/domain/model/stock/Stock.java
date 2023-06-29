package br.com.clinical.project.domain.model.stock;

import br.com.clinical.project.domain.model.material.Material;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
