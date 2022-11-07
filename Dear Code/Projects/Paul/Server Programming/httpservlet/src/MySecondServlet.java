import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MySecondServlet extends HttpServlet{
public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException{
resp.setContentType("text/html");
PrintWriter out=resp.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<title>My Second Servlet</title>");
out.println("</head>");
out.println("<body>");
java.util.Date today=new java.util.Date();
out.println("<h2>Welcome, Today date and time is: "+today+"</h2>");
out.println("</body>");
out.println("</html>");
out.close();
}
}