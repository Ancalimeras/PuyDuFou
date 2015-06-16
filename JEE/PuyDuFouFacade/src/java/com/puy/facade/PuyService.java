/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.facade;

import com.puy.business.entites.Spectacle;
import com.puy.business.logic.PuyOperationBeanRemote;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Antoine
 */
@WebService(serviceName = "PuyService", name="Puy")
@Stateless
public class PuyService {

    
    @EJB
    private PuyOperationBeanRemote puyRemote;
    
    
    @WebMethod(operationName = "verifierAdresseMac")
    public boolean verifierAdresseMac(@WebParam(name="adresseMac") String adresseMac) {
        
        return puyRemote.verifierAdresseMac(adresseMac);
        
    }
    
    
    @WebMethod(operationName = "hello")
    public String hello() {
        
        /*Locale locale = Locale.FRANCE;
        
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("EEEE", locale);
        */
        //date.format(d)
        
        return "Test de string";
    }
    
    @WebMethod(operationName = "getSpectacles")
    public List<Spectacle> getSpectacles() {
        
        return puyRemote.getListeSpectacles();
    }
    
    
}
