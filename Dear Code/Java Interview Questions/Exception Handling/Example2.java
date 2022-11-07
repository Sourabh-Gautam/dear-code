class Driver2 {
    public int get() {
        int a = 10;
        try {
            a = a/2;
            return a;
        }
        catch(Exception ex) {
            System.out.println("Exception Found");
        }
        finally{
            System.out.println("Finally Run");
        }
        return a;
    }
}

class Example2 {
    public static void main(String[] args) {
        Driver2 obj = new Driver2();
        System.out.println(obj.get());
    }
}