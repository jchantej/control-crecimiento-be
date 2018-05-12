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

    private Boolean activo;

    private int idUsuario;

    public Persona() {

        this.fechaRegistro = new Date();
        this.activo = true;

    }

    public Persona(String nombre, String apellido, Date fechaNacimiento, String genero, String grupoSanguineo, String foto,
            int idUsuario) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.grupoSanguineo = grupoSanguineo;
        this.foto = foto;
        this.idUsuario = idUsuario;
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

    public Boolean getActive() {
        return activo;
    }

    public void setActive(Boolean active) {
        this.activo = active;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", genero="
                + genero + ", grupoSanguineo=" + grupoSanguineo + ", foto=" + foto + ", fechaRegistro=" + fechaRegistro + ", active="
                + activo + ", idUsuario=" + idUsuario + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
