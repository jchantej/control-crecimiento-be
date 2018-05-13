package pfm.upm.miw.controlcrecimientobe.recursos;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.PersonaCotroller;
import pfm.upm.miw.controlcrecimientobe.dtos.PersonaDto;



@RestController
@RequestMapping(PersonaRecurso.PERSONAS)
public class PersonaRecurso {

    public static final String PERSONAS = "/personas";


    @Autowired
    private PersonaCotroller personaController;

    @PostMapping
    public void crearPersona(@Valid @RequestBody PersonaDto personaDto)  {

        this.personaController.crearPersona(personaDto);
    }


}
