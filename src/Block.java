import java.util.ArrayList;

public class Block {
    private ArrayList<Cell> cells;
    private String operation;
    private int resultValue;
    private int blockId;
    private Point startPoint;
    private GameMap Gmap=GameMap.getInstance();

    public Block(int blockId,String op,int res) {
        this.blockId = blockId;
        this.operation=op;
        this.resultValue=res;
        this.cells=new ArrayList<Cell>();
    }

    public int getId(){
        return blockId;
    }

    public void addCell(int x,int y) {
        if(cells.isEmpty()) {
            startPoint= new Point(x,y);
            String desc=operation+" "+new Integer(resultValue).toString();
            Cell cell = new Cell(x,y,this,desc);
        }
        Cell cell = new Cell(x,y,this);
        cells.add(cell);
        Gmap.getFrame().getContentPane().add(cell);
    }

    public boolean checkCells(int x,int y,int val){
        if(val>GameMap.getInstance().mapSide) return false;
        for (Cell c:cells) {
            if(c.x==x && c.n==val) return false;
            else if(c.y==y && c.n==val) return false;
        }
        return true;
    }

    private boolean checkBlock(){
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
        if(result==resultValue) return  true;
        else return  false;
    }

}
