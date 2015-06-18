/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.logic;

import com.puy.business.entites.Boutique;
import com.puy.business.entites.MenuRestaurant;
import com.puy.business.entites.Planning;
import com.puy.business.entites.Restaurant;
import com.puy.business.entites.Spectacle;
import java.util.List;
import javax.ejb.Remote;
import javax.persistence.Query;

/**
 *
 * @author Antoine
 */
@Remote
public interface PuyOperationBeanRemote {

    public boolean verifierAdresseMac(String adresseMac);

    public List<Spectacle> getListeSpectacles();

    
    //public List<Spectacle> getDetailSpectacles();

    //public String evaluerSpectacle(float note, int idSpectacle, String idUtilisateur);

    public List<Planning> getHorairesSpectacle(int idSpectacle);

    public String evaluerSpectacle(int note, int idSpectacle, String idUtilisateur);

    public boolean noteExiste(int idSpectacle, String idUtilisateur);

    public List<Restaurant> getListeRestaurants();

    public List<MenuRestaurant> getMenuRestaurant(int idRestaurant);

    public List<Boutique> getListeBoutiques();

    public List<Spectacle> getSpectaclesAVenir();

    public List<Planning> getHorairesAVenir(int idSpectacle);
    
    public int tempsActivites(float lat1, float lng1, float lat2, float lng2);

    public List<Spectacle> getMeilleurPlanning();
    
}
