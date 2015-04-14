/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "finca", catalog = "turu", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Finca.findAll", query = "SELECT f FROM Finca f"),
    @NamedQuery(name = "Finca.findByIdFinca", query = "SELECT f FROM Finca f WHERE f.idFinca = :idFinca")})
public class Finca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_finca", nullable = false)
    private Integer idFinca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFinca", fetch = FetchType.LAZY)
    private List<Potrero> potreroList;

    public Finca() {
    }

    public Finca(Integer idFinca) {
        this.idFinca = idFinca;
    }

    public Integer getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Integer idFinca) {
        this.idFinca = idFinca;
    }

    public List<Potrero> getPotreroList() {
        return potreroList;
    }

    public void setPotreroList(List<Potrero> potreroList) {
        this.potreroList = potreroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFinca != null ? idFinca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finca)) {
            return false;
        }
        Finca other = (Finca) object;
        if ((this.idFinca == null && other.idFinca != null) || (this.idFinca != null && !this.idFinca.equals(other.idFinca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turu.entidades.Finca[ idFinca=" + idFinca + " ]";
    }
    
}
