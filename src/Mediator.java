import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Mediator {
    private static Mediator ISTANCE;
    private JFrame frame;
    private GameMap map;

    private Mediator() {
        map=new GameMap();
    }

    public static Mediator getInstance() {
        if (ISTANCE == null) {
            ISTANCE = new Mediator();
        }
        return ISTANCE;
    }

    public void setFrame(JFrame f) {
        frame = f;
    }

    public JFrame getFrame() {
        return frame;
    }

    public GameMap getMap(){
        return this.map;
    }

}
