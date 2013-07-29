package dao;

import beans.CountryBean;
import java.util.ArrayList;

/**
 * Interface for Country DAO Classes
 * @author Sachith
 */
public interface CountryDAOInt {

    /**
     * Inserting a new country record to the database
     *
     * @param countryBean
     */
    void add(CountryBean countryBean);

    /**
     * Delete the country record by the ID You can only delete an ID if its not
     * used in Address
     *
     * @param country_id
     */
    int delete(int country_id);

    ArrayList<CountryBean> displayCountry();

    /**
     * Select all countries
     */
    void findAll();

    ArrayList<CountryBean> findCountry(int country_id);

    /**
     * Update the Country record by its ID.
     *
     * @param countryBean
     */
    void update(CountryBean countryBean);
    
}
