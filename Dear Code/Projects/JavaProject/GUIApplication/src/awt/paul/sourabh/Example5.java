package awt.paul.sourabh;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

class MyFrame2 extends Frame{
    Button b1, b2;
    public MyFrame2(String title) {
        super(title);
        setSize(500, 500);
        setLocation(200, 200);
        setBackground(Color.CYAN);
        b1=new Button("Quit");
        b2=new Button("Enter");
        FlowLayout fl=new FlowLayout();
        setLayout(fl);
        add(b1);
        add(b2);
        setVisible(true);
    }
}
public class Example5 {
    public static void main(String[] args) {
        MyFrame2 mf2=new MyFrame2("Sourabh Button Frame");
    }
}
