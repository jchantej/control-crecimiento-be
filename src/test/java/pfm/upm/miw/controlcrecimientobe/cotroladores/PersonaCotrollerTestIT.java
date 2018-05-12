package pfm.upm.miw.controlcrecimientobe.cotroladores;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import pfm.upm.miw.controlcrecimientobe.daos.IPersonaDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class PersonaCotrollerTestIT {
    
    @Autowired
    private IPersonaDao iPersonaDao;

    @Autowired
    private IUsuarioDao iUsuarioDao;

    private Persona persona;

    private Usuario usuario;

    @Before
    public void setDb() {

        this.usuario = new Usuario("test@test.com", "test", "test", "test", "test@test.com", "test.jpg");
        iUsuarioDao.save(usuario);

        this.persona = new Persona("Pablo", "Jimenez", new Date(), "M", "ORH+", "toni.jpg", this.usuario.getId());
        this.iPersonaDao.save(persona);

    }

    @Test
    public void testFindById() {

        assertEquals("Pablo", iPersonaDao.findById(this.persona.getId()).get().getNombre());

    }

    @After
    public void delete() {
        this.iUsuarioDao.delete(this.usuario);
        this.iPersonaDao.delete(this.persona);
    }

}
