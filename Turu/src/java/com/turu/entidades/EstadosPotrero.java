/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "estados_potrero", catalog = "turu", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID"})})
@NamedQueries({
    @NamedQuery(name = "EstadosPotrero.findAll", query = "SELECT e FROM EstadosPotrero e"),
    @NamedQuery(name = "EstadosPotrero.findById", query = "SELECT e FROM EstadosPotrero e WHERE e.id = :id"),
    @NamedQuery(name = "EstadosPotrero.findByNombre", query = "SELECT e FROM EstadosPotrero e WHERE e.nombre = :nombre")})
public class EstadosPotrero implements Serializable {
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

    public EstadosPotrero() {
    }

    public EstadosPotrero(BigDecimal id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosPotrero)) {
            return false;
        }
        EstadosPotrero other = (EstadosPotrero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turu.entidades.EstadosPotrero[ id=" + id + " ]";
    }
    
}
