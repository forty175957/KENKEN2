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
        if(block.cells.isEmpty()) {
            this.description = block.operation + " " + new Integer(block.resultValue).toString() ;
        }
        this.block = block;
        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                editCellValue();
            }
        });
    }

    public Cell(Cell c) {
        this.x = c.x;
        this.y = c.y;
        this.description=c.description;
        this.block = c.block;
        Border emptyBorder = BorderFactory.createEmptyBorder();
        setBorder(emptyBorder);
        setOpaque(false);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editCellValue();
            }
        });
    }

    public void reset(){
        updateValueCell(0);
    }

    public void updateDescription(String description){
        this.description=description;
        revalidate();
        repaint();
    }

    public boolean checkCellUpdate(int val){
        boolean flag=true;
        if(val>GameMap.getInstance().mapSide+1) return false;
        for (Cell c:block.cells) {
            if(c.x==this.x && c.n==val) flag=false;
            else if(c.y==this.y && c.n==val) flag=false;
        }
        return flag && GameMap.getInstance().checkMatrix(this.x,this.y,val);
    }

    public void updateValueCell(int val){
        this.n=val;
        GameMap.getInstance().updateMatrix(x,y,val);
        block.completedBlock(block.checkBlock());
        repaint();
    }

    public void update(){
        n=GameMap.getInstance().valueMatrix[x][y];
    }
    @Override
    protected void paintComponent(Graphics g) {
        this.g=g;
        Rectangle bounds=getBounds();
        Graphics2D g2 = (Graphics2D) g;
        if(block.checkBlock()){
            g.setColor(Color.cyan);
            g.fillRect(0, 0,getWidth(),getHeight());
        }else{
            g.setColor(Color.white);
            g.fillRect(0, 0,getWidth(),getHeight());
        }
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawString(this.description, 5, 10);
        if(n!=0) {
            g2.drawString(new Integer(this.n).toString(),30,30);
        }

        drawBorder(g2);
    }

    public void editCellValue(){
        new InputBoxPanel(this);
    }

    private void drawBorder(Graphics2D g2) {
        if (x == 0) {//TOP
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(0, 0, 60, 0);
        }
        //BOTTOM
        if (map.checkBottom(x, y) && y != map.mapSide) {
            g2.setStroke(new BasicStroke(1));
        } else {
            g2.setStroke(new BasicStroke(4));
        }
        g2.drawLine(60, 0, 60, 60);
        //RIGHT
        if (map.checkRight(x, y) && x != map.mapSide && y != map.mapSide) {
            g2.setStroke(new BasicStroke(1));
        } else {
            g2.setStroke(new BasicStroke(4));
        }
        g2.drawLine(60, 60, 0, 60);
        //LEFT
        if (y == 0) {
            g2.setStroke(new BasicStroke(4));
            g2.drawLine(0, 60, 0, 0);
        }
    }

}
