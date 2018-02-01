package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Embeddable
public class CostoAcumuladoAlmacenPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "WhsCode")
    private String whsCode;

    public CostoAcumuladoAlmacenPK() {
    }

    public CostoAcumuladoAlmacenPK(Date fecha, String whsCode) {
        this.fecha = fecha;
        this.whsCode = whsCode;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.fecha);
        hash = 43 * hash + Objects.hashCode(this.whsCode);
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
        final CostoAcumuladoAlmacenPK other = (CostoAcumuladoAlmacenPK) obj;
        if (!Objects.equals(this.whsCode, other.whsCode)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CostoAcumuladoAlmacenPK{" + "fecha=" + fecha + ", whsCode=" + whsCode + '}';
    }
}
