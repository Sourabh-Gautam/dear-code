class A {
    private void show() {
        System.out.println("Inside A");
    }
}

class B extends A {
    public void show() {
        System.out.println("Inside B");
    }
}

public class Example6 {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();
    }
}
