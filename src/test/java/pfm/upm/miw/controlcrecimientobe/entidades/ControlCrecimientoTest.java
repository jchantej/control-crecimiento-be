package pfm.upm.miw.controlcrecimientobe.entidades;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ControlCrecimientoTest {

    Persona persona;

    @Before
    public void setData() {
        this.persona = new Persona("Pablo", "Jimenez", new Date(), "M", "ORH+", "toni.jpg", 1);

    }

    @Test
    public void testSimple() {

        ControlCrecimiento controlCrecimiento = new ControlCrecimiento(791, new BigDecimal(12.5), new BigDecimal(85.00), this.persona);
        assertEquals(791, controlCrecimiento.getEdad());
        assertEquals(new BigDecimal(85.00), controlCrecimiento.getTalla());
        assertEquals(new BigDecimal(12.5), controlCrecimiento.getPeso());
        assertEquals("Pablo", controlCrecimiento.getPersona().getNombre());
        assertEquals("M", controlCrecimiento.getPersona().getGenero());

    }

}
