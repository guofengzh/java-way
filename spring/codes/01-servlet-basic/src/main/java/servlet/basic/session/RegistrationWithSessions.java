package servlet.basic.session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/session/registration")
public class RegistrationWithSessions extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    HttpSession session = request.getSession();
    synchronized(session) {
      String firstName =
        checkVal(request.getParameter("firstName"),
                 session.getAttribute("firstName"),
                 "Unknown first name");
      String lastName =
        checkVal(request.getParameter("lastName"),
                 session.getAttribute("lastName"),
                 "Unknown last name");
      String emailAddress =
        checkVal(request.getParameter("emailAddress"),
                 session.getAttribute("emailAddress"),
                 "Unknown email address");
      session.setAttribute("firstName", firstName);
      session.setAttribute("lastName", lastName);
      session.setAttribute("emailAddress", emailAddress);
      PrintWriter out = response.getWriter();
      String title = "Registering with Sessions";
      String docType =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";
      out.println(docType +
                  "<HTML>\n" +
                  "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                  "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                  "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                  "<UL>\n" +
                  "  <LI><B>First Name</B>: " +
                  firstName + "\n" +
                  "  <LI><B>Last Name</B>: " +
                  lastName + "\n" +
                  "  <LI><B>Email address</B>: " +
                  emailAddress + "\n" +
                  "</UL>\n" +
                  "</BODY></HTML>");
    }
  }
  
  private String checkVal(String orig,
                          Object sessionVal,
                          String replacement) {
    if ((orig != null) && (!orig.equals(""))) {
      return(orig);
    } else if (sessionVal != null) {
      return((String)sessionVal);
    } else {
      return("<FONT COLOR=RED><B>" + replacement + "</B></FONT>");
    }
  }
}
