package controllerlStratford;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Country;

/**
 * Session bean class for entity bean Country class (Stratford Database)
 * @see Country
 * @author Sachith
 */
@Stateless
public class CountryFacadeSt extends AbstractFacadeSt<Country> {
    @PersistenceContext(unitName = "CustomerManagementStratfordPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountryFacadeSt() {
        super(Country.class);
    }
    
}
