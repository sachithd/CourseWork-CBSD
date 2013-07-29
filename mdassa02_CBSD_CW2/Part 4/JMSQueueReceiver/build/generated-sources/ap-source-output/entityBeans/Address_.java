package entityBeans;

import entityBeans.Country;
import entityBeans.Customers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-04-25T22:12:01")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> adrstreet;
    public static volatile SingularAttribute<Address, Country> countryId;
    public static volatile SingularAttribute<Address, Customers> customerId;
    public static volatile SingularAttribute<Address, String> county;
    public static volatile SingularAttribute<Address, String> postcode;
    public static volatile SingularAttribute<Address, Integer> addressId;
    public static volatile SingularAttribute<Address, String> city;

}