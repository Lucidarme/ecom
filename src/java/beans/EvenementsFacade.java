/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Evenements;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lucidarme
 */
@Stateless
public class EvenementsFacade extends AbstractFacade<Evenements> {

    @PersistenceContext(unitName = "ecomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvenementsFacade() {
        super(Evenements.class);
    }
    
}
