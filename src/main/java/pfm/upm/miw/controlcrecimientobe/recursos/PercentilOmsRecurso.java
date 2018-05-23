package pfm.upm.miw.controlcrecimientobe.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pfm.upm.miw.controlcrecimientobe.cotroladores.PercentilOmsController;
import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;




@RestController
@RequestMapping(PercentilOmsRecurso.PERCENTILES)
public class PercentilOmsRecurso {

    public static final String PERCENTILES = "/percentiles";
    public static final String GENEROTIPO = "/generotipo";


    @Autowired
    private PercentilOmsController percentilOmsController;
    
   
    
    @GetMapping(value = GENEROTIPO)
    public List<PercentilOms> getPercentiles(@RequestParam String genero, @RequestParam String tipo){
      return  this.percentilOmsController.getPercentiles(genero, tipo);
    }
    
    

    @GetMapping
    public List<PercentilOms> getAllPercentiles(){
      return  this.percentilOmsController.getAllPercentiles();
    }
    

}
