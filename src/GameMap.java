import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameMap {
    private static GameMap ISTANCE;
    private JFrame frame;
    private Container cp;
    private String[] OPS= {"+","-","/","*"};
    public int[][] map = {
            {1,1,2},
            {1,2,2},
            {3,3,3}};
    public int mapSide=3;
    public HashMap<Integer,Block> blocks = new HashMap<Integer, Block>();

    private GameMap(int mapSide) {
        this.mapSide=mapSide;
    }

    public void createMap(){
        Random rand=new Random();
        for (int i=1;i<5;i++){
            String OP=OPS[rand.nextInt(4)];
            Block b= new Block(i,OP, rand.nextInt(10));
            blocks.put(i,b);
        }
        System.out.println(mapSide);
        for(int x=0;x<mapSide;x++){
            for(int y=0;y<mapSide;y++){
                int id=map[x][y];
                if( blocks.containsKey(id)){
                    blocks.get(id).addCell(x,y);
                }
            }
        }
        String j = Map.save(map,blocks);
        int[][] m = Map.load(j);
        if(m==map){
            System.out.println("test");
        }
    }

    public boolean checkTop(int x,int y){
        if(y>1) {
            int id = map[x][y];
            //System.out.println("CELL[" + x + "][" + y + "]=" + id + " TOP " + x + " " + (y - 1));
            if (map[x][y - 1] == id ) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBottom(int x,int y){
        if(y < mapSide - 1) {
            int id = map[x][y];
            //System.out.println("CELL[" + x + "][" + y + "]=" + id + " BOTTOM " + x + " " + (y + 1));
            if (map[x][y + 1] == map[x][y] ) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLeft(int x,int y){
        if(x>1) {
            int id = map[x][y];
            //System.out.println("CELL[" + x + "][" + y + "]=" + id + " LEFT " + (x - 1) + " " + y);
            if (map[x - 1][y] == map[x][y]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRight(int x,int y){
        if(x<mapSide-1) {
            int id = map[x][y];
            //System.out.println("CELL[" + x + "][" + y + "]=" + id + " RIGHT " + (x + 1) + " " + y);
            if (map[x + 1][y] == map[x][y]) {
                return true;
            }
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
