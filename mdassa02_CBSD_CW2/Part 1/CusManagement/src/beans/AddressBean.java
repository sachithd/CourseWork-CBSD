package beans;

import java.io.Serializable;

/**
 * This class represents address details of a Customer
 * @see CustomerBean 
 * @author Sachith
 */
public class AddressBean implements Serializable{
    private int address_id;
    private String adrStreet;
    private String city;
    private String county;
    private String postcode;
    private int country_id;
    
    public AddressBean()
    {
        
    }

    /**
     * @return the adrStreet
     */
    public String getAdrStreet() {
        return adrStreet;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @return the country
     */
    public int getCountry_id() {
        return country_id;
    }

    /**
     * @param adrStreet the adrStreet to set
     */
    public void setAdrStreet(String adrStreet) {
        this.adrStreet = adrStreet;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @param country_id the country to set
     */
    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    /**
     * @return the address_id
     */
    public int getAddress_id() {
        return address_id;
    }

    /**
     * @param address_id the address_id to set
     */
    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
    
}
