/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.logic;

import javax.ejb.Remote;

/**
 *
 * @author Antoine
 */
@Remote
public interface PuyOperationBeanRemote {

    String testWS();
    
}
