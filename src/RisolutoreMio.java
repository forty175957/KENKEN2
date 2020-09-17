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

    public boolean solveBlock(Block b,int index) {
        for (int i=index;i<b.cells.size();i++) {
            Cell change = b.cells.get(i);
            for (int j = 0; j < GameMap.getInstance().mapSide + 1; j++) {
                if (change.checkCellUpdate(i)) {
                    change.updateValueCell(i);
                    if (b.checkBlock()) {
                        soluzioni.add(GameMap.getInstance().valueMatrix);
                        blocchiRisolti.add(b);
                        System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
                        soluzioni.clear();
                        return true;
                    }
                    if(index==b.cells.size()-1) index=0;
                    solveBlock(b,index+1);
                }
            }
            soluzioniMappa.add(blocchiRisolti);
            System.out.println(soluzioniMappa.size());
        }
        return false;
    }

    public RisolutoreMio(Block b) {
        block = b;
        sol.clear();
        solution2();
        for(int[][] stampaSol : solutionMap) System.out.println(Matrix.MatrixToString(stampaSol));
        //mapIllustration();
        new RisolutoreGui(solutionMap);
    }

    public boolean solve() {
        Cell empty = block.findEmpty();
        if (empty != null) {
            for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                if (empty.checkCellUpdate(i)) {
                    empty.updateValueCell(i);

                    if (solve())  return true;
                    empty.n=0;
                    }
                }
            return block.checkBlock();
        }
        return block.checkBlock() ;
    }

    public boolean solveMod() {
        for (int j = block.cells.size() - 1; j >= 0; j--) {
            Cell c = block.cells.get(j);
            for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                if (c.checkCellUpdate(i)) {
                    c.updateValueCell(i);
                    System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
                    if (solve())  return true;
                    c.reset();
                }
            }
            return false;
        }
        return block.checkBlock() ;
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

    public void solveMod2() {
        Cell empty = block.findEmpty();
        if (empty != null) {
            for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                if (empty.checkCellUpdate(i)) {
                    empty.updateValueCell(i);
                    solveMod2();
                    if(block.checkBlock())
                    {
                        System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
                        soluzioni.add(GameMap.getInstance().valueMatrix);
                        soluzioni.clear();
                    }
                    empty.updateValueCell(0);
                }
            }

        }
        return;
    }


    public void solveMio(Block b) {
        Cell c = b.findEmpty();
        if (c != null) {
            for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                if (c.checkCellUpdate(i)) {
                    c.updateValueCell(i);
                    if (b.checkBlock()) {
                        soluzioni.add(GameMap.getInstance().valueMatrix);
                        blocchiRisolti.add(b);
                        System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
                        soluzioni.clear();
                    }
                    solveMio(b);
                }
            }
            soluzioniMappa.add(blocchiRisolti);
            //System.out.println(soluzioniMappa.size());

        } else {
            for (int j = b.cells.size() - 1; j >= 0; j--) {
                for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                    c = b.cells.get(j);
                    if (c.checkCellUpdate(i)) {
                        c.updateValueCell(i);
                        if (b.checkBlock()) {
                            soluzioni.add(GameMap.getInstance().valueMatrix);
                            blocchiRisolti.add(b);
                            System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
                            soluzioni.clear();
                            //break;
                        }
                    }
                }
                soluzioniMappa.add(blocchiRisolti);
                //System.out.println(soluzioniMappa.size());
            }
        }
    }

    public void resolve(){
        for (int i = 1; i <= GameMap.getInstance().blocks.size(); i++){
            //Block bl = GameMap.getInstance().blocks.get(i);
            solveMod2();
            //GameMap.getInstance().resetMap();
        }
    }

    public void RisolviMappa() {
        int[][] gm = GameMap.getInstance().valueMatrix.clone();
        for (int i = 1; i <= GameMap.getInstance().blocks.size(); i++) {
            Block bl = GameMap.getInstance().blocks.get(i);
            solveMod(bl);
            soluzioniMappa.add(new ArrayList<>(blocchiRisolti));
            blocchiRisolti.clear();
        } solution();
        /*
        for (int i = 1; i <= GameMap.getInstance().blocks.size(); i++) {
            Block bl1 = GameMap.getInstance().blocks.get(i);
            for (int j = 0; j < soluzioniMappa.get(i).size(); j++) {
                bl1 = soluzioniMappa.get(i).get(j);
                if (bl1.checkBlock()) break;
            }
        }*/
    }

    public void solution(){
        Block bl = GameMap.getInstance().findEmptyBlock();
        ArrayList<Block> bc= soluzioniMappa.get(bl.getId());
        //if(bl!=null && bc!=null){
            for(Block b : bc){
                if(b.checkBlock()){
                    boolean flag=true;
                    for(Cell c : b.cells){
                        if(!(c.checkCellUpdate(c.n)))flag=false;
                        }
                    if(flag==true){
                        bl=b;
                        solution();
                    }
                }
            //}
        }
        System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
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

    public void mapIllustration()
    {
        Random n = new Random();
        int x = n.nextInt(solutionMap.size());
        int[][] stampaSol = solutionMap.get(x);
        GameMap.getInstance().valueMatrix=stampaSol;


        /*for(int i=0;i<GameMap.getInstance().mapSide;i++){
            for(int j=0;j<GameMap.getInstance().mapSide;j++){

                GameMap.getInstance().
            }
        }*/
    }
}
