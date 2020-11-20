package EXTRA;


import java.util.ArrayList;
import java.util.Random;

public class GenMio {
    int side;
    int[][] mat;
    ArrayList<int[][]> mappe = new ArrayList<>();
    Random r= new Random();

    public GenMio(int n,int[][] m){
        mat=m;
        side = n;
    };


    public boolean checkMatrix(int row, int col, int x) {
        for (int i = 0; i < side; i++) {
            if (mat[row][i] == x) {
                return false;//NOT VALID UPDATE COL
            } else if (mat[i][col] == x) {
                return false;//NOT VALID UPDATE ROW
            }
        }
        return true;
    }

    public void riempiMatrice(int[][] mat,int x,int y) {
        int[][] finalMat = new int[mat.length][mat.length];
        for(int i=1;i<6;i++) {
            if (checkMatrix(x, y, i)) {
                mat[x][y] = i;
                stampaMatrix(mat);
                System.out.println();
                if (x == mat.length - 1 && y == mat.length - 1) {
                    mappe.add(mat);
                    return;
                }
                if (y < mat.length - 1) {
                    y++;
                } else if (y == mat.length - 1) {
                    x++;
                    y = 0;
                }
            }
        }
        riempiMatrice(mat, x, y);
    }

    public void stampaMappe(){
        for(int[][] m: mappe)stampaMatrix(m);
    }

    public boolean isFull(int[][]mat){
        if(mat[mat.length-1][mat.length-1]!=0)return true;
        return false;
    }

    public static int[][] creaMatrixZero(int n){
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=0;
            }
        }
        return matrix;
    }

    public void stampaMatrix(int[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m.length;j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] Args){
        int[][] m = creaMatrixZero(5);
        GenMio g = new GenMio(5,m);
        g.riempiMatrice(m,0,0);
        g.stampaMappe();

    }
}
