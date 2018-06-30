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
                this.percentilesCrecimiento.add(new PercentilCrecimiento(this.controlCrecimiento, percentilOms,
                        EvaluarRangosPercentil(percentilOms, this.controlCrecimiento), ""));
            }
        } else {

            return Optional.of("No hay correspondencia de percentil OMS>>> Edad:" + edadTotalDias + "Genero :" + persona.get().getGenero());
        }

        iControlCrecimientoDao.save(this.controlCrecimiento);
        iPercentilCrecimientoDao.saveAll(percentilesCrecimiento);

        return Optional.empty();
    }

    public Optional<String> editarControlCrecimiento(int id, ControlCrecimientoDto controlCrecimientoDto) {

        percentilesCrecimiento = new ArrayList<>();
        Optional<ControlCrecimiento> controlCrecimientoDb = iControlCrecimientoDao.findById(id);
        ControlCrecimiento controlCrecimiento = new ControlCrecimiento();

        if (controlCrecimientoDb.isPresent()) {

            controlCrecimiento = controlCrecimientoDb.get();
            List<PercentilCrecimiento> percentilesCrecimientoDb = iPercentilCrecimientoDao.findByControlCrecimiento(controlCrecimiento);
            controlCrecimiento.setEdad(controlCrecimientoDto.getEdad());
            controlCrecimiento.setPeso(controlCrecimientoDto.getPeso());
            controlCrecimiento.setTalla(controlCrecimientoDto.getTalla());
            percentilesCrecimiento.addAll(percentilesCrecimientoDb);

            for (int i = 0; i < percentilesCrecimientoDb.size(); i++) {

                percentilesCrecimiento.get(i).setControlCrecimiento(controlCrecimiento);
                percentilesCrecimiento.get(i)
                        .setObservacion(EvaluarRangosPercentil(percentilesCrecimiento.get(i).getPercentilOms(), controlCrecimiento));

            }

        } else {
            return Optional.of("No data Found >>>Control Crecimiento Id: " + controlCrecimientoDto.getId());
        }

        iPercentilCrecimientoDao.saveAll(percentilesCrecimiento);

        return Optional.of("OK");
    }

    public List<ControlCrecimientoDto> getControlesCrecimiento(int idPersona) {

        List<ControlCrecimiento> controlesCrecimiento;
        List<ControlCrecimientoDto> controlesCrecimientoDto = new ArrayList<>();
        percentilesCrecimiento = new ArrayList<>();
        controlesCrecimiento = this.iControlCrecimientoDao.findByPersonaId(idPersona);

        for (ControlCrecimiento item : controlesCrecimiento) {
            CalculoEdadServicio calculoEdad = new CalculoEdadServicio(item.getPersona().getFechaNacimiento());

            percentilesCrecimiento = iPercentilCrecimientoDao.findByControlCrecimiento(item);
            ControlCrecimientoDto cc = new ControlCrecimientoDto();
            for (PercentilCrecimiento pc : percentilesCrecimiento) {
                if (pc.getPercentilOms().getTipo().equals("P")) {
                    cc.setObservacionPeso(pc.getObservacion());
                }
                if (pc.getPercentilOms().getTipo().equals("T")) {
                    cc.setObservacionTalla(pc.getObservacion());
                }

            }
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

    // TODO: Refactorizar luego para ponerlo en una clase independinte como servicio, ademas agregar la recomendacion

    public String EvaluarRangosPercentil(PercentilOms percentilOms, ControlCrecimiento controlCrecimiento) {
        if (percentilOms.getTipo().equals("P")) {
            if (controlCrecimiento.getPeso().compareTo(percentilOms.getPercentil3()) <= 0) { // P<=P3
                return "Por debajo de los pesos establecidos";
            } else if (controlCrecimiento.getPeso().compareTo(percentilOms.getPercentil3()) == 1
                    && controlCrecimiento.getPeso().compareTo(percentilOms.getPercentil15()) <= 0) { // P>P3 && P<=15

                return "Un poco bajo de Peso";

            } else if (controlCrecimiento.getPeso().compareTo(percentilOms.getPercentil15()) == 1
                    && controlCrecimiento.getPeso().compareTo(percentilOms.getPercentil85()) == -1) { // P>P15 && P<85

                return "Peso Normal";

            } else if (controlCrecimiento.getPeso().compareTo(percentilOms.getPercentil85()) >= 0
                    && controlCrecimiento.getPeso().compareTo(percentilOms.getPercentil97()) == -1) { // P>=P85 && P<97

                return "Un poco subido de Peso";

            } else if (controlCrecimiento.getPeso().compareTo(percentilOms.getPercentil97()) >= 0) { // P>=P97

                return "Por encima de los pesos establecidos";

            } else {
                return "";
            }

        } else if (percentilOms.getTipo().equals("T")) {
            if (controlCrecimiento.getTalla().compareTo(percentilOms.getPercentil3()) <= 0) { // P<=P3
                return "Por debajo de las tallas establecidas";
            } else if (controlCrecimiento.getTalla().compareTo(percentilOms.getPercentil3()) == 1
                    && controlCrecimiento.getTalla().compareTo(percentilOms.getPercentil15()) <= 0) { // P>P3 && P<=15

                return "Un poco bajo de talla";

            } else if (controlCrecimiento.getTalla().compareTo(percentilOms.getPercentil15()) == 1
                    && controlCrecimiento.getTalla().compareTo(percentilOms.getPercentil85()) == -1) { // P>P15 && P<85

                return "Talla Normal";

            } else if (controlCrecimiento.getTalla().compareTo(percentilOms.getPercentil85()) >= 0
                    && controlCrecimiento.getTalla().compareTo(percentilOms.getPercentil97()) == -1) { // P>=P85 && P<97

                return "Un poco subido de Talla";

            } else if (controlCrecimiento.getTalla().compareTo(percentilOms.getPercentil97()) >= 0) { // P>=P97

                return "Por encima de las tallas establecidos";

            } else {
                return "";
            }

        } else {
            return "";
        }

    }

}
