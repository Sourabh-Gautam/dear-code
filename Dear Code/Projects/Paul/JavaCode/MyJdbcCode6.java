// Program to get the price of a book of given id.
import java.sql.*;
import java.util.Scanner;
class MyJdbcCode5{
	public static void main(String []args){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Successfully loaded");
		}
		catch(ClassNotFoundException cnf){
			System.out.println("Cannot load the driver class:" +cnf.getMessage());
			System.exit(1);
		}
		Connection conn=null;
		try{
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-D8VIJP3:1521/orcl","Library","paul");
			CallableStatement cst=conn.prepareCall("{?=call tellmeprice(?)}");
			Scanner kb=new Scanner(System.in);
			System.out.println("Enter BookID:");
			int id=kb.nextInt();
			cst.setInt(2,id);
			cst.registerOutParameter(1,Types.DOUBLE);
			cst.execute();
			double ans=cst.getDouble(1);
			if(ans==0)
			System.out.println("BookId "+id+" is not available in the Library");
			else
			System.out.println("The Book price is "+ans);
			}
	catch(SQLException sq){
		System.out.println("Cannot Communicate with the Database:"+sq.getMessage());
	}
	finally{
		if(conn!=null){
			try{
				conn.close();
			}
		catch(SQLException sq){
			System.out.println("Connot Close the Connection:"+ sq.getMessage());
			System.out.println("Connot Close the Connection:"+ sq.getMessage());
		}
		}
	}
	}
}