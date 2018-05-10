package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Rol implements Serializable {

    private static final long serialVersionUID = 5537479386030959048L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigo;

    private String nombre;

    private Boolean estado;

    private Date fecharegistro;

    public Rol() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Rol [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", fecharegistro=" + fecharegistro
                + "]";
    }

}
