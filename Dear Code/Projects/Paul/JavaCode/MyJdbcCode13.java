//Using important methods of ResultSet{relative(int),absolute(int)}
import java.sql.*;
class MyJdbcCode12{
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
			Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select * from books");
			rs.next();
			rs.relative(5);
			String str=rs.getString(2);
			System.out.println(str);
		}
			
	catch(SQLException ex){
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