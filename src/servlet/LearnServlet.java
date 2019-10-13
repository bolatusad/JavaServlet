package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "LearnServlet", urlPatterns = {"/servlet/learnServlet"})
public class LearnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String title = "测试请求头";

        String docType = "<!doctype html5>";
        out.println(docType + "<html> <head> <title> " + title + "</title>");
        Enumeration<String> headerNames = request.getHeaderNames();
        out.println("<body>");
        String table = "<table><tr><th>名称</th><th>值</th></tr>";
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerVal = request.getHeader(headerName);
            table += "<tr><td>"+ headerName+"</td>";
            table += "<td>"+ headerVal+"</td></tr>";
        }
        table += "</table>";
        out.println(table);
        out.println("</body></html>");
    }
}
