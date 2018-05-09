package co.matisses.persistence.dwb.entity;

import co.matisses.persistence.dwb.annotation.FieldDescription;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "rotacion")
public class Rotacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrotacion")
    private Integer idRotacion;
    @FieldDescription(description = "Referencia")
    @Column(name = "referencia")
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @FieldDescription(description = "Rotación")
    @Column(name = "rotacionporcentaje")
    private BigDecimal rotacionPorcentaje;
    @FieldDescription(description = "Cantidad Comprada")
    @Column(name = "cantidadcomprada")
    private Integer cantidadComprada;
    @FieldDescription(description = "Cantidad Vendida")
    @Column(name = "cantidadvendida")
    private Integer cantidadVendida;
    @FieldDescription(description = "Entrada Neta")
    @Column(name = "cantidadentrada")
    private Integer cantidadEntradaNeta;
    @FieldDescription(description = "Cantidad Salida")
    @Column(name = "cantidadsalida")
    private Integer cantidadSalida;
    @FieldDescription(description = "Saldo Para Venta")
    @Column(name = "saldoventa")
    private Integer saldoVenta;
    @FieldDescription(description = "Total Comprado")
    @Column(name = "totalcomprado")
    private Integer totalComprado;
    @FieldDescription(description = "Promedio Dias de Rotación")
    @Column(name = "rotacionpromediodias")
    private BigDecimal rotacionPromedioDias;
    @FieldDescription(description = "Promedio Dias Rot. Avanz.")
    @Column(name = "rotacionpromediodiasavanz")
    private BigDecimal rotacionPromedioDiasAvanz;
    @FieldDescription(description = "Perfil")
    @Column(name = "perfil")
    private String perfil;
    @FieldDescription(description = "Referencia Corta")
    @Column(name = "ref_corta")
    private String refCorta;
    @FieldDescription(description = "Referencia Aduana")
    @Column(name = "refaduana")
    private String refAduana;
    @FieldDescription(description = "Modelo")
    @Column(name = "modelo")
    private String modelo;
    @FieldDescription(description = "Referencia Proveedor")
    @Column(name = "refprov")
    private String refProv;
    @FieldDescription(description = "Descripción")
    @Column(name = "descripcion")
    private String descripcion;
    @FieldDescription(description = "Código Departamento")
    @Column(name = "coddpto")
    private Integer codDpto;
    @FieldDescription(description = "Nombre de Departamento")
    @Basic(optional = false)
    @Column(name = "nomdpto")
    private String nomDpto;
    @FieldDescription(description = "Código Grupo")
    @Column(name = "codgrupo")
    private String codGrupo;
    @Basic(optional = false)
    @FieldDescription(description = "Nombre Grupo")
    @Column(name = "nomgrupo")
    private String nomGrupo;
    @FieldDescription(description = "Código Subgrupo")
    @Column(name = "codsubgrupo")
    private String codSubGrupo;
    @FieldDescription(description = "Nombre Subgrupo")
    @Basic(optional = false)
    @Column(name = "nomsubgrupo")
    private String nomSubGrupo;
    @FieldDescription(description = "Código Color")
    @Column(name = "codcolores")
    private String codColores;
    @FieldDescription(description = "Color")
    @Column(name = "colores")
    private String colores;
    @FieldDescription(description = "Código Material")
    @Column(name = "codmateriales")
    private String codMateriales;
    @FieldDescription(description = "Material")
    @Column(name = "materiales")
    private String materiales;
    @FieldDescription(description = "Proveedor")
    @Column(name = "proveedor")
    private String proveedor;
    @FieldDescription(description = "Nombre Web")
    @Column(name = "nombreweb")
    private String nombreWeb;
    @FieldDescription(description = "Precio Sin Iva")
    @Column(name = "precio_siniva")
    private Integer precioSinIva;
    @FieldDescription(description = "Fecha Ultima Venta")
    @Column(name = "fecha_ultima_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaVenta;
    @Basic(optional = false)
    @Column(name = "id_informe")
    private Integer idInforme;
    @FieldDescription(description = "Saldo en Taller")
    @Column(name = "saldoTaller")
    private Integer saldoTaller;
    @FieldDescription(description = "Saldo Garantia")
    @Column(name = "saldoGarantia")
    private Integer saldoGarantia;
    @FieldDescription(description = "Utilidad Promedio")
    @Column(name = "utilidad_promedio")
    private BigDecimal utilidadPromedio;
    @FieldDescription(description = "Utilidad Minima")
    @Column(name = "utilidad_minima")
    private BigDecimal utilidadMinima;
    @FieldDescription(description = "Utilidad Avanzada")
    @Column(name = "utilidad_avanzada")
    private BigDecimal utilidadAvanzada;
    @FieldDescription(description = "Entradas Compra")
    @Column(name = "entradasCompra")
    private Integer entradasCompra;
    @FieldDescription(description = "Entradas Taller")
    @Column(name = "entradasTaller")
    private Integer entradasTaller;

    public Integer getIdRotacion() {
        return idRotacion;
    }

    public void setIdRotacion(Integer idRotacion) {
        this.idRotacion = idRotacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getRotacionPorcentaje() {
        return rotacionPorcentaje;
    }

    public void setRotacionPorcentaje(BigDecimal rotacionPorcentaje) {
        this.rotacionPorcentaje = rotacionPorcentaje;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Integer getCantidadEntradaNeta() {
        return cantidadEntradaNeta;
    }

    public void setCantidadEntradaNeta(Integer cantidadEntradaNeta) {
        this.cantidadEntradaNeta = cantidadEntradaNeta;
    }

    public Integer getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(Integer cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public Integer getSaldoVenta() {
        return saldoVenta;
    }

    public void setSaldoVenta(Integer saldoVenta) {
        this.saldoVenta = saldoVenta;
    }

    public Integer getTotalComprado() {
        return totalComprado;
    }

    public void setTotalComprado(Integer totalComprado) {
        this.totalComprado = totalComprado;
    }

    public BigDecimal getRotacionPromedioDias() {
        return rotacionPromedioDias;
    }

    public void setRotacionPromedioDias(BigDecimal rotacionPromedioDias) {
        this.rotacionPromedioDias = rotacionPromedioDias;
    }

    public BigDecimal getRotacionPromedioDiasAvanz() {
        return rotacionPromedioDiasAvanz;
    }

    public void setRotacionPromedioDiasAvanz(BigDecimal rotacionPromedioDiasAvanz) {
        this.rotacionPromedioDiasAvanz = rotacionPromedioDiasAvanz;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getRefCorta() {
        return refCorta;
    }

    public void setRefCorta(String refCorta) {
        this.refCorta = refCorta;
    }

    public String getRefAduana() {
        return refAduana;
    }

    public void setRefAduana(String refAduana) {
        this.refAduana = refAduana;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRefProv() {
        return refProv;
    }

    public void setRefProv(String refProv) {
        this.refProv = refProv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCodDpto() {
        return codDpto;
    }

    public void setCodDpto(Integer codDpto) {
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

    public String getCodSubGrupo() {
        return codSubGrupo;
    }

    public void setCodSubGrupo(String codSubGrupo) {
        this.codSubGrupo = codSubGrupo;
    }

    public String getNomSubGrupo() {
        return nomSubGrupo;
    }

    public void setNomSubGrupo(String nomSubGrupo) {
        this.nomSubGrupo = nomSubGrupo;
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

    public Date getFechaUltimaVenta() {
        return fechaUltimaVenta;
    }

    public void setFechaUltimaVenta(Date fechaUltimaVenta) {
        this.fechaUltimaVenta = fechaUltimaVenta;
    }

    public Integer getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Integer idInforme) {
        this.idInforme = idInforme;
    }

    public Integer getSaldoTaller() {
        return saldoTaller;
    }

    public void setSaldoTaller(Integer saldoTaller) {
        this.saldoTaller = saldoTaller;
    }

    public Integer getSaldoGarantia() {
        return saldoGarantia;
    }

    public void setSaldoGarantia(Integer saldoGarantia) {
        this.saldoGarantia = saldoGarantia;
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

    public BigDecimal getUtilidadAvanzada() {
        return utilidadAvanzada;
    }

    public void setUtilidadAvanzada(BigDecimal utilidadAvanzada) {
        this.utilidadAvanzada = utilidadAvanzada;
    }

    public Integer getEntradasCompra() {
        return entradasCompra;
    }

    public void setEntradasCompra(Integer entradasCompra) {
        this.entradasCompra = entradasCompra;
    }

    public Integer getEntradasTaller() {
        return entradasTaller;
    }

    public void setEntradasTaller(Integer entradasTaller) {
        this.entradasTaller = entradasTaller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRotacion != null ? idRotacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rotacion)) {
            return false;
        }
        Rotacion other = (Rotacion) object;
        if ((this.idRotacion == null && other.idRotacion != null) || (this.idRotacion != null && !this.idRotacion.equals(other.idRotacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Rotacion{");
        sb.append("referencia=");
        sb.append(referencia);
        sb.append(", rotacionPorcentaje=");
        sb.append((rotacionPorcentaje != null ? rotacionPorcentaje.floatValue() : rotacionPorcentaje));
        sb.append(", cantidadComprada=");
        sb.append((cantidadComprada != null ? cantidadComprada.intValue() : cantidadComprada));
        sb.append(", cantidadVendida=");
        sb.append(cantidadVendida != null ? cantidadVendida.intValue() : cantidadVendida);
        sb.append(", cantidadEntrada=");
        sb.append(cantidadEntradaNeta != null ? cantidadEntradaNeta.intValue() : cantidadEntradaNeta);
        sb.append(", cantidadSalida=");
        sb.append(cantidadSalida != null ? cantidadSalida.intValue() : cantidadSalida);
        sb.append(", saldoVenta=");
        sb.append(saldoVenta != null ? saldoVenta.intValue() : saldoVenta);
        sb.append(", totalComprado=");
        sb.append(totalComprado != null ? totalComprado.intValue() : totalComprado);
        sb.append(", rotacionPromedioDias=");
        sb.append(rotacionPromedioDias != null ? rotacionPromedioDias.floatValue() : rotacionPromedioDias);
        sb.append(", rotacionPromedioDiasAvanz=");
        sb.append(rotacionPromedioDiasAvanz != null ? rotacionPromedioDiasAvanz.floatValue() : rotacionPromedioDiasAvanz);
        sb.append(", perfil=");
        sb.append(perfil);
        sb.append(", refCorta=");
        sb.append(refCorta);
        sb.append(", modelo=");
        sb.append(modelo);
        sb.append(", refProv=");
        sb.append(refProv);
        sb.append(", descripcion=");
        sb.append(descripcion);
        sb.append(", codDpto=");
        sb.append(codDpto);
        sb.append(", nomDpto=");
        sb.append(nomDpto);
        sb.append(", codGrupo=");
        sb.append(codGrupo);
        sb.append(", nomGrupo=");
        sb.append(nomGrupo);
        sb.append(", codSubGrupo=");
        sb.append(codSubGrupo);
        sb.append(", nomSubGrupo=");
        sb.append(nomSubGrupo);
        sb.append(", codColores=");
        sb.append(codColores);
        sb.append(", colores=");
        sb.append(colores);
        sb.append(", codMateriales=");
        sb.append(codMateriales);
        sb.append(", materiales=");
        sb.append(materiales);
        sb.append(", proveedor=");
        sb.append(proveedor);
        sb.append(", nombreWeb=");
        sb.append(nombreWeb);
        sb.append(", precioSinIva=");
        sb.append(precioSinIva != null ? precioSinIva.intValue() : precioSinIva);
        sb.append(", idRotacion=");
        sb.append(idRotacion);
        sb.append(", fechaUltimaVenta=");
        sb.append(fechaUltimaVenta);
        sb.append(", idInforme=");
        sb.append(idInforme != null ? idInforme.intValue() : idInforme);
        sb.append(", saldoTaller=");
        sb.append(saldoTaller != null ? saldoTaller.intValue() : saldoTaller);
        sb.append(", saldoGarantia=");
        sb.append(saldoGarantia != null ? saldoGarantia.intValue() : saldoGarantia);
        sb.append(", utilidadPromedio=");
        sb.append(utilidadPromedio != null ? utilidadPromedio.floatValue() : utilidadPromedio);
        sb.append(", utilidadMinima=");
        sb.append(utilidadMinima != null ? utilidadMinima.floatValue() : utilidadPromedio);
        sb.append(", entradasCompra=");
        sb.append(entradasCompra);
        sb.append(", entradasTaller=");
        sb.append(entradasTaller);
        sb.append('}');

        return sb.toString();
    }
}
