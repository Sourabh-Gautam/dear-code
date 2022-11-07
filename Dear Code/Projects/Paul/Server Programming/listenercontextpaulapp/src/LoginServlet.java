import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet{
private PreparedStatement ps;
private Connection conn;
public void init() throws ServletException{
ServletContext sct=super.getServletContext();
ServletConfig scf=super.getServletConfig();
try{
conn=(Connection)sct.getAttribute("connobj");
String qry=scf.getInitParameter("qry");
ps=conn.prepareStatement(qry);
}
catch(Exception e){
System.out.println("Exception occered in init():"+e);
throw new ServletException(e.getMessage());
}
}

public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
resp.setContentType("text/html");
PrintWriter pw=resp.getWriter();
pw.println("<html>");
pw.println("<head>");
pw.println("<title>Login Servlet</title>");
pw.println("<style>");
pw.println("#success{color:green;} #error{color:red}");
pw.println("</style>");
pw.println("</head>");
pw.println("<body>");
String pwd=req.getParameter("password");
String uid=req.getParameter("userid");
try{
ps.setString(1,uid);
ps.setString(2,pwd);
ResultSet rs=ps.executeQuery();
if(rs.next()){
String username=rs.getString("username");
pw.println("<h3 id='success'>Hello "+username+",Welcome to our site!</h3>");
}
else{
pw.println("<h3 id='error'>Sorry, invalid userid or password. Login Denied</h3>");
pw.println("<a href='login.html'> Try again </a><br>");
pw.println("<a href='registration.html'>Register</a><br>");
}
}
catch(SQLException sq){
pw.println("<h4>Sorry! some server error occured.Try again later</h4>");
System.out.println("SQLException in doPost(): "+sq);
}
finally{
pw.println("</body>");
pw.println("</html>");
pw.close();
}
}
}