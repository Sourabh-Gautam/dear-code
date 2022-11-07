import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class RegistrationServlet extends HttpServlet{
private PreparedStatement ps;
private Connection conn;
public void init() throws ServletException{
try{
ServletContext sct=super.getServletContext();
ServletConfig scf=super.getServletConfig();
String dname=sct.getInitParameter("dname");
Class.forName(dname);
System.out.println("Driver Loaded");
String connurl=sct.getInitParameter("connurl");
String username=sct.getInitParameter("username");
String password=sct.getInitParameter("password");
conn=DriverManager.getConnection(connurl,username,password);
System.out.println("Connect to database");
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
pw.println("<title>Registration Servlet</title>");
pw.println("<style>");
pw.println("#success{color:green;} #error{color:red}");
pw.println("</style>");
pw.println("</head>");
pw.println("<body>");
String uname=req.getParameter("username");
String pwd=req.getParameter("password");
String uid=req.getParameter("userid");
try{
ps.setString(1,uname);
ps.setString(2,uid);
ps.setString(3,pwd);
int count=ps.executeUpdate();
if(count==1){
pw.println("<h3 id='success'>Thank you "+uname+ ",For registering with us!</h3>");
pw.println("<a href='login.html'>Login</a><br>");
}
else{
pw.println("<h3 id='error'>Sorry, Cannot Register Now. Try Again Later</h3>");
pw.println("<a href='login.html'> Try again </a><br>");
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
public void destroy(){
try{
conn.close();
}
catch(SQLException sq){
System.out.println("Exception in closing the connection: "+sq);
}
}
}