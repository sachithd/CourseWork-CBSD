import beans.AddressBean;
import beans.CountryBean;
import beans.CustomerBean;
import databaseDagenham.CountryCRUD;
import databaseDagenham.CustomerCRUD;
import databaseStratford.CountryCRUDStratford;
import databaseStratford.CustomerCRUDStratford;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Sachith Dassanayake
 */
public class CusManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * CRUD operations on Dagenham / Stratford databases
         */
        crudOnDagenham();
        crudOnStratford();

    }

    /**
     * CRUD operations on Dagenham Database. 
     * Change values here to add new records, update, delete etc
     */
    private static void crudOnDagenham() {


        /**
         **********************************************************************
         * CRUD Operations on Countries
         * ********************************************************************
         */
        /**
         * Add new Country
         */
        CountryCRUD country = new CountryCRUD();
        CountryBean cb = new CountryBean();
        cb.setName("Japan");
        cb.setCurrency("JPY");
        cb.setExchange(0.23);
        country.add(cb);

        /**
         * Modify Country by country id = 3 
         * Please use a valid country id
         */
        cb.setCountry_id(3);
        cb.setName("Canada");
        cb.setCurrency("CUD");
        cb.setExchange(0.23);
        country.update(cb);

        /**
         * Delete Country by ID 
         * Please use a valid country id
         */
        country.delete(7);
        country.delete(8);
        country.delete(9);

        /**
         * View All Countries
         */
        country.displayCountry();
        ArrayList<CountryBean> al = country.displayCountry();

        for (CountryBean countryBean : al) {
            System.out.println("Country ID " + countryBean.getCountry_id()
                    + ", Name " + countryBean.getName()
                    + ", Currency " + countryBean.getCurrency()
                    + ", Exchange " + countryBean.getExchange().toString());
        }


        /**
         **********************************************************************
         * CRUD Operations on Customers
         * ********************************************************************
         */
        
        /**
         * Add a new customer
         */
        
        CustomerCRUD customer = new CustomerCRUD();
        CustomerBean cusb = new CustomerBean();
        
        //A customer can have many addresses
        AddressBean ab1 = new AddressBean();
        AddressBean ab2 = new AddressBean();

        ArrayList<AddressBean> address = new ArrayList<AddressBean>();
        Date since = Date.valueOf("1980-02-29");


        cusb.setUsername("sachith");
        cusb.setPassword("password");
        cusb.setFname("Sachith");
        cusb.setLname("Dassanayake");
        cusb.setEmail("sachithd@gmail.com");
        cusb.setSince(since);
        
        ab1.setAdrStreet("341 London Road");
        ab1.setCity("Hemel");
        ab1.setCounty("Herts");
        ab1.setPostcode("Hp3 9AL");
        ab1.setCountry_id(1);
        address.add(ab1);

        ab2.setAdrStreet("3 Drovers Way");
        ab2.setCity("Hatfield");
        ab2.setCounty("Herts");
        ab2.setPostcode("AL10 0PU");
        ab2.setCountry_id(2);
        address.add(ab2);

        cusb.setAddress(address);

        customer.add(cusb);


        /**
         * Delete Customer by ID
         * Please use a valid customer ID
         */
        customer.delete(30);

        /**
         * Display Customers list
         */
        customer.findAll();
    }

    
    
    
    /**
     * CRUD operations on Stratford Database. 
     * Change values here to add new records, update, delete etc
     */
    private static void crudOnStratford() {
        /**
         * Add new Country
         */
        CountryCRUDStratford country = new CountryCRUDStratford();
        CountryBean cb = new CountryBean();
        cb.setName("Germany");
        cb.setCurrency("EUR");
        cb.setExchange(1.20);
        country.add(cb);

        /**
         * Modify Country by country id = 3
         * Please use a valid id
         */
        cb.setCountry_id(3);
        cb.setName("Canada");
        cb.setCurrency("CUD");
        cb.setExchange(0.23);
        country.update(cb);

        /**
         * Delete Country by ID
         * Please use a valid country id
         */
        country.delete(7);


        /**
         * View All Countries
         */
        country.displayCountry();
        ArrayList<CountryBean> al = country.displayCountry();

        for (CountryBean countryBean : al) {
            System.out.println("Country ID " + countryBean.getCountry_id()
                    + ", Name " + countryBean.getName()
                    + ", Currency " + countryBean.getCurrency()
                    + ", Exchange " + countryBean.getExchange().toString());
        }


        /**
         * ********************************************************************
         * CRUD Operations on Customers
        *********************************************************************
         */
        
         /**
         * Add a new customer
         */
        CustomerCRUDStratford customer = new CustomerCRUDStratford();
        CustomerBean cusb = new CustomerBean();

        //A customer can have many addresses
        AddressBean ab1 = new AddressBean();
        AddressBean ab2 = new AddressBean();

        ArrayList<AddressBean> address = new ArrayList<AddressBean>();
        Date since = Date.valueOf("1998-05-29");


        cusb.setUsername("john");
        cusb.setPassword("123abc");
        cusb.setFname("John");
        cusb.setLname("Silva");
        cusb.setEmail("john@gmail.com");
        cusb.setSince(since);

        ab1.setAdrStreet("9 Canalside");
        ab1.setCity("Berkhamsted");
        ab1.setCounty("Herts");
        ab1.setPostcode("Hp4 1EG");
        ab1.setCountry_id(1);
        address.add(ab1);

        ab2.setAdrStreet("5 Drovers Way");
        ab2.setCity("Hatfield");
        ab2.setCounty("Herts");
        ab2.setPostcode("AL10 8FQ");
        ab2.setCountry_id(2);
        address.add(ab2);

        cusb.setAddress(address);

        customer.add(cusb);


        /**
         * Delete Customer by ID
         * Please use a valid customer id
         */
        customer.delete(1);

        /**
         * Display Customers list
         */
        customer.findAll();
    }
}
