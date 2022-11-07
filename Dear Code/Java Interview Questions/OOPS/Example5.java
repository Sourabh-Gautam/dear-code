//Can we have concrete method in an interface

interface Animal{

    default void eat(){
            System.out.println("Animal Start eating ....");
    }
}

interface Pet{

    default void eat(){
            System.out.println("Pet Start eating ....");
    }
}
class Zoo implements Pet , Animal{ 
         //Now eat method is a part of this class
    public void eat(){
            System.out.println("Pet Start eating ....");
    }
}

public class Example5{
    public static void main(String[] args){

             Zoo zoo = new Zoo();
             zoo.eat();    //What would be the output
    }
}