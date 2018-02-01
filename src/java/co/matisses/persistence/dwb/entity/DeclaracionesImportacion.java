package co.matisses.persistence.dwb.entity;

import java.io.Serializable;
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
@Table(name = "declaraciones_importacion")
public class DeclaracionesImportacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDIM")
    private Integer idDIM;
    @Basic(optional = false)
    @Column(name = "numimp")
    private String numimp;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "DO")
    private String do1;
    @Column(name = "DIM")
    private String dim;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "saldo")
    private Integer saldo;
    @Column(name = "nroFila")
    private Integer nroFila;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fechaInsercion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInsercion;

    public DeclaracionesImportacion() {
    }

    public DeclaracionesImportacion(Integer idDIM) {
        this.idDIM = idDIM;
    }

    public DeclaracionesImportacion(Integer idDIM, String numimp, String referencia, int cantidad) {
        this.idDIM = idDIM;
        this.numimp = numimp;
        this.referencia = referencia;
        this.cantidad = cantidad;
    }

    public Integer getIdDIM() {
        return idDIM;
    }

    public void setIdDIM(Integer idDIM) {
        this.idDIM = idDIM;
    }

    public String getNumimp() {
        return numimp;
    }

    public void setNumimp(String numimp) {
        this.numimp = numimp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDo1() {
        return do1;
    }

    public void setDo1(String do1) {
        this.do1 = do1;
    }

    public String getDim() {
        return dim;
    }

    public void setDim(String dim) {
        this.dim = dim;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getNroFila() {
        return nroFila;
    }

    public void setNroFila(Integer nroFila) {
        this.nroFila = nroFila;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDIM != null ? idDIM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeclaracionesImportacion)) {
            return false;
        }
        DeclaracionesImportacion other = (DeclaracionesImportacion) object;
        if ((this.idDIM == null && other.idDIM != null) || (this.idDIM != null && !this.idDIM.equals(other.idDIM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.matisses.dwb.persistence.entity.DeclaracionesImportacion[ idDIM=" + idDIM + " ]";
    }
}
