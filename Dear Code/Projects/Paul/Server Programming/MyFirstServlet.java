import javax.servlet.*;
import java.io.*;
public class MyFirstServlet extends GenericServlet{
public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException{
resp.setContentType("text/html");
PrintWriter pw=resp.getWriter();
pw.println("<html>");
pw.println("<head>");
pw.println("<title>My First Servlet</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<h2>Welcome to Servlets<h2>");
pw.println("</body>");
pw.println("</html>");
pw.close();
}
}