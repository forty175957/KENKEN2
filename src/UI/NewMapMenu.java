package UI;

import Core.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;


public class NewMapMenu extends JFrame {
    private Mediator med = Mediator.getInstance();


    public NewMapMenu(){
        super("NUOVA MAPPA");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(1,4));
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(720, 250));
        setVisible(true);
        Icon icon1 = new ImageIcon("/home/lucky/Scaricati/kenken3x3.png");
        Icon icon2 = new ImageIcon("/home/lucky/Scaricati/kenken4x4.png");
        Icon icon3 = new ImageIcon("/home/lucky/Scaricati/kenken5x5.png");
        Icon icon4 = new ImageIcon("/home/lucky/Scaricati/kenken6x6.png");
        JButton map3=new JButton(icon1);
        JButton map4=new JButton(icon2);
        JButton map5=new JButton(icon3);
        JButton map6=new JButton(icon4);

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
