package pfm.upm.miw.controlcrecimientobe.recursos.exepciones;

public class NotFieldDataPersonaException extends Exception {


    private static final long serialVersionUID = -8284402287463388287L;
    
    public static final String DESCRIPTION = "Faltan datos de persona";
    
    public NotFieldDataPersonaException() {
        super(DESCRIPTION);
    }

    public NotFieldDataPersonaException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
