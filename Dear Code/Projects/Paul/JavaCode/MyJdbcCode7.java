//WAP to print the books table column Name and data types using the ResultSetMetaData methods.
import java.sql.*;
class MyJdbcCode6{
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
			ResultSet rs=st.executeQuery("Select * from books");
			ResultSetMetaData rsmd=rs.getMetaData();
			int count=rsmd.getColumnCount();
			for(int i=1; i<=count; i++){
			System.out.println("The "+i+" Column name is: "+rsmd.getColumnName(i)+" ( "+rsmd.getColumnTypeName(i)+" )");
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
			System.out.println("Connot Close the Connection:"+ sq.getMessage());
		}
		}
	}
	}
}