import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton{
    private int x,y;
    private GameMap map=GameMap.getInstance();
    private String n;
    private Block block;

    public Cell( int x, int y, Block block){
        this.x = x;
        this.y = y;
        this.n = new Integer(block.getId()).toString();
        this.block = block;
        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cell "+n+" pressed");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        //paint(g);
        this.setBounds(this.x,this.y,60,60);
        this.setSize(new Dimension(60,60));
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString(this.n,30,30);
        g2.drawString("+",5,10);
        drawBorder(g2);
    }

    private void drawBorder(Graphics2D g2){
        if(map.checkTop(x,y)){                      //TOP
            g2.setStroke(new BasicStroke(2));
        }else{
            g2.setStroke(new BasicStroke(8));
        }
        g2.drawLine(0,0,60,0);
        if(map.checkBottom(x,y)){                   //BOTTOM
            g2.setStroke(new BasicStroke(2));
        }else{
            g2.setStroke(new BasicStroke(8));
        }
        g2.drawLine(60,0,60,60);
        if(map.checkRight(x,y)){                      //RIGHT
            g2.setStroke(new BasicStroke(2));
        }else{
            g2.setStroke(new BasicStroke(8));
        }
        g2.drawLine(60,60,0,60);
        if(map.checkLeft(x,y)){                      //LEFT
            g2.setStroke(new BasicStroke(2));
        }else{
            g2.setStroke(new BasicStroke(8));
        }
        g2.drawLine(0,60,0,0);
    }


    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }


}
