package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "estado_informe")
public class EstadoInforme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoInforme")
    private Integer idEstadoInforme;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public EstadoInforme() {
    }

    public EstadoInforme(Integer idEstadoInforme) {
        this.idEstadoInforme = idEstadoInforme;
    }

    public EstadoInforme(Integer idEstadoInforme, String nombre) {
        this.idEstadoInforme = idEstadoInforme;
        this.nombre = nombre;
    }

    public Integer getIdEstadoInforme() {
        return idEstadoInforme;
    }

    public void setIdEstadoInforme(Integer idEstadoInforme) {
        this.idEstadoInforme = idEstadoInforme;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoInforme != null ? idEstadoInforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoInforme)) {
            return false;
        }
        EstadoInforme other = (EstadoInforme) object;
        if ((this.idEstadoInforme == null && other.idEstadoInforme != null) || (this.idEstadoInforme != null && !this.idEstadoInforme.equals(other.idEstadoInforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.EstadoInforme[ idEstadoInforme=" + idEstadoInforme + " ]";
    }
}
