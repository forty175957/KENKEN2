import java.util.ArrayList;

public class Risolutore {
        public ArrayList<Cell> sol = new ArrayList<Cell>();
        private Block block;
        private ArrayList<Integer> excluded = new ArrayList<>();

        public void solve(Block b, ArrayList<Integer> excluded) {
            Cell c = b.findEmpty();
            int index=0;
            if (c != null) {
                while (!block.checkBlock()) {
                    for (int i = 1; i < GameMap.getInstance().mapSide + 1; i++) {
                        if (c.checkCellUpdate(i) && !excluded.contains(i)) {
                            c.updateValueCell(i);
                            c = b.findEmpty();
                            if (c == null || index < block.cells.size() && !(block.checkBlock())) {
                                c=b.cells.get(index);
                                excluded.add(c.n);
                                index+=1;
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
        }

        public Risolutore(Block b) {
            block = b;
            sol.clear();
            Cell empty = block.findEmpty();
            solve(b, excluded);
        }


    }
