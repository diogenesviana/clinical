package br.com.clinical.project.domain.model.material;

import br.com.clinical.project.domain.model.stock.Stock;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_material")
    private Long idMaterial;

    @Column (name = "tx_material")
    private String txMaterial;

    @OneToOne(mappedBy = "material", cascade = CascadeType.ALL)
    private Stock stock;

}
