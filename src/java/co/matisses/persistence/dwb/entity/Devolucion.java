package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "devoluciones")
public class Devolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iddevoluciones")
    private Integer idDevoluciones;
    @Basic(optional = false)
    @Column(name = "fuente")
    private String fuente;
    @Column(name = "devolucion")
    private String devolucion;
    @Column(name = "fechadev")
    @Temporal(TemporalType.DATE)
    private Date fechaDev;
    @Column(name = "factura")
    private String factura;
    @Column(name = "fechafac")
    @Temporal(TemporalType.DATE)
    private Date fechaFac;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "ref_corta")
    private String refCorta;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "refprov")
    private String refProv;
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Column(name = "coddpto")
    private Short codDpto;
    @Column(name = "nomdpto")
    private String nomDpto;
    @Column(name = "codgrupo")
    private String codGrupo;
    @Column(name = "nomgrupo")
    private String nomGrupo;
    @Column(name = "codsubgrupo")
    private String codsubgrupo;
    @Column(name = "nomsubgrupo")
    private String nomsubgrupo;
    @Column(name = "yeardev")
    private Integer yeardev;
    @Column(name = "monthdev")
    private Integer monthdev;
    @Column(name = "daydev")
    private Integer daydev;
    @Basic(optional = false)
    @Column(name = "yearfac")
    private int yearfac;
    @Basic(optional = false)
    @Column(name = "monthfac")
    private int monthfac;
    @Basic(optional = false)
    @Column(name = "dayfac")
    private int dayfac;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "codcolores")
    private String codcolores;
    @Column(name = "colores")
    private String colores;
    @Column(name = "codmateriales")
    private String codmateriales;
    @Column(name = "materiales")
    private String materiales;
    @Column(name = "proveedor")
    private String proveedor;
    @Column(name = "nombreweb")
    private String nombreweb;
    @Column(name = "precio_siniva")
    private Integer precioSiniva;
    @Column(name = "comentarios")
    private String comentarios;

    public Devolucion() {
    }

    public Devolucion(Integer idDevoluciones) {
        this.idDevoluciones = idDevoluciones;
    }

    public Devolucion(Integer idDevoluciones, String fuente, String devolucion, Date fechaDev, String factura, Date fechaFac, String referencia, String refCorta,
            String descripcion, String refProv, BigDecimal cantidad, Short codDpto, String nomDpto, String codGrupo, String nomGrupo, String codsubgrupo,
            String nomsubgrupo, Integer yeardev, Integer monthdev, Integer daydev, int yearfac, int monthfac, int dayfac, String modelo, String codcolores,
            String colores, String codmateriales, String materiales, String proveedor, String nombreweb, Integer precioSiniva, String comentarios) {
        this.idDevoluciones = idDevoluciones;
        this.fuente = fuente;
        this.devolucion = devolucion;
        this.fechaDev = fechaDev;
        this.factura = factura;
        this.fechaFac = fechaFac;
        this.referencia = referencia;
        this.refCorta = refCorta;
        this.descripcion = descripcion;
        this.refProv = refProv;
        this.cantidad = cantidad;
        this.codDpto = codDpto;
        this.nomDpto = nomDpto;
        this.codGrupo = codGrupo;
        this.nomGrupo = nomGrupo;
        this.codsubgrupo = codsubgrupo;
        this.nomsubgrupo = nomsubgrupo;
        this.yeardev = yeardev;
        this.monthdev = monthdev;
        this.daydev = daydev;
        this.yearfac = yearfac;
        this.monthfac = monthfac;
        this.dayfac = dayfac;
        this.modelo = modelo;
        this.codcolores = codcolores;
        this.colores = colores;
        this.codmateriales = codmateriales;
        this.materiales = materiales;
        this.proveedor = proveedor;
        this.nombreweb = nombreweb;
        this.precioSiniva = precioSiniva;
        this.comentarios = comentarios;
    }

    public Integer getIdDevoluciones() {
        return idDevoluciones;
    }

    public void setIdDevoluciones(Integer idDevoluciones) {
        this.idDevoluciones = idDevoluciones;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getRefCorta() {
        return refCorta;
    }

    public void setRefCorta(String refCorta) {
        this.refCorta = refCorta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRefProv() {
        return refProv;
    }

    public void setRefProv(String refProv) {
        this.refProv = refProv;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Short getCodDpto() {
        return codDpto;
    }

    public void setCodDpto(Short codDpto) {
        this.codDpto = codDpto;
    }

    public String getNomDpto() {
        return nomDpto;
    }

    public void setNomDpto(String nomDpto) {
        this.nomDpto = nomDpto;
    }

    public String getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(String codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    public String getCodsubgrupo() {
        return codsubgrupo;
    }

    public void setCodsubgrupo(String codsubgrupo) {
        this.codsubgrupo = codsubgrupo;
    }

    public String getNomsubgrupo() {
        return nomsubgrupo;
    }

    public void setNomsubgrupo(String nomsubgrupo) {
        this.nomsubgrupo = nomsubgrupo;
    }

    public Integer getYeardev() {
        return yeardev;
    }

    public void setYeardev(Integer yeardev) {
        this.yeardev = yeardev;
    }

    public Integer getMonthdev() {
        return monthdev;
    }

    public void setMonthdev(Integer monthdev) {
        this.monthdev = monthdev;
    }

    public Integer getDaydev() {
        return daydev;
    }

    public void setDaydev(Integer daydev) {
        this.daydev = daydev;
    }

    public int getYearfac() {
        return yearfac;
    }

    public void setYearfac(int yearfac) {
        this.yearfac = yearfac;
    }

    public int getMonthfac() {
        return monthfac;
    }

    public void setMonthfac(int monthfac) {
        this.monthfac = monthfac;
    }

    public int getDayfac() {
        return dayfac;
    }

    public void setDayfac(int dayfac) {
        this.dayfac = dayfac;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodcolores() {
        return codcolores;
    }

    public void setCodcolores(String codcolores) {
        this.codcolores = codcolores;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getCodmateriales() {
        return codmateriales;
    }

    public void setCodmateriales(String codmateriales) {
        this.codmateriales = codmateriales;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombreweb() {
        return nombreweb;
    }

    public void setNombreweb(String nombreweb) {
        this.nombreweb = nombreweb;
    }

    public Integer getPrecioSiniva() {
        return precioSiniva;
    }

    public void setPrecioSiniva(Integer precioSiniva) {
        this.precioSiniva = precioSiniva;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevoluciones != null ? idDevoluciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucion)) {
            return false;
        }
        Devolucion other = (Devolucion) object;
        if ((this.idDevoluciones == null && other.idDevoluciones != null) || (this.idDevoluciones != null && !this.idDevoluciones.equals(other.idDevoluciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.Devolucion[ idDevoluciones=" + idDevoluciones + " ]";
    }
}
