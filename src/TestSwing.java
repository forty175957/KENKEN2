import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class TestSwing extends JFrame {
    GameMap map=GameMap.getInstance();

    public TestSwing (){
        super("HelloWorld!");
        add(new JLabel("Hello World!"));
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        map.setFrame(this);
        Cell c1=new Cell(0,0);
        Cell c2=new Cell(10,0);
        Cell c3 = new Cell(0,10);
        pack();
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new TestSwing();
    }

    class myCell extends JComponent{
        private int x,y,width,height,thickness;

        public myCell(int x, int y,int width,int height,int thickness){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.thickness = thickness;
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(thickness));
            g2.drawRect(x,y,width,height);
        }
    }
}