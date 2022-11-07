class Driver5 {
    public int get() {
        int a = 10;
        try {
            a = a/0;
            return a;
        }
        catch(Exception ex) {
            System.out.println("Exception Found");
            System.exit(0);
            return -1;
        }
        finally{
            System.out.println("Finally Run");
        }
    }
}

class Example5 {
    public static void main(String[] args) {
        Driver5 obj = new Driver5();
        System.out.println(obj.get());
    }
}