import javax.swing.*;
import java.io.IOError;
import java.util.ArrayList;

public class Risolutore {
    public ArrayList<Cell> sol = new ArrayList<Cell>();
    private Block block;
    private ArrayList<Integer> excluded = new ArrayList<>();
    ArrayList<int[][]> soluzioni = new ArrayList<>();
    ArrayList<Block> blocchiRisolti= new ArrayList<>();
    ArrayList<ArrayList<Block>> soluzioniMappa = new ArrayList<>();

    public boolean solve() {
        Cell empty = block.findEmpty();
        if (empty != null) {
            for (int i = 0; i < GameMap.getInstance().mapSide + 1; i++) {
                if (empty.checkCellUpdate(i)) {
                    empty.updateValueCell(i);
                    if (solve() && block.checkBlock()) {
                        return true;
                    } else {
                        empty.reset();
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public Risolutore(Block b) {
        block = b;
        sol.clear();
        int index =0;
        for(Cell c:block.cells) solveMio(b);
    }

    public void solveMio(Block b) {
        Cell c = b.findEmpty();
        if (c!=null) {
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
            System.out.print(soluzioniMappa.size());

        }
        else {
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
                        }
                    }
                }
                soluzioniMappa.add(blocchiRisolti);
                System.out.print(soluzioniMappa.size());
            }
        }
    }

    /*public void RisolviMappa() {
        for (int i = 1; i <= GameMap.getInstance().blocks.size(); i++) {
            Block bl = GameMap.getInstance().blocks.get(i);
            for()

        }
    }*/
}