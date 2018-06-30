package pfm.upm.miw.controlcrecimientobe.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class ControlCrecimientoDto {

    private int id;

    private int edad;

    private BigDecimal peso;

    private BigDecimal talla;

    private String edadPeriodo;

    private String observacionPeso;

    private String observacionTalla;

    private Date fechaRegistro;

    private int idPersona;

    public ControlCrecimientoDto() {
        // Empty para el framework spring
    }

    public ControlCrecimientoDto(BigDecimal peso, BigDecimal talla, int idPersona) {
        this.peso = peso;
        this.talla = talla;
        this.idPersona = idPersona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEdadPeriodo() {
        return edadPeriodo;
    }

    public void setEdadPeriodo(String edadPeriodo) {
        this.edadPeriodo = edadPeriodo;
    }
    
    

    public String getObservacionPeso() {
        return observacionPeso;
    }

    public void setObservacionPeso(String observacionPeso) {
        this.observacionPeso = observacionPeso;
    }

    public String getObservacionTalla() {
        return observacionTalla;
    }

    public void setObservacionTalla(String observacionTalla) {
        this.observacionTalla = observacionTalla;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "ControlCrecimientoDto [id=" + id + ", edad=" + edad + ", peso=" + peso + ", talla=" + talla + ", edadPeriodo=" + edadPeriodo
                + ", observacionPeso=" + observacionPeso + ", observacionTalla=" + observacionTalla + ", fechaRegistro=" + fechaRegistro
                + ", idPersona=" + idPersona + "]";
    }
    



}
