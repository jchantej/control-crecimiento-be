package pfm.upm.miw.controlcrecimientobe.recursos;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.PersonaController;
import pfm.upm.miw.controlcrecimientobe.dtos.PersonaDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;
import pfm.upm.miw.controlcrecimientobe.recursos.exepciones.NotFieldDataPersonaException;

@RestController
@RequestMapping(PersonaRecurso.PERSONAS)
public class PersonaRecurso {

    public static final String PERSONAS = "/personas";

    public static final String USUARIO = "/usuario";

    public static final String ID = "/{id}";

    @Autowired
    private PersonaController personaController;

    @RequestMapping(method = RequestMethod.POST)
    public void crearPersona(@Valid @RequestBody PersonaDto personaDto) throws NotFieldDataPersonaException {

        if (this.personaController.notDataPersona(personaDto)) {
            throw new NotFieldDataPersonaException("Falta la data completa");
        }

        if (this.personaController.notNombre(personaDto)) {
            throw new NotFieldDataPersonaException("Falta el nombre");
        }

        if (this.personaController.notApellido(personaDto)) {
            throw new NotFieldDataPersonaException("Falta el apellido");
        }

        if (this.personaController.notFechaNacimiento(personaDto)) {
            throw new NotFieldDataPersonaException("Falta fecha de nacimiento");
        }

        if (this.personaController.notGenero(personaDto)) {
            throw new NotFieldDataPersonaException("Falta el genero");
        }

        if (this.personaController.notGrupoSanguineo(personaDto)) {
            throw new NotFieldDataPersonaException("Falta el grupo sanguineo");
        }

        if (this.personaController.notIdUsuario(personaDto)) {
            throw new NotFieldDataPersonaException("Falta el id Usuario");
        }

        this.personaController.crearPersona(personaDto);
    }

    @GetMapping
    public List<Persona> getPersonas() {
        return this.personaController.getPersonas();
    }

    @GetMapping(value = USUARIO + ID)
    public List<PersonaDto> getPersonasIdUsuario(@PathVariable int id) {

        return this.personaController.getPersonasIdUsuario(id);
    }

    @GetMapping(value = ID)
    public Optional<Persona> getPersona(@PathVariable int id) {

        return this.personaController.getPersona(id);
    }

    @PutMapping(value = ID)
    public Optional<String> actualizarPersona(@PathVariable int id, @RequestBody PersonaDto personaDto) {

        return this.personaController.editarPersona(id, personaDto);
    }
    
    @DeleteMapping(value = ID)
    public Optional<String> eliminarPersona(@PathVariable int id) {

        return this.personaController.eliminarPersona(id);
    }

}
