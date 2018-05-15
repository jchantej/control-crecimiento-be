package pfm.upm.miw.controlcrecimientobe.recursos;


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

import pfm.upm.miw.controlcrecimientobe.dtos.PersonaDto;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class PersonaResourceFunctionalTesting {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;

    private PersonaDto personaDto;

    @Before
    public void before() {
        this.personaDto = new PersonaDto("Pablo", "Jimenez", new Date(), "M", "ORH+", "toni.jpg", 1);;
    }

   @Test
    public void testCrearPersona() {
       // restService.restBuilder().path(PersonaRecurso.PERSONAS).body(this.personaDto).post().build();
       System.out.println("Test");
    }

}
