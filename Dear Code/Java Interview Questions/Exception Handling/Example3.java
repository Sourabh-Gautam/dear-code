class Driver3 {
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
        System.out.println("Bye");
        return a;
    }
}

class Example3 {
    public static void main(String[] args) {
        Driver3 obj = new Driver3();
        System.out.println(obj.get());
    }
}