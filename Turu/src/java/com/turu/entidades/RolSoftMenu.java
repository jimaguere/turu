/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "rol_soft_menu", catalog = "turu", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RolSoftMenu.findAll", query = "SELECT r FROM RolSoftMenu r"),
    @NamedQuery(name = "RolSoftMenu.findByIdRolSofMenu", query = "SELECT r FROM RolSoftMenu r WHERE r.idRolSofMenu = :idRolSofMenu")})
public class RolSoftMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol_sof_menu", nullable = false)
    private Integer idRolSofMenu;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RolSoftware idRol;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Menu idMenu;

    public RolSoftMenu() {
    }

    public RolSoftMenu(Integer idRolSofMenu) {
        this.idRolSofMenu = idRolSofMenu;
    }

    public Integer getIdRolSofMenu() {
        return idRolSofMenu;
    }

    public void setIdRolSofMenu(Integer idRolSofMenu) {
        this.idRolSofMenu = idRolSofMenu;
    }

    public RolSoftware getIdRol() {
        return idRol;
    }

    public void setIdRol(RolSoftware idRol) {
        this.idRol = idRol;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolSofMenu != null ? idRolSofMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolSoftMenu)) {
            return false;
        }
        RolSoftMenu other = (RolSoftMenu) object;
        if ((this.idRolSofMenu == null && other.idRolSofMenu != null) || (this.idRolSofMenu != null && !this.idRolSofMenu.equals(other.idRolSofMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turu.entidades.RolSoftMenu[ idRolSofMenu=" + idRolSofMenu + " ]";
    }
    
}
