/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.dao;

import com.turu.entidades.RolSoftware;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Asus
 */
@Stateless
public class RolSoftwareFacade extends AbstractFacade<RolSoftware> {
    @PersistenceContext(unitName = "TuruWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolSoftwareFacade() {
        super(RolSoftware.class);
    }
    
}
