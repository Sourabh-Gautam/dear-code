//Program to Fetch the table names of given user.
import java.sql.*;
class MyJdbcCode8{
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
			DatabaseMetaData dbmd=conn.getMetaData();
			String[] types=new String[]{"VIEW","TABLE"};
			ResultSet rs=dbmd.getTables(null,"LIBRARY",null,types);
			while(rs.next()){
			System.out.println(rs.getString(3));}
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