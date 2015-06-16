/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.logic;

import com.puy.business.entites.Spectacle;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Antoine
 */
@Stateless
public class PuyOperationBean implements PuyOperationBeanRemote {
    public String adresseMac;
    
    
    @PersistenceContext(unitName = "PuyDuFouBusinessPU")
    private EntityManager em;
    
    
    
    @Override
    public List<Spectacle> testWS() {
        List<Spectacle> a = em.createNamedQuery("Spectacle.findAll").getResultList();
        
        
        return a;
    }

    @Override
    public void checkAdresseMac(String adresseMac) {
        this.adresseMac = adresseMac;
        
        Query q = em.createNamedQuery("Utilisateur.findByIdUtilisateur");
        
        //if(q.ge)
        
    }
    
    
}
