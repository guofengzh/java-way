package servlet.basic.redirect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/redirect/guess")
public class RedirectServlet extends HttpServlet {
	private final static String MAJOR_IN_JAVA = "java" ;
 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String majorin = request.getParameter("majorin");
		if (majorin == null || majorin.isEmpty() ) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Bad guy, type a word");
			return;
		}
		if (MAJOR_IN_JAVA.equalsIgnoreCase(majorin)) {
			// How we pass data to the target servlet
			HttpSession session = request.getSession() ;
		    session.setAttribute("whatIguess", majorin);
		    // The following redirect use status 302 (SC_MOVED_PERMANENTLY) for redirect, 
		    // there is also 301 (SC_MOVED_PERMANENTLY)
			response.sendRedirect(this.getServletContext().getContextPath()+"/redirect/guessed");
			// and the new 307 (TEMPORARY_REDIRECT) 
			//response.setStatus(307); //this makes the redirection keep your requesting method as is.
			//response.addHeader("Location", this.getServletContext().getContextPath()+"/redirect/guessed");
			return ;
			
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "You guessed wrong");
			return ;
		}
	}
}