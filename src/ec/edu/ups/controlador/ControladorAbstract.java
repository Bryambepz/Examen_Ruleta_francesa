/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.Utils.JAPUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author braya
 */
public abstract class ControladorAbstract<T> {
    private List<T> listaObjetos;
    private Class<T> clase;
    private EntityManager em;

    public ControladorAbstract() {
        listaObjetos = new ArrayList<>();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clase = (Class) pt.getActualTypeArguments()[0];
        em = JAPUtils.getEntityManager();
    }
    
    public ControladorAbstract(EntityManager em) {
        listaObjetos = new ArrayList<>();
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clase = (Class) pt.getActualTypeArguments()[0];
        this.em = em;
    }
    
    public T create(T objeto){
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        listaObjetos.add(objeto);
        return objeto;
    }
    
//    public boolean delete(T objeto){
//        em.getTransaction().begin();
//        em.remove(em.merge(objeto));
//        em.getTransaction().commit();
//        listaObjetos.remove(objeto);
//        return true;
//    }
//    
//    public T update(T objeto){
//        em.getTransaction().begin();
//        objeto = em.merge(objeto);
//        em.getTransaction().commit();
//        this.findAll();
//        return objeto;
//    }
//    
    public T read(Object id){
        return (T) em.find(clase, id);
    }
    
    public List<T> findAll(){
        return em.createQuery("Select t from " + clase.getSimpleName() + " t").getResultList();
    }

    public List<T> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<T> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public Class<T> getClase() {
        return clase;
    }

    public void setClase(Class<T> clase) {
        this.clase = clase;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}
