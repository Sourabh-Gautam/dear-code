import java.util.Scanner;

class Demo{
  public static void main(String []args) {
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter first number : ");
    String a = kb.next();
    System.out.println("Enter second number : ");
    String b = kb.next();
    int num1 = Integer.parseInt(a);
    int num2 = Integer.parseInt(b);
    String oa = Integer.toOctalString(num1);
    String ob = Integer.toOctalString(num2);
    int new1 = Integer.parseInt(oa);
    int new2 = Integer.parseInt(ob);
    System.out.println(new1 + new2);
  }
}