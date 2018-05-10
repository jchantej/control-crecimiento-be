package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class UsuarioRol implements Serializable {
    

    private static final long serialVersionUID = 2906043074688390799L;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public UsuarioRol() {
	}

}