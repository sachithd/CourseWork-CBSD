package sessionBeans;

import entityBeans.Country;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sachith
 */
@Stateless
public class CountryFacade extends AbstractFacade<Country> {
    @PersistenceContext(unitName = "JMSQueueReceiverPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountryFacade() {
        super(Country.class);
    }
    
}
