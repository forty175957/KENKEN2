import java.util.ArrayList;
import java.util.Random;

public class Generatore {
    Random rand=new Random();
    int side;
    int[][] mat;

    public Generatore(int side) {
        mat=new int[side][side];
        this.side=side;
        Random rand=new Random();
        updateCell(0,0);
    }

    private void updateCell(int x,int y){
        //int n=rand.nextInt(side+1);
        mat[x][y]=3;
        System.out.println(Matrix.MatrixToString(mat));
        if(x<side-1){
            y++;
        }
        else if(x==side-1){
            x++;y=0;
        }
        updateCell(x,y);
    }

    public static  void main(String[] args){
        Generatore g=new Generatore(4);
        System.out.println(Matrix.MatrixToString(g.mat));

    }
}
