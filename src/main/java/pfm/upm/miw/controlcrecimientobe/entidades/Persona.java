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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", genero="
                + genero + ", grupoSanguineo=" + grupoSanguineo + ", foto=" + foto + ", fechaRegistro=" + fechaRegistro + ", idUsuario="
                + idUsuario + "]";
    }

}
