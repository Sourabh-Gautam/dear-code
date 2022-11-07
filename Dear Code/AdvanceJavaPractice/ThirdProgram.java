import java.util.Scanner;
import java.sql.*;
class ThirdProgram{
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
			PreparedStatement ps=c.prepareStatement("insert into books(bookid, bookname, price) values(?,?,?)");
			Scanner kb=new Scanner(System.in);
			System.out.print("Enter bookid: ");
			ps.setInt(1, kb.nextInt());
			System.out.print("Enter bookname: ");
			ps.setString(2, kb.next());
			System.out.print("Enter book price: ");
			ps.setDouble(3, kb.nextDouble());
			if(ps.executeUpdate()>0)
				System.out.println("Records Inserted");
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