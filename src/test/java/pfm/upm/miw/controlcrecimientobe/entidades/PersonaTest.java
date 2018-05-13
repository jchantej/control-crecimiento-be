package pfm.upm.miw.controlcrecimientobe.entidades;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import java.util.Date;

public class PersonaTest {

    @Test
    public void testSimple() {
        Persona persona = new Persona("Pablo", "Jimenez", new Date(), "M", "ORH+", "toni.jpg", 1);
        assertEquals("Pablo", persona.getNombre());
        assertEquals("Jimenez", persona.getApellido());
        assertEquals("M", persona.getGenero());
    }

}
