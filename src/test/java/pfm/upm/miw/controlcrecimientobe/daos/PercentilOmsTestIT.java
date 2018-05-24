package pfm.upm.miw.controlcrecimientobe.daos;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class PercentilOmsTestIT {

    @Autowired
    private IPercentilOmsDao iPercentilOmsDao;

    private List<PercentilOms> percentileOmss;

    @Test
    public void testFindByEdadAndGenero() {

        percentileOmss = iPercentilOmsDao.findByEdadAndGenero(0, "M");
        assertNotNull(percentileOmss);
        assertEquals(true, percentileOmss.size() >= 1);
        assertEquals(0, percentileOmss.get(0).getEdad());
        assertEquals("M", percentileOmss.get(0).getGenero());
        System.out.println(percentileOmss.toString());

    }

    @Test
    public void testFindByTipoAndGenero() {

        percentileOmss = iPercentilOmsDao.findByGeneroAndTipo("M", "P");

        assertNotNull(percentileOmss);
        assertEquals(true, percentileOmss.size() >= 1);
        assertEquals("P", percentileOmss.get(0).getTipo());
        assertEquals("M", percentileOmss.get(0).getGenero());

    }

}
