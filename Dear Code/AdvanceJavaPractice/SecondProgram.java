import java.sql.*;
class SecondProgram{
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
			c=DriverManager.getConnection("jdbc:oracle:thin:@//SourabhPaul:1521/xe", "rohit", "admin");
			System.out.println("Connection Established!");
			Statement s=c.createStatement();
			java.util.Scanner kb=new java.util.Scanner(System.in);
			System.out.print("Enter bookid: ");
			int bookid = kb.nextInt();
			System.out.print("Enter bookname: ");
			String bookname =kb.next();
			System.out.print("Enter book price: ");
			double price = kb.nextDouble();
			int n=s.executeUpdate("insert into books(bookid,bookname,price) values("+bookid+",\'"+bookname+"\',"+price+")");
			if(n>0)
				System.out.println(n+" Record inserted");
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