package pfm.upm.miw.controlcrecimientobe.servicios;

import java.util.List;

import pfm.upm.miw.controlcrecimientobe.entidades.PercentilOms;
import pfm.upm.miw.controlcrecimientobe.entidades.Persona;
import pfm.upm.miw.controlcrecimientobe.entidades.Rol;
import pfm.upm.miw.controlcrecimientobe.entidades.Usuario;

public class DatabaseGraph {

    private List<Usuario> usuarioList;

    private List<Persona> personaList;
    
    private List<PercentilOms> percentilOmsList;
    
   
    public DatabaseGraph() {
        // Empty for framework
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public List<PercentilOms> getPercentilOmsList() {
        return percentilOmsList;
    }

    public void setPercentilOmsList(List<PercentilOms> percentilOmsList) {
        this.percentilOmsList = percentilOmsList;
    }

   

}
