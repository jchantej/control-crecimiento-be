package pfm.upm.miw.controlcrecimientobe.recursos;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.ControlCrecimientoController;
import pfm.upm.miw.controlcrecimientobe.dtos.ControlCrecimientoDto;
import pfm.upm.miw.controlcrecimientobe.entidades.ControlCrecimiento;



@RestController
@RequestMapping(ControlCrecimientoRecurso.CONTROLES)
public class ControlCrecimientoRecurso {

    public static final String CONTROLES = "/controles";


    @Autowired
    private ControlCrecimientoController controlCrecimientoController;

    @PostMapping
    public void crearControlCrecimiento(@Valid  @RequestBody ControlCrecimientoDto controlCrecimientoDto) {
      
        Optional<String> error = this.controlCrecimientoController.crearControlCrecimiento(controlCrecimientoDto);
        if (error.isPresent()) {
            System.out.println("Errrorrrr>>>>>>>>>>>>");
        }
        
    }
    
    @GetMapping
    public List<ControlCrecimiento> getControlesCrecimiento(int idPersona){
      return  this.controlCrecimientoController.getControlesCrecimiento(idPersona);
    }



}
