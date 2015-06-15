/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.logic;

import javax.ejb.Stateless;

/**
 *
 * @author Antoine
 */
@Stateless
public class PuyOperationBean implements PuyOperationBeanRemote {

    @Override
    public String testWS() {
        return "Coucou gentil monsieur";
    }

    
    
    
}
