import com.sun.rowset.CachedRowSetImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            String driver = "oracle.jdbc.OracleDriver";
                try {
                    Class.forName(driver);
                   } catch (ClassNotFoundException ex) {
			System.out.println("Class not found: "+ex.getMessage());
			}
            CachedRowSet crs = new CachedRowSetImpl();
            crs.setUrl("jdbc:oracle:thin:@//SourabhPaul:1521/xe");
            crs.setUsername("rohit");
            crs.setPassword("admin");
            File f = new File("E:/Simant.jpg");
            crs.setCommand("insert into photos values (?,?)");
            FileInputStream fin = new FileInputStream(f);
	    crs.updateString(1, f.getName());
            crs.setBinaryStream(2, fin, (int) f.length());
            crs.execute();
        } catch (SQLException ex) {
		System.out.println("Some error occurred: "+ex.getMessage());           
        }

    }
}