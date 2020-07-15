import java.util.ArrayList;

public class Block {
    private ArrayList<Cell> cells;
    private int operation;
    private int resultValue;
    private int blockId;
    private Point startPoint;
    private GameMap Gmap=GameMap.getInstance();

    public Block(int blockId) {
        this.blockId = blockId;
    }
    public int getId(){
        return blockId;
    }

    public void addCell(int x,int y) {
        if(cells.isEmpty()) startPoint= new Point(x,y);
        Cell cell = new Cell(x,y,this);
        cells.add(cell);
    }

}
