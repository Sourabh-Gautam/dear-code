class Driver4 {
    public int get() {
        int a = 10;
        try {
            a = a/0;
            return a;
        }
        catch(Exception ex) {
            System.out.println("Exception Found");
            return -1;
        }
        finally{
            System.out.println("Finally Run");
        }
    }
}

class Example4 {
    public static void main(String[] args) {
        Driver4 obj = new Driver4();
        System.out.println(obj.get());
    }
}