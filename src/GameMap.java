import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameMap {
    private static GameMap ISTANCE;
    private JFrame frame;
    private Container cp;
    public int mapSide=5;
    private String[] OPS= {"+","-","/","*"};
    public int[][] map = {
            {1,1,2,4,4},
            {1,2,2,4,6},
            {3,3,5,6,6},
            {3,5,5,6,7},
            {3,5,6,6,7}};


    int[][] valueMatrix=new int[mapSide][mapSide];
    public HashMap<Integer,Block> blocks = new HashMap<Integer, Block>();

    private GameMap(int mapSide) {
        this.mapSide=mapSide;
    }

    public int[][] getValues() {
        return valueMatrix;
    }

    public ArrayList<String> getOperators(){
        ArrayList<String> op=new ArrayList<String>();
        for(int i=1;i< blocks.size()+1;i++)
        {
            op.add(i,blocks.get(i).operation);
        }
        return op;
    }
    public static GameMap getInstance(){
        if(ISTANCE==null){
            ISTANCE = new GameMap(5);
        }
        return ISTANCE;
    }

    public boolean checkMatrix(int row,int col,int x){
        for(int i=0;i<mapSide;i++){
            if(valueMatrix[row][i]==x){
                return false;//NOT VALID UPDATE COL
            }else if(valueMatrix[i][col]==x){
                return false;//NOT VALID UPDATE ROW
            }
        }
        return true;
    }

    public void updateMatrix(int raw,int col,int x){
        valueMatrix[raw][col]=x;
        System.out.println(Matrix.toString(valueMatrix));
    }

    public void load(String filename){

    }


    public void init(){
        for(int x=0;x<mapSide;x++){
            for(int y=0;y<mapSide;y++){
                int id=map[x][y];
                if(!blocks.containsKey(id)){
                    Block b=new Block(id);
                    blocks.put(id,b);
                }
                Cell c = blocks.get(id).addCell(x,y);
                }
            }

        blocks.get(1).setAll("-",-4);
        blocks.get(2).setAll("*",15);
        blocks.get(3).setAll("+",12);
        blocks.get(4).setAll("*",40);
        blocks.get(5).setAll("+",16);
        blocks.get(6).setAll("*",360);
        blocks.get(7).setAll("-",1);

        for (int i=1;i< blocks.size()+1;i++) {
            System.out.println("block "+i+" op"+blocks.get(i).operation+" res: "+blocks.get(i).resultValue);
            blocks.get(i).cells.get(0).updateDescription(blocks.get(i).operation+" "+new Integer(blocks.get(i).resultValue));
            for (Cell c:blocks.get(i).cells) {
                c.reset();
            }
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
