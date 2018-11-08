package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import model.Item;

public class ItemController {

    //maps for items
    public static Map<String, String> w1Map = new LinkedHashMap<>();
    public static Map<String, String> w2Map = new LinkedHashMap<>();

    // error message
    public static String errorMessage;

    // items objects

    public static Item itemW1;
    public static Item itemW2;
    
 
//the method that passes text to item

    public static void setItemFromText() throws IOException {

        String itemFile = "Item.txt";
        //Shows current line
        int currentLine = 0;
        String line;

        //concreate

        

		// concrete instantiation of items to store information for each puzzle
        itemW1 = new Item();
        itemW2 = new Item();
        

		// concrete instantiation of maps to store information for each puzzle
        w1Map = new LinkedHashMap<>();
        w2Map = new LinkedHashMap<>();
        
        BufferedReader reader = new BufferedReader(new FileReader(itemFile));
        while ((line = reader.readLine()) != null) {
            currentLine++;
            String[] lineContent = line.split(":", 2);


            try {
                if (lineContent.length >= 2) {
                    String key = lineContent[0];
                    String value = lineContent[1];
                    if ((currentLine > 0) && (currentLine <= 8)) {
                        w1Map.put(key, value);
                    }
                    if ((currentLine > 10) && (currentLine <= 17)) {
                        w2Map.put(key, value);
                    }
					// set the current map as the value for each Item Map object R1-R8;

                    itemW1.setItemMap(w1Map);
                    itemW2.setItemMap(w2Map);

                }
                else{
                	errorMessage = "Item Class :: Program Beginning.....";
					System.out.println(errorMessage);
                }
                // jb jb

            } catch (Exception a) {
               // errorMessage = " ohhhhhh myyyy something went wrong !!";
                a.printStackTrace();
                System.out.println(errorMessage);

            }
        }
            Item[] itemObjects = {itemW1, itemW2};

            Map [] itemLinkedHashMapObjects = {
                    itemW1.getItemMap(), itemW2.getItemMap()};
            
        	// print key and value side by side as seperate entities
    		for (String keyItem : itemW1.getItemMap().keySet()) {

    			String key = keyItem.toString();
    			String value = itemW1.getItemMap().get(keyItem).toString();
    			//System.out.println( key + " " + value);
    			//System.out.println("");

    		}
          
    		for (int i = 0; i < itemObjects.length; i++) {
    			for (String keyItem : itemObjects[i].getItemMap().keySet()) {

    				String key = keyItem.toString();
    				String value = itemObjects[i].getItemMap().get(keyItem).toString();
    				// System.out.println( key + " " + value);
    				// System.out.println("");

    			}
    		}
    	
    		

         try {
                for (int i = 0; i < itemLinkedHashMapObjects.length; i++) {
                    itemObjects[i].setItemCategory(itemLinkedHashMapObjects[i].get("ItemName").toString());
                    itemObjects[i].setItemName(itemLinkedHashMapObjects[i].get("ItemName").toString());
                    itemObjects[i].setItemID(itemLinkedHashMapObjects[i].get("ItemID").toString());
                    itemObjects[i].setItemDescription(itemLinkedHashMapObjects[i].get("ItemDesc").toString());
                    itemObjects[i].setItemRoomID(itemLinkedHashMapObjects[i].get("ItemRoomID").toString());
                    itemObjects[i].setCharacterCompatibiltiy(itemLinkedHashMapObjects[i].get("CharacterCompatibility").toString());
                    itemObjects[i].setGemValue( itemLinkedHashMapObjects[i].get("Value").toString());
                    itemObjects[i].setStackable(Boolean.parseBoolean(itemLinkedHashMapObjects[i].get("Stackable").toString()));

                }
            } catch (Exception a) {
                a.printStackTrace();
                System.out.print("Error in lines 72++");
            }

       // itemW1.setItemCategory(w1Map.get("ItemCategory"));

        }

    
    
    //getters and setters for the item objects

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
}




