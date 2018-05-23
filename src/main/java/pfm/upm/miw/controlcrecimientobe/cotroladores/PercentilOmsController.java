package pfm.upm.miw.controlcrecimientobe.cotroladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pfm.upm.miw.controlcrecimientobe.daos.IPercentilOmsDao;
import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;

@Controller
public class PercentilOmsController {

    @Autowired
    private IPercentilOmsDao iPercentilOmsDao;

    public List<PercentilOms> getPercentiles(String genero, String tipo) {

        return iPercentilOmsDao.findByGeneroAndTipo(genero, tipo);
    }
    
    public List<PercentilOms> getAllPercentiles() {

        return iPercentilOmsDao.findAll();
    }
}
