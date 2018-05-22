package pfm.upm.miw.controlcrecimientobe.recursos.exepciones;

public class NotFieldDataControlCrecimientoException extends Exception {


    private static final long serialVersionUID = 1441078558773238196L;
    public static final String DESCRIPTION = "Faltan datos de control";
    
    public NotFieldDataControlCrecimientoException() {
        super(DESCRIPTION);
    }

    public NotFieldDataControlCrecimientoException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
