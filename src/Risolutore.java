import java.util.ArrayList;


public class Risolutore {
    public ArrayList<Cell> sol=new ArrayList<Cell>();
    private Block block;

    public void solve(Cell start){
        for(int i=1;i<GameMap.getInstance().mapSide+1;i++){
             if(start==null){
                 backtrack();
                 System.out.println("no empty cell");
                 break;
             }
             if(start.checkCellUpdate(i)){
                 start.updateValueCell(i);
                 sol.add(start);
                 solve(block.findEmpty());
                 break;
             }
             else if(!start.checkCellUpdate(i) && i==GameMap.getInstance().mapSide+1 ){
                 backtrack();
                 //nessun valore applicabile, BACKTRACK
             }
             if(block.getBlockSize()== sol.size()){
                 System.out.println("Soluzione trovata :"+sol.toString());
             }
        }
    }

    private void backtrack(){
        int r = sol.size();
        if(r!=0) {
            System.out.println("R" + r);
            System.out.println("Soluzione: " + sol.toString());
            Cell last = sol.remove(r-1);
            last.updateValueCell(0);
        }
        solve(block.findEmpty());
    }

    public Risolutore(Block b){
        block=b;
        sol.clear();
        Cell empty = block.findEmpty();
        solve(empty);
    }


}
