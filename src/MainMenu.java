import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public  MainMenu(){
        super("MENU");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,4));
        this.setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(600, 300));
        setVisible(true);
        JButton newBt=new JButton("NEW");
        JButton loadBt=new JButton("LOAD");
        JButton saveBt=new JButton("SAVE");
        JButton exitBt=new JButton("EXIT");
        newBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loadBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapUtil.load();
            }
        });
        saveBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapUtil.save();
            }
        });
        exitBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cp.add(newBt);
        cp.add(loadBt);
        cp.add(saveBt);
        cp.add(exitBt);
    }
}
