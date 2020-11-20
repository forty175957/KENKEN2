package EXTRA;
import Core.Util;
import java.util.Random;

public class GeneratoreVal {
    Random rand=new Random();
    int side;
    int[][] mat;

    public GeneratoreVal(int side) {
       generateValues(side);
    }



    public void generateValues(int side) {
        this.side=side;
        mat=new int[side][side];
        genValues(mat);
        if(Util.matrixContains(mat,0)){
            regenerate();
            return;
        }
    }

    public void regenerate() {
        System.out.println("Reg");
        this.mat=new int[side][side];
        this.generateValues(this.side);
    }

    public boolean checkMatrix(int[] cell, int x) {
        for (int i = 0; i < side; i++) {
            if (mat[cell[0]][i] == x) {
                return false;//NOT VALID UPDATE COL
            } else if (mat[i][cell[1]] == x) {
                return false;//NOT VALID UPDATE ROW
            }
        }
        return true;
    }

    private int[] findEmpty(){
        int count = 0;
        while (count<side*side){
            int x = rand.nextInt(side);
            int y = rand.nextInt(side);
            if(mat[x][y]==0){
                int[] res=new int[2];
                res[0]=x;
                res[1]=y;
                return res;
            }
            else{
                count++;
            }
        }
        return null;
    }

    private void genValues(int[][] m) {
        int[][] old=Util.cloneMatrix(m);
        int[] empty = findEmpty();
        if(empty==null) return;
        if (empty != null) {
            for (int i = 1; i < side + 1; i++) {
                if (checkMatrix(empty,i)) {
                    mat[empty[0]][empty[1]]=i;
                    genValues(mat);
                }
            }
            genValues(old);

        }
        return;
    }

    public static  void main(String args[]){
        GeneratoreVal g=new GeneratoreVal(6);
        System.out.println(Util.MatrixToString(g.mat));
    }
}
