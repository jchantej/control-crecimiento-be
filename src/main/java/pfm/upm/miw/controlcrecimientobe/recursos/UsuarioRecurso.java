package pfm.upm.miw.controlcrecimientobe.recursos;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.UsuarioController;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioDto;
import pfm.upm.miw.controlcrecimientobe.recursos.exepciones.UsuarioExistenteException;


@RestController
@RequestMapping(UsuarioRecurso.USUARIOS)
public class UsuarioRecurso {

    public static final String USUARIOS = "/usuarios";

    @Autowired
    private UsuarioController usuarioController;

    @RequestMapping(method = RequestMethod.POST)
    public void crearUsuario(@Valid @RequestBody UsuarioDto usuarioDto) throws UsuarioExistenteException {
        
        if (this.usuarioController.usuarioExistente(usuarioDto.getUsername())) {
            throw new UsuarioExistenteException(" >>> " + usuarioDto.getUsername());
        }
        
        this.usuarioController.crearUsuario(usuarioDto);
    }

}
