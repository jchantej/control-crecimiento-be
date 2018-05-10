package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class PercentilOms implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String edad;

    private String genero;

    private String tipoPercenetil; // Peso, Talla, IMC

    private BigDecimal indicadorSimetriaL;

    private BigDecimal medianaM;

    private BigDecimal coeficienteVariacionS;

    private BigDecimal percentil3;

    private BigDecimal percentil15;

    private BigDecimal percentil50;

    private BigDecimal percentil85;

    private BigDecimal percentil97;
    
    private Date fechaRegistro;

    public PercentilOms() {
    }

}
