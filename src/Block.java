import java.awt.*;
import java.util.ArrayList;

public class Block {
    public ArrayList<Cell> cells;
    public String operation;
    public int resultValue;
    private int blockId;
    private GameMap Gmap = GameMap.getInstance();

    public Block(int blockId) {
        this.blockId = blockId;
        this.cells = new ArrayList<Cell>();
    }

    public void setAll(String OP, int val) {
        operation = OP;
        resultValue = val;
    }

    public void setOperation(String OP) {
        operation = OP;
    }

    public void setResultValue(int val) {
        resultValue = val;
        System.out.println("id:" + blockId + " op:" + operation + " res:" + resultValue);
    }

    public int getBlockSize() {
        return cells.size();
    }

    public int getId() {
        return blockId;
    }

    public Cell addCell(int x, int y) {
        Cell cell;
        cell = new Cell(x, y, this);
        cells.add(cell);
        Gmap.getFrame().getContentPane().add(cell);
        return cell;
    }

    public void completedBlock(boolean comp) {
        for (Cell c : cells) {
            c.completed = comp;
            c.repaint();
        }
    }

    public Cell findEmpty() {
        Cell result = null;
        for (Cell c : cells) {
            if (c.n == 0) {
                result = c;
                break;
            }
        }
        return result;
    }

    public Cell getCell(int x, int y) {
        Cell cell = null;
        for (Cell c : cells) {
            if (c.x == x && c.y == y) cell = c;
        }
        return cell;
    }

    public boolean checkBlock() {
        int result = 0;

        switch (operation) {
            case "+":
                for (Cell c : cells) {
                    result = result + c.n;
                    if (result > resultValue) return false;
                    if (result == resultValue) {
                        //System.out.println("block " + blockId + " completed!!" + result);
                        //System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
                        return true;
                    }
                }
                break;
            case "*":
                for (Cell c : cells) {
                    if (c.n == 0) {
                        result = 0;
                        return false;
                    }
                    if (result == 0) result = c.n;
                    else result = result * c.n;
                    if (result > resultValue) return false;
                    if (result == resultValue) {
                        //System.out.println("block " + blockId + " completed!!" + result);
                        //System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
                        return true;
                    }

                }
                break;
            case "-":
                for (Cell c : cells) {
                    if (c.n != 0) {
                        result = c.n;
                        for (Cell c2 : cells) {
                            if (c != c2) {
                                result -= c2.n;
                            }
                        }
                        if (result == resultValue) {
                            //System.out.println("block " + blockId + " completed!!" + result);
                            //System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));

                            return true;
                        }
                    }
                }
                break;
            case "/":
                for (Cell c : cells) {
                    if (c.n != 0) {
                        result = c.n;
                        for (Cell c2 : cells) {
                            if (c.n != c2.n) {
                                result /= c2.n;
                            }
                        }
                        if (result == resultValue) {
                            //System.out.println("block " + blockId + " completed!!" + result);
                            //System.out.println(Matrix.MatrixToString(GameMap.getInstance().valueMatrix));
                            return true;
                        }
                    }
                }
                break;
        }
        //System.out.println(result + "  " + resultValue);
        return false;
    }
}


/* public boolean checkBlockMio(){
        int result=0;
        int index =0;

        switch(operation) {
            case "+":
                for (Cell c : cells) {
                    index+=1;
                    if (!(c.n == 0)) {
                        result = result + c.n;
                        if (result > resultValue) return false;
                        if (result == resultValue && index==cells.size()) {
                            System.out.println("block " + blockId + " completed!!" + result);
                            return true;
                        }
                    }
                }
                index=0;
                break;
            case "*":
                for (Cell c : cells) {
                    index+=1;
                    if(c.n==0) {
                        result=0;
                        return false;
                    }
                    if (result == 0) result = c.n;
                    else result = result * c.n;
                    if (result > resultValue) return false;
                    if (result == resultValue && index==cells.size()) {
                        System.out.println("block " + blockId + " completed!!" + result);
                        return true;
                    }

                }
                index=0;
                break;
            case "-":
                for (Cell c : cells) {
                    index+=1;
                    if(c.n!=0) {
                        result = c.n;
                        for (Cell c2 : cells) {
                            if (c != c2) {
                                result -= c2.n;
                            }
                        }
                        if (result == resultValue && index==cells.size()) {
                            System.out.println("block " + blockId + " completed!!" + result);
                            return true;
                        }
                    }
                }
                index=0;
                break;
            case "/":
                for (Cell c : cells) {
                    index+=1;
                    if(c.n!=0) {
                        result = c.n;
                        for (Cell c2 : cells) {
                            if (c.n != c2.n) {
                                result /= c2.n;
                            }
                        }
                        if (result == resultValue && index==cells.size()) {
                            System.out.println("block " + blockId + " completed!!" + result);
                            return true;
                        }
                    }
                }
                index=0;
                break;
        }
        System.out.println(result + "  " + resultValue);
        return false;
    }
 */
