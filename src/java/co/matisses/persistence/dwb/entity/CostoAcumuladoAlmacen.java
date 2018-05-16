package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "costo_acumuladoxalmacen")
public class CostoAcumuladoAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CostoAcumuladoAlmacenPK costoAcumuladoAlmacenPK;
    @Column(name = "costo_acumulado")
    private BigDecimal costoAcumulado;
    @Column(name = "saldo_acumulado")
    private Integer saldoAcumulado;
    @Column(name = "precio_acumulado_sinIVA")
    private BigDecimal precioAcumuladoSinIva;
    @Column(name = "precio_acumulado_conIVA")
    private BigDecimal precioAcumuladoConIva;

    public CostoAcumuladoAlmacen() {
    }

    public CostoAcumuladoAlmacen(CostoAcumuladoAlmacenPK costoAcumuladoAlmacenPK, BigDecimal costoAcumulado, Integer saldoAcumulado, BigDecimal precioAcumuladoSinIva, BigDecimal precioAcumuladoConIva) {
        this.costoAcumuladoAlmacenPK = costoAcumuladoAlmacenPK;
        this.costoAcumulado = costoAcumulado;
        this.saldoAcumulado = saldoAcumulado;
        this.precioAcumuladoSinIva = precioAcumuladoSinIva;
        this.precioAcumuladoConIva = precioAcumuladoConIva;
    }

    public CostoAcumuladoAlmacenPK getCostoAcumuladoAlmacenPK() {
        return costoAcumuladoAlmacenPK;
    }

    public void setCostoAcumuladoAlmacenPK(CostoAcumuladoAlmacenPK costoAcumuladoAlmacenPK) {
        this.costoAcumuladoAlmacenPK = costoAcumuladoAlmacenPK;
    }

    public BigDecimal getCostoAcumulado() {
        return costoAcumulado;
    }

    public void setCostoAcumulado(BigDecimal costoAcumulado) {
        this.costoAcumulado = costoAcumulado;
    }

    public Integer getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public void setSaldoAcumulado(Integer saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }

    public BigDecimal getPrecioAcumuladoSinIva() {
        return precioAcumuladoSinIva;
    }

    public void setPrecioAcumuladoSinIva(BigDecimal precioAcumuladoSinIva) {
        this.precioAcumuladoSinIva = precioAcumuladoSinIva;
    }

    public BigDecimal getPrecioAcumuladoConIva() {
        return precioAcumuladoConIva;
    }

    public void setPrecioAcumuladoConIva(BigDecimal precioAcumuladoConIva) {
        this.precioAcumuladoConIva = precioAcumuladoConIva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costoAcumuladoAlmacenPK != null ? costoAcumuladoAlmacenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostoAcumuladoAlmacen)) {
            return false;
        }
        CostoAcumuladoAlmacen other = (CostoAcumuladoAlmacen) object;
        if ((this.costoAcumuladoAlmacenPK == null && other.costoAcumuladoAlmacenPK != null) || (this.costoAcumuladoAlmacenPK != null && !this.costoAcumuladoAlmacenPK.equals(other.costoAcumuladoAlmacenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.CostoAcumuladoAlmacen[ costoAcumuladoAlmacenPK=" + costoAcumuladoAlmacenPK + " ]";
    }
}
