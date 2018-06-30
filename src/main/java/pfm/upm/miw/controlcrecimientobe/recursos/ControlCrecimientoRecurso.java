package pfm.upm.miw.controlcrecimientobe.recursos;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.ControlCrecimientoController;
import pfm.upm.miw.controlcrecimientobe.dtos.ControlCrecimientoDto;
import pfm.upm.miw.controlcrecimientobe.recursos.exepciones.NotFieldDataControlCrecimientoException;

@RestController
@RequestMapping(ControlCrecimientoRecurso.CONTROLES)
public class ControlCrecimientoRecurso {

    public static final String CONTROLES = "/controles";

    public static final String PERSONA = "/persona";

    public static final String ID = "/{id}";

    @Autowired
    private ControlCrecimientoController controlCrecimientoController;

    @PostMapping
    public void crearControlCrecimiento(@Valid @RequestBody ControlCrecimientoDto controlCrecimientoDto)
            throws NotFieldDataControlCrecimientoException {

        if (this.controlCrecimientoController.notIdPersona(controlCrecimientoDto)) {
            throw new NotFieldDataControlCrecimientoException("Falta Id de la persona");
        }

        if (this.controlCrecimientoController.notTalla(controlCrecimientoDto)) {
            throw new NotFieldDataControlCrecimientoException("Falta la talla");
        }

        if (this.controlCrecimientoController.notPeso(controlCrecimientoDto)) {
            throw new NotFieldDataControlCrecimientoException("Falta el peso");
        }

        Optional<String> error = this.controlCrecimientoController.crearControlCrecimiento(controlCrecimientoDto);
        if (error.isPresent()) {
            throw new NotFieldDataControlCrecimientoException(error.get());
        }

    }

    @PutMapping(value = ID)
    public Optional<String> editarControlCrecimiento(@PathVariable int id, @RequestBody ControlCrecimientoDto controlCrecimientoDto) {

        return this.controlCrecimientoController.editarControlCrecimiento(id, controlCrecimientoDto);
    }

    @GetMapping(value = PERSONA + ID)
    public List<ControlCrecimientoDto> getControlesCrecimiento(@PathVariable int id) {

        return this.controlCrecimientoController.getControlesCrecimiento(id);
    }

}
