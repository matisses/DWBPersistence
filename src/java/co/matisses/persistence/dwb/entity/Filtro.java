package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ygil
 */
@Entity
@Table(name = "filtro")
public class Filtro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_filtro")
    private Integer idFiltro;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "multiples_valores")
    private boolean multiplesValores;
    @Basic(optional = false)
    @Column(name = "codigo_columna")
    private String codigoColumna;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "sufijo")
    private String sufijo;
    @Column(name = "tipoReferencia")
    private boolean tipoReferencia;
    @Column(name = "tamano_minimo")
    private Integer tamanoMinimo;
    @Column(name = "tamano_maximo")
    private Integer tamanoMaximo;
    @Column(name = "formato")
    private String formato;
    @Column(name = "fachada")
    private String fachada;
    @Column(name = "metodo")
    private String metodo;
    @Column(name = "tipo_retorno")
    private String tipoRetorno;

    public Filtro() {
    }

    public Filtro(Integer idFiltro) {
        this.idFiltro = idFiltro;
    }

    public Filtro(Integer idFiltro, String nombre, boolean multiplesValores, String codigoColumna, String tipo, String sufijo, boolean tipoReferencia,
            Integer tamanoMinimo, Integer tamanoMaximo, String formato, String fachada, String metodo, String tipoRetorno) {
        this.idFiltro = idFiltro;
        this.nombre = nombre;
        this.multiplesValores = multiplesValores;
        this.codigoColumna = codigoColumna;
        this.tipo = tipo;
        this.sufijo = sufijo;
        this.tipoReferencia = tipoReferencia;
        this.tamanoMinimo = tamanoMinimo;
        this.tamanoMaximo = tamanoMaximo;
        this.formato = formato;
        this.fachada = fachada;
        this.metodo = metodo;
        this.tipoRetorno = tipoRetorno;
    }

    public Integer getIdFiltro() {
        return idFiltro;
    }

    public void setIdFiltro(Integer idFiltro) {
        this.idFiltro = idFiltro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMultiplesValores() {
        return multiplesValores;
    }

    public void setMultiplesValores(boolean multiplesValores) {
        this.multiplesValores = multiplesValores;
    }

    public String getCodigoColumna() {
        return codigoColumna;
    }

    public void setCodigoColumna(String codigoColumna) {
        this.codigoColumna = codigoColumna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSufijo() {
        return sufijo;
    }

    public void setSufijo(String sufijo) {
        this.sufijo = sufijo;
    }

    public boolean isTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(boolean tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

    public Integer getTamanoMinimo() {
        return tamanoMinimo;
    }

    public void setTamanoMinimo(Integer tamanoMinimo) {
        this.tamanoMinimo = tamanoMinimo;
    }

    public Integer getTamanoMaximo() {
        return tamanoMaximo;
    }

    public void setTamanoMaximo(Integer tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFachada() {
        return fachada;
    }

    public void setFachada(String fachada) {
        this.fachada = fachada;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFiltro != null ? idFiltro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filtro)) {
            return false;
        }
        Filtro other = (Filtro) object;
        if ((this.idFiltro == null && other.idFiltro != null) || (this.idFiltro != null && !this.idFiltro.equals(other.idFiltro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.persistence.dwb.entity.Filtro[ idFiltro=" + idFiltro + " ]";
    }
}
