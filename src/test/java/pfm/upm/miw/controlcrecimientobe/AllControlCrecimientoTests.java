package pfm.upm.miw.controlcrecimientobe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pfm.upm.miw.controlcrecimientobe.daos.AllDaosIntegrationTests;
import pfm.upm.miw.controlcrecimientobe.entidades.AllEntidadesTests;


@RunWith(Suite.class)
@SuiteClasses({
    AllEntidadesTests.class,
    AllDaosIntegrationTests.class,    
})
public class AllControlCrecimientoTests {
       
}
