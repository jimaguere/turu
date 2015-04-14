/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "potrero", catalog = "turu", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Potrero.findAll", query = "SELECT p FROM Potrero p"),
    @NamedQuery(name = "Potrero.findById", query = "SELECT p FROM Potrero p WHERE p.id = :id"),
    @NamedQuery(name = "Potrero.findByArea", query = "SELECT p FROM Potrero p WHERE p.area = :area"),
    @NamedQuery(name = "Potrero.findByForraje", query = "SELECT p FROM Potrero p WHERE p.forraje = :forraje"),
    @NamedQuery(name = "Potrero.findByCarga", query = "SELECT p FROM Potrero p WHERE p.carga = :carga"),
    @NamedQuery(name = "Potrero.findByDiasUsoInv", query = "SELECT p FROM Potrero p WHERE p.diasUsoInv = :diasUsoInv"),
    @NamedQuery(name = "Potrero.findByDiasDescansoInv", query = "SELECT p FROM Potrero p WHERE p.diasDescansoInv = :diasDescansoInv"),
    @NamedQuery(name = "Potrero.findByDiasUsoVer", query = "SELECT p FROM Potrero p WHERE p.diasUsoVer = :diasUsoVer"),
    @NamedQuery(name = "Potrero.findByDiasDescansoVer", query = "SELECT p FROM Potrero p WHERE p.diasDescansoVer = :diasDescansoVer"),
    @NamedQuery(name = "Potrero.findByEstado", query = "SELECT p FROM Potrero p WHERE p.estado = :estado"),
    @NamedQuery(name = "Potrero.findByScore", query = "SELECT p FROM Potrero p WHERE p.score = :score"),
    @NamedQuery(name = "Potrero.findByNombre", query = "SELECT p FROM Potrero p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Potrero.findByFechaAntRot", query = "SELECT p FROM Potrero p WHERE p.fechaAntRot = :fechaAntRot"),
    @NamedQuery(name = "Potrero.findByFechaProxRot", query = "SELECT p FROM Potrero p WHERE p.fechaProxRot = :fechaProxRot"),
    @NamedQuery(name = "Potrero.findByLatitud", query = "SELECT p FROM Potrero p WHERE p.latitud = :latitud"),
    @NamedQuery(name = "Potrero.findByLongitud", query = "SELECT p FROM Potrero p WHERE p.longitud = :longitud")})
public class Potrero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "area")
    private BigInteger area;
    @Column(name = "forraje")
    private BigInteger forraje;
    @Column(name = "carga")
    private BigInteger carga;
    @Column(name = "dias_uso_inv")
    private BigInteger diasUsoInv;
    @Column(name = "dias_descanso_inv")
    private BigInteger diasDescansoInv;
    @Column(name = "dias_uso_ver")
    private BigInteger diasUsoVer;
    @Column(name = "dias_descanso_ver")
    private BigInteger diasDescansoVer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private BigInteger estado;
    @Column(name = "score")
    private BigInteger score;
    @Size(max = 2147483647)
    @Column(name = "nombre", length = 2147483647)
    private String nombre;
    @Column(name = "fecha_ant_rot")
    @Temporal(TemporalType.DATE)
    private Date fechaAntRot;
    @Column(name = "fecha_prox_rot")
    @Temporal(TemporalType.DATE)
    private Date fechaProxRot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud", precision = 17, scale = 17)
    private Double latitud;
    @Column(name = "longitud", precision = 17, scale = 17)
    private Double longitud;
    @JoinColumn(name = "id_finca", referencedColumnName = "id_finca", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Finca idFinca;

    public Potrero() {
    }

    public Potrero(Integer id) {
        this.id = id;
    }

    public Potrero(Integer id, BigInteger estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getArea() {
        return area;
    }

    public void setArea(BigInteger area) {
        this.area = area;
    }

    public BigInteger getForraje() {
        return forraje;
    }

    public void setForraje(BigInteger forraje) {
        this.forraje = forraje;
    }

    public BigInteger getCarga() {
        return carga;
    }

    public void setCarga(BigInteger carga) {
        this.carga = carga;
    }

    public BigInteger getDiasUsoInv() {
        return diasUsoInv;
    }

    public void setDiasUsoInv(BigInteger diasUsoInv) {
        this.diasUsoInv = diasUsoInv;
    }

    public BigInteger getDiasDescansoInv() {
        return diasDescansoInv;
    }

    public void setDiasDescansoInv(BigInteger diasDescansoInv) {
        this.diasDescansoInv = diasDescansoInv;
    }

    public BigInteger getDiasUsoVer() {
        return diasUsoVer;
    }

    public void setDiasUsoVer(BigInteger diasUsoVer) {
        this.diasUsoVer = diasUsoVer;
    }

    public BigInteger getDiasDescansoVer() {
        return diasDescansoVer;
    }

    public void setDiasDescansoVer(BigInteger diasDescansoVer) {
        this.diasDescansoVer = diasDescansoVer;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public BigInteger getScore() {
        return score;
    }

    public void setScore(BigInteger score) {
        this.score = score;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAntRot() {
        return fechaAntRot;
    }

    public void setFechaAntRot(Date fechaAntRot) {
        this.fechaAntRot = fechaAntRot;
    }

    public Date getFechaProxRot() {
        return fechaProxRot;
    }

    public void setFechaProxRot(Date fechaProxRot) {
        this.fechaProxRot = fechaProxRot;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Finca getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Finca idFinca) {
        this.idFinca = idFinca;
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
        if (!(object instanceof Potrero)) {
            return false;
        }
        Potrero other = (Potrero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turu.entidades.Potrero[ id=" + id + " ]";
    }
    
}
