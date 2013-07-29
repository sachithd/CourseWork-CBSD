package ejb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

/**
 * Message driven bean class 
 * @author Sachith
 */
@MessageDriven(mappedName = "jms/CusManagementTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "JMSTopicReceiver"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "JMSTopicReceiver")
})
public class JMSTopicReceiver implements MessageListener {

    @Resource(mappedName = "jms/CusManagementConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/CusManagementQueue")
    private Queue queue;

    public JMSTopicReceiver() {
    }

    /**
     * Listen to message receives and forward the message to a Queue
     * @param message 
     */
    @Override
    public void onMessage(Message message) {

        MapMessage msg = null;
        try {
            msg = (MapMessage) message;
            String customerid = msg.getString("deleteCustomerID");
            String countryid= msg.getString("deleteCountryID");
            
            System.out.println("Message Received by the Topic listner");
            System.out.println(customerid);
            System.out.println(countryid);
            System.out.println("—————————————-");


            //Sending message to a Queue
            sendToQueue(customerid,countryid);


        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    private void sendToQueue(String customerid, String countryid) {

        MessageProducer messageProducer;
        MapMessage message = null;
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(queue);

            message = session.createMapMessage();
            //Create messages and sends to the Queue
            message.setString("deleteCustomerID",customerid);
            message.setString("deleteCountryID", countryid);

            messageProducer.send(message);

            messageProducer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
