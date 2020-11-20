package EXTRA;
import java.util.Random;
import Core.Util;

public class GeneratoreBlocks {
    Random rand=new Random();
    int side;
    int blocksCount=0;
    int[][] mapBlocks;


    public GeneratoreBlocks(int side){
        this.side=side;
        this .mapBlocks = new int[side][side];
        this.generateBlocks(this.side);
    }

    public int[][] generateBlocks(int dim){
        side=dim;
        int blocksCount=0;
        mapBlocks=new int[side][side];
        genBlocks(0,0,1, rand.nextInt(3)+3);
        return mapBlocks;
    }

    private void genBlocks(int x,int y,int id, int nCells){
        this.blocksCount=id;
        nCells--;
        mapBlocks[x][y]=id;
        if(nCells==0) {
            id++;
            nCells= rand.nextInt(3)+2;
        }
        if(x<side-1 &&mapBlocks[x+1][y]==0){
            genBlocks(x+1,y,id,nCells);
        }
        if(x>0 &&mapBlocks[x-1][y]==0){
            genBlocks(x-1,y,id,nCells);
        }
        if(y<side-1 &&mapBlocks[x][y+1]==0){
            genBlocks(x,y+1,id,nCells);
        }
        if(y>0 &&mapBlocks[x][y-1]==0){
            genBlocks(x,y-1,id,nCells);
        }
    }


    public static  void main(String[] args) {
        GeneratoreBlocks g = new GeneratoreBlocks(6);
        System.out.println("BLOCKS MAP");
        System.out.println(Util.MatrixToString(g.mapBlocks));
    }

}
