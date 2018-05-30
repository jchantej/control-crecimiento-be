package pfm.upm.miw.controlcrecimientobe.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.UsuarioController;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioDto;

@RestController
@RequestMapping(UsuarioRecurso.USUARIOS)
public class UsuarioRecurso {

    public static final String USUARIOS = "/usuarios";

    @Autowired
    private UsuarioController usuarioController;

    @PostMapping
    public void crearUsuario(@RequestBody UsuarioDto usuarioDto) {
        this.usuarioController.crearUsuario(usuarioDto);
    }

}
