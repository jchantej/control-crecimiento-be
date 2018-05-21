package pfm.upm.miw.controlcrecimientobe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;

public interface IPercentilOmsDao extends JpaRepository<PercentilOms, Integer>{
    
    public List<PercentilOms> findByEdadAndGenero(int edad, String genero);

}
