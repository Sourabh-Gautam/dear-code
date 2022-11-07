class Driver9 {
    public String get() {
        String a = "10";
        try {
            a = a+"5";
        }
        // catch(Exception ex) {
        //     System.out.println("Exception Found");
        //     return a;
        // }
        finally{
            System.out.println("Finally Run");
            return a+"10";
        }
    }
}

class Example9 {
    public static void main(String[] args) {
        Driver9 obj = new Driver9();
        System.out.println(obj.get());
    }
}