/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.logic;

import com.puy.business.entites.Boutique;
import com.puy.business.entites.MenuRestaurant;
import com.puy.business.entites.Note;
import com.puy.business.entites.NotePK;
import com.puy.business.entites.Planning;
import com.puy.business.entites.Restaurant;
import com.puy.business.entites.Spectacle;
import com.puy.business.entites.Utilisateur;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public boolean noteExiste(int idSpectacle, String idUtilisateur) {
        
        Spectacle spec = em.find(Spectacle.class, idSpectacle);
        Utilisateur util = em.find(Utilisateur.class, idUtilisateur);
        
            Query q = em.createQuery("SELECT n.note FROM Note n WHERE n.spectacle = :idSpectacle and n.utilisateur = :utilisateur").setParameter("idSpectacle", spec).setParameter("utilisateur", util);

            List results = q.getResultList();

            if(results.isEmpty()){
                return false;
            }else{
                return true;
            }
            
    }
        
    
    @Override
    public String evaluerSpectacle(int note, int idSpectacle, String idUtilisateur) {
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
    public List<Planning> getHorairesSpectacle(int idSpectacle) {
        Spectacle spec = em.find(Spectacle.class, idSpectacle);
        
        Locale locale = Locale.FRANCE;
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("EEEE", locale);
        
        String date_jour = date.format(d);
        
        
        List<Planning> listPlanning = em.createQuery("SELECT p.heureDebut FROM Planning p WHERE p.idSpectacle = :idSpectacle AND p.jourSemaine = :jour").setParameter("idSpectacle", spec).setParameter("jour", date_jour).getResultList();
        
        return listPlanning;
    }
    
    
    @Override
    public List<Restaurant> getListeRestaurants() {
        List<Restaurant> rList = em.createNamedQuery("Restaurant.findAll").getResultList();
        if(rList.isEmpty()){
            rList = new ArrayList<Restaurant>();
        }
        return rList;
    }

    @Override
    public List<MenuRestaurant> getMenuRestaurant(int idRestaurant) {
        Restaurant restaurant = em.find(Restaurant.class, idRestaurant);
        List<MenuRestaurant> mr = new ArrayList<MenuRestaurant>();
        List<MenuRestaurant> mrList = em.createQuery("Select mr FROM MenuRestaurant mr WHERE mr.idRestaurant = :idRestaurant").setParameter("idRestaurant", restaurant).getResultList();
        if(!mrList.isEmpty()){
            for(MenuRestaurant menu : mrList){
                MenuRestaurant r = new MenuRestaurant();
                r.setMenu(menu.getMenu());
                r.setDescriptionMenu(menu.getDescriptionMenu());
                r.setTarif(menu.getTarif());
                mr.add(r);
            }
        }
        return mr;
    }

    @Override
    public List<Boutique> getListeBoutiques() {
        List<Boutique> bList = em.createNamedQuery("Boutique.findAll").getResultList();
        if(bList.isEmpty()){
            bList = new ArrayList<Boutique>();
        }
        return bList;
    }
    

    @Override
    public List<Spectacle> getSpectaclesAVenir() {
        Locale locale = Locale.FRANCE;
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("EEEE", locale);
        String date_jour = date.format(d);
        SimpleDateFormat heure = new SimpleDateFormat("kk:mm", locale);
        String heureStr = heure.format(d);
        Date compareDate = null;
        try {
            compareDate = heure.parse(heureStr);
        } catch (ParseException ex) {
            Logger.getLogger(PuyOperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Spectacle> sList = em.createQuery("SELECT DISTINCT s FROM Planning p LEFT JOIN p.idSpectacle s WHERE p.heureDebut > :heure AND p.jourSemaine = :jourSemaine ORDER BY p.heureDebut").setParameter("heure", compareDate).setParameter("jourSemaine", date_jour).getResultList();
      
        return sList;
    }

    @Override
    public List<Planning> getHorairesAVenir(int idSpectacle) {
        Spectacle spectacle = em.find(Spectacle.class, idSpectacle);
        Locale locale = Locale.FRANCE;
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("EEEE", locale);
        String date_jour = date.format(d);
        SimpleDateFormat heure = new SimpleDateFormat("kk:mm", locale);
        String heureStr = heure.format(d);
        Date compareDate = null;
        try {
            compareDate = heure.parse(heureStr);
        } catch (ParseException ex) {
            Logger.getLogger(PuyOperationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Planning> pList = em.createQuery("SELECT p.heureDebut FROM Planning p WHERE p.heureDebut > :heure AND p.jourSemaine = :jourSemaine AND p.idSpectacle = :idSpectacle").setParameter("heure", compareDate).setParameter("jourSemaine", date_jour).setParameter("idSpectacle", spectacle).getResultList();
        if(pList.isEmpty()){
            pList = new ArrayList<Planning>();
        }
        return pList;
    }
    
    @Override
    public int tempsActivites(float lat1, float lng1, float lat2, float lng2){
            Float distance = distance(lat1,lng1,lat2,lng2);
            
            
            Float timeToGo = distance / (5000/60);
            
            int tempsTotal = (int) Math.ceil(timeToGo);
            
            return tempsTotal;
    }
    
    public Float distance(float lat1, float lng1, float lat2, float lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }
    
    @Override
    public List<Spectacle> getMeilleurPlanning() {      
        Locale locale = Locale.FRANCE;
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("EEEE", locale);
        String date_jour = date.format(d);
        List<Spectacle> specList = em.createQuery("SELECT p FROM Planning p LEFT JOIN p.idSpectacle s WHERE p.jourSemaine = :jourSemaine ORDER BY p.heureDebut").setParameter("jourSemaine", date_jour).getResultList();
        List<Planning> pList = em.createQuery("SELECT p FROM Planning p WHERE p.jourSemaine = :jourSemaine ORDER BY p.heureDebut").setParameter("jourSemaine", date_jour).getResultList();
        List<Spectacle> sList = new ArrayList<Spectacle>();  
        Spectacle lastSpec = pList.get(0).getIdSpectacle();       
        Date lastH = new Date(0);
        Date pauseMidi = new Date(11*3600*1000);
        Date pauseSoir = new Date(19*3600*1000);
        boolean doitDejeuner = true;
        boolean doitDiner = true;
        int tpsMarche = 0;
        for(Planning p : pList){
            if(!sList.contains(p.getIdSpectacle())){
                if(pauseMidi.before(p.getHeureDebut()) && doitDejeuner){
                    System.out.println("PAUSE MIDI" + pauseMidi);
                    lastH = new Date(lastH.getTime() + 3600*1000);
                    doitDejeuner = false;
                }
                if(pauseSoir.before(p.getHeureDebut()) && doitDiner){
                    System.out.println("PAUSE SOIR" + pauseSoir);
                    lastH = new Date(lastH.getTime() + 3600*1000);
                    doitDiner = false;
                }
                tpsMarche = tempsActivites(lastSpec.getPositionLatitude(),lastSpec.getPositionLongitude(), p.getIdSpectacle().getPositionLatitude(), p.getIdSpectacle().getPositionLongitude());
                Date heureIntervalle = new Date(lastH.getTime() + tpsMarche*60*1000);
                if(p.getHeureDebut().after(heureIntervalle)){                    
                    System.out.println("last h : "+ heureIntervalle);
                    System.out.println("heure début : "+p.getHeureDebut());
                    lastSpec = p.getIdSpectacle();
                    sList.add(lastSpec);                  
                    lastH = new Date(p.getHeureDebut().getTime() + p.getIdSpectacle().getDuree()*60*1000 + 600*1000);                                    
                }else{
                    specList.remove(p);
                }
            }else{
                specList.remove(p);
            }
        }
        return specList;
    }

    
}
