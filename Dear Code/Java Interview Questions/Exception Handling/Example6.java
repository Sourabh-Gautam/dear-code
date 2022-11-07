class Driver6 {
    public int get() {
        int a = 10;
        try {
            a += 5;
            return a;
        }
        catch(Exception ex) {
            System.out.println("Exception Found");
        }
        finally{
            System.out.println("Finally Run");
            return 0;
        }
    }
}

class Example6 {
    public static void main(String[] args) {
        Driver6 obj = new Driver6();
        System.out.println(obj.get());
    }
}