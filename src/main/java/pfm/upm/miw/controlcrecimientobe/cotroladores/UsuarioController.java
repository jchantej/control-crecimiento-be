package pfm.upm.miw.controlcrecimientobe.cotroladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import pfm.upm.miw.controlcrecimientobe.daos.IRolDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioRolDao;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Rol;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;
import pfm.upm.miw.controlcrecimientobe.entidades.UsuarioRol;

@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IRolDao rolDao;

    @Autowired
    private IUsuarioRolDao usuarioRolDao;
    
    @Transactional
    public void crearUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = usuarioDao.findByUsername(usuarioDto.getUsername());
        Rol rol = rolDao.findByCodigo("COSTUMER");

        if (usuario == null) {

            usuario = new Usuario(usuarioDto.getUsername(), usuarioDto.getPassword(), usuarioDto.getNombre(), usuarioDto.getApellido(),
                    usuarioDto.getCorreo(), usuarioDto.getFoto());

            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setRol(rol);
            usuarioRol.setUsuario(usuario);
            usuarioDao.save(usuario);
            usuarioRolDao.save(usuarioRol);

        } else {

            // TODO: Aqui exception controlada para cuando el usuario ya exista
        }
    }
    

}
