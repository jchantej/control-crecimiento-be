package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getTalla() {
        return talla;
    }

    public void setTalla(BigDecimal talla) {
        this.talla = talla;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ControlCrecimiento [id=" + id + ", edad=" + edad + ", peso=" + peso + ", talla=" + talla + ", fechaRegistro="
                + fechaRegistro + ", persona=" + persona + "]";
    }

}
