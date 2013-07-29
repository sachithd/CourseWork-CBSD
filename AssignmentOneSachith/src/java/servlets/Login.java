/*  Sachith Dassanayake
 *  BBK_COIY029H7_2011: Component Based Software Development
 *  Submission Date 04/03/2012
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import operations.MyFileHandler;

/**
 * This class validates the login request from the HTML form GET request.
 * @author Sachith Dassanayake
 */
public class Login extends HttpServlet {

    /**
     * 
     * This method processes requests for HTTP
     * <code>GET</code> method to validate if a player SSN is already exists in the database.
     * If the SSN exists in the file it will redirect the user to the main screen or if the SSN is valid it redirect to the game
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

            /*
             * Variable declaration
             */
            
            //Assign posted sessions parameters to string variables
            String username = request.getParameter("txtName");
            String city = request.getParameter("txtCity");
            String ssn = request.getParameter("txtSSN");
            
            //File path
            String filename = this.getServletContext().getRealPath("/WEB-INF/") + "\\players.txt";

            
            /*
             * Outputs the HTML header
             * The outputs from this class are not visible to the user as it uses redirect method
             * This servlet is used for validation purpose 
             * The outputs (out.println) were used during the initial stage of the development for testing
             * All the out.println on this page can be removed
             */
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Who Want's to be a Billionaire</title>");
            out.println("</head>");
            out.println("<body>");
            
            
            //Check if the form is completed with data
            if ((username != null) && (username.length() > 0) && (ssn != null) && (ssn.length() > 0) && (city != null) && (city.length() > 0)) {
                out.println("<h2>Hello, " + username + city + ssn + "!</h2>");

                //Check for previous SSN
                MyFileHandler fh = new MyFileHandler();
                int ssnfound = fh.searchFile(ssn, filename);

                if (ssnfound == 0 || ssnfound == 3) {

                    /*
                     * SSN not found or players.txt file not exists. 
                     * If the file not exists create new file and continue to the quiz
                     */

                    //Set the session variables to be used during the game
                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("city", city);
                    request.getSession().setAttribute("ssn", ssn);

                    //Redirects the user to the quiz page
                    response.sendRedirect("/AssignmentOneSachith/Questions");
                    

                    

                } else if (ssnfound == 1) {
                    out.println("SSN Found. This player has already played the game before ");
                    response.sendRedirect("/AssignmentOneSachith/index.html?invalid=1");

                } else {
                    out.println(ssnfound);
                }


            } else {
                /* Empty form submission 
                 * This should be validated easily from the client side by a javascript. 
                 * But it's not implemented as validation is not required for this course work )
                 */
                out.println("nothing");
                response.sendRedirect("/AssignmentOneSachith/index.html?invalid=2");
            }
            out.println("</body>");
            out.println("</html>");
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
