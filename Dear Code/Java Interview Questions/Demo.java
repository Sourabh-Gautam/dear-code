import java.util.*;

class MyName implements Comparable{
    String name;
    public MyName(String name){
        this.name = name;
    }

    public int compareTo(Object name){
        
        return 0;
    }

    public String toString(){
        return name;
    }
}


public class Demo {
    public static void main(String[] args) {

        MyName a = new MyName("sumit");
        MyName b = new MyName("amit");
        MyName c = new MyName("punit");

        // String a = "sumit";
        // String b = "amit";
        // String c = "punit";

        ArrayList li = new ArrayList();
        li.add(a);
        li.add(b);
        li.add(c);
        System.out.println("Before sort : "+li);
        Collections.sort(li);
        System.out.println("After sort : "+li);
    }
}
