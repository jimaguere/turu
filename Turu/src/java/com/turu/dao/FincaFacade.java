/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turu.dao;

import com.turu.entidades.Finca;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Asus
 */
@Stateless
public class FincaFacade extends AbstractFacade<Finca> {
    @PersistenceContext(unitName = "TuruWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FincaFacade() {
        super(Finca.class);
    }
    
}
