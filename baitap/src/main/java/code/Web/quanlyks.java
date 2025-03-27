package code.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class quanlyks extends HttpServlet {

    public quanlyks() {
        super(); // Gọi constructor của HttpServlet
    }


  @Override
  public void init() throws ServletException {
    System.out.println("Servlet " + this.getServletName() + " has started.");
  }

  @Override
  public void destroy() {
    System.out.println("Servlet " + this.getServletName() + " has stopped.");
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    super.service(request, response);

    System.out.println("Request method: " + request.getMethod());
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("<h1>Hello, World!</h1>");
    out.close();
  }
}
