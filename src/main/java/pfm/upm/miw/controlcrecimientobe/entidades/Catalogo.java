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

    private static final long serialVersionUID = 6819595731408621887L;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Catalogo getParentCatalogo() {
        return parentCatalogo;
    }

    public void setParentCatalogo(Catalogo parentCatalogo) {
        this.parentCatalogo = parentCatalogo;
    }

    public List<Catalogo> getItems() {
        return items;
    }

    public void setItems(List<Catalogo> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Catalogo [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", activo=" + activo
                + ", parentCatalogo=" + parentCatalogo + ", items=" + items + "]";
    }

}
