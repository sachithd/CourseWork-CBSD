/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerlStratford;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Customers;

/**
 * Session bean class for entity bean Customers class (Stratford Database)
 * @see Customers
 * @author Sachith
 */
@Stateless
public class CustomersFacadeSt extends AbstractFacadeSt<Customers> {
    @PersistenceContext(unitName = "CustomerManagementStratfordPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacadeSt() {
        super(Customers.class);
    }
    
}
