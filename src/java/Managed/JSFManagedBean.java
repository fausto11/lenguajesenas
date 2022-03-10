/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Entidades.Tipousuario;
import Entidades.Usuario;
import Sesiones.TipousuarioFacadeLocal;
import Sesiones.UsuarioFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author faust
 */
@ManagedBean(name="JSFManagedBean")
@SessionScoped
public class JSFManagedBean {

    @EJB
    private TipousuarioFacadeLocal manejadorTipoUsuario;
    private Tipousuario tipoUsuario;
    private List<Tipousuario> listaTipoUsuario;
    
    @EJB
    private UsuarioFacadeLocal manejadorUsuario;
    private Usuario usuario;
    private String idRole;
    private Date fechaNacimiento;
    
    public JSFManagedBean() {
    }
    
    public void guardarTipoUsuario(){
        manejadorTipoUsuario.create(tipoUsuario);
    }
    
    public void obtenerTipoUsuario(){
        setListaTipoUsuario(manejadorTipoUsuario.findAll());
    }
    
    public void grabarUsuario(){
        this.usuario.setIdrole(manejadorTipoUsuario.find(idRole));
        manejadorUsuario.create(usuario);
    }
    
    public String buscar(){
        this.usuario = manejadorUsuario.getIniciarSesion(usuario);
        return "nnn.xhtml";
    }
    
    @PostConstruct
    private void iniciar(){
        usuario=new Usuario();
        tipoUsuario=new Tipousuario();
        obtenerTipoUsuario();
        
    }
    
    public Tipousuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Tipousuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Tipousuario> getListaTipoUsuario() {
        return listaTipoUsuario;
    }

    public void setListaTipoUsuario(List<Tipousuario> listaTipoUsuario) {
        this.listaTipoUsuario = listaTipoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

   
}
