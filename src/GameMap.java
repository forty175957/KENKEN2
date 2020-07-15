import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GameMap {
    private static GameMap ISTANCE;
    private JFrame frame;
    private Container cp;
    public int[][] map={{1,2,2},{2,2,2},{2,2,3}};
    private int mapSide=2;
    public HashMap<Integer,Block> blocks = new HashMap<Integer,Block>();

    private GameMap(int mapSide) {
        this.mapSide=mapSide;
        map=new int[mapSide][mapSide];
    }

    private void createMap(){
        for(int y=0;y<mapSide;y++){
            for(int x=0;x<mapSide;x++){
                int id=map[x][y];
                if( blocks.containsKey(id)){
                    blocks.get(id).addCell(x,y);
                }
                else{
                    Block b = new Block(id);
                    b.addCell(x,y);
                    blocks.put(id,b);
                }
            }
        }
    }

    public boolean checkTop(int x,int y){
        if(map[x][y-1]==map[x][y] && y>1) {
            return true;
        }
        return false;
    }

    public boolean checkBottom(int x,int y){
        if(map[x][y+1]==map[x][y] && y<mapSide-1) {
            return true;
        }
        return false;
    }

    public boolean checkLeft(int x,int y){
        if(map[x-1][y]==map[x][y] && x>1) {
            return true;
        }
        return false;
    }

    public boolean checkRight(int x,int y){
        if(map[x+1][y]==map[x][y] && x<mapSide-1) {
            return true;
        }
        return false;
    }

    public void setFrame(JFrame f){
        frame=f;
        cp=f.getContentPane();
    }

    public JFrame getFrame(){
        return frame;
    }

    public static GameMap getInstance(int mapSide){
        if(ISTANCE==null){
            ISTANCE = new GameMap(mapSide);
        }
        return ISTANCE;
    }


    public static GameMap getInstance(){
        if(ISTANCE==null){
            ISTANCE = new GameMap(3);
        }
        return ISTANCE;
    }

    public boolean checkCell(int x,int y,int blockId){
        if(map[x][y]==blockId){
            return true;
        }
        return false;
    }

}
