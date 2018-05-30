package pfm.upm.miw.controlcrecimientobe.dtos;


import java.util.Date;

public class UsuarioDto{




    private int id;

    private String username;

    private String password;

    private String nombre;

    private String apellido;

    private String correo;

    private String foto;

    private Boolean activo;

    private Date fechaRegistro;
    
    public UsuarioDto() {
        //Empty for framework
    }

    public UsuarioDto(String username, String password, String nombre, String apellido, String correo, String foto) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.foto = foto;

    }
    
    public UsuarioDto(String username, String password) {
        this.username = username;
        this.password = password;
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.foto = "";

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

    @Override
    public String toString() {
        return "UsuarioDto [id=" + id + ", username=" + username + ", password=" + password + ", nombre=" + nombre + ", apellido="
                + apellido + ", correo=" + correo + ", foto=" + foto + ", activo=" + activo + ", fechaRegistro=" + fechaRegistro + "]";
    }
    
    



}
