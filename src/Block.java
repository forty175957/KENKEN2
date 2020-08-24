import java.awt.*;
import java.util.ArrayList;

public class Block {
    public ArrayList<Cell> cells;
    public String operation;
    public int resultValue;
    private int blockId;
    private GameMap Gmap=GameMap.getInstance();

    public Block(int blockId,String op,int res) {
        this.blockId = blockId;
        this.operation=op;
        this.resultValue=res;
        this.cells=new ArrayList<Cell>();
        System.out.println("id:"+blockId+"op:"+op+"res:"+resultValue);
    }

    public int getId(){
        return blockId;
    }

    public void addCell(int x,int y) {
        Cell cell;
        if(cells.isEmpty()) {
            String desc=operation+" "+new Integer(resultValue).toString();
            cell = new Cell(x,y,this,desc);
        }else{
        cell = new Cell(x,y,this);
        }
        cells.add(cell);
        Gmap.getFrame().getContentPane().add(cell);
    }

    public boolean checkCellUpdate(int x,int y,int val){
        if(val>GameMap.getInstance().mapSide) return false;
        for (Cell c:cells) {
            if(c.x==x && c.n==val) return false;
            else if(c.y==y && c.n==val) return false;
        }
        return true;
    }

    public Block updateValueCell(int x,int y,int val){
        Block b = this.clone();
        for (Cell c:cells) {
            if(c.x==x && c.y=y)
                c.n = val;
        }
        return b;
    }

    public void completedBlock(){
        for (Cell c:cells) {
            c.setBackground(Color.GREEN);
            c.repaint();
        }
    }
    public boolean checkBlock(){
        boolean ret=false;
        int result=0;
        switch(operation){
            case "+":
                for (Cell c:cells) {
                    if(result==0) result=c.n;
                    else result=result+c.n;
                }
            break;
            case "-":
                for (Cell c:cells) {
                    if(result==0) result=c.n;
                    else result=result-c.n;
                }
            break;
            case "*":
                for (Cell c:cells) {
                    if(result==0) result=c.n;
                    else result=result*c.n;
                }
            break;
            case "/":
                for (Cell c:cells) {
                    if(result==0) result=c.n;
                    else result=result/c.n;
                }
            break;
        }
        System.out.println(result+"  "+resultValue);
        if(result==resultValue) {
            ret=true;
            System.out.println("block "+blockId+" completed!!"+ret);
            completedBlock();
        }
        return  ret;
    }

}
