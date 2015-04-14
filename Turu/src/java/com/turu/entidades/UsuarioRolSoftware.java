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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "usuario_rol_software", catalog = "turu", schema = "public")
@NamedQueries({
    @NamedQuery(name = "UsuarioRolSoftware.findAll", query = "SELECT u FROM UsuarioRolSoftware u"),
    @NamedQuery(name = "UsuarioRolSoftware.findByIdUsuarioRolSoftwarre", query = "SELECT u FROM UsuarioRolSoftware u WHERE u.idUsuarioRolSoftwarre = :idUsuarioRolSoftwarre")})
public class UsuarioRolSoftware implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_rol_softwarre", nullable = false)
    private Integer idUsuarioRolSoftwarre;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RolSoftware idRol;

    public UsuarioRolSoftware() {
    }

    public UsuarioRolSoftware(Integer idUsuarioRolSoftwarre) {
        this.idUsuarioRolSoftwarre = idUsuarioRolSoftwarre;
    }

    public Integer getIdUsuarioRolSoftwarre() {
        return idUsuarioRolSoftwarre;
    }

    public void setIdUsuarioRolSoftwarre(Integer idUsuarioRolSoftwarre) {
        this.idUsuarioRolSoftwarre = idUsuarioRolSoftwarre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RolSoftware getIdRol() {
        return idRol;
    }

    public void setIdRol(RolSoftware idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioRolSoftwarre != null ? idUsuarioRolSoftwarre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRolSoftware)) {
            return false;
        }
        UsuarioRolSoftware other = (UsuarioRolSoftware) object;
        if ((this.idUsuarioRolSoftwarre == null && other.idUsuarioRolSoftwarre != null) || (this.idUsuarioRolSoftwarre != null && !this.idUsuarioRolSoftwarre.equals(other.idUsuarioRolSoftwarre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.turu.entidades.UsuarioRolSoftware[ idUsuarioRolSoftwarre=" + idUsuarioRolSoftwarre + " ]";
    }
    
}
