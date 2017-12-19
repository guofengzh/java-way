package servlet.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.json.City;
import servlet.json.CityService;

@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class PDFServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/pdf;charset=UTF-8");

        response.addHeader("Content-Disposition", "inline; filename=" + "cities.pdf");
        ServletOutputStream out = response.getOutputStream();

        List<City> cities = CityService.getCities();

        ByteArrayOutputStream baos = PDFGenerator.getPdfFile(cities);
        baos.writeTo(out);
    }
}