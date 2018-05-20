package pfm.upm.miw.controlcrecimientobe.daos;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pfm.upm.miw.controlcrecimientobe.entidades.ControlCrecimiento;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class ControlCrecimientoTestIT {

    @Autowired
    private IPersonaDao iPersonaDao;

    @Autowired
    private IControlCrecimientoDao iControlCrecimientoDao;

    private Persona persona;

    @Before
    public void setData() {

        this.persona = iPersonaDao.findByNombre("test1");

    }

    @Test
    public void crearControlCrecimiento() {

        ControlCrecimiento controlCrecimiento = new ControlCrecimiento(791, new BigDecimal(12.5), new BigDecimal(85.00), this.persona);
        iControlCrecimientoDao.save(controlCrecimiento);

        assertNotNull(iControlCrecimientoDao.findById(controlCrecimiento.getId()));
        assertEquals(791, controlCrecimiento.getEdad());
        assertEquals(new BigDecimal(85.00), controlCrecimiento.getTalla());
        assertEquals(new BigDecimal(12.5), controlCrecimiento.getPeso());
        assertEquals("test1", controlCrecimiento.getPersona().getNombre());
        assertEquals("M", controlCrecimiento.getPersona().getGenero());
   
        iControlCrecimientoDao.delete(controlCrecimiento);
         

    }
    



}
