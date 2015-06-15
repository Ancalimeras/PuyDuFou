/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bal;

import dao.DaoPuyDuFou;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Antoine
 */
@Stateless
public class BalPuyDuFou implements BalPuyDuFouRemote {

    @EJB
    private DaoPuyDuFou dao;
    
    /*
    
    @Override
    public Float montantCommande(Long numcom) {
        Commande   commande= daoGestionCommerciale.getLaCommande(numcom); 
        return montantCommande(commande);
    }
    
    
    @Override
    public void enregistrerEntite(Object entite) {
        daoGestionCommerciale.enregistrerEntite(entite);
    }*/
    
    
}
