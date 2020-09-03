import javax.swing.*;
import java.awt.*;

public class KenKenMap extends JFrame {
    public Container cp;


    public static KenKenMap getInstance(){
        return new KenKenMap(5,5);
    }
    public KenKenMap(int x,int y){
        super("KENKEN-MAP");
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(x,y));
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GameMap.getInstance().setFrame(this);
        pack();
        setSize(new Dimension(62*x, 68*y));
        setVisible(true);
    }






}