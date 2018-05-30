package pfm.upm.miw.controlcrecimientobe.cotroladores;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioDto;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class UsuarioCotrollerTestIT {

    
    @Autowired
    private UsuarioController usuarioCotroller;

    private UsuarioDto usuarioDto;


    @Test
    public void testCrearUsuario() {
        
        this.usuarioDto = new UsuarioDto("tesst", "test", "test", "test", "test@test.com", "test.jpg");

        usuarioCotroller.crearUsuario(usuarioDto);
      //  assertEquals("Pablo", iPersonaDao.findById(this.persona.getId()).get().getNombre());

    }
    


  /*  @After
    public void delete() {
        this.iUsuarioDao.delete(this.usuario);
        this.iPersonaDao.delete(this.persona);
    }*/

}
