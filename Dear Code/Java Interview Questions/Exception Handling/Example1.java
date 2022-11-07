class Driver1 {
    public void get() {
        try {
            int a = 3/0;
            System.out.println(a);
        }
        catch(Exception ex) {
            System.out.println("Exception");
        }
        finally{
            System.out.println("Finally");
        }
    }
}

class Example1 {
    public static void main(String[] args) {
        Driver1 obj = new Driver1();
        obj.get();
    }
}