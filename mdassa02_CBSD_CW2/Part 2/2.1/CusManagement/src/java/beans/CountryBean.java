/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 * This class represents the country details
 * @author Sachith
 */
public class CountryBean implements Serializable {
    private int country_id;
    private String name;
    private String currency;
    private Double exchange;

    
    public CountryBean()
    {
        
    }
        
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the exchange
     */
    public Double getExchange() {
        return exchange;
    }

    /**
     * @param exchange the exchange to set
     */
    public void setExchange(Double exchange) {
        this.exchange = exchange;
    }

    /**
     * @return the country_id
     */
    public int getCountry_id() {
        return country_id;
    }

    /**
     * @param country_id the country_id to set
     */
    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
    
    
}
