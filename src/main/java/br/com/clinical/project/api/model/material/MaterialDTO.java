package br.com.clinical.project.api.model.material;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {

    private Long idMaterial;
    private String txMaterial;
}
