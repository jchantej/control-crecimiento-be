package pfm.upm.miw.controlcrecimientobe.dtos;

import java.util.Date;

public class UsuarioRolDto {

    private int id;

    private String username;

    private String password;

    private String nombre;

    private String apellido;

    private String correo;

    private String foto;

    private Boolean activo;

    private Date fechaRegistro;

    private int idRol;

    private String codigoRol;

    private String nombreRol;

    public UsuarioRolDto() {
        // Empty for framework
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(String codigoRol) {
        this.codigoRol = codigoRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "UsuarioRolDto [id=" + id + ", username=" + username + ", password=" + password + ", nombre=" + nombre + ", apellido="
                + apellido + ", correo=" + correo + ", foto=" + foto + ", activo=" + activo + ", fechaRegistro=" + fechaRegistro
                + ", idRol=" + idRol + ", codigoRol=" + codigoRol + ", nombreRol=" + nombreRol + "]";
    }

}
