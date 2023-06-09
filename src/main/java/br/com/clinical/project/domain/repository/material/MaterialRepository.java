package br.com.clinical.project.domain.repository.material;

import br.com.clinical.project.domain.model.material.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository <Material, Long> {

    Optional<Material> findByTxMaterial(String txMaterial);
}
