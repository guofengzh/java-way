package servlet.basic.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/redirect/guessed")
public class GuessedServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession() ;
		String guessed = (String)session.getAttribute("whatIguess");
		session.removeAttribute("whatIguess");  // we removed it to prevent from memory leak
		response.setStatus(HttpServletResponse.SC_OK);
		response.setHeader("Content-Type", "text/plain");
		PrintWriter writer = response.getWriter() ;
		writer.print("Right, you guessed " + guessed) ;
	}

}
