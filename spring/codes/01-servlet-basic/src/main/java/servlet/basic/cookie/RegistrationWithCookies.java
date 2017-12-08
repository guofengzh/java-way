package servlet.basic.cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/cookie/registration")
public class RegistrationWithCookies extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    String firstName =
      checkVal(request.getParameter("firstName"),
               CookieUtilities.getCookieValue(request, "firstName", null),
               "Unknown first name");
    String lastName =
      checkVal(request.getParameter("lastName"),
               CookieUtilities.getCookieValue(request, "lastName", null),
               "Unknown last name");
    String emailAddress =
      checkVal(request.getParameter("emailAddress"),
               CookieUtilities.getCookieValue(request, "emailAddress", null),
               "Unknown email address");
    Cookie c1 = new LongLivedCookie("firstName", firstName);
    response.addCookie(c1);
    Cookie c2 = new LongLivedCookie("lastName", lastName);
    response.addCookie(c2);
    Cookie c3 = new LongLivedCookie("emailAddress", emailAddress);
    response.addCookie(c3);
    PrintWriter out = response.getWriter();
    String title = "Registering with Cookies";
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
  
  private String checkVal(String orig,
                          String cookieVal,
                          String replacement) {
    if ((orig != null) && (!orig.equals(""))) {
      return(orig);
    } else if (cookieVal != null) {
      return(cookieVal);
    } else {
      return("<FONT COLOR=RED><B>" + replacement + "</B></FONT>");
    }
  }
}
