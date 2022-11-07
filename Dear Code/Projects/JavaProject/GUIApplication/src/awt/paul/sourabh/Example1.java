package awt.paul.sourabh;

import java.awt.Color;
import java.awt.Frame;

public class Example1 {
    public static void main(String []args){
        Frame f=new Frame();
        f.setTitle("Sourabh");
        f.setSize(500, 400);
        f.setLocation(100, 100);
        f.setVisible(true);
        Color c=new Color(255, 255, 0);
        f.setBackground(c);
    }
}
