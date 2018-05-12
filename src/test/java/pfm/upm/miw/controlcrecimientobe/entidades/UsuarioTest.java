package pfm.upm.miw.controlcrecimientobe.entidades;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UsuarioTest {

    @Test
    public void testSimple() {
        
        Usuario usuario = new Usuario("jchantej@gmail.com", "test", "Juan Pablo", "Jimenez", "jchantej@gmail.com", "juan.jpg");
          assertEquals("jchantej@gmail.com", usuario.getUsername());
          assertEquals("Juan Pablo", usuario.getNombre());
          assertEquals("Jimenez", usuario.getApellido());
          assertEquals("jchantej@gmail.com", usuario.getCorreo());
          
    }

}
