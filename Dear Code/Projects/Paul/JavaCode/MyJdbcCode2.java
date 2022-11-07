//Program to communicate with predefined database user "scott".
import java.sql.*;
class MyJdbcCode1{
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
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//SourabhPaul:1521/orcl","scott","tiger");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("Select ename,sal from emp");
			while(rs.next()){
			String name=rs.getString(1);
			int amt=rs.getInt(2);
			System.out.println(name+"/t"+amt);
			}}
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