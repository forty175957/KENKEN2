import javax.swing.*;
import java.util.Map;

public class GameMap {
    private static GameMap ISTANCE;
    public static final int side = 10;
    private JFrame frame;
    public int[][] map;
    private int mapSide;
    public Map<int,Block> blocks=new HashMap<int,Block>();

    private GameMap(int mapSide) {
        this.mapSide=mapSide;
        map=new int[mapSide][mapSide];
    }

    public void setFrame(JFrame f){
        frame=f;
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

    public boolean checkCell(Cell c,int blockId){
        if(map[c.getX()][c.getY()]==blockId){
            return true;
        }
        return false;
    }

    private void scanMap(){
        for(int i=0;i<mapSide;i++){
            for(int t=0;t<mapSide;t++){
                if(blocks.containsKey(map[i][t])){
                    blocks.get(map[i][t]).addCell(i,t);
                }
            }
        }
    }
}
