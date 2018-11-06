package controller;

import model.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ItemController {

    //maps for items
    public static Map<String,String> w1Map = new LinkedHashMap<>();





    // error message
    public static String errorMessage;

    // items objects
    public static Item itemW1;

    //the method that passes text to item

    public static void setItemFromText() throws IOException{

        String itemFile= "Item.txt";
        //Shows current line
        int currentLine= 0;
        String line;

        //concreate

        itemW1 = new Item();

        BufferedReader reader = new BufferedReader( new FileReader(itemFile));
        while((line = reader.readLine())!= null){
            currentLine++;
            String[] lineConent = line.split(":", 2);


            try{
                if (lineConent.length>=2){
                    String key = lineConent[0];
                    String value = lineConent[1];
                    if ((currentLine >=1) && (currentLine >=8)){
                        w1Map.put(key, value);
                    }
                }
                // jb jb
                itemW1.setItemMap(w1Map);

        }
        catch ( Exception a){
                errorMessage= " ohhhhhh myyyy something went wrong !!";
                a.printStackTrace();
                System.out.println(errorMessage);

        }

        }

    }
}

