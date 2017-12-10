package servlet.pathinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pathinfo/info/*")
public class PathInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        out.println("getServletContext().getContextPath() = "
                + getServletContext().getContextPath());
        out.println("request.getContextPath() = " + request.getContextPath());
        out.println("request.getServletPath() = " + request.getServletPath());
        out.println("request.getRequestURI() = " + request.getRequestURI());
        out.println("request.getPathInfo() = " + request.getPathInfo());
        out.println("request.getPathTranslated() =  " + request.getPathTranslated()); 
    }
}