/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmclientws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import webservices.Country;
import webservices.Customers;

/**
 * Client application to test the functionality of the web service
 * @author Sachith
 */
public class CMClientWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Few Examples of web service method calls
         */
        
        //Get total number of customers
        getTotalCustomers();

        //View all Customers
        viewAllCustomers();

        //Add new Customer
        addNewCustomer();

        //find a country
        findDGCountry();


    }

    /**
     * Get total number of Customers 
     */
    private static void getTotalCustomers() {
        System.out.println(countCustomer());
    }

    /**
     * View All Customers in Dagenham database
     */
    private static void viewAllCustomers() {
        List<Customers> al = findAllCustomer();

        for (Customers customerBean : al) {
            System.out.println(customerBean.getCustomerId());
            System.out.println(customerBean.getUsername());
            System.out.println(customerBean.getPassword());
            System.out.println(customerBean.getFname());
            System.out.println(customerBean.getLname());
            System.out.println(customerBean.getEmail());
            System.out.println(customerBean.getSince().toString());
        }
    }

    /**
     * Add new Customers
     */
    private static void addNewCustomer() {
        DatatypeFactory df = null;
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new IllegalStateException(
                    "Error while trying to obtain a new instance of DatatypeFactory", e);
        }

        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(date.getTime());


        Customers cb = new Customers();
        cb.setUsername("WS Client");
        cb.setPassword("WS Password");
        cb.setFname("My F Name");
        cb.setLname("My L Name");
        cb.setEmail("keith@dcs.bbk.ac.uk");
        cb.setSince(df.newXMLGregorianCalendar(gc));
        createCustomer(cb);

    }
    
    /**
     * Find Country by ID
     * This needs a user input
     */
    private static void findDGCountry() {
        BufferedReader is = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter country ID");
        String line=null;
        try {
            line = is.readLine();
        } catch (IOException ex) {
            Logger.getLogger(CMClientWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        int val = Integer.parseInt(line);

        Country country = findCountry(val);
        System.out.println(country.getCountryId() );
        System.out.println(country.getName());
        System.out.println(country.getCurrency());
        System.out.println(country.getExchange().toString());




    }

    /**
     * Web Service methods
     *
     * @return
     */
    private static java.util.List<webservices.Customers> findAllCustomer() {
        webservices.CustomerOperationsWS_Service service = new webservices.CustomerOperationsWS_Service();
        webservices.CustomerOperationsWS port = service.getCustomerOperationsWSPort();
        return port.findAllCustomer();
    }

    private static int countCustomer() {
        webservices.CustomerOperationsWS_Service service = new webservices.CustomerOperationsWS_Service();
        webservices.CustomerOperationsWS port = service.getCustomerOperationsWSPort();
        return port.countCustomer();
    }

    private static void createCustomer(webservices.Customers entity) {
        webservices.CustomerOperationsWS_Service service = new webservices.CustomerOperationsWS_Service();
        webservices.CustomerOperationsWS port = service.getCustomerOperationsWSPort();
        port.createCustomer(entity);
    }

    private static Country findCountry(java.lang.Object id) {
        webservices.CustomerOperationsWS_Service service = new webservices.CustomerOperationsWS_Service();
        webservices.CustomerOperationsWS port = service.getCustomerOperationsWSPort();
        return port.findCountry(id);
    }
}
