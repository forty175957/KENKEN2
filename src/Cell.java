import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton {
    int x, y;
    private GameMap map = GameMap.getInstance();
    public int n;
    String description="";
    Graphics g;
    Container cp;
    Block block;
    public boolean completed;

    public Cell(int x, int y, Block block) {
        this.x = x;
        this.y = y;
        //this.n = block.getId();
        this.description="("+block.getId()+")";
        this.block = block;
        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cell " + new Integer(n).toString() + " pressed");
                editCellValue();
            }
        });
    }

    public Cell(int x, int y, Block block,String description) {
        this.x = x;
        this.y = y;
        this.description=description+"("+block.getId()+")";
        this.block = block;
        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
        setOpaque(false);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cell " + new Integer(n).toString() + " pressed");
                editCellValue();
            }
        });
    }

    public void reset(){
        n=0;
    }

    public void updateDescription(String description){
        this.description=description;
    }

    public boolean checkCellUpdate(int val){
        boolean flag=true;
        if(val>GameMap.getInstance().mapSide) return false;
        for (Cell c:block.cells) {
            if(c.x==x && c.n==val) flag=false;
            else if(c.y==y && c.n==val) flag=false;
        }
        return flag && GameMap.getInstance().checkMatrix(this.x,this.y,val);
    }

    public void updateValueCell(int val){
        n=val;
        GameMap.getInstance().updateMatrix(x,y,val);
        block.completedBlock(block.checkBlock());
    }


    @Override
    protected void paintComponent(Graphics g) {
        this.g=g;
        Rectangle bounds=getBounds();
        Graphics2D g2 = (Graphics2D) g;
        if(completed){
            g.setColor(Color.cyan);
            g.fillRect(0, 0,getWidth(),getHeight());
        }
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawString(this.description, 5, 10);
        g2.drawString(new Integer(this.n).toString(),30,30);
        drawBorder(g2);
    }

    public void editCellValue(){
        new InputBoxPanel(this);
    }

    private void drawBorder(Graphics2D g2) {
        if (y == 0) {//TOP
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(0, 0, 60, 0);
        }
        //BOTTOM
        if (map.checkBottom(x, y) && y != map.mapSide) {
            g2.setStroke(new BasicStroke(2));
        } else {
            g2.setStroke(new BasicStroke(4));
        }
        g2.drawLine(60, 0, 60, 60);
        //RIGHT
        if (map.checkRight(x, y) && x != map.mapSide && y != map.mapSide) {
            g2.setStroke(new BasicStroke(2));
        } else {
            g2.setStroke(new BasicStroke(4));
        }
        g2.drawLine(60, 60, 0, 60);
        //LEFT
        if (x == 0) {
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(0, 60, 0, 0);
        }
    }

}
