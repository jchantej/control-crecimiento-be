package pfm.upm.miw.controlcrecimientobe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pfm.upm.miw.controlcrecimientobe.entidades.Persona;


public interface IPersonaDao extends JpaRepository<Persona, Integer> {
    
    public Persona findByNombre(String nombre);
    public List<Persona> findByIdUsuarioAndActivoTrue(int  idUsuario);

}
