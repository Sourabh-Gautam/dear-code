
// Is it mandatory to catch unchecked exceptions?

class Driver14 {
    public int get() {
        int a = 10;
        try {
            a = a/0;
            return a;
        }
        catch(ArithmeticException ex) {
            throw ex;
        }
    }
}

class Example14 {
    public static void main(String[] args) {
        Driver14 obj = new Driver14();
        System.out.println(obj.get());
    }
}