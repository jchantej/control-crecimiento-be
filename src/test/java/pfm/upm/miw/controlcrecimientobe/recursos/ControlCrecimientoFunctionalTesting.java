package pfm.upm.miw.controlcrecimientobe.recursos;

import java.math.BigDecimal;
import java.util.Date;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pfm.upm.miw.controlcrecimientobe.daos.IPersonaDao;
import pfm.upm.miw.controlcrecimientobe.dtos.ControlCrecimientoDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class ControlCrecimientoFunctionalTesting {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;

    @Autowired
    private IPersonaDao iPersonaDao;

    private ControlCrecimientoDto controlCrecimientoDto;

    private Persona persona;

    @Before
    public void before() {
        this.persona = iPersonaDao.findByNombre("test1");
        this.persona.setFechaNacimiento(new Date());
        iPersonaDao.save(this.persona);
        this.controlCrecimientoDto = new ControlCrecimientoDto(new BigDecimal(3.35), new BigDecimal(30.00), this.persona.getId() );


    }

    @Test
    public void testCrearControlCrecimiento() {
        restService.restBuilder().path(ControlCrecimientoRecurso.CONTROLES).body(this.controlCrecimientoDto).post().build();
    }
    

}
