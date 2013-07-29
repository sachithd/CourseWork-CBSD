/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansDagenham;

import entityBeans.Customers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session bean class for Customer entity bean
 * @author Sachith
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> {
    @PersistenceContext(unitName = "CusManagementWSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }
    
}
