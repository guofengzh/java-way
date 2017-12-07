package avic.servlet.basic;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/list")
public class MakeList extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>A List</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>A List</H1>\n" +
                "<UL>\n" +
                "  <LI>" + Math.random() + "</LI>\n" +
                "  <LI>" + Math.random() + "</LI>\n" +
                "  <LI>" + Math.random() + "</LI>\n" +
                "  <LI>" + Math.random() + "</LI>\n" +
                "</UL>\n" +
                "</BODY></HTML>");
  }
}
