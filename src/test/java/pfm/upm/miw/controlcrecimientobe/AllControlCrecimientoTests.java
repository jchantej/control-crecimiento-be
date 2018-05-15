package pfm.upm.miw.controlcrecimientobe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pfm.upm.miw.controlcrecimientobe.cotroladores.AllCotrollersIntegrationTests;
import pfm.upm.miw.controlcrecimientobe.daos.AllDaosIntegrationTests;
import pfm.upm.miw.controlcrecimientobe.entidades.AllEntidadesTests;
import pfm.upm.miw.controlcrecimientobe.recursos.AllRecursosFunctionalTests;
import pfm.upm.miw.controlcrecimientobe.servicios.AllServiciosIntegrationTests;


@RunWith(Suite.class)
@SuiteClasses({
    AllEntidadesTests.class,
    AllDaosIntegrationTests.class, 
    AllCotrollersIntegrationTests.class,
    AllRecursosFunctionalTests.class,
    AllServiciosIntegrationTests.class
})
public class AllControlCrecimientoTests {
       
}
