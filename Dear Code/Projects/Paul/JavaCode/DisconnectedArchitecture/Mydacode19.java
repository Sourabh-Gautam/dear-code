import java.sql.*;
import java.util.*;
class Mydacode18{
public static void main(String []args){
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver Loaded Successfully");
	}
	catch(ClassNotFoundException cns){
		System.out.println("Could not load the driver "+cns.getMessage());
		System.exit(1);
		}
	try{
		com.sun.rowset.CachedRowSetImpl crs=new com.sun.rowset.CachedRowSetImpl();
		crs.setUrl("jdbc:oracle:thin:@//SourabhPaul:1521/orcl");
		crs.setUsername("library");
		crs.setPassword("paul");
		Scanner kb=new Scanner(System.in);
		crs.setCommand("select * from books where price<?");
		System.out.println("Enter the value of price");
		double amt=kb.nextDouble();
		crs.setDouble(1,amt);
		crs.execute();
		int count=0;
		while(crs.next()){
			String bname=crs.getString(2);
			double price=crs.getDouble(3);
			System.out.println(bname+"\t"+price);
			}
		}
	catch(SQLException sq){
		System.out.println("Could not connected to the database");
		}
	}
}