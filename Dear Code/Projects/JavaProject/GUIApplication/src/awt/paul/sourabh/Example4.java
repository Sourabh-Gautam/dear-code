package awt.paul.sourabh;

import java.awt.Color;
import java.awt.Frame;

class MyFrame extends Frame{
    public MyFrame(String title) {
        setTitle(title);
        setSize(500, 500);
        setLocation(200, 200);
        setVisible(true);
        setBackground(Color.CYAN);
    }
}
public class Example4 {
    public static void main(String[] args) {
        MyFrame mf=new MyFrame("Sourabh");
    }
}
