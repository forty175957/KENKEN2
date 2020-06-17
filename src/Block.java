import java.util.ArrayList;

public class Block {
    private ArrayList<Cell> cells;
    private int operation;
    private int resultValue;
    private int blockId;
    private Point startPoint;
    private GameMap Gmap=GameMap.getInstance();

    public Block(int blockId,int x,int y) {
        this.blockId = blockId;
        this.startPoint=new Point(x,y);
    }

    public void addCell(int x,int y) {
        Cell cell = new Cell(x,y);
        cells.add(cell);
    }

    private boolean checkLeft(Cell c){
        int x=c.getX()+Gmap.side;
        int y=c.getY();
        if(Gmap.checkCell(x,y,blockId)){
            return true;
        }
        return false;
    }

    private boolean checkRight(Cell c){
        int x=c.getX()-Gmap.side;
        int y=c.getY();
        if(Gmap.checkCell(x,y,blockId)){
            return true;
        }
        return false;
    }

    private boolean checkDown(Cell c){
        int x=c.getX();
        int y=c.getY()+Gmap.side;
        if(Gmap.checkCell(x,y,blockId)){
            return true;
        }
        return false;
    }

    private boolean checkUp(Cell c){
        int x=c.getX();
        int y=c.getY()-Gmap.side;
        if(Gmap.checkCell(x,y,blockId)){
            return true;
        }
        return false;
    }


    public void drawLines(){
        for (Cell c:cells) {
            if(checkUp(c)){

            }
        }
    }
}
