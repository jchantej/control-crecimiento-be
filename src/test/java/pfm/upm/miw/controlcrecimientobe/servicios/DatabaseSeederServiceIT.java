package pfm.upm.miw.controlcrecimientobe.servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class DatabaseSeederServiceIT {

    @Autowired
    private IUsuarioDao iUsuarioDao;
    
    @Autowired
    private DatabaseSeederService databaseSeederService;
    
    @Test
    public void testUsuarioSeedDatabase() throws IOException {
        this.databaseSeederService.deleteAllAndCreateAdmin();
        this.databaseSeederService.seedDatabase("control-crecimiento-db-test.yml");
        Usuario usuario = iUsuarioDao.findByUsername("admin");
        assertNotNull(usuario);
        assertEquals("admin", usuario.getUsername());

    }
    
}
