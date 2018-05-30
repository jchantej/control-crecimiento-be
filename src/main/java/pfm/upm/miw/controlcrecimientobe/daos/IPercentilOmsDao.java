package pfm.upm.miw.controlcrecimientobe.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;

public interface IPercentilOmsDao extends JpaRepository<PercentilOms, Integer> {

    public List<PercentilOms> findByEdadAndGenero(int edad, String genero);

    @Query("select p from PercentilOms p where p.genero = ?1 and p.tipo = ?2 and p.edad between 0 and ?3 ")
    public List<PercentilOms> findByGeneroAndTipoAndEdadBetweenCeroAndEdad(String genero, String tipo, int edad);

}
