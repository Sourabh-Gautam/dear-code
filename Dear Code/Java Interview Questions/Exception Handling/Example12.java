
// Will finally run in this code ? Even when we are throwing exception on our own.

class Driver12 {
    public int get() {
        int a = 10;
        try {
            a = a/0;
            return a;
        }
        catch(ArithmeticException ex) {
            throw ex;
        }
        finally{
            System.out.println("Finally Run");
            a = a+10;
        }
    }
}

class Example12 {
    public static void main(String[] args) {
        Driver12 obj = new Driver12();
        System.out.println(obj.get());
    }
}