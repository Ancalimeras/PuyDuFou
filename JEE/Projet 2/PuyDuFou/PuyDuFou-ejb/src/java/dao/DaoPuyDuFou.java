/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antoine
 */
@Stateless
public class DaoPuyDuFou implements DaoPuyDuFouRemote {

    @PersistenceContext(unitName = "PuyDuFou-ejbPU")
    private EntityManager em;
    
    
    
    
    
    @Override
    public String test(){
        return "test";
    }
    /*
    @Override
    public Commande getLaCommande(Long numcom) {
        return em.find(Commande.class, numcom);
    }*/
    
    /*
    @Override
    public List<Region> getlesRegions(){
       return em.createQuery("SELECT R FROM Region R").getResultList();
       
   }
    
    @Override
    public  <T> T        getEntite( Class<T> classeEntite, Object cle){
        
        return em.find( classeEntite, cle);
        
    }
    
    
    
    @Override
    public Produit getProduit(String refProd) {
       
        return getEntite(Produit.class, refProd);
    }
    
    
    
@Override
    public void enregistrerEntite(Object entite) {
        
        em.persist(entite);
    }

    
    @Override
    public void supprimerEntite(Object entite) {
        
        Object asupp=em.merge(entite);
        em.remove(asupp);
    }
    
    @Override
        public void repercuterMAJ(Object entite) {
        
        entite=em.merge(entite);
    }
    
    @Override
    public void detacher(Object entite){
    
        em.detach(entite);
    }
    
    @Override
    public void rafraichir(Object entite){
    
       em.refresh(entite);
       
       
    }*/
    
    
}
