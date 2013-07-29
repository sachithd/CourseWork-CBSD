/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import beans.CustomerBean;
import databaseDagenham.CustomerCRUD;
import databaseStratford.CustomerCRUDStratford;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * This class implements the RMI interface
 * @author Sachith
 */
public class RMIObject extends UnicastRemoteObject implements RMIInterface {

    public RMIObject() throws RemoteException {
        super();
    }
    
    /**
     * Customers from Dagenham database
     * @param customer_id
     * @return an ArrayList of CustomerBean
     * @throws RemoteException 
     */
    @Override
    public ArrayList<CustomerBean> getCustomersDagenham(int customer_id) throws RemoteException {
        ArrayList<CustomerBean> returnCustomerBean = new ArrayList<CustomerBean>();
        try {
            System.out.println("Invoke getCustomersDagenham from " + getClientHost());
            
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
        CustomerCRUD customers = new CustomerCRUD();
        returnCustomerBean = customers.findCustomer(customer_id);
        return returnCustomerBean;
        
    }
    
    /**
     * Customers from Stratford database
     * @param customer_id
     * @return an array list of CustomerBean
     * @throws RemoteException 
     */
    @Override
    public ArrayList<CustomerBean> getCustomersStratford(int customer_id) throws RemoteException {
         ArrayList<CustomerBean> returnCustomerBean = new ArrayList<CustomerBean>();
          CustomerCRUDStratford customersStartford = new CustomerCRUDStratford();
          returnCustomerBean = customersStartford.findCustomer(customer_id);
          return returnCustomerBean;
    }
    
    /**
     * 
     * @return an ArrayList of CustomerBean
     * @throws RemoteException 
     */
    @Override
    public ArrayList<CustomerBean> getCustomersBoth() throws RemoteException {
        ArrayList<CustomerBean> returnCustomerBean = new ArrayList<CustomerBean>();
        CustomerCRUD customers = new CustomerCRUD();
        CustomerCRUDStratford customersStartford = new CustomerCRUDStratford();
        returnCustomerBean = customers.findAllCustomers();
        returnCustomerBean.addAll(customersStartford.findAllCustomers());
        return returnCustomerBean;
        
    }
}
