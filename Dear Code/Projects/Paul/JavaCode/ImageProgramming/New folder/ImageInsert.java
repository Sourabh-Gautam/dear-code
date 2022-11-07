//Program to insert image in database.
import java.sql.*;
import java.io.*;
import java.util.Scanner;
class ImageInsert{
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
			Scanner kb=new Scanner(System.in);
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//sourabh-pc:1521/xe","rohit","admin");
			PreparedStatement pst=conn.prepareStatement("insert into items values(?,?,?,?)");
			while(true){
			System.out.print("Enter image name:");
			File f=new File("E:/GoGuysImages/"+kb.next());
			FileInputStream fis=new FileInputStream(f);
			pst.setBinaryStream(3,fis,(int)f.length());

			String fname=f.getName();
			pst.setString(1,fname);

			System.out.print("Enter price of item: ");
			pst.setDouble(2, kb.nextDouble());

			pst.setString(4, "grocery");

			int num=pst.executeUpdate();
			System.out.println("Image inserted");
			System.out.println("do you want to insert more images? Y/N");
			if(kb.next().equalsIgnoreCase("n"))
				System.exit(0);
			}
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