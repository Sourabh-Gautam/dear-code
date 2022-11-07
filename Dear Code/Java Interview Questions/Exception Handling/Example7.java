class Driver7 {
    public int get() {
        int a = 10;
        try {
            a = a/0;
        }
        catch(Exception ex) {
            System.out.println("Exception Found");
            return a;
        }
        finally{
            System.out.println("Finally Run");
            return a+5;
        }
    }
}

class Example7 {
    public static void main(String[] args) {
        Driver7 obj = new Driver7();
        System.out.println(obj.get());
    }
}