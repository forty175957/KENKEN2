import java.awt.color.ICC_Profile;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Map {
    public static int[][] MATRIX;
    public static ArrayList<Block> blocks;

    public static int[][] load(String s){
        JSONParser parser = new JSONParser();
        int[][] matrix=new int[3][3];

        try{
            Object obj = parser.parse(s);
            JSONObject data = (JSONObject) obj;
            matrix= (int[][]) data.get("matrix");
        }catch(ParseException pe) {

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
        return matrix;

    }

    public static String save(int[][] MATRIX, HashMap<Integer,Block> blocks){
        JSONObject obj = new JSONObject();

        obj.put("matrix", MATRIX);
        obj.put("blocks",blocks);

        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        }catch(Exception e){
            e.printStackTrace();
        }
        String result= out.toString();
        System.out.println(result);
        return result;
    }

}
