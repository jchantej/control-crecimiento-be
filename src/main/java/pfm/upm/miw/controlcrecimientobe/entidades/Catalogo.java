package pfm.upm.miw.controlcrecimientobe.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Catalogo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codigo;

    private String nombre;

    private String descripcion;

    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_catalogo_fk", nullable = true)
    private Catalogo parentCatalogo;

    @OneToMany(mappedBy = "parentCatalogo")
    private List<Catalogo> items;

    public Catalogo() {
    }

}
