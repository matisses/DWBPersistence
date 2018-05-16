package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ygil
 */
@Embeddable
public class RotacionImportacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "id_compra")
    private int idCompra;

    public RotacionImportacionPK() {
    }

    public RotacionImportacionPK(String referencia, int idCompra) {
        this.referencia = referencia;
        this.idCompra = idCompra;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.referencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RotacionImportacionPK other = (RotacionImportacionPK) obj;
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RotacionImportacionPK{" + "referencia=" + referencia + ", idCompra=" + idCompra + '}';
    }
}
