package pfm.upm.miw.controlcrecimientobe.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import pfm.upm.miw.controlcrecimientobe.entidades.ControlCrecimiento;


public interface IControlCrecimientoDao extends JpaRepository<ControlCrecimiento, Integer> {
    

}
