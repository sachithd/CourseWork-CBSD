package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Address;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-04-18T19:23:24")
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