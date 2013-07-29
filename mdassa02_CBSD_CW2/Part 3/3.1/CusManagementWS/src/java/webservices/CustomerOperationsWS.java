/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import entityBeans.Address;
import entityBeans.Country;
import entityBeans.Customers;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessionBeansDagenham.AddressFacade;
import sessionBeansDagenham.CountryFacade;
import sessionBeansDagenham.CustomersFacade;

/**
 * This class defines all the web service methods
 * @author Sachith
 */
@WebService(serviceName = "CustomerOperationsWS")
public class CustomerOperationsWS {

  @EJB private AddressFacade addressf;
  @EJB private CountryFacade countryf;
  @EJB private CustomersFacade customerf;

  
    /**
     * Address CRUD Operations
     */
    @WebMethod(operationName = "createAddress")
    @Oneway
    public void createAddress(@WebParam(name = "entity") Address entity) {
        addressf.create(entity);
    }

    @WebMethod(operationName = "editAddress")
    @Oneway
    public void editAddress(@WebParam(name = "entity") Address entity) {
        addressf.edit(entity);
    }

    @WebMethod(operationName = "removeAddress")
    @Oneway
    public void removeAddress(@WebParam(name = "entity") Address entity) {
        addressf.remove(entity);
    }

    @WebMethod(operationName = "findAddress")
    public Address findAddress(@WebParam(name = "id") Object id) {
        return addressf.find(id);
    }

    @WebMethod(operationName = "findAllAddress")
    public List<Address> findAllAddress() {
        return addressf.findAll();
    }

    @WebMethod(operationName = "findRangeAddress")
    public List<Address> findRangeAddress(@WebParam(name = "range") int[] range) {
        return addressf.findRange(range);
    }

    @WebMethod(operationName = "countAddress")
    public int countAddress() {
        return addressf.count();
    }
    
    
    /**
     * Country CRUD Operations
     */
    @WebMethod(operationName = "createCountry")
    @Oneway
    public void createCountry(@WebParam(name = "entity") Country entity) {
        countryf.create(entity);
    }

    @WebMethod(operationName = "editCountry")
    @Oneway
    public void editCountry(@WebParam(name = "entity") Country entity) {
        countryf.edit(entity);
    }

    @WebMethod(operationName = "removeCountry")
    @Oneway
    public void removeCountry(@WebParam(name = "entity") Country entity) {
        countryf.remove(entity);
    }

    @WebMethod(operationName = "findCountry")
    public Country findCountry(@WebParam(name = "id") Object id) {
        return countryf.find(id);
    }

    @WebMethod(operationName = "findAllCountry")
    public List<Country> findAllCountry() {
        return countryf.findAll();
    }

    @WebMethod(operationName = "findRangeCountry")
    public List<Country> findRangeCountry(@WebParam(name = "range") int[] range) {
        return countryf.findRange(range);
    }

    @WebMethod(operationName = "countCountry")
    public int countCountry() {
        return countryf.count();
    }
    
    /**
     * Customer CRUD Operation
     */
    
    @WebMethod(operationName = "createCustomer")
    @Oneway
    public void createCustomer(@WebParam(name = "entity") Customers entity) {
        customerf.create(entity);
    }

    @WebMethod(operationName = "editCustomer")
    @Oneway
    public void editCustomer(@WebParam(name = "entity") Customers entity) {
        customerf.edit(entity);
    }

    @WebMethod(operationName = "removeCustomer")
    @Oneway
    public void removeCustomer(@WebParam(name = "entity") Customers entity) {
        customerf.remove(entity);
    }

    @WebMethod(operationName = "findCustomer")
    public Customers findCustomer(@WebParam(name = "id") Object id) {
        return customerf.find(id);
    }

    @WebMethod(operationName = "findAllCustomer")
    public List<Customers> findAllCustomer() {
        return customerf.findAll();
    }

    @WebMethod(operationName = "findRangeCustomer")
    public List<Customers> findRangeCustomer(@WebParam(name = "range") int[] range) {
        return customerf.findRange(range);
    }

    @WebMethod(operationName = "countCustomer")
    public int countCustomer() {
        return customerf.count();
    }
}
