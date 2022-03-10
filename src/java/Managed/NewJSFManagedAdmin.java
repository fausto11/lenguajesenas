/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Entidades.Contenido;
import Entidades.Tema;
import Sesiones.ContenidoFacadeLocal;
import Sesiones.TemaFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author faust
 */
@ManagedBean(name="NewJSFManagedAdmin")
@SessionScoped
public class NewJSFManagedAdmin {

      @EJB
      private ContenidoFacadeLocal manejadorContenido;
      private Contenido contenido;
      private List<Contenido> listaContenido;
      
      @EJB
      private TemaFacadeLocal manejadorTemas;
      private Tema tema;
      private String idcontenido;
      private List<Tema> listaTema;
      
    public NewJSFManagedAdmin() {

    }
    
    public void listaTema(){
        setListaTema(manejadorTemas.findAll());
    }
    
     public void guardarContenido(){
          manejadorContenido.create(contenido);
      }
     
     public void guardarTema(){
         this.tema.setIdcontenido(manejadorContenido.find(idcontenido));
         manejadorTemas.create(tema);
     }
     
     
     public void listarContenido(){
         setListaContenido(manejadorContenido.findAll());
     }
     
     @PostConstruct
     private void iniciar(){
         contenido = new Contenido();
         tema = new Tema();
         listarContenido();
         listaTema();
     }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public List<Contenido> getListaContenido() {
        return listaContenido;
    }

    public void setListaContenido(List<Contenido> listaContenido) {
        this.listaContenido = listaContenido;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String getIdcontenido() {
        return idcontenido;
    }

    public void setIdcontenido(String idcontenido) {
        this.idcontenido = idcontenido;
    }

    public List<Tema> getListaTema() {
        return listaTema;
    }

    public void setListaTema(List<Tema> listaTema) {
        this.listaTema = listaTema;
    }

    
    
}
