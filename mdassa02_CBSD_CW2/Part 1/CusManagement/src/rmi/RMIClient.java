package rmi;

import beans.CustomerBean;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RMI Client Class
 * @author Sachith
 */
public class RMIClient {

    public static void main(String[] args) {

        try {
            //Get reference to rmi registry server
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");

            //Lookup server object
            RMIInterface ri = (RMIInterface) registry.lookup("CustomerM");


            //1. Get Daghenham Customer by ID
            getDaghenhamCustomers(ri);


            //2. Get Stratford Customer by ID
            getStratfordCustomers(ri);

            //3. Get Both Daghenham & Stratford Customers
            getBothCustomers(ri);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Get customer list from Stratford database
     * @param ri 
     */
    
    public static void getStratfordCustomers(RMIInterface ri) {
        try {
            System.out.println("Display Stratford Customer by ID");
            ArrayList<CustomerBean> alist2 = ri.getCustomersStratford(5);

            for (CustomerBean customerBean : alist2) {
                System.out.println("Customer ID " + customerBean.getCustomer_id()
                        + ", User Name " + customerBean.getUsername()
                        + ", Password " + customerBean.getPassword()
                        + ", First Name " + customerBean.getFname()
                        + ", Last Name " + customerBean.getLname()
                        + ", Email " + customerBean.getEmail()
                        + ", Since " + customerBean.getSince().toString());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get customers list from Dagenham database
     * @param ri 
     */
    public static void getDaghenhamCustomers(RMIInterface ri) {
        try {
            System.out.println("Displaying Daghenham Customer by ID");

            ArrayList<CustomerBean> alist1 = ri.getCustomersDagenham(31);

            for (CustomerBean customerBean : alist1) {
                System.out.println("Customer ID " + customerBean.getCustomer_id()
                        + ", User Name " + customerBean.getUsername()
                        + ", Password " + customerBean.getPassword()
                        + ", First Name " + customerBean.getFname()
                        + ", Last Name " + customerBean.getLname()
                        + ", Email " + customerBean.getEmail()
                        + ", Since " + customerBean.getSince().toString());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get customers from both databases and display the results.
     * @param ri 
     */
    public static void getBothCustomers(RMIInterface ri) {
        try {
            System.out.println("Display Both");
            ArrayList<CustomerBean> alist3 = ri.getCustomersBoth();
            for (CustomerBean customerBean : alist3) {
                System.out.println("Customer ID " + customerBean.getCustomer_id()
                        + ", User Name " + customerBean.getUsername()
                        + ", Password " + customerBean.getPassword()
                        + ", First Name " + customerBean.getFname()
                        + ", Last Name " + customerBean.getLname()
                        + ", Email " + customerBean.getEmail()
                        + ", Since " + customerBean.getSince().toString());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
