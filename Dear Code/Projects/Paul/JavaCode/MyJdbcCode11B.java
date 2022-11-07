//Program to display Behaviour of Default resultSet.Here we know Why resultSet not reverse the code while having previos() method.
import java.sql.*;
class MyJdbcCode11A{
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
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//SourabhPaul/orcl","library","paul");
			Statement st=conn.createStatement();
			st.setMaxRows(2);
			ResultSet rs=st.executeQuery("select * from books order by price desc");
			while(rs.next()){
			String name=rs.getString("bookname");	
			double price=rs.getDouble("price");
			System.out.println(name+"\t"+price);
			}
			System.out.print("Press any key to print the record reversly");
			System.in.read();//this statement freeze the program
			while(rs.previous()){
			String name=rs.getString("bookname");	
			double price=rs.getDouble("price");
			System.out.println(name+"\t"+price);
			}
		}
			
	catch(Exception ex){
		System.out.println("Cannot Communicate with the Database:"+ex.getMessage());
	}
	finally{
		if(conn!=null){
			try{
				conn.close();
			}
		catch(SQLException sq){
			System.out.println("Connot Close the Connection:"+ sq.getMessage());
					}
		}
	}
	}
}