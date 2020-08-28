import java.awt.*;
import java.util.ArrayList;

public class Block {
    public ArrayList<Cell> cells;
    public String operation;
    public int resultValue;
    private int blockId;
    private GameMap Gmap=GameMap.getInstance();

    public Block(int blockId) {
        this.blockId = blockId;
        this.cells=new ArrayList<Cell>();
    }

    public void setOperation(String OP){
        operation=OP;
    }

    public void setResultValue(int val){
        resultValue=val;
        System.out.println("id:"+blockId+" op:"+operation+" res:"+resultValue);
    }

    public int getBlockSize(){
        return cells.size();
    }

    public int getId(){
        return blockId;
    }

    public Cell addCell(int x,int y) {
        Cell cell;
        cell = new Cell(x,y,this);
        cells.add(cell);
        Gmap.getFrame().getContentPane().add(cell);
        return  cell;
    }

    public void completedBlock(){
        for (Cell c:cells) {
            c.completed=true;
            c.repaint();
        }
    }

     public Cell findEmpty(){
        Cell result=null;
         for (Cell c:cells) {
            if(c.n==0){
                result=c;
                break;
            }
         }
         return result;
     }

    public Cell getCell(int x,int y){
        Cell cell=null;
        for (Cell c:cells) {
            if(c.x==x && c.y==y) cell=c;
        }
        return cell;
    }

    public boolean checkBlock(){
        boolean ret=false;
        int result=calcResult();
        System.out.println(result+"  "+resultValue);
        if(result==resultValue) {
            ret=true;
            System.out.println("block "+blockId+" completed!!"+ret);
            completedBlock();
        }
        return ret;
    }

    public int calcResult(){
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

        return  result;
    }

}
