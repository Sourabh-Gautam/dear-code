//Program to display top two highest paid books from the books table.
import java.sql.*;
class MyJdbcCode10{
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
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//SourabhPaul:1521/orcl","library","paul");
			Statement st=conn.createStatement();
			st.setMaxRows(2);
			ResultSet rs=st.executeQuery("select * from books order by price desc");
			while(rs.next()){
			String name=rs.getString("bookname");	
			double price=rs.getDouble("price");
			System.out.println(name+"\t"+price);
			}
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
					}
		}
	}
	}
}