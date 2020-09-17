import javax.swing.*;
import java.io.IOError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class RisolutoreMio {
    public ArrayList<Cell> sol = new ArrayList<Cell>();
    private Block block;
    ArrayList<int[][]> solutionMap = new ArrayList<>();
    ArrayList<int[][]> soluzioni = new ArrayList<>();
    ArrayList<Block> blocchiRisolti= new ArrayList<>();
    ArrayList<ArrayList<Block>> soluzioniMappa = new ArrayList<>();



    public RisolutoreMio(Block b) {
        block = b;
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
                int[][] m = cloneArray(GameMap.getInstance().valueMatrix);
                solutionMap.add(m);
            }
        }
        return;
    }

    public static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }

}
