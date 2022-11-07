//Program to retrieve date of employee in scott user. if the day is sunday or saturday then a * will print in front of name of employee.
import java.sql.*;
import java.text.*;
class MyDateCode{
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
			ResultSet rs=st.executeQuery("Select ename,hiredate from emp");
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat sdfa=new SimpleDateFormat("E");
			while(rs.next()){
			String name=rs.getString("ename");
			Date d1=rs.getDate("hiredate");
			String d2=sdf.format(d1);
			System.out.print(name+"\t"+d1+"\t"+d2);
			String dname=sdfa.format(d1);
			if(dname.equalsIgnoreCase("Sat")||dname.equalsIgnoreCase("Sun"))
				System.out.println("*");
			else
				System.out.println();
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