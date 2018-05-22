package pfm.upm.miw.controlcrecimientobe.entidades;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PercentilCrecimientoTest {

    ControlCrecimiento controlCrecimiento;

    PercentilOms percentilOms;

    Persona persona;

    @Before
    public void setData() {
        this.persona = new Persona("Pablo", "Jimenez", new Date(), "M", "ORH+", "toni.jpg", 1);
        this.controlCrecimiento = new ControlCrecimiento(791, new BigDecimal(12.5), new BigDecimal(85.00), this.persona);
        this.percentilOms = new PercentilOms(0, "M", "P", new BigDecimal(0.3487), new BigDecimal(3.3464), new BigDecimal(0.14602),
                new BigDecimal(2.507), new BigDecimal(2.865), new BigDecimal(3.346), new BigDecimal(3.878), new BigDecimal(4.35));
    }

    @Test
    public void testSimple() {

        PercentilCrecimiento percentilCrecimiento = new PercentilCrecimiento(this.controlCrecimiento, this.percentilOms, "recomendacion",
                "observacion");
        assertEquals(791, percentilCrecimiento.getControlCrecimiento().getEdad());
        assertEquals(new BigDecimal(85.00), percentilCrecimiento.getControlCrecimiento().getTalla());
        assertEquals(0, percentilCrecimiento.getPercentilOms().getEdad());
        assertEquals("M", percentilCrecimiento.getPercentilOms().getGenero());
        assertEquals("Pablo", percentilCrecimiento.getControlCrecimiento().getPersona().getNombre());
        assertEquals("M", percentilCrecimiento.getControlCrecimiento().getPersona().getGenero());

    }

}
