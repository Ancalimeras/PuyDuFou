/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.facade;

import com.puy.business.entites.Boutique;
import com.puy.business.entites.MenuRestaurant;
import com.puy.business.entites.Planning;
import com.puy.business.entites.Restaurant;
import com.puy.business.entites.Spectacle;
import com.puy.business.logic.PuyOperationBeanRemote;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Antoine
 */
@WebService(serviceName = "PuyService", name="Puy")
@Stateless
public class PuyService {

    
    @EJB
    private PuyOperationBeanRemote puyRemote;
    
    
    @WebMethod(operationName = "getSpectacles")
    public List<Spectacle> getSpectacles() {
        
        return puyRemote.getListeSpectacles();
    }
    
    @WebMethod(operationName = "verifierAdresseMac")
    public boolean verifierAdresseMac(@WebParam(name="adresseMac") String adresseMac) {
        
        return puyRemote.verifierAdresseMac(adresseMac);
        
    }
    
    @WebMethod(operationName = "noteExiste")
    public boolean noteExiste(@WebParam(name="idSpectacle") int idSpectacle, @WebParam(name="adresseMac") String adresseMac) {
        
        return puyRemote.noteExiste(idSpectacle, adresseMac);
        
    }
    
    @WebMethod(operationName = "evaluerSpectacle")
    public String evaluerSpectacle(@WebParam(name="note")int note, @WebParam(name="idSpectacle") int idSpectacle, @WebParam(name="idUtilisateur") String idUtilisateur) {
        if(note >= 0 && idSpectacle > 0 && idUtilisateur != null){
            return puyRemote.evaluerSpectacle(note, idSpectacle, idUtilisateur);
        }else{
            return "Les paramètres sont incorrects";
        }
    }
    
    @WebMethod(operationName = "getHorairesSpectacle")
    public List<Planning> getHorairesSpectacle(@WebParam(name="idSpectacle") int idSpectacle) {
        
        return puyRemote.getHorairesSpectacle(idSpectacle);
        
    }
    
    @WebMethod(operationName = "getListeRestaurants")
    public List<Restaurant> getListeRestaurants() {
        return puyRemote.getListeRestaurants();
    }
    
    @WebMethod(operationName = "getListeMenuRestaurant")
    public List<MenuRestaurant> getListeMenuRestaurant(@WebParam(name="idRestaurant") int idRestaurant) {
        return puyRemote.getMenuRestaurant(idRestaurant);
    }

    
    @WebMethod(operationName = "getListeBoutiques")
    public List<Boutique> getListeBoutiques() {
        return puyRemote.getListeBoutiques();
    }
    
    
    
    /*
    @WebMethod(operationName = "getDetailSpectacles")
    public List<Spectacle> getDetailSpectacles() {
        
        return puyRemote.getDetailSpectacles();
        
    }*/
    
    
}
