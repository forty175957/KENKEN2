import java.util.ArrayList;


public class Risolutore {
    public ArrayList<Cell> sol=new ArrayList<Cell>();
    private Block block;

    public void solve(Block b){
        Cell c = b.findEmpty();
        while (true){
            for (int i=1;i<GameMap.getInstance().mapSide;i++){
                if(c.checkCellUpdate(i)){
                    c.updateValueCell(i);
                }
                if(i==GameMap.getInstance().mapSide){
                    backtrack(b);
                }
            }
            c= b.findEmpty();
        }
    }

    private void backtrack(Block b){
        int r = sol.size();
        if(r!=0) {
            System.out.println("R" + r);
            System.out.println("Soluzione: " + sol.toString());
            Cell last = sol.remove(r-1);
            last.updateValueCell(0);
        }
        solve(b);
    }

    public Risolutore(Block b){
        block=b;
        sol.clear();
        Cell empty = block.findEmpty();
        solve(b);
    }


}
