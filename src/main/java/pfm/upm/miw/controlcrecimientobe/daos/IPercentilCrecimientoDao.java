package pfm.upm.miw.controlcrecimientobe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfm.upm.miw.controlcrecimientobe.entidades.ControlCrecimiento;
import pfm.upm.miw.controlcrecimientobe.entidades.PercentilCrecimiento;

public interface IPercentilCrecimientoDao extends JpaRepository<PercentilCrecimiento, Integer> {   
    
    public List<PercentilCrecimiento> findByControlCrecimiento(ControlCrecimiento controlCrecimiento);
    

}
