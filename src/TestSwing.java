import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSwing extends JFrame {
    GameMap map=GameMap.getInstance();
    public Container cp;


    public  TestSwing(int a){
        super("KENKEN-MAP");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(map.mapSide,map.mapSide));
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        new  MainMenu();
        map.setFrame(this);
        map.init();
        pack();
        setSize(new Dimension(310, 340));
        setVisible(true);
        //Risolutore Res = new Risolutore(GameMap.getInstance().blocks.get(3));
    }


    public static void main(String[] args) {
        new TestSwing(1);
    }

}