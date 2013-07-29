
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.*;

/**
 * Represents a client application which sends a message to a Topic
 *
 * @author Sachith
 */
public class Main {

    @Resource(mappedName = "jms/CusManagementConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/CusManagementTopic")
    private static Topic topic;

    public static void main(String[] args) {
        MessageProducer messageProducer;
        MapMessage message = null;

        Session session;
        try {
            Connection connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            messageProducer = session.createProducer(topic);

            message = session.createMapMessage();

            //Please use a valid customer id 
            message.setString("deleteCustomerID", "43");
            message.setString("deleteCountryID", "24");

            messageProducer.send(message);


            messageProducer.close();
            session.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
