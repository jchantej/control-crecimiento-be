package pfm.upm.miw.controlcrecimientobe.servicios;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pfm.upm.miw.controlcrecimientobe.utils.CalculoEdadTest;

@RunWith(Suite.class)
@SuiteClasses({
    DatabaseSeederServiceIT.class,    
})

public class AllServiciosIntegrationTests {

}
