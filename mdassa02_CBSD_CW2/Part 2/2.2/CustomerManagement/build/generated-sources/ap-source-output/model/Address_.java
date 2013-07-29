package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Country;
import model.Customers;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-04-18T19:23:24")
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