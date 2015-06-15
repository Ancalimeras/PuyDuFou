/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;


import bal.BalPuyDuFouRemote;
import dao.DaoPuyDuFouRemote;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;


/**
 *
 * @author Antoine
 */
@WebService(serviceName = "PuyDuFouWebService", name="Puy")
@Stateless
public class PuyDuFouWebService {
    
    
    @EJB
    private DaoPuyDuFouRemote dao;
    
    @EJB
    private BalPuyDuFouRemote bal;
    
    
    
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    
}
