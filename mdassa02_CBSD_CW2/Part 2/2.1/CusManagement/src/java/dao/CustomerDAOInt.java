/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.CustomerBean;
import java.util.ArrayList;

/**
 * Interface for Customer DAO Classes
 * @author Sachith
 */
public interface CustomerDAOInt {

    /**
     * Insering a new country record to the database
     *
     * @param customerBean
     */
    void add(CustomerBean customerBean);

    /**
     * Delete the customer record by the ID Delete addresses associated with the
     * customer id
     *
     * @param customer_id
     */
    int delete(int customer_id);

    /**
     * Find all customers
     * @return ArrayList of all the customers in Stratford database
     */
    ArrayList<CustomerBean> findAllCustomers();

    /**
     * Select customers by ID
     */
    ArrayList<CustomerBean> findCustomer(int customer_id);

    /**
     * Update the Country record by its ID.
     *
     * @param customerBean
     */
    void update(CustomerBean customerBean);
    
}
