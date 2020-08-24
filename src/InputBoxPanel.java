import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputBoxPanel extends JFrame {
    public InputBoxPanel(Cell c){
        super("Edit Cell");
        setLocation(500,500);
        getContentPane().setLayout(new FlowLayout());
        JTextField textfield1 = new JTextField("",10);
        JLabel label=new JLabel("INSERT VALUE");
        JButton b= new JButton("SET");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int val=new Integer(textfield1.getText());
                if(!c.block.checkCells(c.x,c.y,val)){
                    label.setText("INVALID VALUE");
                }else{
                    dispose();
                    c.block.updateValueCell(c.x,c.y,val);
                    GameMap.getInstance().getFrame().getContentPane().revalidate();
                    GameMap.getInstance().getFrame().repaint();
                }
            }
        });
        JButton b2= new JButton("RESOLVE");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new Risolutore(c.block);
            }
        });
        getContentPane().add(label);
        getContentPane().add(textfield1);
        getContentPane().add(b);
        getContentPane().add(b2);
        pack();
        setVisible(true);

    }

}
