import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class MyDateTimeServlet extends HttpServlet{
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
resp.setContentType("text/html");
PrintWriter pw=resp.getWriter();
pw.println("<html>");
pw.println("<head>");
pw.println("<link rel='stylesheet' type='text/css' href='mystyle.css'>");
pw.println("<style>");
pw.println("h2{ color: red;}");
pw.println("<title>My First Servlet</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<h2>The Current Date And Time is:<h2>");
java.util.Date dt=new java.util.Date();
pw.println("<h3>"+dt+"<h3>");
pw.println("</body>");
pw.println("</html>");
pw.close();
}
}