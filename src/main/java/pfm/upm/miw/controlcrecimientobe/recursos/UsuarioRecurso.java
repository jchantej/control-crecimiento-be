package pfm.upm.miw.controlcrecimientobe.recursos;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.UsuarioController;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioDto;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioRolDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;
import pfm.upm.miw.controlcrecimientobe.recursos.exepciones.UsuarioExistenteException;

@RestController
@RequestMapping(UsuarioRecurso.USUARIOS)
public class UsuarioRecurso {

    public static final String USUARIOS = "/usuarios";

    public static final String USERNAME = "/{username}";

    public static final String USUARIOROL = "/usuariorol";
    
    public static final String LOGIN = "/login";


    @Autowired
    private UsuarioController usuarioController;

    @RequestMapping(method = RequestMethod.POST)
    public void crearUsuario(@Valid @RequestBody UsuarioDto usuarioDto) throws UsuarioExistenteException {

        if (this.usuarioController.usuarioExistente(usuarioDto.getUsername())) {
            throw new UsuarioExistenteException(" >>> " + usuarioDto.getUsername());
        }

        this.usuarioController.crearUsuario(usuarioDto);
    }
    
    

    @PutMapping(value = USERNAME)
    public Optional<String> editarUsuario(@PathVariable String username, @RequestBody UsuarioDto usuarioDto) {

        return this.usuarioController.editarUsuario(username, usuarioDto);
    }
    
    @DeleteMapping(value = USERNAME)
    public Optional<String> eliminarUsuario(@PathVariable String username) {

        return this.usuarioController.eliminarUsuario(username);
    }


    @GetMapping(value = USERNAME)
    public Usuario getUsuario(@PathVariable String username) {

        return this.usuarioController.getUsuario(username);

    }

    @GetMapping(value = LOGIN)
    public UsuarioRolDto getUsuarioRol(@RequestParam String username, @RequestParam String password) {

        return this.usuarioController.getUsuarioRol(username, password);

    }

}
