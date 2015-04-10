/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.daos;

import com.turu.entidades.RolSoftware;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mateo
 */
@Stateless
public class RolSoftwareFacade extends AbstractFacade<RolSoftware> {
    @PersistenceContext(unitName = "TuruPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolSoftwareFacade() {
        super(RolSoftware.class);
    }
    
}
