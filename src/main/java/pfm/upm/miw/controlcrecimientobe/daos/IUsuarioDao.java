package pfm.upm.miw.controlcrecimientobe.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;


public interface IUsuarioDao  extends JpaRepository<Usuario, Integer>{
    
    public Usuario findByUsername(String username);

}
