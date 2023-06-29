package br.com.clinical.project.domain.model.material;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_material")
    private Long idMaterial;

    @Column (name = "tx_material")
    private String txMaterial;

    @Column (name = "qt_material")
    private BigDecimal qtMaterial;


}
