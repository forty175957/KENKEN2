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
                        if (solve()) {
                            return true;
                        }
                        empty.reset();
                    }
                }
                return false;
            } else {
                return true;
            }
        }

 /*       public void solve_old(Block b, ArrayList<Integer> excluded) {
            Cell c;
            int index=0;
            while (!block.checkBlock()) {
                c= block.findEmpty();
                if (c != null) {
                    for (int i = 1; i < GameMap.getInstance().mapSide+1; i++) {
                        if (c.checkCellUpdate(i) && !excluded.contains(i)) {
                            c.updateValueCell(i);
                            if (!(block.checkBlock())) {
                                c=b.cells.get(index);
                                excluded.add(c.n);
                            }
                        }
                        if (i == GameMap.getInstance().mapSide) {
                            backtrack(b, excluded);
                        }
                    }
                }
            }

        }

        private void backtrack(Block b, ArrayList<Integer> excluded) {
            int r = sol.size();
            if (r != 0) {
                System.out.println("R" + r);
                System.out.println("Soluzione: " + sol.toString());
                Cell last = sol.remove(r - 1);
                excluded.add(last.n);
                last.reset();
            }
            solve(b, excluded);
        }*/

        public Risolutore(Block b) {
            block = b;
            sol.clear();

            solve();
        }


    }
