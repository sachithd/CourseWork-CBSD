package servlets;

import controller.CustomersFacade;
import controllerlStratford.CustomersFacadeSt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customers;

/**
 * Servlet to perform CRUD Operations on Customer table
 * @author Sachith
 */
@WebServlet(name = "CustomerOperations", urlPatterns = {"/CustomerOperations"})
public class CustomerOperations extends HttpServlet {

    @EJB
    CustomersFacade cf;
    @EJB
    CustomersFacadeSt cf2;

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
            out.println("<title>Servlet Customer Operations</title>");
            out.println("</head>");
            out.println("<body>");
            /**
             * Depends on the database value, performs the db operations
             */
            if (request.getParameter("Database").equals("DaghenamDB")) {
                
                /**
                 * Add new customer
                 */
                if (request.getParameter("Operation").equals("addCustomer")) {
                    //  out.println("<h1>Servlet CustomerOperations at " + request.getContextPath() + "</h1>");
                    Customers cb = new Customers();

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
                    cf.create(cb);
                    out.println("New Customer Record Added");



                } 
                /**
                 * Delete customer
                 */
                
                else if (request.getParameter("Operation").equals("deleteCustomer")) {

                    int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                    Customers customerBean = cf.find(customer_id);
                    customerBean = cf.find(customer_id);
                    cf.remove(customerBean);
                    out.println("Customer Removed");


                } 
                /**
                 * Find customer by id
                 */
                
                else if (request.getParameter("Operation").equals("findCustomer")) {
                    int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                    Customers customerBean = cf.find(customer_id);

                    out.println("<table border=\"1\"><tr><th>Customer ID</th><th>User Name</th><th>Password</th><th>First Name</th><th>Last Name</th>"
                            + "<th>Email</th><th>Since</th>");

                    out.println("<tr><td>" + customerBean.getCustomerId() + "</td>");
                    out.println("<td>" + customerBean.getUsername() + "</td>");
                    out.println("<td>" + customerBean.getPassword() + "</td>");
                    out.println("<td>" + customerBean.getFname() + "</td>");
                    out.println("<td>" + customerBean.getLname() + "</td>");
                    out.println("<td>" + customerBean.getEmail() + "</td>");
                    out.println("<td>" + customerBean.getSince().toString() + "</td></tr>");


                } 
                /**
                 * View all customers
                 */
                else if (request.getParameter("Operation").equals("viewCustomer")) {
                    List<Customers> al = cf.findAll();
                    out.println("<table><tr><th>Customer ID</th><th>User Name</th><th>Password</th><th>First Name</th><th>Last Name</th>"
                            + "<th>Email</th><th>Since</th>");
                    for (Customers customerBean : al) {
                        out.println("<tr><td>" + customerBean.getCustomerId() + "</td>");
                        out.println("<td>" + customerBean.getUsername() + "</td>");
                        out.println("<td>" + customerBean.getPassword() + "</td>");
                        out.println("<td>" + customerBean.getFname() + "</td>");
                        out.println("<td>" + customerBean.getLname() + "</td>");
                        out.println("<td>" + customerBean.getEmail() + "</td>");
                        out.println("<td>" + customerBean.getSince().toString() + "</td></tr>");
                    }
                } 
                /**
                 * Update existing customer
                 */
                else if (request.getParameter("Operation").equals("updateCustomer")) {
                    Customers cb = new Customers();
                    int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                    cb.setCustomerId(customer_id);
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
                    cf.edit(cb);
                    out.println("Customer Record Updated");
                }
            } /**
             * Stratford database operations
             */
            else {
                /**
                 * Add new customer
                 */
                if (request.getParameter("Operation").equals("addCustomer")) {
                    //  out.println("<h1>Servlet CustomerOperations at " + request.getContextPath() + "</h1>");
                    Customers cb = new Customers();

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
                    cf2.create(cb);
                    out.println("New Customer Record Added");



                } 
                /**
                 * Delete customer
                 */
                
                else if (request.getParameter("Operation").equals("deleteCustomer")) {

                    int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                    Customers customerBean = cf2.find(customer_id);
                    customerBean = cf2.find(customer_id);
                    cf2.remove(customerBean);
                    out.println("Customer Removed");


                } 
                /**
                 * Find Customer
                 */
                
                else if (request.getParameter("Operation").equals("findCustomer")) {
                    int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                    Customers customerBean = cf2.find(customer_id);

                    out.println("<table border=\"1\"><tr><th>Customer ID</th><th>User Name</th><th>Password</th><th>First Name</th><th>Last Name</th>"
                            + "<th>Email</th><th>Since</th>");

                    out.println("<tr><td>" + customerBean.getCustomerId() + "</td>");
                    out.println("<td>" + customerBean.getUsername() + "</td>");
                    out.println("<td>" + customerBean.getPassword() + "</td>");
                    out.println("<td>" + customerBean.getFname() + "</td>");
                    out.println("<td>" + customerBean.getLname() + "</td>");
                    out.println("<td>" + customerBean.getEmail() + "</td>");
                    out.println("<td>" + customerBean.getSince().toString() + "</td></tr>");


                } 
                /**
                 * View All Customers
                 */
                
                else if (request.getParameter("Operation").equals("viewCustomer")) {
                    List<Customers> al = cf2.findAll();
                    out.println("<table><tr><th>Customer ID</th><th>User Name</th><th>Password</th><th>First Name</th><th>Last Name</th>"
                            + "<th>Email</th><th>Since</th>");
                    for (Customers customerBean : al) {
                        out.println("<tr><td>" + customerBean.getCustomerId() + "</td>");
                        out.println("<td>" + customerBean.getUsername() + "</td>");
                        out.println("<td>" + customerBean.getPassword() + "</td>");
                        out.println("<td>" + customerBean.getFname() + "</td>");
                        out.println("<td>" + customerBean.getLname() + "</td>");
                        out.println("<td>" + customerBean.getEmail() + "</td>");
                        out.println("<td>" + customerBean.getSince().toString() + "</td></tr>");
                    }
                } 
                /**
                 * Update existing customer
                 */
                else if (request.getParameter("Operation").equals("updateCustomer")) {
                    Customers cb = new Customers();
                    int customer_id = Integer.parseInt(request.getParameter("txtCustomerID"));
                    cb.setCustomerId(customer_id);
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
                    cf2.edit(cb);
                    out.println("Customer Record Updated");
                }
            }


        } 
        catch(Exception e)
        {
             out.println(e.toString());
        }
        
        finally {
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
