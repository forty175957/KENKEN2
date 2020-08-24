import java.util.ArrayList;
import java.util.Random;

public class Generatore {
    Random rand=new Random();
    ArrayList<Integer> soluzione=new ArrayList<Integer>();

    public Generatore(int side) {
    int[][] matrix= new int[side][side];
    int nEl=side*side;
    int id=1;int r=0;int c=0;
    int n=rand.nextInt(5);
    while(n>0){
        if(matrix[r][c]==0){
            matrix[r][c]=id;
        }
        else{
            if(rand.nextBoolean()){
                r++;
            }else{
                c++;
            }
        }
    }
    }
}
