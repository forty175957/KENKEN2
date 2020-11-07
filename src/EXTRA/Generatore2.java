import java.util.ArrayList;
import java.util.Random;

public class Generatore2 {
    Random rand=new Random();
    int side;
    public enum Direction {BOTTOM,RIGHT};
    int[][] valueMatrix;
    int[][] map;
    ArrayList<Integer> excluded = new ArrayList<>();


    public Generatore2(int side) {
        valueMatrix =new int[side][side];
        map=new int[side][side];
        this.side=side;
        //updateCell(0,0);
        genBlock(0,0,1,3);
        System.out.println(Matrix.MatrixToString(map));

    }

    private void generateMap(){
        int nCells= (int) Math.pow(side,side);
        int n=rand.nextInt(side)+1;
        for(int i=0;i<n;i++){

        }

    }

    public void genBlock(int x,int y,int id, int nCells){
        int randDirection= rand.nextInt(3);
        switch (randDirection){
            case 0://GO RIGHT
                if(y+1<side && map[x][y+1]==0){
                    y++;
                }else{
                    genBlock(x,y,id,nCells);
                }
            case 1://GO LEFT
                if(y-1>0 && map[x][y-1]==0){
                    y--;
                }else{
                    genBlock(x,y,id,nCells);
                }
            case 2://GO BOTTOM
                if(x+1<side && map[x+1][y]==0){
                    x++;
                }else{
                    genBlock(x,y,id,nCells);
                }
        }
        map[x][y]=id;
        nCells--;
    }

    public boolean checkMatrix(int row, int col, int x) {
        for (int i = 0; i < side; i++) {
            if (valueMatrix[row][i] == x) {
                return false;//NOT VALID UPDATE COL
            } else if (valueMatrix[i][col] == x) {
                return false;//NOT VALID UPDATE ROW
            }
        }
        return true;
    }

    private void updateCell(int x,int y){
        valueMatrix[x][y]=0;
        excluded.clear();
        int n = rand.nextInt(side)+1;
        while(!checkMatrix(x, y, n)) {
            if(!excluded.contains(n)) excluded.add(n);
            if(excluded.size()==side-1) {
            //I have tried all possible value and doesn't match the constraints so backtrack
                if (y==0) {
                    x--;
                    y = side-1;
                } else if(y>0){
                   y--;
                }
                //System.out.println("backtrack x:"+new Integer(x).toString()+" y:"+new Integer(y).toString());
                updateCell(x, y);
                return;
            }
            n = rand.nextInt(side)+1;
        }
        if(checkMatrix(x,y,n)){
            valueMatrix[x][y] = n;
            if (y < side - 1) {
                y++;
            } else if (y == side - 1) {
                x++;
                y = 0;
            }
            //System.out.println(Matrix.MatrixToString(mat));
            if(x>side-1) {
                //FINIMMA
                System.out.println(Matrix.MatrixToString(valueMatrix));
                return;
            }
            updateCell(x, y);
        }
    }



    public static  void main(String[] args){
        Generatore2 g=new Generatore2(6);

    }
}
