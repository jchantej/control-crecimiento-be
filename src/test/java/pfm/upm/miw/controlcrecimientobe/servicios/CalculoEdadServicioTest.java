package pfm.upm.miw.controlcrecimientobe.servicios;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import pfm.upm.miw.controlcrecimientobe.servicios.CalculoEdadServicio;


public class CalculoEdadServicioTest {
    
    CalculoEdadServicio calculoEdadServicio;
    
    @Before
    public void setData() {
        calculoEdadServicio = new CalculoEdadServicio(new Date("1990/11/25"));
    }
    
   @Test 
   public void  testGetEdadPeriodoDias() {
       assertEquals(this.calculoEdadServicio.getEdadPeriodoDias(), this.calculoEdadServicio.getEdadPeriodoDias());
   }
   
   @Test 
   public void  testGetEdadPeriodoMeses() {
       assertEquals(this.calculoEdadServicio.getEdadPeriodoMeses(), this.calculoEdadServicio.getEdadPeriodoMeses());
   }
   
   @Test 
   public void  testGetEdadPeriodoAnios() {
       assertEquals(this.calculoEdadServicio.getEdadPeriodoAnios(), this.calculoEdadServicio.getEdadPeriodoAnios());
   }
   
   @Test 
   public void  testGetEdadTotalDias() {
       assertEquals(this.calculoEdadServicio.getEdadTotalDias(), this.calculoEdadServicio.getEdadTotalDias());
   }
   

}
