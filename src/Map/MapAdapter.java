package Map;
import Core.Mediator;

public abstract class MapAdapter {
    public abstract MapModel load();
    public abstract void save(MapModel map);

}
