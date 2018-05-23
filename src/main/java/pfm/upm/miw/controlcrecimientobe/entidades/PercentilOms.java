package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class PercentilOms implements Serializable {


    private static final long serialVersionUID = 3687215337326275362L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int edad;

    private String genero;

    private String tipo;

    private BigDecimal indicadorSimetria;

    private BigDecimal mediana;

    private BigDecimal coeficienteVariacion;

    private BigDecimal percentil3;

    private BigDecimal percentil15;

    private BigDecimal percentil50;

    private BigDecimal percentil85;

    private BigDecimal percentil97;

    private Date fechaRegistro;

    public PercentilOms() {
        this.fechaRegistro = new Date();
    }
    
    

    public PercentilOms(int edad, String genero, String tipo, BigDecimal indicadorSimetria, BigDecimal mediana,
            BigDecimal coeficienteVariacion, BigDecimal percentil3, BigDecimal percentil15, BigDecimal percentil50, BigDecimal percentil85,
            BigDecimal percentil97) {
        this();
        this.edad = edad;
        this.genero = genero;
        this.tipo = tipo;
        this.indicadorSimetria = indicadorSimetria;
        this.mediana = mediana;
        this.coeficienteVariacion = coeficienteVariacion;
        this.percentil3 = percentil3;
        this.percentil15 = percentil15;
        this.percentil50 = percentil50;
        this.percentil85 = percentil85;
        this.percentil97 = percentil97;
    }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipoPercenetil(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getIndicadorSimetria() {
        return indicadorSimetria;
    }

    public void setIndicadorSimetria(BigDecimal indicadorSimetria) {
        this.indicadorSimetria = indicadorSimetria;
    }

    public BigDecimal getMediana() {
        return mediana;
    }

    public void setMediana(BigDecimal mediana) {
        this.mediana = mediana;
    }

    public BigDecimal getCoeficienteVariacion() {
        return coeficienteVariacion;
    }

    public void setCoeficienteVariacion(BigDecimal coeficienteVariacion) {
        this.coeficienteVariacion = coeficienteVariacion;
    }

    public BigDecimal getPercentil3() {
        return percentil3;
    }

    public void setPercentil3(BigDecimal percentil3) {
        this.percentil3 = percentil3;
    }

    public BigDecimal getPercentil15() {
        return percentil15;
    }

    public void setPercentil15(BigDecimal percentil15) {
        this.percentil15 = percentil15;
    }

    public BigDecimal getPercentil50() {
        return percentil50;
    }

    public void setPercentil50(BigDecimal percentil50) {
        this.percentil50 = percentil50;
    }

    public BigDecimal getPercentil85() {
        return percentil85;
    }

    public void setPercentil85(BigDecimal percentil85) {
        this.percentil85 = percentil85;
    }

    public BigDecimal getPercentil97() {
        return percentil97;
    }

    public void setPercentil97(BigDecimal percentil97) {
        this.percentil97 = percentil97;
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
        return "PercentilOms [id=" + id + ", edad=" + edad + ", genero=" + genero + ", tipoPercenetil=" + tipo
                + ", indicadorSimetria=" + indicadorSimetria + ", mediana=" + mediana + ", coeficienteVariacion=" + coeficienteVariacion
                + ", percentil3=" + percentil3 + ", percentil15=" + percentil15 + ", percentil50=" + percentil50 + ", percentil85="
                + percentil85 + ", percentil97=" + percentil97 + ", fechaRegistro=" + fechaRegistro + "]";
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
        PercentilOms other = (PercentilOms) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
    

}
