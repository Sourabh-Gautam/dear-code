// Can overlaoding be done within the same class ?

class A {
    void show(int a){
        System.out.println("Inside A");
    }
}

class B extends A {
    void show(String s){
        System.out.println("Inside B");
    }
}

public class Example18 {
    public static void main(String[] args) {
        
    }
}

// Answer : No
