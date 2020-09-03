import java.util.ArrayList;

public class Risolutore {
        public ArrayList<Cell> sol = new ArrayList<Cell>();
        private Block block;
        private ArrayList<Integer> excluded = new ArrayList<>();

        public boolean solve(Cell empty) {
            if (block.checkBlock()) {
                return true;
            }
            if (empty != null) {
                for (int i = 1; i < GameMap.getInstance().mapSide+1; i++) {
                    if (empty.checkCellUpdate(i)) {
                        empty.updateValueCell(i);
                        if (solve(empty)) {
                            return true;
                        }
                        empty.reset();
                        if (i == GameMap.getInstance().mapSide) {
                            empty.updateValueCell(1);
                            empty.reset();
                            Cell c = block.findEmpty();
                            solve(c);
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
            solve(block.findEmpty());
        }


    }
