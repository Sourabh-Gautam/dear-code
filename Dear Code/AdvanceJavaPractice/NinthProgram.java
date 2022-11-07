import java.util.*;
import java.sql.*;
class NinthProgram{
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
			c.setAutoCommit(false);
			Scanner kb = new Scanner(System.in);
			PreparedStatement st=c.prepareStatement("Insert into books values(?,?,?)");
			String choice;
			do{
				System.out.print("Enter the book id: ");
				int id = kb.nextInt();
				System.out.print("Enter the book name: ");
				String name = kb.next();
				System.out.print("Enter the price: ");
				double price = kb.nextDouble();
				st.setInt(1,id);
				st.setString(2,name);
				st.setDouble(3,price);
				st.addBatch();
				System.out.println("Anymore rows you want to add : Yes / No");
				choice =kb.next();
			}while(choice.equalsIgnoreCase("yes"));
			int []ans =st.executeBatch();
			c.commit();
			System.out.println("All records inserted");
		}
		catch(BatchUpdateException bue){
			System.out.println("Batch Exception found"+bue.getMessage());
			int []arr =bue.getUpdateCounts();
			System.out.println(arr.length+1+" Query generated exception");
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