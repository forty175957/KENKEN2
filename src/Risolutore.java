import java.util.ArrayList;


public class Risolutore {
    public ArrayList<Cell> sol=new ArrayList<Cell>();
    private Block block;
    private ArrayList<Integer> excluded = new ArrayList<>();

    public void solve(Block b,ArrayList<Integer> excluded){
        Cell c = b.findEmpty();
        if(c!=null) {
            while (!block.checkBlock()) {
                for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                    if (c.checkCellUpdate(i) && !excluded.contains(i)) {
                        c.updateValueCell(i);
                        c = b.findEmpty();
                    }
                    if (i == GameMap.getInstance().mapSide) {
                        backtrack(b, excluded);
                    }
                }
                c = b.findEmpty();
            }
        }
        else{
            for(Cell ce : b.cells)
            {

            }
        }
    }
    ///FORTUNATO È UN CAZZONE!!!

    private void backtrack(Block b,ArrayList<Integer> excluded){
        int r = sol.size();
        if(r!=0) {
            System.out.println("R" + r);
            System.out.println("Soluzione: " + sol.toString());
            Cell last = sol.remove(r-1);
            excluded.add(last.n);
            last.updateValueCell(0);
        }
        solve(b,excluded);
    }

    public Risolutore(Block b){
        block=b;
        sol.clear();
        Cell empty = block.findEmpty();
        solve(b,excluded);
    }


}
