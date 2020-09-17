import java.util.ArrayList;

public class Risolutore {
    public ArrayList<Cell> sol = new ArrayList<Cell>();
    ArrayList<int[][]> solutionMap = new ArrayList<>();
    ArrayList<int[][]> soluzioni = new ArrayList<>();



    public Risolutore() {
        GameMap.getInstance().resetMap();
        sol.clear();
        solution2();
        for(int[][] stampaSol : solutionMap) System.out.println(Matrix.MatrixToString(stampaSol));
        //mapIllustration();
        new RisolutoreGui(solutionMap);
    }

    public void solveMod(Block bl)
    {
        Cell empty = bl.findEmpty();
        if (empty != null) {
            for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                if (empty.checkCellUpdate(i)) {
                    empty.updateValueCell(i);
                    solveMod(bl);
                    if(bl.checkBlock())
                    {
                        soluzioni.add(GameMap.getInstance().valueMatrix);
                        solution2();
                        soluzioni.clear();
                        //break;
                    }
                    empty.updateValueCell(0);
                }
            }

        }
        return;
    }

    public void solution2() {
        Block bloc = new Block(GameMap.getInstance().findEmptyBlock());
        if (bloc != null) {
            solveMod(bloc);
            if(bloc.checkBlock() && bloc.getId()==GameMap.getInstance().blocks.size()){
                int[][] m = Matrix.cloneMatrix(GameMap.getInstance().valueMatrix);
                solutionMap.add(m);
            }
        }
        return;
    }

}
