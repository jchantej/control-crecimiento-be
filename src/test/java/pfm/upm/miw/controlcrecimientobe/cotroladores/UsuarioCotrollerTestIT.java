package pfm.upm.miw.controlcrecimientobe.cotroladores;



import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioDto;



@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class UsuarioCotrollerTestIT {

    
    @Autowired
    private UsuarioController usuarioCotroller;
    @Autowired
    private IUsuarioDao iUsuarioDao;

    private UsuarioDto usuarioDto;

    
    @Before
    public void setDb() {

        //TODO: Pendiente de refactorizar test
        this.usuarioDto = new UsuarioDto("tesst", "test", "test", "test", "test@test.com", "test.jpg");

    }


    @Test
    public void testCrearUsuario() {
        
        usuarioCotroller.crearUsuario(usuarioDto);
        assertEquals("tesst", iUsuarioDao.findByUsername("tesst").getUsername());

    }


}
