/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.CustomerBean;
import dao.CustomerDAODagenham;
import dao.CustomerDAOInt;
import dao.CustomerDAOStratford;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet to handle operations on Customer table
 *
 * @author Sachith
 */
public class CustomerOperations extends HttpServlet {

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


            CustomerBean cb = new CustomerBean();

            /**
             * Choose the database according to the selection
             */
            CustomerDAOInt cd;
            if (request.getParameter("Database").equals("DaghenamDB")) {
                cd = new CustomerDAODagenham();
            } else {
                cd = new CustomerDAOStratford();

            }


            HttpSession session = request.getSession(true);
            /**
             * Add new Customer
             */
            if (request.getParameter("Operation").equals("addCustomer")) {

                String username = request.getParameter("txtUserName");
                cb.setUsername(username);
                String password = request.getParameter("txtPassword");
                cb.setPassword(password);
                String fName = request.getParameter("txtFName");
                cb.setFname(fName);
                String LName = request.getParameter("txtLName");
                cb.setLname(LName);
                String email = request.getParameter("txtEmail");
                cb.setEmail(email);
                Date since = Date.valueOf(request.getParameter("txtSince"));
                cb.setSince(since);

                try {
                    cd.add(cb);

                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Add new Customer</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("New Customer added sucessfully");
                    out.println("</body>");
                    out.println("</html>");

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } /**
             * Delete customer by its id
             */
            else if (request.getParameter("Operation").equals("deleteCustomer")) {
                int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Delete Customer</title>");
                out.println("</head>");
                out.println("<body>");


                if (cd.delete(customer_id) > 0) {
                    out.println("Customer deleted sucessfully (Including related addresses)");

                } else if (cd.delete(customer_id) == 0) {
                    out.println("Customer id not found");
                } else {
                    out.println("An error occured");
                }
                out.println("</body>");
                out.println("</html>");

            } /**
             * Find customer by id
             */
            else if (request.getParameter("Operation").equals("findCustomer")) {
                int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                ArrayList<CustomerBean> al = cd.findCustomer(customer_id);
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Find Customer</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table><tr><th>Customer ID</th><th>User Name</th><th>Password</th><th>First Name</th><th>Last Name</th>"
                        + "<th>Email</th><th>Since</th>");
                for (CustomerBean customerBean : al) {
                    out.println("<tr><td>" + customerBean.getCustomer_id() + "</td>");
                    out.println("<td>" + customerBean.getUsername() + "</td>");
                    out.println("<td>" + customerBean.getPassword() + "</td>");
                    out.println("<td>" + customerBean.getFname() + "</td>");
                    out.println("<td>" + customerBean.getLname() + "</td>");
                    out.println("<td>" + customerBean.getEmail() + "</td>");
                    out.println("<td>" + customerBean.getSince().toString() + "</td></tr>");
                }

                out.println("</body>");
                out.println("</html>");

            } /**
             * View all customers
             */
            else if (request.getParameter("Operation").equals("viewCustomer")) {
                // int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                ArrayList<CustomerBean> al = cd.findAllCustomers();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>View All Customers</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<table border=\"1\"><tr><th>Customer ID</th><th>User Name</th><th>Password</th><th>First Name</th><th>Last Name</th>"
                        + "<th>Email</th><th>Since</th>");
                for (CustomerBean customerBean : al) {
                    out.println("<tr><td>" + customerBean.getCustomer_id() + "</td>");
                    out.println("<td>" + customerBean.getUsername() + "</td>");
                    out.println("<td>" + customerBean.getPassword() + "</td>");
                    out.println("<td>" + customerBean.getFname() + "</td>");
                    out.println("<td>" + customerBean.getLname() + "</td>");
                    out.println("<td>" + customerBean.getEmail() + "</td>");
                    out.println("<td>" + customerBean.getSince().toString() + "</td></tr>");
                }

                out.println("</body>");
                out.println("</html>");

            } /**
             * Update a customer by its id
             */
            else if (request.getParameter("Operation").equals("updateCustomer")) {

                int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                cb.setCustomer_id(customer_id);
                String username = request.getParameter("txtUserName");
                cb.setUsername(username);
                String password = request.getParameter("txtPassword");
                cb.setPassword(password);
                String fName = request.getParameter("txtFName");
                cb.setFname(fName);
                String LName = request.getParameter("txtLName");
                cb.setLname(LName);
                String email = request.getParameter("txtEmail");
                cb.setEmail(email);
                Date since = Date.valueOf(request.getParameter("txtSince"));
                cb.setSince(since);

                try {
                    cd.update(cb);

                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Update Existing Customer</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("Customer record updated sucessfully");
                    out.println("</body>");
                    out.println("</html>");

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
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
