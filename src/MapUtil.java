import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;

public class MapUtil {

    public static void load() {
        String s=loadFile();
        System.out.println(s);
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(s);
            JSONObject data = (JSONObject) obj;
            int[][] mat = Matrix.StringtoMatrix((String) data.get("matrix"), 5);
            GameMap.getInstance().map = mat;
            int[][] values = Matrix.StringtoMatrix((String) data.get("values"), 5);
            GameMap.getInstance().valueMatrix = values;
            String[] res=Matrix.StringToList((String) data.get("results"));
            GameMap.getInstance().setResult(res);
            String[] op = Matrix.StringToList((String) data.get("operators"));
            GameMap.getInstance().setOperator(op);

            //inizializzo GameMap
            new KenKenMap(5,5);
            GameMap.getInstance().updateBlocks(op,res);
            GameMap.getInstance().initGmap();

        }catch (Exception e){
            e.printStackTrace();
        }


    }



    public static String save() {
        JSONObject obj = new JSONObject();
        int[][] MATRIX = GameMap.getInstance().map;
        int[][] values = GameMap.getInstance().getValues();
        String[] result=GameMap.getInstance().getResult();
        String[] operators = GameMap.getInstance().getOperators();
        obj.put("matrix", Matrix.MatrixToString(MATRIX));
        obj.put("values", Matrix.MatrixToString(values));
        obj.put("operators", Matrix.ListToString(operators));
        obj.put("results",Matrix.ListToString(result));
        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonString = obj.toJSONString();
        System.out.println(jsonString);
        return jsonString;
    }

    private static String loadFile(){
        String s="";
        JFileChooser fileChooser = new JFileChooser();
        int n = fileChooser.showOpenDialog(new JPanel());
        File f = fileChooser.getSelectedFile();
        try {
            FileReader fInput = new FileReader(f);
            BufferedReader inStream = new BufferedReader(fInput);
            String text;
            while((text=inStream.readLine()) != null){
                s+=text;
            }
            System.out.println(s);
            System.out.println("---------------------");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return s;
    }
}
