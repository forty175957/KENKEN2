import java.util.Scanner;

public class Matrix {
    public static String MatrixToString(int[][] matrix)
    {
        StringBuilder sbResult = new StringBuilder();
        int size=matrix[0].length;
        for(int i = 0; i < size;i++)
        {
            for(int j = 0; j < size;j++)
            {
                sbResult.append(matrix[i][j]);
                sbResult.append("\t");
            }
            sbResult.append("\n");
        }

        return sbResult.toString();
    }

    public  static int[][] StringtoMatrix(String s,int size){
        Scanner sc=new Scanner(s);
        int[][] matrix=new int[size][size];
        //String line = sc.nextLine();
        for (int i=0;i<size;i++){
            String[] line =sc.nextLine().split("\t");
            for(int j=0;j<size;j++){
                matrix[i][j]=new Integer(line[j]);
            }
        }
        return  matrix;
    }

    public  static String[] StringToList(String s){
        String[] line=s.split("\t");
        return line;
    }

    public  static String ListToString(String[] json){
        String line="";
        for (String x:json) {
            line+=x+"\t";
        }
        return  line;
    }
}
