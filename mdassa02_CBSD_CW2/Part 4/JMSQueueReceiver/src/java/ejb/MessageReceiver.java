/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entityBeans.Country;
import entityBeans.Customers;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import sessionBeans.CountryFacade;
import sessionBeans.CustomersFacade;

/**
 * Message driven bean
 *
 * @author Sachith
 */
@MessageDriven(mappedName = "jms/CusManagementQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageReceiver implements MessageListener {

    @EJB
    CustomersFacade customerf;
    @EJB
    CountryFacade countryf;

    public MessageReceiver() {
    }

    /**
     * Receives the message sent to the queue and perform database operation
     * according to the message
     *
     * @param message
     */
    @Override
    public void onMessage(Message message) {

        MapMessage msg = null;
        try {
            msg = (MapMessage) message;
            String customerid = msg.getString("deleteCustomerID");
            String countryid = msg.getString("deleteCountryID");

            System.out.println("Message Received by the Queue listner");
            System.out.println(customerid);
            System.out.println(countryid);
            System.out.println("—————————————-");


            /**
             * Database Operations on Dagenham Database
             */
            deleteCustomer(customerid);
            deleteCountry(countryid);


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void deleteCustomer(String customerid) {
        int customer_id = Integer.parseInt(customerid);
        Customers customerBean = customerf.find(customer_id);
        if (customerBean != null) {
            customerf.remove(customerBean);
            System.out.println("Customer Removed");
        } else {
            System.out.println("Customer ID not found");
        }



    }

    private void deleteCountry(String countryid) {
        int country_id = Integer.parseInt(countryid);
        Country countryBean = countryf.find(country_id);
        if (countryBean != null) {
            countryf.remove(countryBean);
            System.out.println("Country Removed");
        } else {
            System.out.println("Country ID not found");
        }
    }
}
