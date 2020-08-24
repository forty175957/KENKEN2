import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Risolutore {
    Random rand=new Random();
    ArrayList<Integer> soluzione=new ArrayList<Integer>();

    public static void resolve(HashMap<Integer,Block> blocks){
        for(int i=1;i<blocks.size()+1;i++){
            Block b =blocks.get(i);
            System.out.println("BLOCK n "+b.getId());
            new Risolutore(b);
        }
    }

    public ArrayList<Cell> resolve(Block b){
        Block mod;
        for (Cell c: b.cells ) {
            if(c.n!=0){
                for(int i=1;i<GameMap.getInstance().mapSide;i++){
                    boolean check = b.checkCellUpdate(c.x,c.y,i);
                    if(check){
                        mod=b.updateValueCell(c.x,c.y,i);
                    }
                    else if(!check && i==GameMap.getInstance().mapSide){
                        backtrack()
                    }
                }
            }
        }
    }

    public Risolutore(Block block){
        /*
        System.out.println(soluzione.toString());*/
    }


    public static HashMap<Cell,Integer> backtrack(ArrayList<Cell> solution,Block b){

    }
}
