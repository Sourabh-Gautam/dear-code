// Program to insert a record using Statement interface in programmer defined table "Library".
import java.sql.*;
import java.util.Scanner;
class MyJdbcCode2{
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
			Statement st=conn.createStatement();
			Scanner kb=new Scanner(System.in);
			System.out.println("Enter BookID:");
			int id=kb.nextInt();
			System.out.println("Enter BookName:");
			kb.nextLine();
			String bookname=kb.nextLine();
			System.out.println("Enter BookPrice:");
			int price=kb.nextInt();
			String qry="Insert into Books(BookID,BookName,Price) values("+id+",'"+bookname+"',"+price+")";
			int ans=st.executeUpdate(qry);
			if(ans==0)
				System.out.println("No Records Inserted");
			else
				System.out.println(ans+" Records Inserted");
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