package pfm.upm.miw.controlcrecimientobe.daos;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class PersonaTestIT {

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
    public void crearPersona() {

        this.persona = new Persona("Pablo", "Jimenez", new Date(), "M", "ORH+", "toni.jpg", this.usuario.getId());
        this.iPersonaDao.save(persona);
        assertNotNull(iPersonaDao.findById(this.persona.getId()).get().getNombre());
        assertEquals("Jimenez", iPersonaDao.findById(this.persona.getId()).get().getApellido());
        assertEquals("M", iPersonaDao.findById(this.persona.getId()).get().getGenero());
        assertEquals("ORH+", iPersonaDao.findById(this.persona.getId()).get().getGrupoSanguineo());

    }

    @Test
    public void testFindById() {
        assertNotNull(iPersonaDao.findById(this.persona.getId()).get().getNombre());
        assertEquals("Pablo", iPersonaDao.findById(this.persona.getId()).get().getNombre());
    }

    @After
    public void delete() {
        this.iUsuarioDao.delete(this.usuario);
        this.iPersonaDao.delete(this.persona);
    }

}
