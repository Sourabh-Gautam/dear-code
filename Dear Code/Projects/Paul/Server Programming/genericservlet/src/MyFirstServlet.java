import javax.servlet.*;
import java.io.*;

public class MyFirstServlet extends GenericServlet{
public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException{
resp.setContentType("text/html");
PrintWriter out=resp.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<title>My First Servlet</title>");
out.println("</head>");
out.println("<body>");
out.println("<h2>Welcome to Servlet</h2>");
out.println("</body>");
out.println("</html>");
out.close();
}
}