package servlets;


import controller.CountryFacade;
import controllerlStratford.CountryFacadeSt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Country;

/**
 * Servlet to perform CRUD Operations on Country table
 * @author Sachith
 */
@WebServlet(name = "CountryOperations", urlPatterns = {"/CountryOperations"})
public class CountryOperations extends HttpServlet {

    @EJB CountryFacade cf;
    @EJB CountryFacadeSt cf2;
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
             * Depending on the database value, performs the db operations
             */
            if (request.getParameter("Database").equals("DaghenamDB")) {

                /**
                 * Add new Country
                 */
                if (request.getParameter("Operation").equals("addCountry")) {

                    out.println("<h1>Add new country</h1>");
                    Country cb = new Country();
                    String name = request.getParameter("txtCountryName");
                    cb.setName(name);
                    String currency = request.getParameter("txtCurrency");
                    cb.setCurrency(currency);
                    Double exchange = Double.parseDouble(request.getParameter("txtExchange"));
                    cb.setExchange(exchange);
                    cf.create(cb);
                    out.println("New Country added sucessfully");

                } 
                /**
                 * Update existing country
                 */
                else if (request.getParameter("Operation").equals("updateCountry")) {

                    out.println("<h1>Update Existing country</h1>");
                    Country cb = new Country();
                    int country_id = Integer.parseInt(request.getParameter("txtCountryID"));
                    cb.setCountryId(country_id);
                    String name = request.getParameter("txtCountryName");
                    cb.setName(name);
                    String currency = request.getParameter("txtCurrency");
                    cb.setCurrency(currency);
                    Double exchange = Double.parseDouble(request.getParameter("txtExchange"));
                    cb.setExchange(exchange);
                    cf.edit(cb);
                    out.println("Country Updated");

                } 
                /**
                 * Delete country by ID
                 */
                else if (request.getParameter("Operation").equals("deleteCountry")) {
                    out.println("<h1>Delete country</h1>");
                    Country cb = new Country();
                    int country_id = Integer.parseInt(request.getParameter("txtCountryID"));
                    cb = cf.find(country_id);
                    cf.remove(cb);
                    out.println("Country Removed");
                } 
                /**
                 * View all Countries
                 */
                
                else if (request.getParameter("Operation").equals("viewCountry")) {

                    out.println("<h1>View All Countries</h1>");
                    List<Country> al = cf.findAll();

                    out.println("<table><tr><th>Country ID</th><th>Name</th><th>Currency</th><th>Exchange</th>");
                    for (Country country : al) {
                        out.println("<tr><td>" + country.getCountryId() + "</td>");
                        out.println("<td>" + country.getName() + "</td>");
                        out.println("<td>" + country.getCurrency() + "</td>");
                        out.println("<td>" + country.getExchange().toString() + "</td></tr>");

                    }
                    out.println("</table>");
                } 
                /**
                 * Find a country by ID
                 */
                else if (request.getParameter("Operation").equals("findCountry")) {
                    int countryID = Integer.parseInt(request.getParameter("txtCountryID"));
                    out.println("<h1>Find Countries</h1>");

                    List<Country> al = cf.findCountry(countryID);

                    out.println("<table><tr><th>Country ID</th><th>Name</th><th>Currency</th><th>Exchange</th>");
                    for (Country country : al) {
                        out.println("<tr><td>" + country.getCountryId() + "</td>");
                        out.println("<td>" + country.getName() + "</td>");
                        out.println("<td>" + country.getCurrency() + "</td>");
                        out.println("<td>" + country.getExchange().toString() + "</td></tr>");

                    }
                    out.println("</table>");
                }

            }
            /**
             * Stratford database
             */
            else {
                /**
                 * Add new country
                 */
                if (request.getParameter("Operation").equals("addCountry")) {

                    out.println("<h1>Add new country</h1>");
                    Country cb = new Country();
                    String name = request.getParameter("txtCountryName");
                    cb.setName(name);
                    String currency = request.getParameter("txtCurrency");
                    cb.setCurrency(currency);
                    Double exchange = Double.parseDouble(request.getParameter("txtExchange"));
                    cb.setExchange(exchange);
                    cf2.create(cb);
                    out.println("New Country added sucessfully");

                } 
                /**
                 * Update existing country
                 */
                else if (request.getParameter("Operation").equals("updateCountry")) {

                    out.println("<h1>Update Existing country</h1>");
                    Country cb = new Country();
                    int country_id = Integer.parseInt(request.getParameter("txtCountryID"));
                    cb.setCountryId(country_id);
                    String name = request.getParameter("txtCountryName");
                    cb.setName(name);
                    String currency = request.getParameter("txtCurrency");
                    cb.setCurrency(currency);
                    Double exchange = Double.parseDouble(request.getParameter("txtExchange"));
                    cb.setExchange(exchange);
                    cf2.edit(cb);
                    out.println("Country Updated");

                } 
                /**
                 * Delete country by ID
                 */
                else if (request.getParameter("Operation").equals("deleteCountry")) {
                    out.println("<h1>Delete country</h1>");
                    Country cb = new Country();
                    int country_id = Integer.parseInt(request.getParameter("txtCountryID"));
                    cb = cf2.find(country_id);
                    cf2.remove(cb);
                    out.println("Country Removed");
                } 
                /**
                 * View all countries
                 */
                
                else if (request.getParameter("Operation").equals("viewCountry")) {

                    out.println("<h1>View All Countries</h1>");
                    List<Country> al = cf2.findAll();

                    out.println("<table><tr><th>Country ID</th><th>Name</th><th>Currency</th><th>Exchange</th>");
                    for (Country country : al) {
                        out.println("<tr><td>" + country.getCountryId() + "</td>");
                        out.println("<td>" + country.getName() + "</td>");
                        out.println("<td>" + country.getCurrency() + "</td>");
                        out.println("<td>" + country.getExchange().toString() + "</td></tr>");

                    }
                    out.println("</table>");
                } 
                /**
                 * Find country by ID
                 */
                else if (request.getParameter("Operation").equals("findCountry")) {
                    int countryID = Integer.parseInt(request.getParameter("txtCountryID"));
                    out.println("<h1>Find Countries</h1>");
                    Country country = cf2.find(countryID);
                   // List<Country> al = cf2.findCountry(countryID);

                    out.println("<table><tr><th>Country ID</th><th>Name</th><th>Currency</th><th>Exchange</th>");
                   // for (Country country : al) {
                        out.println("<tr><td>" + country.getCountryId() + "</td>");
                        out.println("<td>" + country.getName() + "</td>");
                        out.println("<td>" + country.getCurrency() + "</td>");
                        out.println("<td>" + country.getExchange().toString() + "</td></tr>");

                   // }
                    out.println("</table>");
                }
                
            }

        } catch (Exception e) {
            //System.out.println(e.toString());
            out.println(e.toString());

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
