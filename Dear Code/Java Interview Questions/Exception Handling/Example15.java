
// Is it mandatory to catch checked exceptions?
import java.io.*;
class Driver15 {
    public int get() throws IOException {
        int a = 10;
        try {
            FileWriter file = new FileWriter("E://dummy/text.txt");
            file.write("sourabh");;
            return 1;
        }
        catch(IOException ex) {
            throw ex;
        }
    }
}

class Example15 {
    public static void main(String[] args) {
        Driver15 obj = new Driver15();
        try {
            System.out.println(obj.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}