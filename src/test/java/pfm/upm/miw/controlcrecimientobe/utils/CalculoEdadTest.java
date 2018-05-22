package pfm.upm.miw.controlcrecimientobe.utils;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import pfm.upm.miw.controlcrecimientobe.utils.CalculoEdad;


public class CalculoEdadTest {
    
    CalculoEdad calculoEdad;
    
    @Before
    public void setData() {
        calculoEdad = new CalculoEdad(new Date("1990/11/25"));
    }
    
   @Test 
   public void  testGetEdadPeriodoDias() {
       assertEquals(this.calculoEdad.getEdadPeriodoDias(), this.calculoEdad.getEdadPeriodoDias());
   }
   
   @Test 
   public void  testGetEdadPeriodoMeses() {
       assertEquals(this.calculoEdad.getEdadPeriodoMeses(), this.calculoEdad.getEdadPeriodoMeses());
   }
   
   @Test 
   public void  testGetEdadPeriodoAnios() {
       assertEquals(this.calculoEdad.getEdadPeriodoAnios(), this.calculoEdad.getEdadPeriodoAnios());
   }
   
   @Test 
   public void  testGetEdadTotalDias() {
       assertEquals(this.calculoEdad.getEdadTotalDias(), this.calculoEdad.getEdadTotalDias());
   }
   

}
