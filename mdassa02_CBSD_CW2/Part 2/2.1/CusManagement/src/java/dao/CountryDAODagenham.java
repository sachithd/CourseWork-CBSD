package dao;

import beans.CountryBean;
import db.ConnectionFactoryDagenham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO Classes, CRUD Operations on Country table of Dagenham database
 * @author Sachith
 */
public class CountryDAODagenham implements CountryDAOInt {

    Connection connection = null;
    PreparedStatement prestmnt = null;
    ResultSet resultSet = null;

    public CountryDAODagenham() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactoryDagenham.getInstance().getConnection();
        return conn;
    }

    /**
     * Inserting a new country record to the database
     *
     * @param countryBean
     */
    @Override
    public void add(CountryBean countryBean) {
        try {
            String queryString = "INSERT INTO country(name, currency, exchange) VALUES(?,?,?)";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            //prestmnt.setInt(1, countryBean.getCountry_id());
            prestmnt.setString(1, countryBean.getName());
            prestmnt.setString(2, countryBean.getCurrency());
            prestmnt.setDouble(3, countryBean.getExchange());
            prestmnt.executeUpdate();
            System.out.println("Country Inserted");
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
     * Update the Country record by its ID.
     *
     * @param countryBean
     */
    @Override
    public void update(CountryBean countryBean) {

        try {
            String queryString = "UPDATE Country SET name=?, currency=?, exchange=? WHERE Country_id=?";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            prestmnt.setString(1, countryBean.getName());
            prestmnt.setString(2, countryBean.getCurrency());
            prestmnt.setDouble(3, countryBean.getExchange());
            prestmnt.setInt(4, countryBean.getCountry_id());
            prestmnt.executeUpdate();
            System.out.println("Country Updated Successfully");
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
     * Delete the country record by the ID You can only delete an ID if its not
     * used in Address
     *
     * @param country_id
     */
    @Override
    public int delete(int country_id) {
        int results=-1;
        try {
            String queryString = "DELETE FROM country WHERE country_id=?";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            prestmnt.setInt(1, country_id);
            results = prestmnt.executeUpdate();
            System.out.println("Record Deleted");
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
     * Select all countries
     */
    @Override
    public void findAll() {
        try {
            String queryString = "SELECT * FROM country";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            resultSet = prestmnt.executeQuery();
            while (resultSet.next()) {
                System.out.println("Country ID " + resultSet.getInt("country_id")
                        + ", Name " + resultSet.getString("Name")
                        + ", Currency " + resultSet.getString("currency")
                        + ", Exchange " + resultSet.getDouble("exchange"));
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
    
    
    @Override
       public ArrayList<CountryBean> displayCountry() {
        ArrayList<CountryBean> returnCountryBean = new ArrayList<CountryBean>();
        
        try {
            String queryString = "SELECT * FROM country";
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            resultSet = prestmnt.executeQuery();
            while (resultSet.next()) {
               CountryBean cb = new CountryBean(); 
               cb.setCountry_id(resultSet.getInt("country_id"));
               cb.setName(resultSet.getString("Name"));
               cb.setCurrency(resultSet.getString("currency"));
               cb.setExchange(resultSet.getDouble("exchange"));
               returnCountryBean.add(cb);
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
        return returnCountryBean;

    }
    

    @Override
    public ArrayList<CountryBean> findCountry(int country_id) {
        ArrayList<CountryBean> returnCountryBean = new ArrayList<CountryBean>();
        
        try {
            String queryString = "SELECT * FROM country where country_id=" + country_id;
            connection = getConnection();
            prestmnt = connection.prepareStatement(queryString);
            resultSet = prestmnt.executeQuery();
            while (resultSet.next()) {
               CountryBean cb = new CountryBean(); 
               cb.setCountry_id(resultSet.getInt("country_id"));
               cb.setName(resultSet.getString("Name"));
               cb.setCurrency(resultSet.getString("currency"));
               cb.setExchange(resultSet.getDouble("exchange"));
               returnCountryBean.add(cb);
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
        return returnCountryBean;

    }
}
