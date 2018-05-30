package pfm.upm.miw.controlcrecimientobe.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import pfm.upm.miw.controlcrecimientobe.entidades.Rol;



public interface IRolDao  extends JpaRepository<Rol, Integer>{
    
    public Rol findByCodigo(String codigo);

}
