// Use case of Abstraction using interface

interface MyBank{
    void transfer();
    void showBalance();
    void withdraw();
}

class MyBankImpl implements MyBank{
    public void transfer(){
        System.out.println("Transferred");
    }

    public void showBalance(){
        System.out.println("1000");
    }

    public void withdraw(){
        System.out.println("Withdraw done");
    }

}

class BankManager {
    public static MyBank getMyBank(){
        return new MyBankImpl();
    }
}

public class Example4 {
    public static void main(String[] args) {
        MyBank b = BankManager.getMyBank();
        b.transfer();
        b.withdraw();
        b.showBalance();
    }
}