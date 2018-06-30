package pfm.upm.miw.controlcrecimientobe.recursos;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class PercentilOmsFunctionalTesting {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;


    @Test
    public void testgetAllPercentilOms() {
        
        List<PercentilOms> percentilesOms = Arrays.asList(restService.restBuilder(new RestBuilder<PercentilOms[]>())
                .basicAuth("admin", "admin")
                .clazz(PercentilOms[].class).path(PercentilOmsRecurso.PERCENTILES).get()
                .build());  
        
        assertEquals("M", percentilesOms.get(0).getGenero());
    }
      


    @Test
    public void testGetPercentiles() {
        
        List<PercentilOms> percentilesOms = Arrays.asList(restService.restBuilder(new RestBuilder<PercentilOms[]>())
                .basicAuth("admin", "admin")
                .clazz(PercentilOms[].class).path(PercentilOmsRecurso.PERCENTILES).path(PercentilOmsRecurso.GENEROTIPO)
                .param("genero", "M").param("tipo", "P").param("edad", "50").get().build());
        
        assertEquals("M", percentilesOms.get(0).getGenero());
        assertEquals("P", percentilesOms.get(0).getTipo());
        
    }
    

}
