package servlet.basic.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/forward/guessed")
public class GuessedServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String guessed =  (String)request.getAttribute("whatIguess") ;
		PrintWriter writer = response.getWriter() ;
		// use setStatus(int) to set successful status
		response.setStatus(HttpServletResponse.SC_CREATED);
		response.setHeader("Content-Type", "text/plain");
		writer.print("Pong, you guessed " + guessed) ;
	}

}
