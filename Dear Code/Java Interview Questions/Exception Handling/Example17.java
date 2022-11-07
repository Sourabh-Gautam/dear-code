import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Try with resources
class Example17{
    public static void main(String[] args) {
        try{
            int[] arr = {1,2,3};
            System.out.println(arr[5]);
            FileReader fr = new FileReader("E://text.html");
            System.out.println(fr.read());
            fr.close();
            
        }catch(ArrayIndexOutOfBoundsException | IOException ex){
            System.out.println("Error occured : "+ex.getMessage());
        }
    }
}