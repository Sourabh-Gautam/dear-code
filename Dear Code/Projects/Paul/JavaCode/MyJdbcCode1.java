//To learn concept of Batch. If any query generate exception how to find which query generated exception.Use rollback also.
import java.sql.*;
class BatchTest{
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
			Statement st=conn.createStatement();
			conn.setAutoCommit(false);
			st.addBatch("insert into books values(112,'Control Analysis',1900)");
			st.addBatch("insert into book values(113,'Power Analysis',2000)");
			System.out.println("Books successfully added into the batch");
			int[] ans=st.executeBatch();
			for(int i=0;i<ans.length;i++){
				System.out.println("The Query "+(i+1)+" effected "+ans[i]+" rows");
				}
		}
	catch(BatchUpdateException bue){
		try{
		System.out.println("BatchUpdateException Occured: "+bue.getMessage());
		int[] guc=bue.getUpdateCounts();
		System.out.println(guc[0]);
		System.out.println("Query number "+(guc.length+1)+" give Exception");
		conn.rollback();
		}
		catch(SQLException sq){
		System.out.println("Cannot rollback "+sq.getMessage());
		}
	}		
	catch(SQLException ex){
		System.out.println("SQLException Occured: "+ex.getMessage());
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