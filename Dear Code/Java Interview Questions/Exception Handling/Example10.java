class Driver10 {
    public String get() {
        String a = "10";
        try {
            a = a+"5";
            return a;
        }
        catch(Exception ex) {
            System.out.println("Exception Found");
            return a;
        }
        finally{
            System.out.println("Finally Run");
            a = a+"10";
        }
    }
}

class Example10 {
    public static void main(String[] args) {
        Driver10 obj = new Driver10();
        System.out.println(obj.get());
    }
}