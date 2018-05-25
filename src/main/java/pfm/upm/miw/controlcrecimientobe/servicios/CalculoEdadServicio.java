package pfm.upm.miw.controlcrecimientobe.servicios;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculoEdadServicio {

    private Date fechaNacimiento;

    public CalculoEdadServicio(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public int getEdadPeriodoDias() {

        return getPeriodo().getDays();
    }

    public int getEdadPeriodoMeses() {

        return getPeriodo().getMonths();
    }

    public int getEdadPeriodoAnios() {

        return getPeriodo().getYears();

    }
    


    public int getEdadTotalDias() {

        return Days.daysBetween( new DateTime(this.fechaNacimiento), DateTime.now()).getDays();

    }

    private Period getPeriodo() {
        
       String formatoFecha = "dd/MM/yyyy";
       SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
       
       String fechaCadena = sdf.format(this.fechaNacimiento);
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(formatoFecha);

        LocalDate fechaNacimientoTemporal = LocalDate.parse(fechaCadena, fmt);
        LocalDate ahora = LocalDate.now();

       return Period.between(fechaNacimientoTemporal, ahora);


    }

}
