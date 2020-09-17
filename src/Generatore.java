import java.util.ArrayList;
import java.util.Random;

public class Generatore {
    Random rand=new Random();
    int side;
    GameMap map;

    public Generatore(int side) {
        map=GameMap.getInstance(side);
        this.side=side;
        Random rand=new Random();
        updateCell(0,0);
    }

    private void updateCell(int x,int y){
        //int n=rand.nextInt(side+1);
        map.valueMatrix[x][y]=3;
        if(x<side-1){
            updateCell(x++,y);
            return;
        }
        else if(x==side-1){
            updateCell(0,y++);
            return;
        }
    }

    public static  void main(String[] args){
        Generatore g=new Generatore(4);
        System.out.println(Matrix.MatrixToString(g.map.valueMatrix));

    }
}
