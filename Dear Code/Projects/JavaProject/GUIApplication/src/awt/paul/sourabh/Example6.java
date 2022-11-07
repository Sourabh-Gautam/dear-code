package awt.paul.sourabh;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame3 extends Frame implements ActionListener {
    Button b1, b2, b3 ,b4;
    public MyFrame3(String title){
        setTitle(title);
        setSize(500, 400);
        setLocation(100, 200);
        FlowLayout fl=new FlowLayout();
        setLayout(fl);
        b1=new Button("Red");
        b2=new Button("Green");
        b3=new Button("Blue");
        b4=new Button("Quit");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
            setBackground(Color.RED);
        else if(e.getSource()==b2)
            setBackground(Color.GREEN);
        else if(e.getSource()==b3)
            setBackground(Color.BLUE);
        else
            System.exit(0);
    }
}
public class Example6 {
    public static void main(String[] args) {
        MyFrame3 mf3=new MyFrame3("Background Colour Change");
    }
}
