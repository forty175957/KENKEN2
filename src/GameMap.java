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
            {1,1,2,4,4},
            {1,2,2,4,6},
            {3,3,5,6,6},
            {3,5,5,6,7},
            {3,5,6,6,7}};
    public int mapSide=4;
    public HashMap<Integer,Block> blocks = new HashMap<Integer, Block>();

    private GameMap(int mapSide) {
        this.mapSide=mapSide;
    }

    public static GameMap getInstance(){
        if(ISTANCE==null){
            ISTANCE = new GameMap(5);
        }
        return ISTANCE;
    }

    public void createMap(){
        Random rand=new Random();
        for (int i=1;i<mapSide+1;i++){

        }
        System.out.println(mapSide);
        for(int x=0;x<mapSide;x++){
            for(int y=0;y<mapSide;y++){
                int id=map[x][y];
                String OP=OPS[rand.nextInt(4)];
                Block b=new Block(id);
                b.setOperation(OP);
                blocks.put(id,b);
                Cell c = blocks.get(id).addCell(x,y);
                for(int i=0;i<mapSide+1;i++){
                    if(c.checkCellUpdate(i)){
                        c.updateValueCell(i);
                    }
                }
            }
        }
        for(int i=1;i<blocks.size()+1;i++){
            Block b = blocks.get(i);
            int goal=b.calcResult();
            b.setResultValue(goal);
            System.out.println("BLOCK "+b.getId()+" OP:"+b.operation+"="+goal);
            b.cells.get(0).updateDescription(b.resultValue+" "+b.operation);
            frame.revalidate();
            frame.repaint();
            for (Cell c: b.cells) {
                c.reset();
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
            if (map[x][y - 1] == id ) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBottom(int x,int y){
        if(y < mapSide - 1) {
            int id = map[x][y];
            if (map[x][y + 1] == map[x][y] ) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLeft(int x,int y){
        if(x>1) {
            int id = map[x][y];
            if (map[x - 1][y] == map[x][y]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRight(int x,int y){
        if(x<mapSide-1) {
            int id = map[x][y];
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

}
