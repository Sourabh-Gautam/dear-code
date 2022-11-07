import java.util.Scanner;
import java.sql.*;
class SeventhProgram{
	public static void main(String []args){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver successfully loaded");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Driver not loaded: "+cnfe.getMessage());
		}
		
		Connection c=null;
		try{
			c=DriverManager.getConnection("jdbc:oracle:thin:@//SourabhPaul:1521/xe", "rohit", "admin");
			
			System.out.println("Connection Established!");
			Statement st=c.createStatement();
			ResultSet rs = st.executeQuery("select * from books order by price desc");
			rs.next();
			System.out.println(rs.getString(2));
		}
		catch(SQLException sqle){
			System.out.println("Some error occured: "+sqle.getMessage());
		}
		finally{
			if(c!=null){
				try{
					c.close();
				}
				catch(Exception ex){
					System.out.println("Could not close connection: "+ex.getMessage());
				}
			}
		}
	}
}