/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import beans.CustomerBean;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Sachith
 */
public interface RMIInterface extends Remote{
    
  public ArrayList<CustomerBean> getCustomersDagenham(int customer_id) throws RemoteException;
  public ArrayList<CustomerBean> getCustomersStratford(int customer_id) throws RemoteException;
  public ArrayList<CustomerBean> getCustomersBoth() throws RemoteException;

}
