package controller;

import model.Monster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MonsterController {

    public static Map<String, String> m1Map = new LinkedHashMap<>();
    public static Map<String, String> m2Map = new LinkedHashMap<>();
    public static Map<String, String> m3Map = new LinkedHashMap<>();
    public static Map<String, String> m4Map = new LinkedHashMap<>();
    public static Map<String, String> m5Map = new LinkedHashMap<>();
    public static Map<String, String> m6Map = new LinkedHashMap<>();
    public static Map<String, String> m7Map = new LinkedHashMap<>();
    public static Map<String, String> m8Map = new LinkedHashMap<>();

    //error message
    public static String errorMessage;

    //items object

    public static Monster m1Monster, m2Monster, m3Monster, m4Monster, m5Monster, m6Monster, m7Monster, m8Monster;

    // the method that passe to text

    public static void setMonsterFromText() throws IOException{

        String itemFile = "Monster.txt";
        int currentLine = 0;
        String line;


        m1Monster = new Monster();
        m2Monster = new Monster();
        m3Monster = new Monster();
        m4Monster = new Monster();
        m5Monster = new Monster();
        m6Monster = new Monster();
        m7Monster = new Monster();
        m8Monster = new Monster();

        m1Map = new LinkedHashMap<>();
        m2Map = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(itemFile));
        while ((line = reader.readLine())!= null){
            currentLine++;
            String[] lineContent = line.split(":", 2);

            try {
                if (lineContent.length>=2){
                    String key = lineContent[0];
                    String value = lineContent [1];
                    if ((currentLine >0 ) && (currentLine<= 11)){
                        m2Map.put(key, value);
                    }
                    if ((currentLine >=0 ) && (currentLine<= 11)){
                        m2Map.put(key, value);
                    }
                    if ((currentLine >=0 ) && (currentLine<= 11)){
                        m2Map.put(key, value);
                    }
                    if ((currentLine >=0 ) && (currentLine<= 11)){
                        m2Map.put(key, value);
                    }
                    if ((currentLine >=0 ) && (currentLine<= 11)){
                        m2Map.put(key, value);
                    }
                    if ((currentLine >=0 ) && (currentLine<= 11)){
                        m2Map.put(key, value);
                    }
                    if ((currentLine >=0 ) && (currentLine<= 11)){
                        m2Map.put(key, value);
                    }
                    if ((currentLine >=0 ) && (currentLine<= 11)){
                        m2Map.put(key, value);
                    }

                    m1Monster.setMonsterMap(m1Map);


                }
            }

        }






    }

}
