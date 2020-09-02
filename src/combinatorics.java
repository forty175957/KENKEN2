import java.util.*;

public class combinatorics{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        List<int[]> list = new ArrayList<int[]>();
        List<List<Integer>> sol=new ArrayList<List<Integer>>();
        combinations2(arr);
    /*     combinations(5,arr,list);
              combinations3(arr,list);*/
        listToString(list);
    }

    public static void combinations2(int[] arr){
        List<List<Integer>> sol=new ArrayList<List<Integer>>();
        int n= arr.length;
        for (int i=0;i< arr.length;i++) {
            List<Integer> p=new  ArrayList<Integer>();
            p.add(arr[i]);
            recur(arr,p,sol,i,n);
        }
        for (List<Integer> l:sol) {
            System.out.println(l.toArray().toString());
        }
    }

    public static void recur(int[] arr,List<Integer> part,List<List<Integer>> sol,int i,int n){
        for(int x=0;x<n;x++){
            if(!part.contains(arr[x])) part.add(arr[x]);
        }if(part.size()==n) sol.add(part);
        else{
            recur(arr,part,sol,i+1,n);
        }
    }

    static void combinations3(int[] arr, List<int[]> list){
        for(int q = 0; q<arr.length-3; q++)
            for(int i = 0; i<arr.length-2; i++)
                for(int j = i+1; j<arr.length-1; j++)
                    for(int k = j+1; k<arr.length; k++)
                        list.add(new int[]{arr[i],arr[j],arr[k],arr[q]});
    }

    private static void listToString(List<int[]> list){
        for(int i = 0; i<list.size(); i++){ //iterate through list
            for(int j : list.get(i)){ //iterate through array
                System.out.printf("%d ",j);
            }
            System.out.print("\n");
        }
    }

    public static void combinations(int n, int[] arr, List<int[]> list) {
        // Calculate the number of arrays we should create
        int numArrays = (int)Math.pow(arr.length, n);
        // Create each array
        for(int i = 0; i < numArrays; i++) {
            int[] current = new int[n];
            // Calculate the correct item for each position in the array
            for(int j = 0; j < n; j++) {
                // This is the period with which this position changes, i.e.
                // a period of 5 means the value changes every 5th array
                int period = (int) Math.pow(arr.length, n - j - 1);
                // Get the correct item and set it
                int index = i / period % arr.length;
                current[j] = arr[index];
            }
            list.add(current);
        }
    }





}