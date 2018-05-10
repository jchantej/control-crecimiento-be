package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
public class Rol implements Serializable {
    
    
    private static final long serialVersionUID = 5537479386030959048L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String codigo;
    
    private String nombre;

    private Boolean estado;
    
    private Date fecharegistro;


    
    public Rol() {
    }

}
