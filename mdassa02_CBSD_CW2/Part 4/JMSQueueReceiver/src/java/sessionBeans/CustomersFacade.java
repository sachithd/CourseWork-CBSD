package sessionBeans;

import entityBeans.Customers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sachith
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> {
    @PersistenceContext(unitName = "JMSQueueReceiverPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }
    
}
