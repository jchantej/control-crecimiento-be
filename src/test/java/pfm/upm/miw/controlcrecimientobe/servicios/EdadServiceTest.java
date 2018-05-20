package pfm.upm.miw.controlcrecimientobe.servicios;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class EdadServiceTest {
    
   // @Autowired
    EdadService edadService;
    
    @Before
    public void setData() {
        edadService = new EdadService(new Date("1990/11/25"));
    }
    
   @Test 
   public void  testGetEdadPeriodoDias() {
       assertEquals(this.edadService.getEdadPeriodoDias(), this.edadService.getEdadPeriodoDias());
   }
   
   @Test 
   public void  testGetEdadPeriodoMeses() {
       assertEquals(this.edadService.getEdadPeriodoMeses(), this.edadService.getEdadPeriodoMeses());
   }
   
   @Test 
   public void  testGetEdadPeriodoAnios() {
       assertEquals(this.edadService.getEdadPeriodoAnios(), this.edadService.getEdadPeriodoAnios());
   }
   
   @Test 
   public void  testGetEdadTotalDias() {
       assertEquals(this.edadService.getEdadTotalDias(), this.edadService.getEdadTotalDias());
   }
   

}
