package pfm.upm.miw.controlcrecimientobe.recursos;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.PersonaController;
import pfm.upm.miw.controlcrecimientobe.dtos.PersonaDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;



@RestController
@RequestMapping(PersonaRecurso.PERSONAS)
public class PersonaRecurso {

    public static final String PERSONAS = "/personas";


    @Autowired
    private PersonaController personaController;

    @RequestMapping(method = RequestMethod.POST)
    public void crearPersona(@RequestBody PersonaDto personaDto)  {

        this.personaController.crearPersona(personaDto);
    }
    
    @GetMapping
    public List<Persona> getPersonas(){
      return  this.personaController.getPersonas();
    }



}
