/*
Desing a frame containing a button titled Click Me. As soon as the user click on the button the counter increment in the title bar by 1
i.e the title bar should display how many times the button has been clicked.
 */
package awt.paul.sourabh;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyAssignment1Frame extends Frame implements ActionListener{
    Button b;
    Integer count=0;
    public MyAssignment1Frame(String title){
        setTitle(title);
        setSize(500, 400);
        setLocation(100, 200);
        FlowLayout fl=new FlowLayout();
        setLayout(fl);
        setVisible(true);
        b=new Button("Click Me");
        add(b);
        b.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        count=count+1;
        setTitle(count.toString());
    }
    
}

public class Assignment1 {
    public static void main(String[] args) {
        MyAssignment1Frame maf=new MyAssignment1Frame("0");
    }
}
