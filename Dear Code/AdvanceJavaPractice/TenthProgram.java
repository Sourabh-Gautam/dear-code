import java.util.*;
import java.sql.*;
class TenthProgram{
	public static void main(String []args){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver successfully loaded");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Driver not loaded : "+cnfe.getMessage());
			System.exit(0);
		}
		
		
		try{
			com.sun.rowset.CachedRowSetImpl crs =new com.sun.rowset.CachedRowSetImpl();
			crs.setUrl("jdbc:oracle:thin:@//SourabhPaul:1521/xe");
			crs.setUsername("rohit");
			crs.setPassword("admin");
			crs.setCommand("select * from books");
			crs.execute();
			crs.beforeFirst();
			while(crs.previous())
			{	int id =crs.getInt(1);
				String name = crs.getString(2);
				double price =crs.getDouble(3);
				System.out.println("Bookid :"+id+" Bookname :"+name+" Price :"+price);	
			}
		}

		catch(SQLException sqle){
			System.out.println("Some error occured: "+sqle.getMessage());
		}
	}
}