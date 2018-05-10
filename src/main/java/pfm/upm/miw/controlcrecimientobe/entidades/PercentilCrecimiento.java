package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class PercentilCrecimiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_control_crecimiento")
    private ControlCrecimiento controlCrecimiento;

    @ManyToOne
    @JoinColumn(name = "id_percentil_oms")
    private PercentilOms percentilOms;

    private String observacion;

    private String recomendacion;

    private Date fechaRegistro;

    public PercentilCrecimiento() {
    }

    public ControlCrecimiento getControlCrecimiento() {
        return controlCrecimiento;
    }

    public void setControlCrecimiento(ControlCrecimiento controlCrecimiento) {
        this.controlCrecimiento = controlCrecimiento;
    }

    public PercentilOms getPercentilOms() {
        return percentilOms;
    }

    public void setPercentilOms(PercentilOms percentilOms) {
        this.percentilOms = percentilOms;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
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
        return "PercentilCrecimiento [id=" + id + ", controlCrecimiento=" + controlCrecimiento + ", percentilOms=" + percentilOms
                + ", observacion=" + observacion + ", recomendacion=" + recomendacion + ", fechaRegistro=" + fechaRegistro + "]";
    }

}
