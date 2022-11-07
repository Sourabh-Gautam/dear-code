class Fruit {
    Fruit(){
        System.out.println("Fruit Constructor");
    }
}

class Mango extends Fruit {
    Mango(){
        System.out.println("Mango Constructor");
    }
}

public class Example2 {
    public static void main(String[] args) {
        new Mango();
    }
}
