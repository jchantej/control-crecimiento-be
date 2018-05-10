package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class ControlCrecimiento implements Serializable {

    private static final long serialVersionUID = 7288977592736498051L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int edad;

    private BigDecimal peso;

    private BigDecimal talla;

    private Date fechaRegistro;

    @ManyToOne
    private Persona persona;

    public ControlCrecimiento() {
    }

}
