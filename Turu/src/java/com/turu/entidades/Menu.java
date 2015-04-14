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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "menu", catalog = "turu", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "Menu.findByDescripcion", query = "SELECT m FROM Menu m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Menu.findByUrl", query = "SELECT m FROM Menu m WHERE m.url = :url")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu", nullable = false)
    private Integer idMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion", nullable = false, length = 2147483647)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "url", nullable = false, length = 2147483647)
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu", fetch = FetchType.LAZY)
    private List<RolSoftMenu> rolSoftMenuList;
    @OneToMany(mappedBy = "parentIdMenu", fetch = FetchType.LAZY)
    private List<Menu> menuList;
    @JoinColumn(name = "parent_id_menu", referencedColumnName = "id_menu")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu parentIdMenu;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Menu(Integer idMenu, String descripcion, String url) {
        this.idMenu = idMenu;
        this.descripcion = descripcion;
        this.url = url;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<RolSoftMenu> getRolSoftMenuList() {
        return rolSoftMenuList;
    }

    public void setRolSoftMenuList(List<RolSoftMenu> rolSoftMenuList) {
        this.rolSoftMenuList = rolSoftMenuList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getParentIdMenu() {
        return parentIdMenu;
    }

    public void setParentIdMenu(Menu parentIdMenu) {
        this.parentIdMenu = parentIdMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turu.entidades.Menu[ idMenu=" + idMenu + " ]";
    }
    
}
