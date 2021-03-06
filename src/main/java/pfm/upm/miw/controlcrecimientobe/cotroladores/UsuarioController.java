package pfm.upm.miw.controlcrecimientobe.cotroladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import pfm.upm.miw.controlcrecimientobe.daos.IRolDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioDao;
import pfm.upm.miw.controlcrecimientobe.daos.IUsuarioRolDao;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioDto;
import pfm.upm.miw.controlcrecimientobe.dtos.UsuarioRolDto;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;
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

        Rol rol = rolDao.findByCodigo("COSTUMER");
        Usuario usuario = new Usuario(usuarioDto.getUsername(), new BCryptPasswordEncoder().encode(usuarioDto.getPassword()),
                usuarioDto.getNombre(), usuarioDto.getApellido(), usuarioDto.getCorreo(), usuarioDto.getFoto());

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        usuarioDao.save(usuario);
        usuarioRolDao.save(usuarioRol);

    }

    public Optional<String> editarUsuario(String username, UsuarioDto usuarioDto) {
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario != null) {
            usuario.setApellido(usuarioDto.getApellido());
            usuario.setCorreo(usuarioDto.getCorreo());
            usuario.setFoto(usuarioDto.getFoto());
            usuario.setNombre(usuarioDto.getNombre());
            usuario.setPassword(usuarioDto.getPassword());
            usuario.setUsername(usuarioDto.getUsername());
            usuarioDao.save(usuario);
            return Optional.of("OK");

        } else {

            return Optional.of("No data Found >>>Usuario username: " + usuarioDto.getUsername());
        }

    }

    // TODO: Pendiente eliminar los personas ligadas a la persona
    @Transactional
    public Optional<String> eliminarUsuario(String username) {
        Usuario usuario = usuarioDao.findByUsername(username);

        if (usuario != null) {

            UsuarioRol ur = usuarioRolDao.findByUsuario(usuario);

            usuarioRolDao.delete(ur);
            usuarioDao.delete(usuario);

        } else {
            return Optional.of("No data Found >>>Usuario");
        }

        return Optional.of("OK");
    }

    public boolean usuarioExistente(String username) {
        Usuario usuario = usuarioDao.findByUsername(username);
        return usuario != null;
    }

    public Usuario getUsuario(String username) {

        return usuarioDao.findByUsername(username);
    }

    public UsuarioRolDto getUsuarioRol(String username, String password) {
        // TODO: Realizar clase independiente para encriptar y desencriptar
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UsuarioRol usuarioRol = usuarioRolDao.findByUsuario(usuarioDao.findByUsername(username));
        UsuarioRolDto usuarioRolDto = new UsuarioRolDto();
        if (usuarioRol != null) {
            usuarioRolDto.setUsername(usuarioRol.getUsuario().getUsername());
            if (encoder.matches(password, usuarioRol.getUsuario().getPassword())) {
                usuarioRolDto.setPassword(password);
            } else {
                usuarioRolDto.setPassword(usuarioRol.getUsuario().getPassword());
            }
            
            usuarioRolDto.setActivo(usuarioRol.getUsuario().getActivo());
            usuarioRolDto.setApellido(usuarioRol.getUsuario().getApellido());
            usuarioRolDto.setNombre(usuarioRol.getUsuario().getNombre());
            usuarioRolDto.setFoto(usuarioRol.getUsuario().getFoto());
            usuarioRolDto.setCorreo(usuarioRol.getUsuario().getCorreo());
            usuarioRolDto.setId(usuarioRol.getUsuario().getId());
            usuarioRolDto.setIdRol(usuarioRol.getRol().getId());
            usuarioRolDto.setCodigoRol(usuarioRol.getRol().getCodigo());
            usuarioRolDto.setNombreRol(usuarioRol.getRol().getNombre());

        }
        

        return usuarioRolDto;

    }

}
