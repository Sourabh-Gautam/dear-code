class Fruit {
    public void tell(){
        whoami();
    }

    public void whoami(){
        System.out.println("I am fruit");
    }
}

class Mango extends Fruit {
    public void whoami(int a){
        System.out.println("I am Mango");
    }
}

public class Example1 {
    public static void main(String[] args) {
        Mango m = new Mango();
        m.tell();
    }
}
