import java.util.Scanner;

// Try with resources
class Example16{
    public static void main(String[] args) {
        try(Scanner kb = new Scanner(System.in)){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = a/b;
            System.out.println(c);
        }catch(ArithmeticException ae){
            System.out.println("Cannot divide by zero : "+ae.getMessage());
        }
    }
}