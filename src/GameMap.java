import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GameMap {
    private static GameMap ISTANCE;
    private JFrame frame;
    private Container cp;
    public int mapSide=5;
    private String[] OPS= {"+","-","/","*"};
    public int[][] map ;
    int[][] valueMatrix=new int[mapSide][mapSide];
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

    public void initGmap(){
        for(int x=0;x<mapSide;x++) {
            for (int y = 0; y < mapSide; y++) {
                int id = map[x][y];
                Block b = null;
                if (blocks.containsKey(id)) {
                    b = blocks.get(id);
                } else {
                    b = new Block(id);
                }
                b.addCell(x, y);
            }
        }
        for (int i=1;i< blocks.size()+1;i++) {
            System.out.println("block " + i + " op" + blocks.get(i).operation + " res: " + blocks.get(i).resultValue);
            String description=blocks.get(i).operation + " " + new Integer(blocks.get(i).resultValue);
            for (Cell c : blocks.get(i).cells) {
                c.updateDescription(description);
                c.reset();
            }
        }
    }

    public void setFrame(JFrame f){
        frame=f;
        cp=f.getContentPane();
    }

    public JFrame getFrame(){
        return frame;
    }

//##MAP ADAPTER
    public int[][] getValues() {
        return valueMatrix;
    }

    public String[] getOperators(){
        String[] op=new String[blocks.size()];
        for(int i=1;i< blocks.size()+1;i++)
        {
            op[i-1]=blocks.get(i).operation;
        }
        return op;
    }

    public void setOperator(String[] op){
        for(int i=1;i< blocks.size()+1;i++) {
            blocks.get(i).operation=op[i-1];
        }
    }

    public void setResult(String[] res){
        for(int i=1;i< blocks.size()+1;i++) {
            blocks.get(i).resultValue= Integer.parseInt(res[i-1]);
        }
    }

    public String[] getResult(){
        String[] res=new String[blocks.size()];
        for(int i=1;i< blocks.size()+1;i++)
        {
            res[i-1]=new Integer(blocks.get(i).resultValue).toString();
        }
        return res;
    }

    public void updateMatrix(int raw,int col,int x){
        valueMatrix[raw][col]=x;
        System.out.println(Matrix.MatrixToString(valueMatrix));
    }

//##MAP CONTROL
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

    public void updateBlocks(String [] op,String[] res){
        for (int i = 1; i < op.length - 1; i++) {
            Block b=new Block(i+1);
            b.setAll(op[i],Integer.parseInt(res[i]));
            GameMap.getInstance().blocks.put(i+1,b);
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

}
