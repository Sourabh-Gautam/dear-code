//Program to Fetch the all table names and column name of given user.
import java.sql.*;
class MyJdbcCode9{
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
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-D8VIJP3:1521/orcl","library","paul");
			DatabaseMetaData dbmd=conn.getMetaData();
			String[] types=new String[]{"VIEW","TABLE"};
			ResultSet rs=dbmd.getTables(null,"LIBRARY",null,types);
			while(rs.next()){
			String str=rs.getString(3);
			System.out.print(str+"(");
			Statement st=conn.createStatement();
			ResultSet rs1=st.executeQuery("select * from "+str);
			ResultSetMetaData rsmd=rs1.getMetaData();
			int count=rsmd.getColumnCount();
			for(int i=1;i<=count;i++)
			System.out.print(rsmd.getColumnName(i)+",");
			System.out.print("\b)");
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