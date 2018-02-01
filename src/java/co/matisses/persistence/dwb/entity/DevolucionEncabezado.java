package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "devoluciones_encabezado")
public class DevolucionEncabezado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iddevoluciones_encabezado")
    private Integer idDevolucionesEncabezado;
    @Column(name = "fuente")
    private String fuente;
    @Column(name = "devolucion")
    private String devolucion;
    @Column(name = "fechadev")
    @Temporal(TemporalType.DATE)
    private Date fechaDev;
    @Column(name = "yeardev")
    private Integer yearDev;
    @Column(name = "monthdev")
    private Integer monthDev;
    @Column(name = "daydev")
    private Integer dayDev;
    @Column(name = "factura")
    private String factura;
    @Column(name = "fechafac")
    @Temporal(TemporalType.DATE)
    private Date fechaFac;
    @Column(name = "yearfac")
    private Integer yearFac;
    @Column(name = "monthfac")
    private Integer monthFac;
    @Column(name = "dayfac")
    private Integer dayFac;
    @Column(name = "nit")
    private String nit;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "observaciones")
    private String observaciones;

    public DevolucionEncabezado() {
    }

    public DevolucionEncabezado(Integer idDevolucionesEncabezado) {
        this.idDevolucionesEncabezado = idDevolucionesEncabezado;
    }

    public DevolucionEncabezado(Integer idDevolucionesEncabezado, String fuente, String devolucion, Date fechaDev, Integer yearDev, Integer monthDev, Integer dayDev,
            String factura, Date fechaFac, Integer yearFac, Integer monthFac, Integer dayFac, String nit, String razonSocial, String observaciones) {
        this.idDevolucionesEncabezado = idDevolucionesEncabezado;
        this.fuente = fuente;
        this.devolucion = devolucion;
        this.fechaDev = fechaDev;
        this.yearDev = yearDev;
        this.monthDev = monthDev;
        this.dayDev = dayDev;
        this.factura = factura;
        this.fechaFac = fechaFac;
        this.yearFac = yearFac;
        this.monthFac = monthFac;
        this.dayFac = dayFac;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.observaciones = observaciones;
    }

    public Integer getIdDevolucionesEncabezado() {
        return idDevolucionesEncabezado;
    }

    public void setIdDevolucionesEncabezado(Integer idDevolucionesEncabezado) {
        this.idDevolucionesEncabezado = idDevolucionesEncabezado;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

    public Date getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(Date fechaDev) {
        this.fechaDev = fechaDev;
    }

    public Integer getYearDev() {
        return yearDev;
    }

    public void setYearDev(Integer yearDev) {
        this.yearDev = yearDev;
    }

    public Integer getMonthDev() {
        return monthDev;
    }

    public void setMonthDev(Integer monthDev) {
        this.monthDev = monthDev;
    }

    public Integer getDayDev() {
        return dayDev;
    }

    public void setDayDev(Integer dayDev) {
        this.dayDev = dayDev;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Date getFechaFac() {
        return fechaFac;
    }

    public void setFechaFac(Date fechaFac) {
        this.fechaFac = fechaFac;
    }

    public Integer getYearFac() {
        return yearFac;
    }

    public void setYearFac(Integer yearFac) {
        this.yearFac = yearFac;
    }

    public Integer getMonthFac() {
        return monthFac;
    }

    public void setMonthFac(Integer monthFac) {
        this.monthFac = monthFac;
    }

    public Integer getDayFac() {
        return dayFac;
    }

    public void setDayFac(Integer dayFac) {
        this.dayFac = dayFac;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevolucionesEncabezado != null ? idDevolucionesEncabezado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevolucionEncabezado)) {
            return false;
        }
        DevolucionEncabezado other = (DevolucionEncabezado) object;
        if ((this.idDevolucionesEncabezado == null && other.idDevolucionesEncabezado != null) || (this.idDevolucionesEncabezado != null && !this.idDevolucionesEncabezado.equals(other.idDevolucionesEncabezado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.DevolucionEncabezado[ idDevolucionesEncabezado=" + idDevolucionesEncabezado + " ]";
    }
}
