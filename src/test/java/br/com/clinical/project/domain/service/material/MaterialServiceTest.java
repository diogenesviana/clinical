package br.com.clinical.project.domain.service.material;

import br.com.clinical.project.domain.model.material.Material;
import br.com.clinical.project.domain.repository.material.MaterialRepository;
import br.com.clinical.project.domain.exception.BusinessException;
import br.com.clinical.project.api.exceptionhandler.ObjectNotFoundException;
import br.com.clinical.project.api.model.material.MaterialRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MaterialServiceTest {


    public static final long ID_MATERIAL = 1L;
    public static final String TX_MATERIAL = "Caneta";
    public static final BigDecimal QT_MATERIAL = BigDecimal.valueOf(20);
    public static final String MATERIAL_NOT_FOUND = "Material não encontrado";
    public static final String EXISTS = " já existe no sistema";
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
        when(materialRepository.findById(anyLong())).thenReturn(materialOptional);
        Material response = materialService.findById(ID_MATERIAL);

        assertNotNull(response);
        assertEquals(Material.class, response.getClass());
        assertEquals(ID_MATERIAL, response.getIdMaterial());
        assertEquals(TX_MATERIAL, response.getTxMaterial());
        assertEquals(QT_MATERIAL, response.getQtMaterial());



    }

    @Test
    void whenFindByIdThenReturnException() {
        when(materialRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(MATERIAL_NOT_FOUND));

        try {
            materialService.findById(2L);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(MATERIAL_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
    void whenCallFindAllThenGetListMaterial() {
        when(materialRepository.findAll()).thenReturn(List.of(material));
        List<Material> response = materialService.findAll();

        assertEquals(1, response.size());
        assertEquals(Material.class, response.get(0).getClass());
        assertNotNull(response);
        assertEquals(ID_MATERIAL, material.getIdMaterial());
    }

    @Test
    void whenCreateThenReturnSuccess() {
        when(materialRepository.save(any())).thenReturn(material);
        Material response = materialService.create(materialRequestDTO);

        assertNotNull(response);
        assertEquals(Material.class, response.getClass());
        assertEquals(ID_MATERIAL, response.getIdMaterial());

    }

    @Test
    void whenCreateThenReturnNotSuccess() {
        when(materialRepository.findByTxMaterial(anyString())).thenReturn(materialOptional);

        try{
            Material response = materialService.create(materialRequestDTO);
        } catch(Exception ex) {
            assertEquals(BusinessException.class, ex.getClass());
            assertEquals(material.getTxMaterial() + EXISTS, ex.getMessage());
        }
    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(materialRepository.save(any())).thenReturn(material);
        when(materialRepository.findById(ID_MATERIAL)).thenReturn(materialOptional);
        Material response = materialService.update(material.getIdMaterial(), materialRequestDTO);

        assertNotNull(response);
        assertEquals(Material.class, response.getClass());
        assertEquals(ID_MATERIAL, response.getIdMaterial());
        assertEquals(TX_MATERIAL, response.getTxMaterial());
    }

    @Test
    void whenUpdateThenReturnNotSuccess() {
        when(materialRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(MATERIAL_NOT_FOUND));

        try{
            Material response = materialService.update(material.getIdMaterial(), materialRequestDTO);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(MATERIAL_NOT_FOUND, ex.getMessage());
        }
    }

    private void startMaterial(){
        material = new Material(ID_MATERIAL, TX_MATERIAL, QT_MATERIAL);
        materialOptional = Optional.of(new Material(ID_MATERIAL, TX_MATERIAL, QT_MATERIAL));
        materialRequestDTO = new MaterialRequestDTO(ID_MATERIAL, TX_MATERIAL, QT_MATERIAL);
    }
}