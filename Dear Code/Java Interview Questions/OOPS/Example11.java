import java.io.FileNotFoundException;
import java.io.IOException;

class A {
    void show() throws IOException {
        System.out.println("Inside A");
    }
}

class B extends A {
    void show() throws FileNotFoundException{
        System.out.println("Inside B");
    }
}

public class Example11 {
    public static void main(String[] args) {
        
    }
}
