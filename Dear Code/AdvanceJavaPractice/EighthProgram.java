import java.util.*;
import java.sql.*;
class EighthProgram{
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
			Statement st=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select bookid, bookname, price from books order by price");
			ArrayList<String> booklist=new ArrayList<String>();
			while(rs.next()){
				double amt=rs.getDouble("price");
				if(amt<5000.0){
					amt=amt+amt*.1;
					rs.updateDouble("Price",amt);
					rs.updateRow();
					booklist.add(rs.getString("bookname"));
				}
			}
			System.out.println(booklist.size()+" following rows updated");
			for(int i=0; i<booklist.size(); i++){
				System.out.println(booklist.get(i));
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