package avic.servlet.basic;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/table")
public class MakeTable extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    int rows = 25;
    int cols = 10;
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>A Table</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>A Table</H1>\n" +
                "<TABLE BORDER=1>\n" +
                "<TR BGCOLOR=\"#EF8429\">");
    // Table headings
    for(int col=1; col<cols+1; col++) {
      out.printf("  <TH>Column %s%n", col);
    }
    // Table body
    for(int row=1; row<rows+1; row++) {
      out.println("<TR>");
      for(int col=1; col<cols+1; col++) {
        out.printf("  <TD>Row %s, Col %s%n", row, col);
      }
    }
    out.println("</TABLE></BODY></HTML>");
  }
}
