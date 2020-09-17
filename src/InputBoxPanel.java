import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputBoxPanel extends JFrame implements KeyListener{
    JLabel label;
    JButton setBt;
    JTextField textfield1;
    Cell c;

    public InputBoxPanel(Cell cell){
        super("Edit Cell");
        c=cell;
        setLocation(500,500);
        getContentPane().setLayout(new FlowLayout());
        textfield1 = new JTextField("",10);
        label=new JLabel("INSERT VALUE");
        setBt= new JButton("SET");
        textfield1.addKeyListener(this);


        setBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int val = new Integer(textfield1.getText());
                if (!c.checkCellUpdate(val)) {
                    label.setText("INVALID VALUE");
                } else {
                    dispose();
                    c.updateValueCell(val);
                    GameMap.getInstance().getFrame().getContentPane().revalidate();
                    GameMap.getInstance().getFrame().repaint();
                    }
                }
            });
        getContentPane().add(label);
        getContentPane().add(textfield1);
        getContentPane().add(setBt);
        pack();
        setVisible(true);

    }

    public void keyReleased(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            int val = new Integer(textfield1.getText());
            if (!c.checkCellUpdate(val)) {
                label.setText("INVALID VALUE");
            } else {
                dispose();
                c.updateValueCell(val);
                GameMap.getInstance().getFrame().getContentPane().revalidate();
                GameMap.getInstance().getFrame().repaint();
            }
        }
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

}
