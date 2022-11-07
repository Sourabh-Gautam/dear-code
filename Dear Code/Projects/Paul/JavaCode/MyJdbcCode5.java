// Program to insert a record using CallableStatement in programmer defined table "Library".
import java.sql.*;
import java.util.Scanner;
class MyJdbcCode4{
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
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//SOURABHCOMPUTER/orcl","Library","paul");
			CallableStatement cst=conn.prepareCall("{call addbook(?,?,?)}");
			Scanner kb=new Scanner(System.in);
			System.out.println("Enter BookID:");
			int id=kb.nextInt();
			System.out.println("Enter BookName:");
			kb.nextLine();
			String bookname=kb.nextLine();
			System.out.println("Enter BookPrice:");
			int price=kb.nextInt();
			cst.setInt(1,id);
			cst.setString(2,bookname);
			cst.setInt(3,price);
			cst.execute();
			System.out.println("Record has been Inserted");
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