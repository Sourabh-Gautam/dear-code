import javax.servlet.*;
import java.sql.*;
public class MyListener implements ServletContextListener{
private Connection conn;
public void contextInitialized(ServletContextEvent scte){
ServletContext sct=scte.getServletContext();
try{
System.out.println("contextInitialized method called...");
String dname=sct.getInitParameter("dname");
Class.forName(dname);
System.out.println("Driver Loaded");
String connurl=sct.getInitParameter("connurl");
String username=sct.getInitParameter("username");
String password=sct.getInitParameter("password");
conn=DriverManager.getConnection(connurl,username,password);
System.out.println("Connect to database");
sct.setAttribute("connobj",conn);
}
catch(Exception e){
	System.out.println("Some Exception Occured: "+e);
}
}
public void contextDestroyed(ServletContextEvent scte){
System.out.println("contextDestroyed() method is called...");
try{
conn.close();
}
catch(SQLException sq){
System.out.println("Exception in closing the Connection: "+sq);
}
}
}