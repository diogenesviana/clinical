package br.com.clinical.project.repository;

import br.com.clinical.project.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository <Material, Long> {

}
