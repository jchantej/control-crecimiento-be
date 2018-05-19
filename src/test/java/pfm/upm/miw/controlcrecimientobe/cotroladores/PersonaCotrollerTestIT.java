package pfm.upm.miw.controlcrecimientobe.cotroladores;

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

import pfm.upm.miw.controlcrecimientobe.daos.IPersonaDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.dtos.PersonaDto;
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
    
    @Autowired
    private PersonaController personaCotroller;

    private Persona persona;
    private PersonaDto personaDto ;

    private Usuario usuario;

    @Before
    public void setDb() {

        this.usuario = new Usuario("test@test.com", "test", "test", "test", "test@test.com", "test.jpg");
        iUsuarioDao.save(usuario);
        this.persona = new Persona("Pablo", "Jimenez", new Date(), "M", "ORH+", "toni.jpg", this.usuario.getId());
        this.iPersonaDao.save(persona);
        
        personaDto = new PersonaDto();
        personaDto.setNombre("test");
        personaDto.setIdUsuario(1);
        personaDto.setActive(true);
        personaDto.setApellido("test");
        personaDto.setFechaNacimiento(new Date());
        personaDto.setGenero("test");
        personaDto.setGrupoSanguineo("test");

    }

    @Test
    public void testFindById() {

        assertEquals("Pablo", iPersonaDao.findById(this.persona.getId()).get().getNombre());

    }
    
    @Test
    public void testNotNombre() {
        
        this.personaDto.setNombre(null);
        assertTrue(personaCotroller.notNombre(this.personaDto));

     }
     
    @Test
     public void notApellido() {

        this.personaDto.setApellido("");
        assertTrue(personaCotroller.notApellido(this.personaDto));

      }
    
    @Test
     public void testNotFechaNacimiento() {
        this.personaDto.setFechaNacimiento(null);
        assertTrue(personaCotroller.notFechaNacimiento(   this.personaDto));

      }
     
    @Test
     public void testNotGenero() {
        this.personaDto.setGenero("");
        assertTrue(personaCotroller.notGenero(this.personaDto));


      }
     
    @Test
     public void testNotGrupoSanguineo() {
        this.personaDto.setGrupoSanguineo(null);
        assertTrue(personaCotroller.notGrupoSanguineo(this.personaDto));


      }
     
    @Test
     public void testNotIdUsuario() {
        this.personaDto.setIdUsuario(0);
        assertTrue(personaCotroller.notIdUsuario(personaDto));

      }
    
    @Test
    public void testNotDataPersona() {
       PersonaDto personaDtoTest = new PersonaDto();
       assertTrue(personaCotroller.notIdUsuario(personaDtoTest));

     }

    @After
    public void delete() {
        this.iUsuarioDao.delete(this.usuario);
        this.iPersonaDao.delete(this.persona);
    }

}
