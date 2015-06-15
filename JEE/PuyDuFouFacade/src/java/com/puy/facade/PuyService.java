/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.facade;

import com.puy.business.logic.PuyOperationBeanRemote;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    
    @WebMethod(operationName = "hello")
    public String hello() {
        
        
        Locale locale = Locale.FRANCE;
        
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("EEEE", locale);
        
        
        return date.format(d);
    }
}
