//Program to increase the value of price by 10% having price less than 2000.
import java.sql.*;
class Mydacode19{
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
		crs.setCommand("select * from books");
		crs.execute();
		int count=0;
		while(crs.next()){
			double amt=crs.getDouble(3);
			if(amt<2000){
				amt=amt+amt*.1;
				crs.updateDouble(3,amt);
				crs.updateRow();
				++count;
				}
			}
		if(count>0){
			crs.acceptChanges();
			System.out.println(count+" rows affected");
			}
		else
			System.out.println("No rows affected");
		}
	catch(SQLException sq){
		System.out.println("Could not connected to the database");
		}
	}
}