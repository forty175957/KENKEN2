import java.util.ArrayList;

public class Risolutore {
        public ArrayList<Cell> sol = new ArrayList<Cell>();
        private Block block;
        private ArrayList<Integer> excluded = new ArrayList<>();

        public boolean solve() {
            Cell empty = block.findEmpty();
            if (empty != null) {
                for (int i = 0; i < GameMap.getInstance().mapSide + 1; i++) {
                    if (empty.checkCellUpdate(i)) {
                        empty.updateValueCell(i);
                        if (solve() && block.checkBlock()) {
                            return true;
                        }else {
                            empty.reset();
                            return  false;
                        }
                    }
                }
            }
            return true;
        }

        public Risolutore(Block b) {
            block = b;
            sol.clear();
            solve();
        }


    }
