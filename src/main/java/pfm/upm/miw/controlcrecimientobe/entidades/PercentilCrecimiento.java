package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the percentilestaturaoms database table.
 * 
 */
@Entity
public class PercentilCrecimiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_control_crecimiento")
    private ControlCrecimiento controlCrecimiento;
    
    @ManyToOne
    @JoinColumn(name = "id_percentil_oms")
    private PercentilOms percentilOms;
    
    private String observacion;
    private String recomendacion;
    
    private Date fechaRegistro;

    public PercentilCrecimiento() {
    }

}
