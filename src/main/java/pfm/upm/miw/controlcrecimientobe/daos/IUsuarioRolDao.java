package pfm.upm.miw.controlcrecimientobe.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;
import pfm.upm.miw.controlcrecimientobe.entidades.UsuarioRol;

public interface IUsuarioRolDao extends JpaRepository<UsuarioRol, Integer> {

    public UsuarioRol findByUsuario(Usuario usuario);
}
