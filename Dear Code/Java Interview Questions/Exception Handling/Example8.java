class Driver8 {
    public String get() {
        String a = "10";
        try {
            a = a+"5";
        }
        catch(Exception ex) {
            System.out.println("Exception Found");
            return a;
        }
        finally{
            System.out.println("Finally Run");
            return a+"10";
        }
    }
}

class Example8 {
    public static void main(String[] args) {
        Driver8 obj = new Driver8();
        System.out.println(obj.get());
    }
}