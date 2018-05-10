package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 2446079007438298704L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    private String password;

    private String nombre;

    private String apellido;

    private String correo;

    private String foto;

    private Boolean activo;

    private Date fechaRegistro;

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido
                + ", correo=" + correo + ", foto=" + foto + ", activo=" + activo + ", fechaRegistro=" + fechaRegistro + "]";
    }

}
