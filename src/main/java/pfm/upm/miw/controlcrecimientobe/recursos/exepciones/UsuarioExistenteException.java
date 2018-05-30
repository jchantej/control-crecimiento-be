package pfm.upm.miw.controlcrecimientobe.recursos.exepciones;

public class UsuarioExistenteException extends Exception {


    private static final long serialVersionUID = -8290402539020501024L;
    
    public static final String DESCRIPTION = "El usuario ya existe";
    
    public UsuarioExistenteException() {
        super(DESCRIPTION);
    }

    public UsuarioExistenteException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
