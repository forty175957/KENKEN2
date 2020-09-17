import java.util.ArrayList;

public class Risolutore {
    public ArrayList<Cell> sol = new ArrayList<Cell>();
    ArrayList<int[][]> solutionMap = new ArrayList<>();
    ArrayList<int[][]> soluzioni = new ArrayList<>();



    public Risolutore() {
        GameMap.getInstance().resetMap();
        sol.clear();
        solveMap();
        for(int[][] stampaSol : solutionMap) System.out.println(Matrix.MatrixToString(stampaSol));
        new RisolutoreGui(solutionMap);
    }

    public void solveBlock(Block bl) {
        Cell empty = bl.findEmpty();
        if (empty != null) {
            for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                if (empty.checkCellUpdate(i)) {
                    empty.updateValueCell(i);
                    solveBlock(bl);
                    if(bl.checkBlock())
                    {
                        soluzioni.add(GameMap.getInstance().valueMatrix);
                        solveMap();
                        soluzioni.clear();
                    }
                    empty.updateValueCell(0);
                }
            }

        }
        return;
    }

    public void solveMap() {
        Block bloc = new Block(GameMap.getInstance().findEmptyBlock());
        if (bloc != null) {
            solveBlock(bloc);
            if(bloc.checkBlock() && bloc.getId()==GameMap.getInstance().blocks.size()){
                int[][] m = Matrix.cloneMatrix(GameMap.getInstance().valueMatrix);
                solutionMap.add(m);
            }
        }
        return;
    }

}
