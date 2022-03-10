/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Entidades.Usuario;
import Sesiones.UsuarioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author faust
 */
@ManagedBean(name="JSFManagedLogin")
@SessionScoped
public class JSFManagedLogin {

    @EJB
    private UsuarioFacadeLocal manejadorUsuario;
    private Usuario usuario;
    
    public String inicioSesion(){
      String contrasena=usuario.getContrasena();
      
      this.usuario = manejadorUsuario.getIniciarSesion(usuario);
        if (usuario.getContrasena().equals(contrasena)) {
           // System.out.println(usuario.getIdrole().toString());
            if (usuario.getIdrole().toString().equals("Entidades.Tipousuario[ idrole=ADMIN ]")) {
                return "temasAdmin.xhtml";
                
            }else{
                return "contenido.xhtml";
            }
           
        }else{
            return "index.xhtml";
        }   
    }
   
    
   @PostConstruct
    public void inicio(){
       usuario=new Usuario();
   }
    
    
    public JSFManagedLogin() {
    }

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
