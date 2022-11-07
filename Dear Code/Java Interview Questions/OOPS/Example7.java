class A {
    void show() throws Exception {
        System.out.println("Inside A");
    }
}

class B extends A {
    void show() {
        System.out.println("Inside B");
    }
}

public class Example7 {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();
    }
}
