import javax.swing.*;
import java.awt.*;

public class MyLine extends JComponent {
    private int x1,y1,x2,y2,thickness;

    public MyLine(int x1, int y1,int x2,int y2,int thickness){
        this.x1 = x1;
        this.y1= y1;
        this.y2 = y2;
        this.x2 = y2;
        this.thickness = thickness;
    }

    public MyLine(Point p1, Point p2,int thickness){
        x1=p1.x;
        y1=p1.y;
        x2=p2.x;
        y2=p2.y;
        this.thickness = thickness;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(thickness));
        g2.drawLine(x1,y1,x2,y2);
    }
}
