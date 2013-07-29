/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeansDagenham;

import entityBeans.Country;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session bean class for country entity bean
 * @author Sachith
 */
@Stateless
public class CountryFacade extends AbstractFacade<Country> {
    @PersistenceContext(unitName = "CusManagementWSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountryFacade() {
        super(Country.class);
    }
    
}
