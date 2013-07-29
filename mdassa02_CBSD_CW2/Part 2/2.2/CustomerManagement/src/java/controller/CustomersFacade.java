/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Customers;

/**
 * Session bean class for entity bean Customers class (Dagenham Database)
 * @see Customers
 * @author Sachith
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> {
    @PersistenceContext(unitName = "CustomerManagementPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }
    
}
