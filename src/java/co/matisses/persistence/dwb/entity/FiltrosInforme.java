package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "filtros_informe")
public class FiltrosInforme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_filtro_informe")
    private Integer idFiltroInforme;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "id_informe")
    private Integer idInforme;
    @JoinColumn(name = "id_filtro", referencedColumnName = "id_filtro")
    @ManyToOne(optional = false)
    private Filtro filtro;

    public FiltrosInforme() {
    }

    public FiltrosInforme(Integer idFiltroInforme) {
        this.idFiltroInforme = idFiltroInforme;
    }

    public FiltrosInforme(Integer idFiltroInforme, String valor, Integer idInforme, Filtro filtro) {
        this.idFiltroInforme = idFiltroInforme;
        this.valor = valor;
        this.idInforme = idInforme;
        this.filtro = filtro;
    }

    public Integer getIdFiltroInforme() {
        return idFiltroInforme;
    }

    public void setIdFiltroInforme(Integer idFiltroInforme) {
        this.idFiltroInforme = idFiltroInforme;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Integer idInforme) {
        this.idInforme = idInforme;
    }

    public Filtro getFiltro() {
        return filtro;
    }

    public void setFiltro(Filtro filtro) {
        this.filtro = filtro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFiltroInforme != null ? idFiltroInforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FiltrosInforme)) {
            return false;
        }
        FiltrosInforme other = (FiltrosInforme) object;
        if ((this.idFiltroInforme == null && other.idFiltroInforme != null) || (this.idFiltroInforme != null && !this.idFiltroInforme.equals(other.idFiltroInforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.FiltrosInforme[ idFiltroInforme=" + idFiltroInforme + " ]";
    }
}
