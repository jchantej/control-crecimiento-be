package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Persona implements Serializable {


    private static final long serialVersionUID = -7750270148622468152L;

    @Id
    @GeneratedValue
    private int id;
    
    private String nombre;

    private String apellido;

    private Date fechaNacimiento;
    
    private String genero;

    private String grupoSanguineo;

    private String foto;

    private Date fechaRegistro;
    
    private int idUsuario;
    

    public Persona() {
    }


}
