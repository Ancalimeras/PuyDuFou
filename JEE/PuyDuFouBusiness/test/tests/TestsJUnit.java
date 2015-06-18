/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.puy.business.logic.PuyOperationBean;
import com.puy.business.logic.PuyOperationBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antoine
 */
public class TestsJUnit {
    PuyOperationBeanRemote puyOperationBean = lookupPuyOperationBeanRemote();
    
    public TestsJUnit() {
    }
    
    
    @Test
     public void verifierAdresseMac(){
       //Créé une adresse mac valide si elle n'existe pas dans la base et renvoie true
       //Si elle existe, revoie true sans la créer
       //Si non valide ou nulle, renvoie false
       assertEquals(puyOperationBean.verifierAdresseMac("00:00:00:00:00:00"),true);
     }
    
     
     @Test
     public void noteExiste(){
         //Teste si l'utilisateur a noté un spectacle ou pas
         //Params : Spectacle & adresse mac
       assertEquals(puyOperationBean.noteExiste(1,"00:00:00:00:00:0A"),true);
     }
     
     /*
     @Test
     public void evaluerSpectacle(){
         //Params : Note, Spectacle, idUtilisateur
         //Renvoie la moyenne après avoir évalué un spectacle
       assertEquals(puyOperationBean.evaluerSpectacle(5, 1, "00:00:00:00:00:0A"),"4");
     }*/
     
     
     
     

    private PuyOperationBeanRemote lookupPuyOperationBeanRemote() {
        try {
            Context c = new InitialContext();
            return (PuyOperationBeanRemote) c.lookup("java:global/PuyDuFouBusiness/PuyOperationBean!com.puy.business.logic.PuyOperationBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
