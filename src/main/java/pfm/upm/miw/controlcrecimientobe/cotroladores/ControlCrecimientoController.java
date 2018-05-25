package pfm.upm.miw.controlcrecimientobe.cotroladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import pfm.upm.miw.controlcrecimientobe.daos.IControlCrecimientoDao;
import pfm.upm.miw.controlcrecimientobe.daos.IPercentilCrecimientoDao;
import pfm.upm.miw.controlcrecimientobe.daos.IPercentilOmsDao;
import pfm.upm.miw.controlcrecimientobe.daos.IPersonaDao;
import pfm.upm.miw.controlcrecimientobe.dtos.ControlCrecimientoDto;
import pfm.upm.miw.controlcrecimientobe.entidades.ControlCrecimiento;
import pfm.upm.miw.controlcrecimientobe.entidades.PercentilCrecimiento;
import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;
import pfm.upm.miw.controlcrecimientobe.servicios.CalculoEdadServicio;

@Transactional
@Controller
public class ControlCrecimientoController {

    @Autowired
    private IPersonaDao iPersonaDao;

    @Autowired
    private IPercentilOmsDao iPercentilOmsDao;

    @Autowired
    private IControlCrecimientoDao iControlCrecimientoDao;

    @Autowired
    private IPercentilCrecimientoDao iPercentilCrecimientoDao;

    private ControlCrecimiento controlCrecimiento;

    private List<PercentilCrecimiento> percentilesCrecimiento;

    private List<PercentilOms> percentilesOmss;

    private int edadTotalDias;

    public Optional<String> crearControlCrecimiento(ControlCrecimientoDto controlCrecimientoDto) {

        percentilesCrecimiento = new ArrayList<>();
        Optional<Persona> persona = this.iPersonaDao.findById(controlCrecimientoDto.getIdPersona());
        if (persona.isPresent()) {
            edadTotalDias = new CalculoEdadServicio(persona.get().getFechaNacimiento()).getEdadTotalDias();
            this.controlCrecimiento = new ControlCrecimiento(edadTotalDias, controlCrecimientoDto.getPeso(),
                    controlCrecimientoDto.getTalla(), persona.get());

        } else {
            return Optional.of("No data Found >>>Persona Id: " + controlCrecimientoDto.getIdPersona());
        }

        percentilesOmss = iPercentilOmsDao.findByEdadAndGenero(edadTotalDias, persona.get().getGenero());
        if (percentilesOmss != null || percentilesOmss.size() > 0) {

            for (PercentilOms percentilOms : percentilesOmss) {
                this.percentilesCrecimiento.add(new PercentilCrecimiento(this.controlCrecimiento, percentilOms, "", ""));
            }
        } else {

            return Optional.of("No hay correspondencia de percentil OMS>>> Edad:" + edadTotalDias + "Genero :" + persona.get().getGenero());
        }

        iControlCrecimientoDao.save(this.controlCrecimiento);
        iPercentilCrecimientoDao.saveAll(percentilesCrecimiento);

        return Optional.empty();
    }

    public List<ControlCrecimientoDto> getControlesCrecimiento(int idPersona) {

        List<ControlCrecimiento> controlesCrecimiento;
        List<ControlCrecimientoDto> controlesCrecimientoDto = new ArrayList<>();
        controlesCrecimiento = this.iControlCrecimientoDao.findByPersonaId(idPersona);

        for (ControlCrecimiento item : controlesCrecimiento) {
            CalculoEdadServicio calculoEdad = new CalculoEdadServicio(item.getPersona().getFechaNacimiento());
            ControlCrecimientoDto cc = new ControlCrecimientoDto();
            cc.setEdad(item.getEdad());
            cc.setEdadPeriodo(Integer.toString(calculoEdad.getEdadPeriodoAnios()) + " años, "
                    + Integer.toString(calculoEdad.getEdadPeriodoMeses()) + " meses");
            cc.setFechaRegistro(item.getFechaRegistro());
            cc.setId(item.getId());
            cc.setPeso(item.getPeso());
            cc.setTalla(item.getTalla());
            controlesCrecimientoDto.add(cc);
        }

        return controlesCrecimientoDto;
    }

    public boolean notTalla(ControlCrecimientoDto controlCrecimientoDto) {
        return controlCrecimientoDto.getTalla() == null || controlCrecimientoDto.getTalla().intValue() <= 0;

    }

    public boolean notPeso(ControlCrecimientoDto controlCrecimientoDto) {
        return controlCrecimientoDto.getPeso() == null || controlCrecimientoDto.getPeso().intValue() <= 0;

    }

    public boolean notIdPersona(ControlCrecimientoDto controlCrecimientoDto) {
        return controlCrecimientoDto.getIdPersona() <= 0;

    }

}
