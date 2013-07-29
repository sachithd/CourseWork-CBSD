/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.AddressFacade;
import controller.CountryFacade;
import controller.CustomersFacade;
import controllerlStratford.AddressFacadeSt;
import controllerlStratford.CountryFacadeSt;
import controllerlStratford.CustomersFacadeSt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import model.Country;
import model.Customers;

/**
 * Servlet to perform CRUD Operations on Address table
 * @author Sachith
 */
@WebServlet(name = "AddressOperations", urlPatterns = {"/AddressOperations"})
public class AddressOperations extends HttpServlet {

    @EJB
    AddressFacade af;
    @EJB
    CustomersFacade customerf;
    @EJB
    CountryFacade countryf;
    @EJB
    AddressFacadeSt af2;
    @EJB
    CustomersFacadeSt customerf2;
    @EJB
    CountryFacadeSt countryf2;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Countries</title>");
            out.println("</head>");
            out.println("<body>");
            /**
             * Depends on the database value, performs the db operations
             */
            if (request.getParameter("Database").equals("DaghenamDB")) {
                
                /**
                 * Add new address
                 */
                if (request.getParameter("Operation").equals("addAddress")) {

                    out.println("<h1>Add new address</h1>");
                    Address ab = new Address();
                    String adrStreet = request.getParameter("txtAdrStreet");
                    ab.setAdrstreet(adrStreet);
                    String city = request.getParameter("txtCity");
                    ab.setCity(city);
                    String county = request.getParameter("txtCounty");
                    ab.setCounty(county);
                    String postcode = request.getParameter("txtPostCode");
                    ab.setPostcode(postcode);

                    int countryid = Integer.parseInt(request.getParameter("txtCountryID"));
                    Country countryb = countryf.find(countryid);
                    ab.setCountryId(countryb);

                    int customerid = Integer.parseInt(request.getParameter("txtCustomerID"));
                    Customers customerb = customerf.find(customerid);
                    ab.setCustomerId(customerb);

                    af.create(ab);
                    out.println("New Address added sucessfully");


                } 
                /**
                 * Update address by ID
                 */
                else if (request.getParameter("Operation").equals("updateAddress")) {
                    Address ab = new Address();
                    out.println("<h1>Update Existing Address</h1>");

                    int address_id = Integer.parseInt(request.getParameter("txtAddressID"));
                    ab.setAddressId(address_id);

                    String adrStreet = request.getParameter("txtAdrStreet");
                    ab.setAdrstreet(adrStreet);
                    String city = request.getParameter("txtCity");
                    ab.setCity(city);
                    String county = request.getParameter("txtCounty");
                    ab.setCounty(county);
                    String postcode = request.getParameter("txtPostCode");
                    ab.setPostcode(postcode);

                    int countryid = Integer.parseInt(request.getParameter("txtCountryID"));
                    Country countryb = countryf.find(countryid);
                    ab.setCountryId(countryb);

                    int customerid = Integer.parseInt(request.getParameter("txtCustomerID"));
                    Customers customerb = customerf.find(customerid);
                    ab.setCustomerId(customerb);

                    af.edit(ab);
                    out.println("Address Updated sucessfully");


                } 
                /**
                 * Delete address by ID
                 */
                else if (request.getParameter("Operation").equals("deleteAddress")) {
                    int address_id = Integer.parseInt(request.getParameter("txtAddressID"));
                    out.println("<h1>Delete Address</h1>");
                    Address ab = af.find(address_id);
                    af.remove(ab);
                    out.println("Address Removed");


                } 
                /**
                 * View All Addresses
                 */
                else if (request.getParameter("Operation").equals("viewAddress")) {
                    out.println("<h1>View All Addresses</h1>");
                    List<Address> al = af.findAll();

                    out.println("<table><tr><th>Address ID</th><th>Adr Street</th><th>City</th><th>County</th><th>Post Code</th><th>Country ID</th><th>Customer ID</th>");
                    for (Address address : al) {
                        out.println("<tr><td>" + address.getAddressId() + "</td>");
                        out.println("<td>" + address.getAdrstreet() + "</td>");
                        out.println("<td>" + address.getCity() + "</td>");
                        out.println("<td>" + address.getCounty() + "</td>");
                        out.println("<td>" + address.getPostcode() + "</td>");
                        out.println("<td>" + address.getCountryId().getName() + "</td>");
                        out.println("<td>" + address.getCustomerId().getUsername() + "</td></tr>");
                    }
                    out.println("</table>");


                }
                /**
                 * Find address by ID
                 */
                else if (request.getParameter("Operation").equals("findAddress")) {

                    int addressID = Integer.parseInt(request.getParameter("txtAddressID"));
                    out.println("<h1>Find Addresses</h1>");
                    Address address = af.find(addressID);
                    out.println("<table><tr><th>Address ID</th><th>Adr Street</th><th>City</th><th>County</th><th>Post Code</th><th>Country ID</th><th>Customer ID</th>");
                    out.println("<tr><td>" + address.getAddressId() + "</td>");
                    out.println("<td>" + address.getAdrstreet() + "</td>");
                    out.println("<td>" + address.getCity() + "</td>");
                    out.println("<td>" + address.getCounty() + "</td>");
                    out.println("<td>" + address.getPostcode() + "</td>");
                    out.println("<td>" + address.getCountryId().getName() + "</td>");
                    out.println("<td>" + address.getCustomerId().getUsername() + "</td></tr>");
                    out.println("</table>");
                }
            } /**
             * Stratford database operations
             */
            else {
                /**
                 * Add new address
                 */
                if (request.getParameter("Operation").equals("addAddress")) {

                    out.println("<h1>Add new address</h1>");
                    Address ab = new Address();
                    String adrStreet = request.getParameter("txtAdrStreet");
                    ab.setAdrstreet(adrStreet);
                    String city = request.getParameter("txtCity");
                    ab.setCity(city);
                    String county = request.getParameter("txtCounty");
                    ab.setCounty(county);
                    String postcode = request.getParameter("txtPostCode");
                    ab.setPostcode(postcode);

                    int countryid = Integer.parseInt(request.getParameter("txtCountryID"));
                    Country countryb = countryf2.find(countryid);
                    ab.setCountryId(countryb);

                    int customerid = Integer.parseInt(request.getParameter("txtCustomerID"));
                    Customers customerb = customerf2.find(customerid);
                    ab.setCustomerId(customerb);

                    af2.create(ab);
                    out.println("New Address added sucessfully");


                } 
                /**
                 * Update existing address
                 */
                else if (request.getParameter("Operation").equals("updateAddress")) {
                    Address ab = new Address();
                    out.println("<h1>Update Existing Address</h1>");

                    int address_id = Integer.parseInt(request.getParameter("txtAddressID"));
                    ab.setAddressId(address_id);

                    String adrStreet = request.getParameter("txtAdrStreet");
                    ab.setAdrstreet(adrStreet);
                    String city = request.getParameter("txtCity");
                    ab.setCity(city);
                    String county = request.getParameter("txtCounty");
                    ab.setCounty(county);
                    String postcode = request.getParameter("txtPostCode");
                    ab.setPostcode(postcode);

                    int countryid = Integer.parseInt(request.getParameter("txtCountryID"));
                    Country countryb = countryf2.find(countryid);
                    ab.setCountryId(countryb);

                    int customerid = Integer.parseInt(request.getParameter("txtCustomerID"));
                    Customers customerb = customerf2.find(customerid);
                    ab.setCustomerId(customerb);

                    af2.edit(ab);
                    out.println("Address Updated sucessfully");


                } 
                /**
                 * Delete address
                 */
                else if (request.getParameter("Operation").equals("deleteAddress")) {
                    int address_id = Integer.parseInt(request.getParameter("txtAddressID"));
                    out.println("<h1>Delete Address</h1>");
                    Address ab = af2.find(address_id);
                    af2.remove(ab);
                    out.println("Address Removed");


                } 
                /**
                 * View all addresses
                 */
                else if (request.getParameter("Operation").equals("viewAddress")) {
                    out.println("<h1>View All Addresses</h1>");
                    List<Address> al = af2.findAll();

                    out.println("<table><tr><th>Address ID</th><th>Adr Street</th><th>City</th><th>County</th><th>Post Code</th><th>Country ID</th><th>Customer ID</th>");
                    for (Address address : al) {
                        out.println("<tr><td>" + address.getAddressId() + "</td>");
                        out.println("<td>" + address.getAdrstreet() + "</td>");
                        out.println("<td>" + address.getCity() + "</td>");
                        out.println("<td>" + address.getCounty() + "</td>");
                        out.println("<td>" + address.getPostcode() + "</td>");
                        out.println("<td>" + address.getCountryId().getName() + "</td>");
                        out.println("<td>" + address.getCustomerId().getUsername() + "</td></tr>");
                    }
                    out.println("</table>");


                } 
                /**
                 * Find address by ID
                 */
                else if (request.getParameter("Operation").equals("findAddress")) {

                    int addressID = Integer.parseInt(request.getParameter("txtAddressID"));
                    out.println("<h1>Find Addresses</h1>");
                    Address address = af2.find(addressID);
                    out.println("<table><tr><th>Address ID</th><th>Adr Street</th><th>City</th><th>County</th><th>Post Code</th><th>Country ID</th><th>Customer ID</th>");
                    out.println("<tr><td>" + address.getAddressId() + "</td>");
                    out.println("<td>" + address.getAdrstreet() + "</td>");
                    out.println("<td>" + address.getCity() + "</td>");
                    out.println("<td>" + address.getCounty() + "</td>");
                    out.println("<td>" + address.getPostcode() + "</td>");
                    out.println("<td>" + address.getCountryId().getName() + "</td>");
                    out.println("<td>" + address.getCustomerId().getUsername() + "</td></tr>");
                    out.println("</table>");
                }


            }

        } catch (Exception e) {
            out.println(e.toString());
            //System.out.p
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
