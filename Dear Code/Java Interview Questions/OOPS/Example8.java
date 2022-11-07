// Can we overrid private methods?

class A {
    private void show() {
        System.out.println("Inside A");
    }
}

class B extends A {
    void show() {
        System.out.println("Inside B");
    }
}

public class Example8 {
    public static void main(String[] args) {
        
    }
}


// Answer :
// If we override private methods then compiler doesn't give any error. But compiler treat your's overriden method as a new method. It is because parent show() method is not visible in Child class as it is a private method so if a method isn't even visible how can it be override?
