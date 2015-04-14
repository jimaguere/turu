/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.dao;

import com.turu.entidades.RolSoftMenu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Asus
 */
@Stateless
public class RolSoftMenuFacade extends AbstractFacade<RolSoftMenu> {
    @PersistenceContext(unitName = "TuruWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolSoftMenuFacade() {
        super(RolSoftMenu.class);
    }
    
}
