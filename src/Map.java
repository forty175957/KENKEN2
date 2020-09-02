import java.awt.color.ICC_Profile;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Map {

    /*public static int[][] load(String s){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(s);
            JSONObject data = (JSONObject) obj;
            int[][] mat= Matrix.toMatrix((String) data.get("matrix"),5);
            GameMap.getInstance().map=mat;
            int[][] values=Matrix.toMatrix((String) data.get("values"),5);
            GameMap.getInstance().valueMatrix=values;
            //HashMap<int,String> op=(HashMap<int,String>) data.get("operators");
            //for (int i=1;i<op.size()+1;i++) {
            //    GameMap.getInstance().blocks.get(i).setOperation(op.get(i));
            //}
        }catch(ParseException pe) {

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
        return mat;

    }

    public static String save(){
        JSONObject obj = new JSONObject();
        int[][] MATRIX=GameMap.getInstance().map;
        int[][] values=GameMap.getInstance().getValues();
        HashMap<int,String> operators=GameMap.getInstance().getOperators();
        obj.put("matrix", Matrix.toString(MATRIX));
        obj.put("values",values);
        obj.put("operators",operators);
        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        }catch(Exception e){
            e.printStackTrace();
        }
        String result= obj.toJSONString();
        System.out.println(result);
        return result;

    }
*/
}
