package pfm.upm.miw.controlcrecimientobe.entidades;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class PercentilOmsTest {
    @Test
    public void testSimple() {
        PercentilOms percentilOms = new PercentilOms(0, "M", "P", new BigDecimal(0.3487), new BigDecimal(3.3464), new BigDecimal(0.14602),
                new BigDecimal(2.507), new BigDecimal(2.865), new BigDecimal(3.346), new BigDecimal(3.878), new BigDecimal(4.35));

        assertEquals(0, percentilOms.getEdad());
        assertEquals("P", percentilOms.getTipoPercenetil());
        assertEquals(new BigDecimal(0.3487), percentilOms.getIndicadorSimetria());
        assertEquals(new BigDecimal(2.507), percentilOms.getPercentil3());
        assertEquals(new BigDecimal(4.35), percentilOms.getPercentil97());

    }

}
