/*  Sachith Dassanayake
 *  BBK_COIY029H7_2011: Component Based Software Development
 *  Submission Date 04/03/2012
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import operations.MyFileHandler;

/**
 * This class which extends a HttpServlet manages all the game functions
 *
 * @author Sachith Dassanayake
 */
public class Questions extends HttpServlet {

    MyFileHandler mfh;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * This method uses the session variables set in the {@link Login} servlet
     * and manages the game questioner
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        HttpSession session = request.getSession(true);


        //If the session attribute ssn is empty then redirects to the main page
        if (session.getAttribute("ssn") == null) {
            response.sendRedirect("/AssignmentOneSachith");
        } else {
            //If the SSN is valid display the questions

            // Retreive the session variables
            String username = session.getAttribute("username").toString();
            String city = session.getAttribute("city").toString();
            String ssn = session.getAttribute("ssn").toString();

            PrintWriter out = response.getWriter();

            Integer qno = 0;
            String answer = null;

            try {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Who Want's to be a Billionaire Question</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<font color=\"BLUE\"><h1> Who Want's to be a Billionaire</h1><hr/></font>");



                //Output the logged in user details
                out.println("Logged on as " + username + " of " + city + " (SSN : " + ssn + ") </br><br/>");

                if (request.getParameter("questionCounter") != null) {
                    qno = Integer.parseInt(request.getParameter("questionCounter"));
                }
                qno++;

                //File name for questions 1 to 9 generated according to the question number
                String qfilename = this.getServletContext().getRealPath("/WEB-INF/") + "\\ques" + qno.toString() + ".txt";

                //File to record winner details
                String winnerfile = this.getServletContext().getRealPath("/WEB-INF/") + "\\winners.txt";

                //File to record player details
                String playerfile = this.getServletContext().getRealPath("/WEB-INF/") + "\\players.txt";

                //Initialize variable mfh
                mfh = new MyFileHandler();

                //Reads the questions file and store the file content in to a String array
                String[] fileContents = mfh.readFile(qfilename);


                //If user has already answered the first question so this condition will be True
                if ((answer = request.getParameter("answers")) != null) {

                    session.setAttribute("questionNo", qno);

                    String[] line = {username + " of " + city + " won " + getWinningPrice(qno - 1)};

                    //Validate if the answer is correct and the question is within the correct range (1 - 9)
                    if (answer.equals(session.getAttribute("correctAnswer")) && qno <= 10) {

                        //If the user has answered all 9 questions correctly
                        if (qno == 10) {
                            
                            String[] winningLine = {username + " of " + city + " won " + getQuestionPrice(qno - 1)};

                            //Write winner details to the winners file
                            mfh.writeFile(winningLine, winnerfile);

                            //Write player details to the player file
                            writePlayer(username, city, ssn, mfh, playerfile);

                            out.println("<br/>Congratulation you won " + getQuestionPrice(qno - 1) + "<br/>");
                            session.setAttribute("ssn", null);
                            setMainMenuLink(out);
                        }

                        // If the answer is invalid     
                    } else {
                        out.println("<br/>Game over<br/>");


                        //Write winner details to the winners file only if there is a winning
                        if (!getWinningPrice(qno - 1).equals("$0")) {
                            mfh.writeFile(line, winnerfile);
                            out.println("<br/>Congratulation you won " + getWinningPrice(qno - 1) + "<br/>");
                        } else {
                            out.println("<br/> Thanks for playing Who Want's to be a Billionaire<br/>");
                        }


                        //Write player details to the player file
                        writePlayer(username, city, ssn, mfh, playerfile);


                        setMainMenuLink(out);

                        //Set the SSN session variable to null so the same user cannot 
                        session.setAttribute("ssn", null);
                    }



                } //Running the game for the first time for a user with a valid SSN
                // Here we do not have to check for the correct answer as this is running for the first time
                else {

                    session.setAttribute("questionNo", qno);
                }

                if (qno < 10) {

                    // The 6th line of the question file contains the correct answer
                    session.setAttribute("correctAnswer", fileContents[5]);

                    //Setting up the user interface for questions
                    setUserInterface(out, fileContents[0], fileContents[1], fileContents[2], fileContents[3], fileContents[4], qno.toString(), getQuestionPrice(qno));
                }

                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }


        }
    }

    /**
     * This methods takes the PrinterWriter as a parameter and outputs a button
     * to the Main page after the game ends
     *
     * @param out
     */
    public void setMainMenuLink(PrintWriter out) {
        // out.println("<form method=\"post\" action=\"\\AssignmentOneSachith\">");
        out.println("<form method=\"post\" action=\"/AssignmentOneSachith\">");
        out.println("<input type=\"submit\" value=\"Main Menu\" />");
        out.println("</form>");
        out.println("</html>");
        out.close();
    }

    /**
     * This method writes the player details to the player file
     *
     * @param username
     * @param city
     * @param ssn
     * @param fh Instance of a {@link MyFileHandler} Class
     */
    public void writePlayer(String username, String city, String ssn, MyFileHandler fh, String playerfile) {
        String[] playerDetails = {username, city, ssn};
        fh.writeFile(playerDetails, playerfile);

    }

    /**
     * This method outputs the HTML page to display the questions
     *
     * @param out PrinterWriter to Output HTML
     * @param q Question to be output
     * @param a1 Answer 1 to be output
     * @param a2 Answer 2 to be output
     * @param a3 Answer 3 to be output
     * @param a4 Answer 4 to be output
     * @param qno Question number to be output
     * @param amount How much a question is worth if the given answer is correct
     */
    public void setUserInterface(PrintWriter out, String q, String a1, String a2, String a3, String a4, String qno, String amount) {
        //Question Number
        out.println("The question " + qno + " is worth " + amount + "<br/><br/>");
        out.println(q + "<br/>");
        // out.println("<form method=\"post\" action=\"\\AssignmentOneSachith\\Questions\">");
        out.println("<form method=\"post\" action=\"\">");
        out.println("<input type=\"radio\" name=\"answers\" value=\"" + a1 + "\" CHECKED />" + a1 + "<br />");
        out.println("<input type=\"radio\" name=\"answers\" value=\"" + a2 + "\" />" + a2 + " <br />");
        out.println("<input type=\"radio\" name=\"answers\" value=\"" + a3 + "\" />" + a3 + " <br />");
        out.println("<input type=\"radio\" name=\"answers\" value=\"" + a4 + "\" />" + a4 + "<br />");
        out.println("<input type=\"hidden\" name=\"questionCounter\" value=\"" + qno + "\" /> ");
        out.println("<br />");
        out.println("<input type=\"submit\" value=\"Next Question\" />");
        out.println("</form>");

    }

    /**
     * This method return the price value of a question
     *
     * @param q Question number as a parameter
     * @return A String containing the price
     */
    public String getQuestionPrice(Integer q) {
        switch (q) {
            case 1:
                return "$100";
            case 2:
                return "$500";
            case 3:
                return "$1000";
            case 4:
                return "$5000";
            case 5:
                return "$10000";
            case 6:
                return "$50000";
            case 7:
                return "$100000";
            case 8:
                return "$500000";
            case 9:
                return "$1000000";
            default:
                return "Nothing";
        }

    }

    /**
     * This method generates the winning according to the current question
     * number
     *
     * @param q The question number
     * @return A String containing the winning price
     */
    public String getWinningPrice(Integer q) {
        switch (q) {
            case 1:
                return "$0";
            case 2:
                return "$0";
            case 3:
                return "$0";
            case 4:
                return "$1000";
            case 5:
                return "$1000";
            case 6:
                return "$10000";
            case 7:
                return "$10000";
            case 8:
                return "$100000";
            case 9:
                return "$100000";
            default:
                return "Nothing";
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
