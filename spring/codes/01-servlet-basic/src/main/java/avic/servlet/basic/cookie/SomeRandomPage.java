package avic.servlet.basic.cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** A servlet that displays a page on some random topic.
 *  However, the foreground and background colors can
 *  be customized if the user visits the color setup page.
 */

@WebServlet("/some-random-page")
public class SomeRandomPage extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String bgColor =
      CookieUtilities.getCookieValue(request, "bgColor", "WHITE");
    String fgColor =
      CookieUtilities.getCookieValue(request, "fgColor", "BLACK");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Some Random Page";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"" + bgColor +
                   "\" TEXT=\"" + fgColor + "\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "Blah, blah, blah, blah. Yadda, yadda, yadda, yadda.\n" +
                "Blah, blah, blah, blah. Yadda, yadda, yadda, yadda.\n" +
                "Blah, blah, blah, blah. Yadda, yadda, yadda, yadda.\n" +
                "<P>\n" +
                "Blah, blah, blah, blah. Yadda, yadda, yadda, yadda.\n" +
                "Blah, blah, blah, blah. Yadda, yadda, yadda, yadda.\n" +
                "Blah, blah, blah, blah. Yadda, yadda, yadda, yadda.\n" +
                "<HR>\n" +
                "See the <A HREF=\"color-setup.html\">\n" +
                "color setup page</A> to\n" +
                "customize the colors on this page.\n" +
                "</BODY></HTML>");
  }
}
