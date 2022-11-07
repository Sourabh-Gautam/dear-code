//Program to insert image in database.
import java.sql.*;
import java.io.*;
class TwelthProgram{
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
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//SourabhPaul:1521/xe","rohit","admin");
			PreparedStatement pst=conn.prepareStatement("select * from photos");
			ResultSet rs = pst.executeQuery();
			rs.next();
			Blob b = rs.getBlob(2);
			byte[] arr=b.getBytes(1, (int)b.length());
			String name = rs.getString(1);
			File f = new File("E:/AdvanceJavaPractice");
			FileOutputStream fos=new FileOutputStream(f.getAbsolutePath()+"/"+name);
			fos.write(arr);

			int num=pst.executeUpdate();
			System.out.println("Image retreived");
			}
	catch(Exception sq){
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