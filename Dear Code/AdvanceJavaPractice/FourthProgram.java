import java.util.Scanner;
import java.sql.*;
class FourthProgram{
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
			CallableStatement cst=c.prepareCall("{call addbook(?,?,?)}");
			Scanner kb=new Scanner(System.in);
			System.out.print("Enter bookid: ");
			cst.setInt(1, kb.nextInt());
			System.out.print("Enter bookname: ");
			cst.setString(2, kb.next());
			System.out.print("Enter price: ");
			cst.setDouble(3, kb.nextDouble());
			cst.execute();
			System.out.println("Records have been inserted");
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