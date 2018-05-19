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
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.dtos.PersonaDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;
import pfm.upm.miw.controlcrecimientobe.recursos.PersonaRecurso;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class PersonaResourceFunctionalTesting {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;

    @Autowired
    private IUsuarioDao iUsuarioDao;

    private PersonaDto personaDto;

    private Usuario usuario;

    @Before
    public void before() {
        this.usuario = iUsuarioDao.findByUsername("test1");
        this.personaDto = new PersonaDto("Pablo", "Jimenez", new Date(), "M", "ORH+", "toni.jpg", usuario.getId());


    }

    @Test
    public void testCrearPersona() {
        restService.restBuilder().path(PersonaRecurso.PERSONAS).body(this.personaDto).post().build();
    }

    @Test
    public void testCrearPersonaNotDataException() {
        thrown.expect(new HttpMatcher(HttpStatus.BAD_REQUEST));
        PersonaDto personaDtoTest = new PersonaDto();
        restService.restBuilder().path(PersonaRecurso.PERSONAS).body(personaDtoTest).post().build();
    }
    
    @Test
    public void testCrearPersonaNotNombreException() {
        thrown.expect(new HttpMatcher(HttpStatus.BAD_REQUEST));
        this.personaDto.setNombre("");
        restService.restBuilder().path(PersonaRecurso.PERSONAS).body(this.personaDto).post().build();
    }
    @Test
    public void testCrearPersonaNotApellidoException() {
        thrown.expect(new HttpMatcher(HttpStatus.BAD_REQUEST));
        this.personaDto.setApellido(null);
        restService.restBuilder().path(PersonaRecurso.PERSONAS).body(this.personaDto).post().build();
    }

    @Test
    public void testCrearPersonaNotFechaNacimientoException() {
        thrown.expect(new HttpMatcher(HttpStatus.BAD_REQUEST));
        this.personaDto.setFechaNacimiento(null);
        restService.restBuilder().path(PersonaRecurso.PERSONAS).body(this.personaDto).post().build();
    }

    @Test
    public void testCrearPersonaNoteneroException() {
        thrown.expect(new HttpMatcher(HttpStatus.BAD_REQUEST));
        this.personaDto.setGenero("");
        restService.restBuilder().path(PersonaRecurso.PERSONAS).body(this.personaDto).post().build();
    }

    @Test
    public void testCrearPersonaNotGrupoSanguineoException() {
        thrown.expect(new HttpMatcher(HttpStatus.BAD_REQUEST));
        this.personaDto.setGrupoSanguineo(null);
        restService.restBuilder().path(PersonaRecurso.PERSONAS).body(this.personaDto).post().build();
    }
    
    @Test
    public void testCrearPersonaNotIdUsuarioException() {
        thrown.expect(new HttpMatcher(HttpStatus.BAD_REQUEST));
        this.personaDto.setIdUsuario(0);
        restService.restBuilder().path(PersonaRecurso.PERSONAS).body(this.personaDto).post().build();
    }


}
