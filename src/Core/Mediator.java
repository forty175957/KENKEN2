package Core;

import EXTRA.BlocksBuilder;
import Map.GameMap;
import Map.JsonMapAdapter;
import Map.MapAdapter;
import Map.MapModel;
import UI.NewMapMenu;

import javax.swing.*;

public class Mediator {
    private static Mediator ISTANCE;
    private MapAdapter loader = new JsonMapAdapter();
    private JFrame frame;
    private GameMap map;

    private Mediator() {
        map=new GameMap();
    }

    public static Mediator getInstance() {
        if (ISTANCE == null) {
            ISTANCE = new Mediator();
        }
        return ISTANCE;
    }

    public void resetMap(){
        Mediator.getInstance().getMap().resetMap();
    }

    public void loadMenu(){
        new NewMapMenu();
    }
    public void loadMap(){
        MapModel map = loader.load();
        this.map.loadMap(map);
    }

    public void saveMap(){
        MapModel map = this.map.dumpMap();
        loader.save(map);
    }

    public void loadNewMap(int side){
        BlocksBuilder bb = new BlocksBuilder(side);
        MapModel map = bb.build();
        this.map.loadMap(map);
    }

    public void resolveMap() {
        new Risolutore().solve();
    }

    public void exit(){
        System.exit(0);
    }

    public void setFrame(JFrame f) {
        frame = f;
    }

    public JFrame getFrame() {
        return frame;
    }

    public GameMap getMap(){
        return this.map;
    }

}
