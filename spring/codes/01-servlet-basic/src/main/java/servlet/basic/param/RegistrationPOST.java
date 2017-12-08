package servlet.basic.param; 

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/param/register-post")
public class RegistrationPOST extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String firstName = checkVal(request.getParameter("firstName"),
                                "Missing first name");
    String lastName = checkVal(request.getParameter("lastName"),
                                "Missing last name");
    String emailAddress = checkVal(request.getParameter("emailAddress"),
                                   "Missing email address");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Registering";
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
  
  // Method to handle POST method request.
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
     
     doGet(request, response);
  }
  

  /** Returns error message if value is missing or is empty string. */
  
  protected String checkVal(String orig, String replacement) {
    if ((orig == null) || (orig.trim().equals(""))) {
      return("<FONT COLOR=RED><B>" + replacement + "</B></FONT>");
    } else {
      return(orig);
    }
  }
}
