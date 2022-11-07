//Using DatabaseMetaData
import java.sql.*;
class MyJdbcCode7{
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
			System.out.println("Driver Name: "+dbmd.getDriverName());
			System.out.println("Driver Name: "+dbmd.getDriverVersion());
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
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