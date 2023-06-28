package br.com.clinical.project.service.material;

import br.com.clinical.project.model.material.Material;
import br.com.clinical.project.repository.material.MaterialRepository;
import br.com.clinical.project.service.material.dto.MaterialRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MaterialServiceTest {


    public static final long ID_MATERIAL = 1L;
    public static final String TX_MATERIAL = "Caneta";
    public static final BigDecimal QT_MATERIAL = BigDecimal.valueOf(20);
    @InjectMocks
    private MaterialService materialService;

    @Mock
    private MaterialRepository materialRepository;

    @Mock
    private ModelMapper modelMapper;

    private Material material;
    private Optional<Material> materialOptional;
    private MaterialRequestDTO materialRequestDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startMaterial();
    }

    @Test
    void whenFindByIdThenReturnMaterialInstance() {
        Mockito.when(materialRepository.findById(Mockito.anyLong())).thenReturn(materialOptional);
        Material response = materialService.findById(ID_MATERIAL);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(Material.class, response.getClass());
        Assertions.assertEquals(ID_MATERIAL, response.getIdMaterial());
        Assertions.assertEquals(TX_MATERIAL, response.getTxMaterial());
        Assertions.assertEquals(QT_MATERIAL, response.getQtMaterial());


    }

    @Test
    void findAll() {
        Mockito.when(materialRepository.findAll()).thenReturn(Collections.singletonList(material));
        List<Material> materials = materialService.findAll();
        //Assertions.assertEquals(List<Material> material, materials);
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    private void startMaterial(){
        material = new Material(ID_MATERIAL, TX_MATERIAL, QT_MATERIAL);
        materialOptional = Optional.of(new Material(ID_MATERIAL, TX_MATERIAL, QT_MATERIAL));
        materialRequestDTO = new MaterialRequestDTO(ID_MATERIAL, TX_MATERIAL, QT_MATERIAL);

    }
}