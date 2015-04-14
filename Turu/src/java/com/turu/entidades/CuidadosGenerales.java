/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "cuidados_generales", catalog = "turu", schema = "public")
@NamedQueries({
    @NamedQuery(name = "CuidadosGenerales.findAll", query = "SELECT c FROM CuidadosGenerales c"),
    @NamedQuery(name = "CuidadosGenerales.findById", query = "SELECT c FROM CuidadosGenerales c WHERE c.id = :id"),
    @NamedQuery(name = "CuidadosGenerales.findByNombre", query = "SELECT c FROM CuidadosGenerales c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CuidadosGenerales.findByDescripcion", query = "SELECT c FROM CuidadosGenerales c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CuidadosGenerales.findByFechaAnt", query = "SELECT c FROM CuidadosGenerales c WHERE c.fechaAnt = :fechaAnt"),
    @NamedQuery(name = "CuidadosGenerales.findByFechaProx", query = "SELECT c FROM CuidadosGenerales c WHERE c.fechaProx = :fechaProx"),
    @NamedQuery(name = "CuidadosGenerales.findByProductos", query = "SELECT c FROM CuidadosGenerales c WHERE c.productos = :productos"),
    @NamedQuery(name = "CuidadosGenerales.findByObservaciones", query = "SELECT c FROM CuidadosGenerales c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CuidadosGenerales.findByCostoInsumo", query = "SELECT c FROM CuidadosGenerales c WHERE c.costoInsumo = :costoInsumo"),
    @NamedQuery(name = "CuidadosGenerales.findByCostoJornal", query = "SELECT c FROM CuidadosGenerales c WHERE c.costoJornal = :costoJornal"),
    @NamedQuery(name = "CuidadosGenerales.findByPeriodicidad", query = "SELECT c FROM CuidadosGenerales c WHERE c.periodicidad = :periodicidad"),
    @NamedQuery(name = "CuidadosGenerales.findByDuracion", query = "SELECT c FROM CuidadosGenerales c WHERE c.duracion = :duracion"),
    @NamedQuery(name = "CuidadosGenerales.findByTipo", query = "SELECT c FROM CuidadosGenerales c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "CuidadosGenerales.findByIdCuidadoAp", query = "SELECT c FROM CuidadosGenerales c WHERE c.idCuidadoAp = :idCuidadoAp"),
    @NamedQuery(name = "CuidadosGenerales.findByFecha", query = "SELECT c FROM CuidadosGenerales c WHERE c.fecha = :fecha")})
public class CuidadosGenerales implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 131089, scale = 0)
    private BigDecimal id;
    @Size(max = 2147483647)
    @Column(name = "NOMBRE", length = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "DESCRIPCION", length = 2147483647)
    private String descripcion;
    @Column(name = "FECHA_ANT")
    @Temporal(TemporalType.DATE)
    private Date fechaAnt;
    @Column(name = "FECHA_PROX")
    @Temporal(TemporalType.DATE)
    private Date fechaProx;
    @Column(name = "PRODUCTOS")
    private BigInteger productos;
    @Size(max = 2147483647)
    @Column(name = "OBSERVACIONES", length = 2147483647)
    private String observaciones;
    @Column(name = "COSTO_INSUMO")
    private BigInteger costoInsumo;
    @Column(name = "COSTO_JORNAL")
    private BigInteger costoJornal;
    @Column(name = "PERIODICIDAD")
    private BigInteger periodicidad;
    @Column(name = "DURACION")
    private BigInteger duracion;
    @Column(name = "TIPO")
    private BigInteger tipo;
    @Column(name = "ID_CUIDADO_AP")
    private BigInteger idCuidadoAp;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public CuidadosGenerales() {
    }

    public CuidadosGenerales(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAnt() {
        return fechaAnt;
    }

    public void setFechaAnt(Date fechaAnt) {
        this.fechaAnt = fechaAnt;
    }

    public Date getFechaProx() {
        return fechaProx;
    }

    public void setFechaProx(Date fechaProx) {
        this.fechaProx = fechaProx;
    }

    public BigInteger getProductos() {
        return productos;
    }

    public void setProductos(BigInteger productos) {
        this.productos = productos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigInteger getCostoInsumo() {
        return costoInsumo;
    }

    public void setCostoInsumo(BigInteger costoInsumo) {
        this.costoInsumo = costoInsumo;
    }

    public BigInteger getCostoJornal() {
        return costoJornal;
    }

    public void setCostoJornal(BigInteger costoJornal) {
        this.costoJornal = costoJornal;
    }

    public BigInteger getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(BigInteger periodicidad) {
        this.periodicidad = periodicidad;
    }

    public BigInteger getDuracion() {
        return duracion;
    }

    public void setDuracion(BigInteger duracion) {
        this.duracion = duracion;
    }

    public BigInteger getTipo() {
        return tipo;
    }

    public void setTipo(BigInteger tipo) {
        this.tipo = tipo;
    }

    public BigInteger getIdCuidadoAp() {
        return idCuidadoAp;
    }

    public void setIdCuidadoAp(BigInteger idCuidadoAp) {
        this.idCuidadoAp = idCuidadoAp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuidadosGenerales)) {
            return false;
        }
        CuidadosGenerales other = (CuidadosGenerales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turu.entidades.CuidadosGenerales[ id=" + id + " ]";
    }
    
}
