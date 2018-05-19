package pfm.upm.miw.controlcrecimientobe.cotroladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pfm.upm.miw.controlcrecimientobe.daos.IPersonaDao;
import pfm.upm.miw.controlcrecimientobe.dtos.PersonaDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;

@Controller
public class PersonaController {

    @Autowired
    private IPersonaDao personaDao;

    public void crearPersona(PersonaDto personaDto) {
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(), personaDto.getFechaNacimiento(),
                personaDto.getGenero(), personaDto.getGrupoSanguineo(), personaDto.getFoto(), personaDto.getIdUsuario());

        this.personaDao.save(persona);
    }
    

    public List<Persona> getPersonas() {
        
        return this.personaDao.findAll();
    }
    
    
    
    public boolean notNombre(PersonaDto personaDto) {
       return personaDto.getNombre() == null || personaDto.getNombre().equals("");

    }
    
    public boolean notApellido(PersonaDto personaDto) {
        return personaDto.getApellido() == null || personaDto.getApellido().equals("");

     }
    
    public boolean notFechaNacimiento(PersonaDto personaDto) {
        return personaDto.getFechaNacimiento() == null || personaDto.getFechaNacimiento().equals("");

     }
    
    public boolean notGenero(PersonaDto personaDto) {
        return personaDto.getGenero() == null || personaDto.getGenero().equals("");

     }
    
    public boolean notGrupoSanguineo(PersonaDto personaDto) {
        return personaDto.getGrupoSanguineo() == null || personaDto.getGrupoSanguineo().equals("");

     }
    
    public boolean notIdUsuario(PersonaDto personaDto) {
        return personaDto.getIdUsuario() <= 0 ;

     }
    public boolean notDataPersona(PersonaDto personaDto) {
        return personaDto.equals(null) ;

     }

}
