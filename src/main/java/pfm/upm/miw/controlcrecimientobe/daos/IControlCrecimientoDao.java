package pfm.upm.miw.controlcrecimientobe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfm.upm.miw.controlcrecimientobe.entidades.ControlCrecimiento;


public interface IControlCrecimientoDao extends JpaRepository<ControlCrecimiento, Integer> {    
    
    public List<ControlCrecimiento> findByPersonaIdOrderByFechaRegistroDesc(int idPersona);

}



