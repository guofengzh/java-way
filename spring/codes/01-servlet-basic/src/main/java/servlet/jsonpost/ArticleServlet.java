package servlet.jsonpost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "articles", urlPatterns = {"/articles"})
public class ArticleServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    // This will store all received articles
    List<Article> articles = new LinkedList<Article>();
 
    /***************************************************
     * URL: /jsonservlet
     * doPost(): receives JSON data, parse it, map it and send back as JSON
     ****************************************************/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    	System.out.println(request.getContentType());
    	if (!request.getContentType().toLowerCase().startsWith("application/json")) {
    		response.sendError(400, "Unknow content type" );
    		return ;
    	}
        // 1. get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String s ;
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        String json = sb.toString() ;
 
        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();
 
        // 3. Convert received JSON to Article
        Article article = mapper.readValue(json, Article.class);
 
        // 4. Set response type to JSON
        response.setContentType("application/json");            
 
        // 5. Add article to List<Article>
        articles.add(article);
 
        // 6. Send List<Article> as JSON to client
        mapper.writeValue(response.getOutputStream(), articles);
        
        response.setStatus(201);
    }
}