
// What happen if we are throwing an exception from catch block and as well as returning some value inside finally?

class Driver13 {
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
            return a;
        }
    }
}

class Example13 {
    public static void main(String[] args) {
        Driver13 obj = new Driver13();
        System.out.println(obj.get());
    }
}