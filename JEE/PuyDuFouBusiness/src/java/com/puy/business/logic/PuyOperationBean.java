/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.logic;

import com.puy.business.entites.Note;
import com.puy.business.entites.NotePK;
import com.puy.business.entites.Spectacle;
import com.puy.business.entites.Utilisateur;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    public String testWS() {
       // List<Spectacle> a = em.createNamedQuery("Spectacle.findAll").getResultList();
      
        return "COucou";
    }

    @Override
    public String evaluerSpectacle(float note, int idSpectacle, String idUtilisateur) {
        Spectacle s = (Spectacle) em.createNamedQuery("Spectacle.findByIdSpectacle").setParameter("idSpectacle", idSpectacle).getSingleResult();
        Utilisateur u = new Utilisateur(idUtilisateur);
        NotePK nPK = new NotePK(idSpectacle, idUtilisateur);
        Note nouvNote = new Note();
        nouvNote.setNotePK(nPK);
        nouvNote.setNote(note);
        nouvNote.setSpectacle(s);
        nouvNote.setUtilisateur(u);
        em.persist(nouvNote);
        
        double moyNote = (double) em.createQuery("Select avg(n.note) FROM Note n WHERE n.notePK.idSpectacle = :idSpectacle").setParameter("idSpectacle", idSpectacle).getSingleResult();
        //float nbNote = (float) em.createQuery("Select count(n.note) FROM Note n WHERE n.notePK.idSpectacle = :idSpectacle").setParameter("idSpectacle", idSpectacle).getSingleResult(); 
        String moyFormated = new DecimalFormat("##.##").format(moyNote);
        s.setMoyenneNote((float) moyNote);
        em.persist(s);

        return moyFormated;
    }

    
    
}
