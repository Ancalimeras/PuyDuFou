/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.logic;

import com.puy.business.entites.Note;
import com.puy.business.entites.NotePK;
import com.puy.business.entites.Planning;
import com.puy.business.entites.Spectacle;
import com.puy.business.entites.Utilisateur;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
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
        
        if(adresseMac == null || adresseMac.length() != 17){
            return false;
        }else{
            //Récupérer l'adresse mac dans la base si elle existe
            Query q = em.createNamedQuery("Utilisateur.findByIdUtilisateur").setParameter("idUtilisateur", adresseMac);
        
            List results = q.getResultList();

            if(results.isEmpty()){
                //Si l'adresse mac de l'appareil n'existe pas dans la bdd, on l'ajoute à la bdd
                Utilisateur user = new Utilisateur(adresseMac);
                em.persist(user);
                return true;
            }else{
                //Return true car l'adresse mac existe
                return true;
            }
        }
    }
    
    @Override
    public String evaluerSpectacle(float note, int idSpectacle, String idUtilisateur) {
        if(note >= 0 && idSpectacle > 0 && idUtilisateur != null){
            List<Spectacle> sList = em.createNamedQuery("Spectacle.findByIdSpectacle").setParameter("idSpectacle", idSpectacle).getResultList();
            if(!sList.isEmpty()){
                Spectacle s = sList.get(0);
                List<Utilisateur> uList = em.createNamedQuery("Utilisateur.findByIdUtilisateur").setParameter("idUtilisateur", idUtilisateur).getResultList();
                List<Note> n = em.createQuery("SELECT n FROM Note n WHERE n.notePK.idSpectacle = :idSpectacle AND n.notePK.idUtilisateur = :idUtilisateur").setParameter("idSpectacle", idSpectacle).setParameter("idUtilisateur", idUtilisateur).getResultList();
                if(n.isEmpty() && !uList.isEmpty()){                      
                    NotePK nPK = new NotePK(idSpectacle, idUtilisateur);
                    Note nouvNote = new Note(nPK);
                    nouvNote.setNote(note);
                    em.persist(nouvNote);        
                    double moyNote = (double) em.createQuery("Select avg(n.note) FROM Note n WHERE n.notePK.idSpectacle = :idSpectacle").setParameter("idSpectacle", idSpectacle).getSingleResult();
                    //float nbNote = (float) em.createQuery("Select count(n.note) FROM Note n WHERE n.notePK.idSpectacle = :idSpectacle").setParameter("idSpectacle", idSpectacle).getSingleResult();
                    String moyFormated = new DecimalFormat("##.##").format(moyNote);
                    s.setMoyenneNote((float) moyNote);
                    em.persist(s);
                    return moyFormated;
                }else{
                    String moyFormated = new DecimalFormat("##.##").format(s.getMoyenneNote());
                    return moyFormated;
                }  
            }else{
                return "Spectacle introuvable";
            }
        }else{
            return "Erreur: paramètre null";
        }        
    }

    
    @Override
    public List<Spectacle> getDetailSpectacles() {
    List<Spectacle> ls = em.createQuery("SELECT s FROM Spectacle s order by s.idSpectacle").getResultList();
    
    for (Spectacle s : ls){
        //List<Planning> lp = s.getPlanningCollection();
        
        //Collection<Planning> listSpec = new LinkedList<Planning>();
        List<Planning> lp = em.createQuery("SELECT p FROM Planning p WHERE p.idSpectacle = :spectacle").setParameter("spectacle", s).getResultList();
        //setPlanningCollection(lp)
        for(Planning p: lp){
            
            em.detach(p);
            //p.setIdSpectacle(null);
            //listSpec.add(p);
            s.getPlanningCollection().add(p);
        }
        //s.setPlanningCollection(listSpec);
    }
    return ls;
    
    }
    
    
    
}
