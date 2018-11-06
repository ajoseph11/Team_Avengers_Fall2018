package controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ItemController {

    //maps for items
    public static Map<String, String> w1Map = new LinkedHashMap<>();
    public static Map<String, String> w2Map = new LinkedHashMap<>();

    // error message
    public static String errorMessage;

    // items objects

    public static Item itemW1;
    public static Item itemW2;

    public static Item getItemW2() {
        return itemW2;
    }

    public static void setItemW2(Item itemW2) {
        ItemController.itemW2 = itemW2;
    }

    public static Item getItemW1() {
        return itemW1;
    }

    public static void setItemW1(Item itemW1) {
        ItemController.itemW1 = itemW1;
    }
//the method that passes text to item

    public static void setItemFromText() throws IOException {

        String itemFile = "Item.txt";
        //Shows current line
        int currentLine = 0;
        String line;

        //concreate

        itemW1 = new Item();
        itemW2 = new Item();

        BufferedReader reader = new BufferedReader(new FileReader(itemFile));
        while ((line = reader.readLine()) != null) {
            currentLine++;
            String[] lineConent = line.split(":", 2);


            try {
                if (lineConent.length >= 2) {
                    String key = lineConent[0];
                    String value = lineConent[1];
                    if ((currentLine >= 1) && (currentLine <= 8)) {
                        w1Map.put(key, value);
                    }
                    if ((currentLine >= 10) && (currentLine <= 17)) {
                        w2Map.put(key, value);
                    }
                    itemW1.setItemMap(w1Map);
                    itemW2.setItemMap(w2Map);

                }
                else{
                    System.out.println("Room Item Controller ::  Begins");
                }
                // jb jb

            } catch (Exception a) {
                errorMessage = " ohhhhhh myyyy something went wrong !!";
                a.printStackTrace();
                System.out.println(errorMessage);

            }
            Item[] itemObjects = {itemW1, itemW2};

            Map[] itemLinkedMapObjects = {
                    itemW1.getItemMap(), itemW2.getItemMap()};

         try {
                for (int i = 0; i < itemObjects.length; i++) {
                    itemObjects[i].setItemCategory(itemLinkedMapObjects[i].get("ItemCategory").toString());
                    itemObjects[i].setItemName(itemLinkedMapObjects[i].get("ItemName").toString());
                    itemObjects[i].setItemID(itemLinkedMapObjects[i].get("ItemID").toString());
                    itemObjects[i].setItemDescription(itemLinkedMapObjects[i].get("ItemDesc").toString());
                    itemObjects[i].setItemRoomID(itemLinkedMapObjects[i].get("ItemRoomID").toString());
                    itemObjects[i].setCharacterCompatibiltiy(itemLinkedMapObjects[i].get("CharacterCompatibility").toString());
                    itemObjects[i].setGemValue( itemLinkedMapObjects[i].get("Value").toString());
                    itemObjects[i].setStackable(Boolean.parseBoolean(itemLinkedMapObjects[i].get("Stackable").toString()));

                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("Error in lines 72++");
            }

       // itemW1.setItemCategory(w1Map.get("ItemCategory"));

        }

    }
}




