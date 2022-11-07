import java.sql.*;
class FirstProgram{
	public static void main(String []args){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver successfully loaded");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("Driver not loaded: "+cnfe.getMessage());
		}
		
		Connection c=null;
		try{
			c=DriverManager.getConnection("jdbc:oracle:thin:@//sourabh-pc:1521/xe", "myhibernatebatch", "admin");
			System.out.println("Connection Established!");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select emp_name from emp");
			while(rs.next()){
				String empname=rs.getString(1);
				System.out.println(empname);
			}
		}
		catch(SQLException sqle){
			System.out.println("Some error occured: "+sqle.getMessage());
		}
		finally{
			if(c!=null){
				try{
					c.close();
				}
				catch(Exception ex){
					System.out.println("Could not close connection: "+ex.getMessage());
				}
			}
		}
	}
}