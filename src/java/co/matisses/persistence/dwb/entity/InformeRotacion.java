package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "informe_rotacion")
public class InformeRotacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_informe")
    private Integer idInforme;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fecha")
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Column(name = "autor")
    private String autor;
    @JoinColumn(name = "estado", referencedColumnName = "idEstadoInforme")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoInforme estado;

    public InformeRotacion() {
    }

    public InformeRotacion(Integer idInforme, String nombre, Date fecha, String correo, String autor, EstadoInforme estado) {
        this.idInforme = idInforme;
        this.nombre = nombre;
        this.fecha = fecha;
        this.correo = correo;
        this.autor = autor;
        this.estado = estado;
    }

    public Integer getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Integer idInforme) {
        this.idInforme = idInforme;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public EstadoInforme getEstado() {
        return estado;
    }

    public void setEstado(EstadoInforme estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInforme != null ? idInforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformeRotacion)) {
            return false;
        }
        InformeRotacion other = (InformeRotacion) object;
        if ((this.idInforme == null && other.idInforme != null) || (this.idInforme != null && !this.idInforme.equals(other.idInforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.NewEntity[ idInforme=" + idInforme + " ]";
    }

}
