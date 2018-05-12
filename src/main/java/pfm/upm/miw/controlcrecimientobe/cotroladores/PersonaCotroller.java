package pfm.upm.miw.controlcrecimientobe.cotroladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pfm.upm.miw.controlcrecimientobe.daos.IPersonaDao;
import pfm.upm.miw.controlcrecimientobe.dtos.PersonaDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;

@Controller
public class PersonaCotroller {

    @Autowired
    private IPersonaDao personaDao;

    public void crearPersona(PersonaDto personaDto) {
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(), personaDto.getFechaNacimiento(),
                personaDto.getGenero(), personaDto.getGrupoSanguineo(), personaDto.getFoto(), personaDto.getIdUsuario());

        this.personaDao.save(persona);
    }

}
