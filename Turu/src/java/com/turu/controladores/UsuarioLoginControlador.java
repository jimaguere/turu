/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.controladores;


import com.turu.daos.UsuarioFacade;
import com.turu.entidades.Usuario;



import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author mateo
 */
@ManagedBean(name = "usuarioLogin")
@SessionScoped
public class UsuarioLoginControlador {

    /**
     * Creates a new instance of UsuarioLoginControlador
     */
     @EJB
    UsuarioFacade usuarioFacade;
    private String usuario;
    private String clave;
    private String claveActual;
    private String claveNueva;
    private String claveConfirmada;
    private boolean login;
    private String url;
    private Usuario usuarioEdit;

    public String getClaveActual() {
        return claveActual;
    }

    public void setClaveActual(String claveActual) {
        this.claveActual = claveActual;
    }

    public String getClaveNueva() {
        return claveNueva;
    }

    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }

    public String getClaveConfirmada() {
        return claveConfirmada;
    }

    public void setClaveConfirmada(String claveConfirmada) {
        this.claveConfirmada = claveConfirmada;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;        
    }

    public String cerrarSession() throws IOException {
        this.login = false;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().getSession(login);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/Inicial/Menu.xhtml";
    }
    
    public void editarSeguridad() throws Exception{
        if(!this.clave.equals(this.claveActual)){
              FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña Actual incorrecta", ""));
              return;
        }
        if(!this.claveConfirmada.equals(this.claveNueva)){
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden ", ""));
            return;
        }
        usuarioEdit.setClave(md5(this.claveConfirmada));
        this.usuarioFacade.edit(usuarioEdit);
        this.clave=this.claveConfirmada;
        this.claveConfirmada=new String();
        this.claveActual=new String();
        this.claveNueva=new String();
        FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseñas cambiada exitosamente ", ""));
    }

    public void confirmar() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        List<Usuario> usuarios = usuarioFacade.findUsuario(this.usuario);
        if (usuarios.isEmpty()) {
            context.addMessage(null, new FacesMessage("Error usuario:", this.usuario + " No existe"));
            return;
        }
        Usuario user = usuarios.get(0);
        usuarioEdit=user;
       
        if (user.getClave().equals(md5(this.clave))) {
            this.login = true;
            context.getExternalContext().redirect("Menu/index.xhtml");
        } else {
            context.addMessage(null, new FacesMessage("Error", "Clave Incorrecta para el usuario:" + this.usuario));
        }
    }

    private static String md5(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());
        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0" + Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }

        return h.toString();
    }

    /**
     * Creates a new instance of UsuarioLogin
     */
   
    @PostConstruct
    public void reset(){
        ServletContext servContx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        url=(String) servContx.getContextPath();
        
    }
    
    public UsuarioLoginControlador() {
    }
}
