import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;

public interface MapInterface {
    public Mediator med = Mediator.getInstance();

    public void load();
    public void save();

}
