package databaseDagenham;

import beans.AddressBean;
import beans.CustomerBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class handles all the CRUD operations on Customer table on Dagenham database
 * @author Sachith
 */
public class CustomerCRUD {

    Connection connection = null;
    PreparedStatement prestmnt = null;
    ResultSet resultSet = null;

    public CustomerCRUD() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    /**
     * Inserting a new country record to the database
     *
     * @param customerBean
     */
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
     * @see CustomerBean
     * @param customerBean
     */
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
     * Delete the customer record by the ID 
     * This will also delete addresses associated with the customer id
     *
     * @param customer_id
     */
    public void delete(int customer_id) {

        try {
            connection = getConnection();
            String queryString = "DELETE FROM address WHERE customer_id=?";

            prestmnt = connection.prepareStatement(queryString);
            prestmnt.setInt(1, customer_id);
            prestmnt.executeUpdate();

            queryString = "DELETE FROM customers WHERE customer_id=?";
            prestmnt = connection.prepareStatement(queryString);
            prestmnt.setInt(1, customer_id);
            prestmnt.executeUpdate();


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

    }

    /**
     * Select customers by ID and return an array list of Customerbean 
     * @param customer_id
     * @return ArrayList<CustomerBean> 
     */
    public ArrayList<CustomerBean> findCustomer(int customer_id) {

        ArrayList<CustomerBean> returnCustomerBean = new ArrayList<CustomerBean>();
        //ArrayList<CountryBean> countryBean = new ArrayList<CountryBean>();
        try {
            String queryString = "SELECT * FROM customers where customer_id= " + customer_id;
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            resultSet = prestmnt.executeQuery();
            ResultSet resultSet2 = null;
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

                /*
                 * System.out.println("Customer ID " +
                 * resultSet.getInt("customer_id") + ", User Name " +
                 * resultSet.getString("username") + ", Password " +
                 * resultSet.getString("password") + ", First Name " +
                 * resultSet.getString("fname") + ", Last Name " +
                 * resultSet.getString("lname") + ", Email " +
                 * resultSet.getString("email") + ", Since " + resultSet.getDate("since"));
                 */

               /* queryString = "SELECT * FROM address a,country c where customer_id =" + resultSet.getInt("customer_id") + "and c.country_id=a.country_id";
                prestmnt = connection.prepareStatement(queryString);
                resultSet2 = prestmnt.executeQuery();
                while (resultSet2.next()) {

              


                    System.out.println("Address ID " + resultSet2.getInt("address_id")
                            + ", Street " + resultSet2.getString("adrstreet")
                            + ", City " + resultSet2.getString("city")
                            + ", County " + resultSet2.getString("county")
                            + ", PostCode " + resultSet2.getString("postcode")
                            + ", Country" + resultSet2.getString("name"));
                }*/

                
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
     * @return ArrayList of all the customers
     */

    public ArrayList<CustomerBean> findAllCustomers()
    {
         ArrayList<CustomerBean> returnCustomerBean = new ArrayList<CustomerBean>();
        //ArrayList<CountryBean> countryBean = new ArrayList<CountryBean>();
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
    
    
    
    
    
    /**
     * Select all customers with addresses. (Prints the results here for the time being. Can be improved by returning an ArrayList)
     */
    public void findAll() {
        try {
            String queryString = "SELECT * FROM customers";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            resultSet = prestmnt.executeQuery();
            ResultSet resultSet2 = null;
            while (resultSet.next()) {
                System.out.println("Customer ID " + resultSet.getInt("customer_id")
                        + ", User Name " + resultSet.getString("username")
                        + ", Password " + resultSet.getString("password")
                        + ", First Name " + resultSet.getString("fname")
                        + ", Last Name " + resultSet.getString("lname")
                        + ", Email " + resultSet.getString("email")
                        + ", Since " + resultSet.getDate("since"));

                queryString = "SELECT * FROM address a,country c where customer_id =" + resultSet.getInt("customer_id") + "and c.country_id=a.country_id";
                prestmnt = connection.prepareStatement(queryString);
                resultSet2 = prestmnt.executeQuery();
                while (resultSet2.next()) {
                    System.out.println("Address ID " + resultSet2.getInt("address_id")
                            + ", Street " + resultSet2.getString("adrstreet")
                            + ", City " + resultSet2.getString("city")
                            + ", County " + resultSet2.getString("county")
                            + ", PostCode " + resultSet2.getString("postcode")
                            + ", Country ID " + resultSet2.getString("name"));
                }

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
    }
}
