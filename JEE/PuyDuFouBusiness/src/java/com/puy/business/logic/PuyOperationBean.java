/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.logic;

import com.puy.business.entites.Spectacle;
import com.puy.business.entites.Utilisateur;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Antoine
 */
@Stateless
public class PuyOperationBean implements PuyOperationBeanRemote {
    
    
    @PersistenceContext(unitName = "PuyDuFouBusinessPU")
    private EntityManager em;
    
    
    @Override
    public List<Spectacle> getListeSpectacles() {
        List<Spectacle> a = em.createNamedQuery("Spectacle.findAll").getResultList();
        
        return a;
    }

    @Override
    public boolean verifierAdresseMac(String adresseMac) {
        
        if(adresseMac.equals(null)){
            return false;
        }else{
            Query q = em.createNamedQuery("Utilisateur.findByIdUtilisateur").setParameter("idUtilisateur", adresseMac);
        
            List results = q.getResultList();

            if(results.isEmpty() || results==null){
                Utilisateur user = new Utilisateur(adresseMac);
                em.persist(user);
            }
        
        return true;
        }
        
        
    }
    
    

    

    
    
}
