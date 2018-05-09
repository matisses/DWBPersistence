package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "entradas")
public class Entradas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identradas")
    private Integer idEntradas;
    @Basic(optional = false)
    @Column(name = "fuente")
    private String fuente;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "ref_corta")
    private String refCorta;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "refprov")
    private String refProv;
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "coddpto")
    private Short codDpto;
    @Basic(optional = false)
    @Column(name = "nomdpto")
    private String nomDpto;
    @Column(name = "codgrupo")
    private String codGrupo;
    @Basic(optional = false)
    @Column(name = "nomgrupo")
    private String nomGrupo;
    @Column(name = "codsubgrupo")
    private String codSubgrupo;
    @Basic(optional = false)
    @Column(name = "nomsubgrupo")
    private String nomSubgrupo;
    @Column(name = "yearEnt")
    private Integer yearEnt;
    @Column(name = "monthEnt")
    private Integer monthEnt;
    @Column(name = "dayEnt")
    private Integer dayEnt;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "codcolores")
    private String codcolores;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_siniva")
    private BigDecimal precioSinIVA;
    @Column(name = "tipo")
    private String tipo;

    public Entradas() {
    }

    public Entradas(Integer identradas) {
        this.idEntradas = identradas;
    }

    public Entradas(Integer identradas, String fuente, Date fecha, String nomdpto, String nomgrupo, String nomsubgrupo) {
        this.idEntradas = identradas;
        this.fuente = fuente;
        this.fecha = fecha;
        this.nomDpto = nomdpto;
        this.nomGrupo = nomgrupo;
        this.nomSubgrupo = nomsubgrupo;
    }

    public Integer getIdEntradas() {
        return idEntradas;
    }

    public void setIdEntradas(Integer idEntradas) {
        this.idEntradas = idEntradas;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
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

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Integer getYearEnt() {
        return yearEnt;
    }

    public void setYearEnt(Integer yearEnt) {
        this.yearEnt = yearEnt;
    }

    public Integer getMonthEnt() {
        return monthEnt;
    }

    public void setMonthEnt(Integer monthEnt) {
        this.monthEnt = monthEnt;
    }

    public Integer getDayEnt() {
        return dayEnt;
    }

    public void setDayEnt(Integer dayEnt) {
        this.dayEnt = dayEnt;
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

    public BigDecimal getPrecioSinIVA() {
        return precioSinIVA;
    }

    public void setPrecioSinIVA(BigDecimal precioSinIVA) {
        this.precioSinIVA = precioSinIVA;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntradas != null ? idEntradas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradas)) {
            return false;
        }
        Entradas other = (Entradas) object;
        if ((this.idEntradas == null && other.idEntradas != null) || (this.idEntradas != null && !this.idEntradas.equals(other.idEntradas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.Entradas[ idEntradas=" + idEntradas + " ]";
    }
}
