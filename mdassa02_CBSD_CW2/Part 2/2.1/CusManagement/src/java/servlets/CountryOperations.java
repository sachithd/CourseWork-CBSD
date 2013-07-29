/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.CountryBean;
import dao.CountryDAODagenham;
import dao.CountryDAOInt;
import dao.CountryDAOStratford;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet to handle operations on Country table
 * @author Sachith
 */
public class CountryOperations extends HttpServlet {

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


            CountryBean cb = new CountryBean();

            /**
             * Choose the database according to the selection
             */
            CountryDAOInt cd;
            if (request.getParameter("Database").equals("DaghenamDB")) {
                cd = new CountryDAODagenham();
            } else {
                cd = new CountryDAOStratford();

            }



            HttpSession session = request.getSession(true);

            /**
             * Add new country
             */
            if (request.getParameter("Operation").equals("addCountry")) {

                String name = request.getParameter("txtCountryName");
                cb.setName(name);
                String currency = request.getParameter("txtCurrency");
                cb.setCurrency(currency);
                Double exchange = Double.parseDouble(request.getParameter("txtExchange"));
                cb.setExchange(exchange);

                try {
                    cd.add(cb);

                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Add new country</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("New Country added sucessfully");
                    out.println("</body>");
                    out.println("</html>");

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } 
            /**
             * Delete country by ID
             */
            else if (request.getParameter("Operation").equals("deleteCountry")) {
                int country_id = Integer.parseInt(request.getParameter("txtCountryID"));
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Delete country</title>");
                out.println("</head>");
                out.println("<body>");


                if (cd.delete(country_id) > 0) {
                    out.println("Country deleted sucessfully");

                } else if (cd.delete(country_id) == 0) {
                    out.println("country id not found");
                } else {
                    out.println("An error occured");
                }
                out.println("</body>");
                out.println("</html>");
            } 
            /**
             * Find country by ID
             */
            
            else if (request.getParameter("Operation").equals("findCountry")) {
                int country_id = Integer.parseInt(request.getParameter("txtCountryID"));
                ArrayList<CountryBean> al = cd.findCountry(country_id);
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Find country</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table><tr><th>Country ID</th><th>Name</th><th>Currency</th><th>Exchange</th>");
                for (CountryBean countryBean : al) {
                    out.println("<tr><td>" + countryBean.getCountry_id() + "</td>");
                    out.println("<td>" + countryBean.getName() + "</td>");
                    out.println("<td>" + countryBean.getCurrency() + "</td>");
                    out.println("<td>" + countryBean.getExchange().toString() + "</td></tr>");
                }



            } /**
             * Update country details by ID
             */
            else if (request.getParameter("Operation").equals("update")) {

                int country_id = Integer.parseInt(request.getParameter("txtCountryID"));
                cb.setCountry_id(country_id);
                String name = request.getParameter("txtCountryName");
                cb.setName(name);
                String currency = request.getParameter("txtCurrency");
                cb.setCurrency(currency);
                Double exchange = Double.parseDouble(request.getParameter("txtExchange"));
                cb.setExchange(exchange);

                try {
                    cd.update(cb);

                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Update country</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("Country Updated sucessfully");
                    out.println("</body>");
                    out.println("</html>");

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } /**
             * View all countries
             */
            else if (request.getParameter("Operation").equals("viewCountry")) {
                ArrayList<CountryBean> al = cd.displayCountry();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>View All countries</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table><tr><th>Country ID</th><th>Name</th><th>Currency</th><th>Exchange</th>");
                for (CountryBean countryBean : al) {
                    out.println("<tr><td>" + countryBean.getCountry_id() + "</td>");
                    out.println("<td>" + countryBean.getName() + "</td>");
                    out.println("<td>" + countryBean.getCurrency() + "</td>");
                    out.println("<td>" + countryBean.getExchange().toString() + "</td></tr>");
                }

            }




        } catch (Exception e) {
            out.println(e.toString());
        } finally {
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
