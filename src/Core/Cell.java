package Core;

import UI.CellButton;

import javax.swing.*;

public class Cell {
    public int x, y;
    public int n;
    public Block block;
    public JButton bt;
    private boolean completed=false;
    private Mediator med= Mediator.getInstance();

    public Cell(int x, int y, Block block) {
        this.x = x;
        this.y = y;
        this.block = block;
        this.bt = new CellButton(this);
    }

    public void reset(){
        updateValue(0);
    }

    public boolean checkCellUpdate(int val){
        boolean flag=true;
        if(val>med.getMap().mapSide) return false;
        for (Cell c:block.cells) {
            if(c.x==this.x && c.n==val) flag=false;
            else if(c.y==this.y && c.n==val) flag=false;
        }
        return flag && med.getMap().checkMatrix(this.x,this.y,val);
    }

    public void updateValue(int val){
        n=val;
        Mediator.getInstance().getMap().updateMatrix(x,y,val);
        block.completedBlock(block.checkBlock());
        updateButton();
    }

    public void isCompleted(boolean state){
        this.completed=state;
    }

    public void updateButton(){
        this.bt.revalidate();
        this.bt.repaint();
    }
}