/*
Design a frame containing a button titled Change Color. As soon as user click on the button the background of the
frame should change randomly.
 */
package awt.paul.sourabh;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class MyAssignment2Frame extends Frame implements ActionListener{
    Button b;
    Random r;
    public MyAssignment2Frame(String title){
        setTitle(title);
        setSize(500, 400);
        setLocation(100, 200);
        FlowLayout fl=new FlowLayout();
        setLayout(fl);
        setVisible(true);
        b=new Button("Change Color");
        add(b);
        b.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        r=new Random();
        Color c=new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        setBackground(c);
    }
}
    
public class Assignment2 {
        public static void main(String[] args) {
        MyAssignment2Frame maf=new MyAssignment2Frame("Random background colors");
    }
}
