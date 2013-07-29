package entityBeans;

import entityBeans.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-04-25T22:12:01")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, Integer> countryId;
    public static volatile SingularAttribute<Country, String> name;
    public static volatile CollectionAttribute<Country, Address> addressCollection;
    public static volatile SingularAttribute<Country, Double> exchange;
    public static volatile SingularAttribute<Country, String> currency;

}