package entityBeans;

import entityBeans.Address;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-04-25T22:12:01")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> username;
    public static volatile SingularAttribute<Customers, String> lname;
    public static volatile SingularAttribute<Customers, Integer> customerId;
    public static volatile SingularAttribute<Customers, String> email;
    public static volatile CollectionAttribute<Customers, Address> addressCollection;
    public static volatile SingularAttribute<Customers, Date> since;
    public static volatile SingularAttribute<Customers, String> password;
    public static volatile SingularAttribute<Customers, String> fname;

}