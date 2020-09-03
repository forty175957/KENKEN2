import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputBoxPanel extends JFrame{

    public InputBoxPanel(Cell c){
        super("Edit Cell");
        setLocation(500,500);
        getContentPane().setLayout(new FlowLayout());
        JTextField textfield1 = new JTextField("",10);
        JLabel label=new JLabel("INSERT VALUE");
        JButton setBt= new JButton("SET");
        JButton resolveBt= new JButton("RESOLVE");
        addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }

            @Override
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

            @Override
            public void keyTyped(KeyEvent keyEvent) {
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
        });
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
            resolveBt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    new Risolutore(c.block);
                }
            });
        getContentPane().add(label);
        getContentPane().add(textfield1);
        getContentPane().add(setBt);
        getContentPane().add(resolveBt);
        pack();
        setVisible(true);

    }

}
