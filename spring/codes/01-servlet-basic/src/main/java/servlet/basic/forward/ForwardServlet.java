package servlet.basic.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward/guess")
public class ForwardServlet extends HttpServlet {
	private final static String MAJOR_IN_JAVA = "java" ;
 
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String majorin = request.getParameter("majorin");
		if (majorin == null || majorin.isEmpty() ) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Bad guy, type a word");
			return;
		}
		if (MAJOR_IN_JAVA.equalsIgnoreCase(majorin)) {
			// How we pass data to the target servlet
		    request.setAttribute("whatIguess", majorin);
		    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/forward/guessed");
		    try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} 
		    
			return ;
			
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "You guessed wrong");
			return ;
		}
	}
}