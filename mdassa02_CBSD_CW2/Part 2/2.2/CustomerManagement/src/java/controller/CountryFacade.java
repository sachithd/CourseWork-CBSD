/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Country;

/**
 * Session bean class for entity bean Country class (Dagenham Database)
 * @see Country
 * @author Sachith
 */
@Stateless
public class CountryFacade extends AbstractFacade<Country> {

    @PersistenceContext(unitName = "CustomerManagementPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountryFacade() {
        super(Country.class);
    }

    public List<Country> findCountry(int countryID) {
        Query jpqlQuery = em.createNamedQuery("Country.findByCountryId");
        List<Country> countryList = jpqlQuery.setParameter("countryId", countryID).getResultList();
        return countryList;
    }
}
