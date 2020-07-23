import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputBoxPanel extends JFrame {
    public InputBoxPanel(Cell c){
        super("Edit Cell");
        getContentPane().setLayout(new FlowLayout());
        JTextField textfield1 = new JTextField("",10);
        JLabel label=new JLabel("INSERT VALUE");
        JButton b= new JButton("SET");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int val=new Integer(textfield1.getText());
                if(!c.checkValueUpdate(val)){
                    label.setText("INVALID VALUE");
                }else{
                    dispose();
                }
            }
        });
        getContentPane().add(label);
        getContentPane().add(textfield1);
        getContentPane().add(b);
        pack();
        setVisible(true);

    }

}
