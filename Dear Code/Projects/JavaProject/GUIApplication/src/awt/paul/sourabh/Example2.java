package awt.paul.sourabh;


import java.awt.Color;
import java.awt.Frame;
import java.util.Date;

/*
To print date as a title of a frame 

 */
public class Example2 {
    public static void main(String []args){
        Date d=new Date();
        Frame f=new Frame();
        Color c=new Color(255, 0, 255);
        f.setSize(400, 500);
        f.setLocation(100, 100);
        f.setTitle(d.toString());
        f.setBackground(c);
        f.setVisible(true);
    }
}
