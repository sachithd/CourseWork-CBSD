
package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI Server
 * @author Sachith
 */
public class RMIServer {
    
      public static void main(String[] args) {

          
          try {

        
        
       //Create and get reference to rmi registry
      Registry registry = LocateRegistry.createRegistry(1099);
 
      //Instantiate server object
      RMIObject rmio = new RMIObject();
 
      //Register server object
      registry.rebind("CustomerM", rmio);
      System.out.println("RMI Server is created!!!");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
    
}
