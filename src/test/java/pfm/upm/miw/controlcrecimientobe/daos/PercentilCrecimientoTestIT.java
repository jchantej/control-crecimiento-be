package pfm.upm.miw.controlcrecimientobe.daos;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pfm.upm.miw.controlcrecimientobe.entidades.ControlCrecimiento;
import pfm.upm.miw.controlcrecimientobe.entidades.PercentilCrecimiento;
import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;
import pfm.upm.miw.controlcrecimientobe.utils.CalculoEdad;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class PercentilCrecimientoTestIT {

    @Autowired
    private IPersonaDao iPersonaDao;

    @Autowired
    private IPercentilOmsDao iPercentilOmsDao;

    @Autowired
    private IControlCrecimientoDao iControlCrecimientoDao;

    @Autowired
    private IPercentilCrecimientoDao iPercentilCrecimientoDao;

    private List<PercentilCrecimiento> percentilesCrecimiento;

    private ControlCrecimiento controlCrecimiento;

    private List<PercentilOms> percentilesOmss;

    private int edadTotalDias;

    private Persona persona;


    @Before
    public void setData() {

        this.persona = iPersonaDao.findByNombre("test1");
        this.persona.setFechaNacimiento(new Date());

        edadTotalDias = new CalculoEdad(this.persona.getFechaNacimiento()).getEdadTotalDias();

    }

    @Test
    public void crearControlCrecimiento() {

        percentilesCrecimiento = new ArrayList<>();

        this.controlCrecimiento = new ControlCrecimiento(edadTotalDias, new BigDecimal(12.5), new BigDecimal(85.00), this.persona);

        percentilesOmss = iPercentilOmsDao.findByEdadAndGenero(edadTotalDias, this.persona.getGenero());

        iControlCrecimientoDao.save(this.controlCrecimiento);
        for (PercentilOms percentilOms : percentilesOmss) {
            percentilesCrecimiento.add(new PercentilCrecimiento(iControlCrecimientoDao.save(this.controlCrecimiento), percentilOms,
                    "observacion", "recomendacion"));
        }

        iPercentilCrecimientoDao.saveAll(percentilesCrecimiento);
         
         assertNotNull(iPercentilCrecimientoDao.findById(percentilesCrecimiento.get(0).getId())); 
         assertEquals(new BigDecimal(12.5), percentilesCrecimiento.get(0).getControlCrecimiento().getPeso());
         assertEquals("M", percentilesCrecimiento.get(0).getPercentilOms().getGenero());
         assertEquals("M", percentilesCrecimiento.get(0).getControlCrecimiento().getPersona().getGenero()); 
         assertEquals("test1", percentilesCrecimiento.get(0).getControlCrecimiento().getPersona().getNombre()); 

         
         
    }

}
