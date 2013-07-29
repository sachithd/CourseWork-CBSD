/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.AddressBean;
import beans.CustomerBean;
import db.ConnectionFactoryStratford;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO Classes, CRUD Operations on Country table of Stratford database
 * @author Sachith
 */
public class CustomerDAOStratford implements CustomerDAOInt {

    Connection connection = null;
    PreparedStatement prestmnt = null;
    ResultSet resultSet = null;

    public CustomerDAOStratford() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactoryStratford.getInstance().getConnection();
        return conn;
    }

    /**
     * Insering a new country record to the database
     *
     * @param customerBean
     */
    @Override
    public void add(CustomerBean customerBean) {
        try {
            String queryString = "INSERT INTO customers(username, password, fname, lname, email, since) VALUES(?,?,?,?,?,?)";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString, new String[]{"customer_id"});
            //prestmnt.setInt(1, customerBean.getCountry_id());
            prestmnt.setString(1, customerBean.getUsername());
            prestmnt.setString(2, customerBean.getPassword());
            prestmnt.setString(3, customerBean.getFname());
            prestmnt.setString(4, customerBean.getLname());
            prestmnt.setString(5, customerBean.getEmail());
            prestmnt.setString(6, customerBean.getSince().toString());
            prestmnt.executeUpdate();
            System.out.println("Customer Inserted");

            //Last inserted id
            ResultSet rs = prestmnt.getGeneratedKeys();
            long customer_id = -1;
            if (rs.next()) {
                customer_id = rs.getLong(1);
            } else {
                throw new SQLException("Creating user failed, no generated key obtained.");
            }

            rs.close();

            //Inserting the addresses
            ArrayList<AddressBean> al = customerBean.getAddress();


            for (AddressBean addressBean : al) {

                queryString = "INSERT INTO address(adrstreet, city, county, postcode, country_id, customer_id) VALUES(?,?,?,?,?,?)";
                prestmnt = connection.prepareStatement(queryString);
                prestmnt.setString(1, addressBean.getAdrStreet());
                prestmnt.setString(2, addressBean.getCity());
                prestmnt.setString(3, addressBean.getCounty());
                prestmnt.setString(4, addressBean.getPostcode());
                prestmnt.setInt(5, addressBean.getCountry_id());
                prestmnt.setInt(6, (int) customer_id);
                prestmnt.executeUpdate();
                System.out.println("Customer address Inserted");

            }




        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.toString());
        } finally {
            try {
                if (prestmnt != null) {
                    prestmnt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //e.printStackTrace();
                System.out.println(e.toString());
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println(e.toString());
            }

        }

    }

    /**
     * Update the Country record by its ID.
     *
     * @param customerBean
     */
    @Override
    public void update(CustomerBean customerBean) {

        try {
            String queryString = "UPDATE customers SET username=?, password=?, fname=?, lname=?, email=?, since=? WHERE customer_id=?";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            prestmnt.setString(1, customerBean.getUsername());
            prestmnt.setString(2, customerBean.getPassword());
            prestmnt.setString(3, customerBean.getFname());
            prestmnt.setString(4, customerBean.getLname());
            prestmnt.setString(5, customerBean.getEmail());
            prestmnt.setString(6, customerBean.getSince().toString());
            prestmnt.setInt(7, customerBean.getCustomer_id());
            prestmnt.executeUpdate();
            System.out.println("customers Updated Successfully");

            //Updating the addresses
            ArrayList<AddressBean> al = customerBean.getAddress();

            for (AddressBean addressBean : al) {

                queryString = "update address SET adrstreet=?, city=?, county=?, postcode=?, country_id=? WHERE customer_id=?";
                prestmnt = connection.prepareStatement(queryString);
                prestmnt.setString(1, addressBean.getAdrStreet());
                prestmnt.setString(2, addressBean.getCity());
                prestmnt.setString(3, addressBean.getCounty());
                prestmnt.setString(4, addressBean.getPostcode());
                prestmnt.setInt(5, addressBean.getCountry_id());
                prestmnt.setInt(6, customerBean.getCustomer_id());
                prestmnt.executeUpdate();
                System.out.println("Customer address Updated");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prestmnt != null) {
                    prestmnt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    /**
     * Delete the customer record by the ID Delete addresses associated with the
     * customer id
     *
     * @param customer_id
     */
    @Override
    public int delete(int customer_id) {
          int results=-1;
        try {
            connection = getConnection();
            String queryString = "DELETE FROM address WHERE customer_id=?";

            prestmnt = connection.prepareStatement(queryString);
            prestmnt.setInt(1, customer_id);
            results = prestmnt.executeUpdate();

            queryString = "DELETE FROM customers WHERE customer_id=?";
            prestmnt = connection.prepareStatement(queryString);
            prestmnt.setInt(1, customer_id);
            results = prestmnt.executeUpdate();


            System.out.println("Customer / Address Record Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prestmnt != null) {
                    prestmnt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return results;

    }

    /**
     * Select customers by ID
     */
    @Override
    public ArrayList<CustomerBean> findCustomer(int customer_id) {

        ArrayList<CustomerBean> returnCustomerBean = new ArrayList<CustomerBean>();
        try {
            String queryString = "SELECT * FROM customers where customer_id= " + customer_id;
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            resultSet = prestmnt.executeQuery();
            while (resultSet.next()) {

                CustomerBean cb = new CustomerBean();
                cb.setCustomer_id(resultSet.getInt("customer_id"));
                cb.setUsername(resultSet.getString("username"));
                cb.setPassword(resultSet.getString("password"));
                cb.setFname(resultSet.getString("fname"));
                cb.setLname(resultSet.getString("lname"));
                cb.setEmail(resultSet.getString("email"));
                cb.setSince(resultSet.getDate("since"));

                returnCustomerBean.add(cb);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (prestmnt != null) {
                    prestmnt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return returnCustomerBean;
    }
    
    /**
     * Find all customers 
     * @return ArrayList of all the customers in Stratford database
     */

    @Override
    public ArrayList<CustomerBean> findAllCustomers()
    {
         ArrayList<CustomerBean> returnCustomerBean = new ArrayList<CustomerBean>();
        
        try {
            String queryString = "SELECT * FROM customers ";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            resultSet = prestmnt.executeQuery();
            while (resultSet.next()) {

                CustomerBean cb = new CustomerBean();
                cb.setCustomer_id(resultSet.getInt("customer_id"));
                cb.setUsername(resultSet.getString("username"));
                cb.setPassword(resultSet.getString("password"));
                cb.setFname(resultSet.getString("fname"));
                cb.setLname(resultSet.getString("lname"));
                cb.setEmail(resultSet.getString("email"));
                cb.setSince(resultSet.getDate("since"));

                returnCustomerBean.add(cb);

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (prestmnt != null) {
                    prestmnt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return returnCustomerBean;
    }

}
