package UI;

import Core.Mediator;

import javax.swing.*;
import java.awt.*;

public class KenKenMap extends JFrame {
    public Mediator med = Mediator.getInstance();

    public KenKenMap(int side){
        super("KENKEN-MAP");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(side,side));
        this.setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        med.setFrame(this);
        pack();
        setSize(new Dimension(62*side, 68*side));
        setVisible(true);
    }

}