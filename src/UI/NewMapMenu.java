package UI;

import Core.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMapMenu extends JFrame {
    private Mediator med = Mediator.getInstance();

    public NewMapMenu(){
        super("NEW MAP");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,4));
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(720, 70));
        setVisible(true);
        JButton map3=new JButton("3X3");
        JButton map4=new JButton("4X4");
        JButton map5=new JButton("5X5");
        JButton map6=new JButton("6X6");
        map3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                med.loadNewMap(3);
            }
        });
        map4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                med.loadNewMap(4);
            }
        });
        map5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                med.loadNewMap(5);
            }
        });
        map6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                med.loadNewMap(6);
            }
        });
        cp.add(map3);
        cp.add(map4);
        cp.add(map5);
        cp.add(map6);
    }


}
