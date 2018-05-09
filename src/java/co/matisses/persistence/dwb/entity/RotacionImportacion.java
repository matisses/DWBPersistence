package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "rotacionimportacion")
public class RotacionImportacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RotacionImportacionPK rotacionImportacionPK;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "cantidad_compra")
    private int cantidadCompra;
    @Basic(optional = false)
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Column(name = "fecha_ultima_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaVenta;
    @Basic(optional = false)
    @Column(name = "dias_stock")
    private int diasStock;
    @Basic(optional = false)
    @Column(name = "saldo_pendiente")
    private int saldoPendiente;
    @Basic(optional = false)
    @Column(name = "cantidad_venta")
    private int cantidadVenta;
    @Basic(optional = false)
    @Column(name = "cantidad_baja")
    private int cantidadBaja;
    @Column(name = "utilidad_promedio")
    private BigDecimal utilidadPromedio;
    @Column(name = "utilidad_minima")
    private BigDecimal utilidadMinima;
    @Column(name = "nro_salidas")
    private Integer nroSalidas;
    @Column(name = "suma_utilidades")
    private BigDecimal sumaUtilidades;

    public RotacionImportacion() {
    }

    public RotacionImportacion(RotacionImportacionPK rotacionImportacionPK) {
        this.rotacionImportacionPK = rotacionImportacionPK;
    }

    public RotacionImportacion(RotacionImportacionPK rotacionImportacionPK, String tipo, int cantidadCompra, Date fechaCompra, Date fechaCierre, Date fechaUltimaVenta,
            int diasStock, int saldoPendiente, int cantidadVenta, int cantidadBaja, BigDecimal utilidadPromedio, BigDecimal utilidadMinima, Integer nroSalidas, BigDecimal sumaUtilidades) {
        this.rotacionImportacionPK = rotacionImportacionPK;
        this.tipo = tipo;
        this.cantidadCompra = cantidadCompra;
        this.fechaCompra = fechaCompra;
        this.fechaCierre = fechaCierre;
        this.fechaUltimaVenta = fechaUltimaVenta;
        this.diasStock = diasStock;
        this.saldoPendiente = saldoPendiente;
        this.cantidadVenta = cantidadVenta;
        this.cantidadBaja = cantidadBaja;
        this.utilidadPromedio = utilidadPromedio;
        this.utilidadMinima = utilidadMinima;
        this.nroSalidas = nroSalidas;
        this.sumaUtilidades = sumaUtilidades;
    }

    public RotacionImportacionPK getRotacionImportacionPK() {
        return rotacionImportacionPK;
    }

    public void setRotacionImportacionPK(RotacionImportacionPK rotacionImportacionPK) {
        this.rotacionImportacionPK = rotacionImportacionPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getFechaUltimaVenta() {
        return fechaUltimaVenta;
    }

    public void setFechaUltimaVenta(Date fechaUltimaVenta) {
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    public int getDiasStock() {
        return diasStock;
    }

    public void setDiasStock(int diasStock) {
        this.diasStock = diasStock;
    }

    public int getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(int saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public int getCantidadBaja() {
        return cantidadBaja;
    }

    public void setCantidadBaja(int cantidadBaja) {
        this.cantidadBaja = cantidadBaja;
    }

    public BigDecimal getUtilidadPromedio() {
        return utilidadPromedio;
    }

    public void setUtilidadPromedio(BigDecimal utilidadPromedio) {
        this.utilidadPromedio = utilidadPromedio;
    }

    public BigDecimal getUtilidadMinima() {
        return utilidadMinima;
    }

    public void setUtilidadMinima(BigDecimal utilidadMinima) {
        this.utilidadMinima = utilidadMinima;
    }

    public Integer getNroSalidas() {
        return nroSalidas;
    }

    public void setNroSalidas(Integer nroSalidas) {
        this.nroSalidas = nroSalidas;
    }

    public BigDecimal getSumaUtilidades() {
        return sumaUtilidades;
    }

    public void setSumaUtilidades(BigDecimal sumaUtilidades) {
        this.sumaUtilidades = sumaUtilidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rotacionImportacionPK != null ? rotacionImportacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RotacionImportacion)) {
            return false;
        }
        RotacionImportacion other = (RotacionImportacion) object;
        if ((this.rotacionImportacionPK == null && other.rotacionImportacionPK != null) || (this.rotacionImportacionPK != null && !this.rotacionImportacionPK.equals(other.rotacionImportacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RotacionImportacion{" + "rotacionImportacionPK=" + rotacionImportacionPK + ", tipo=" + tipo + ", cantidadCompra=" + cantidadCompra
                + ", fechaCompra=" + fechaCompra + ", fechaCierre=" + fechaCierre + ", fechaUltimaVenta=" + fechaUltimaVenta + ", diasStock=" + diasStock
                + ", saldoPendiente=" + saldoPendiente + ", cantidadVenta=" + cantidadVenta + ", cantidadBaja=" + cantidadBaja + ", utilidadPromedio=" + utilidadPromedio
                + ", utilidadMinima=" + utilidadMinima + ", nroSalidas=" + nroSalidas + ", sumaUtilidades=" + sumaUtilidades + '}';
    }
}
