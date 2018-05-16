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
@Table(name = "ventasnetas")
public class VentasNetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idventasnetas")
    private Integer idVentasNetas;
    @Basic(optional = false)
    @Column(name = "fuente")
    private String fuente;
    @Basic(optional = false)
    @Column(name = "factura")
    private String factura;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "refcorta")
    private String refCorta;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "refprov")
    private String refProv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "coddpto")
    private String codDpto;
    @Column(name = "nomdpto")
    private String nomDpto;
    @Column(name = "codgrupo")
    private String codGrupo;
    @Column(name = "nomgrupo")
    private String nomGrupo;
    @Column(name = "codsubgrupo")
    private String codSubgrupo;
    @Column(name = "nomsubgrupo")
    private String nomSubgrupo;
    @Column(name = "yearfac")
    private Integer yearFac;
    @Column(name = "monthfac")
    private Integer monthFac;
    @Column(name = "dayfac")
    private Integer dayFac;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "codcolores")
    private String codColores;
    @Column(name = "colores")
    private String colores;
    @Column(name = "codmateriales")
    private String codMateriales;
    @Column(name = "materiales")
    private String materiales;
    @Column(name = "proveedor")
    private String proveedor;
    @Column(name = "nombreweb")
    private String nombreWeb;
    @Column(name = "precioU_siniva")
    private Integer precioSinIva;
    @Column(name = "costoU")
    private BigDecimal costoUnitario;
    @Column(name = "porcentaje_utilidad")
    private BigDecimal porcentajeUtilidad;
    @Column(name = "nit")
    private String nit;
    @Column(name = "comentariosfac")
    private String comentariosFac;

    public VentasNetas() {
    }

    public VentasNetas(Integer idVentasNetas, String fuente, String factura, String referencia, String refCorta, String descripcion, String refProv, BigDecimal cantidad, Date fecha,
            String codDpto, String nomDpto, String codGrupo, String nomGrupo, String codSubgrupo, String nomSubgrupo, Integer yearFac, Integer monthFac, Integer dayFac, String modelo,
            String codColores, String colores, String codMateriales, String materiales, String proveedor, String nombreWeb, Integer precioSinIva, BigDecimal costoUnitario,
            BigDecimal porcentajeUtilidad, String nit, String comentariosfac) {
        this.idVentasNetas = idVentasNetas;
        this.fuente = fuente;
        this.factura = factura;
        this.referencia = referencia;
        this.refCorta = refCorta;
        this.descripcion = descripcion;
        this.refProv = refProv;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.codDpto = codDpto;
        this.nomDpto = nomDpto;
        this.codGrupo = codGrupo;
        this.nomGrupo = nomGrupo;
        this.codSubgrupo = codSubgrupo;
        this.nomSubgrupo = nomSubgrupo;
        this.yearFac = yearFac;
        this.monthFac = monthFac;
        this.dayFac = dayFac;
        this.modelo = modelo;
        this.codColores = codColores;
        this.colores = colores;
        this.codMateriales = codMateriales;
        this.materiales = materiales;
        this.proveedor = proveedor;
        this.nombreWeb = nombreWeb;
        this.precioSinIva = precioSinIva;
        this.costoUnitario = costoUnitario;
        this.porcentajeUtilidad = porcentajeUtilidad;
        this.nit = nit;
        this.comentariosFac = comentariosfac;
    }

    public Integer getIdVentasNetas() {
        return idVentasNetas;
    }

    public void setIdVentasNetas(Integer idVentasNetas) {
        this.idVentasNetas = idVentasNetas;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodDpto() {
        return codDpto;
    }

    public void setCodDpto(String codDpto) {
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

    public String getCodSubgrupo() {
        return codSubgrupo;
    }

    public void setCodSubgrupo(String codSubgrupo) {
        this.codSubgrupo = codSubgrupo;
    }

    public String getNomSubgrupo() {
        return nomSubgrupo;
    }

    public void setNomSubgrupo(String nomSubgrupo) {
        this.nomSubgrupo = nomSubgrupo;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodColores() {
        return codColores;
    }

    public void setCodColores(String codColores) {
        this.codColores = codColores;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getCodMateriales() {
        return codMateriales;
    }

    public void setCodMateriales(String codMateriales) {
        this.codMateriales = codMateriales;
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

    public String getNombreWeb() {
        return nombreWeb;
    }

    public void setNombreWeb(String nombreWeb) {
        this.nombreWeb = nombreWeb;
    }

    public Integer getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(Integer precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public BigDecimal getPorcentajeUtilidad() {
        return porcentajeUtilidad;
    }

    public void setPorcentajeUtilidad(BigDecimal porcentajeUtilidad) {
        this.porcentajeUtilidad = porcentajeUtilidad;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getComentariosFac() {
        return comentariosFac;
    }

    public void setComentariosFac(String comentariosFac) {
        this.comentariosFac = comentariosFac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentasNetas != null ? idVentasNetas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasNetas)) {
            return false;
        }
        VentasNetas other = (VentasNetas) object;
        if ((this.idVentasNetas == null && other.idVentasNetas != null) || (this.idVentasNetas != null && !this.idVentasNetas.equals(other.idVentasNetas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.VentasNetas[ idVentasNetas=" + idVentasNetas + " ]";
    }
}
