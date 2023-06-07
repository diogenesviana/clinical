package model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
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
