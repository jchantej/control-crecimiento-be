package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;


@Entity
public class Usuario implements Serializable {


    private static final long serialVersionUID = 2446079007438298704L;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @Column(unique = true)
    private String username;
    
	private String password;
	
	private String nombre;
	
	private String apellido;
	
	private String correo;
	
	private String foto;
	
	private Boolean activo;

	private Date fechaRegistro;

	
	public Usuario() {
	}

   

}