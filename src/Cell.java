import javax.swing.*;

public class Cell{
    private int x,y;
    private GameMap map=GameMap.getInstance();
    Point A,B,C,D;

    public Cell(int x,int y){
        this.x=x;
        this.y=y;
        A=new Point(x,y);
        B=new Point(x+map.side,y);
        C=new Point(x+map.side,y+map.side);
        D=new Point(x,y+map.side);
    }

    public boolean checkNeighbors(Cell[] cells){
        for (Cell c:cells){

        }
        return false;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }



    /*private Cell NorthCell,SouthCell,WestCell,EastCell;
    //int lineWidth_1=1;

    public void setNorthCell(Cell notrhCell){
        NorthCell=notrhCell;
    }
    public void setEastCell(Cell eastCell) {
        EastCell = eastCell;
    }

    public void setWestCell(Cell westCell) {
        WestCell = westCell;
    }

    public void setSouthCell(Cell southCell) {
        SouthCell = southCell;
    }

    public void draw(JFrame frame){
        if(NorthCell!=null){
            frame.add(new MyLine(x,y,x+sideDimension,y,1));
        }else{
            frame.add(new MyLine(x,y,x+sideDimension,y,4));
        }
        if(SouthCell!=null){
            frame.add(new MyLine(x,y+sideDimension,x+sideDimension,y+sideDimension,1));
        }else{
            frame.add(new MyLine(x,y+sideDimension,x+sideDimension,y+sideDimension,4));
        }
        if(EastCell!=null){
            frame.add(new MyLine(x+sideDimension,y,x+sideDimension,y+sideDimension,1));
        }else{
            frame.add(new MyLine(x+sideDimension,y,x+sideDimension,y+sideDimension,4));
        }
        if(WestCell!=null){
            frame.add(new MyLine(x,y,x,y+sideDimension,1));
        }else{
            frame.add(new MyLine(x,y,x,y+sideDimension,4));
        }
    }*/

}
