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
    public static Map<String, String> w3Map = new LinkedHashMap<>();
    public static Map<String, String> w4Map = new LinkedHashMap<>();
    public static Map<String, String> w5Map = new LinkedHashMap<>();
    public static Map<String, String> w6Map = new LinkedHashMap<>();
    public static Map<String, String> w7Map = new LinkedHashMap<>();//w
    public static Map<String, String> a1Map = new LinkedHashMap<>();
    public static Map<String, String> a2Map = new LinkedHashMap<>();
    public static Map<String, String> a3Map = new LinkedHashMap<>();
    public static Map<String, String> a4Map = new LinkedHashMap<>();
    public static Map<String, String> a5Map = new LinkedHashMap<>();//a
    public static Map<String, String> d1Map = new LinkedHashMap<>();
    public static Map<String, String> d2Map = new LinkedHashMap<>();
    public static Map<String, String> d3Map = new LinkedHashMap<>();
    public static Map<String, String> d4Map = new LinkedHashMap<>();
    public static Map<String, String> d5Map = new LinkedHashMap<>();
    public static Map<String, String> d6Map = new LinkedHashMap<>();
    public static Map<String, String> d7Map = new LinkedHashMap<>();//d
    public static Map<String, String> k11Map = new LinkedHashMap<>();
    public static Map<String, String> k12Map = new LinkedHashMap<>();
    public static Map<String, String> k13Map = new LinkedHashMap<>();
    public static Map<String, String> k15Map = new LinkedHashMap<>();//k
    public static Map<String, String> c1Map = new LinkedHashMap<>();//c

    // error message
    public static String errorMessage;

    // items objects

    public static Item itemW1, itemW2,itemW3,itemW4, itemW5,itemW6,itemW7,
    itema1,itema2,itema3,itema4,itema5,itemd1,itemd2,itemd3,itemd4,itemd5,itemd6,itemd7,
    itemk11, itemk12, itemk13, itemk15, itemc1;
    
 
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
        itemW3 = new Item();
        itemW4 = new Item();
        itemW5 = new Item();
        itemW6 = new Item();
        itemW7 = new Item();
        itema1 = new Item();
        itema2 = new Item();
        itema3 = new Item();
        itema4 = new Item();
        itema5 = new Item();
        itemd1 = new Item();
        itemd2 = new Item();
        itemd3 = new Item();
        itemd4 = new Item();
        itemd5 = new Item();
        itemd6 = new Item();
        itemd7 = new Item();
        itemk11 = new Item();
        itemk12 = new Item();
        itemk13 = new Item();
        itemk15 = new Item();
        itemc1 = new Item();
        

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
                    if ((currentLine >= 10) && (currentLine <= 17)) {
                        w2Map.put(key, value);
                    }
                    if ((currentLine >= 19) && (currentLine <= 26)) {
                        w3Map.put(key, value);
                    }
                    
                    if ((currentLine >= 28) && (currentLine <= 35)) {
                        w4Map.put(key, value);
                    }
                    if ((currentLine >= 37) && (currentLine <= 44)) {
                        w5Map.put(key, value);
                    }
                    
                    if ((currentLine >= 46) && (currentLine <= 53)) {
                        w6Map.put(key, value);
                    }
                    if ((currentLine >= 55) && (currentLine <= 62)) {
                        w7Map.put(key, value);
                    }
                    if ((currentLine >= 64) && (currentLine <= 71)) {
                        a1Map.put(key, value);
                    }
                    if ((currentLine >= 73) && (currentLine <= 80)) {
                        a2Map.put(key, value);
                    }
                    if ((currentLine >= 82) && (currentLine <= 89)) {
                        a3Map.put(key, value);
                    }
                    if ((currentLine >= 91) && (currentLine <= 98)) {
                        a4Map.put(key, value);
                    }
                    if ((currentLine >= 100) && (currentLine <= 107)) {
                        a5Map.put(key, value);
                    }
                    if ((currentLine >= 109) && (currentLine <= 116)) {
                        d1Map.put(key, value);
                    }
                    if ((currentLine >= 118) && (currentLine <= 125)) {
                        d2Map.put(key, value);
                    }
                    if ((currentLine >= 127) && (currentLine <= 134)) {
                        d3Map.put(key, value);
                    }
                    if ((currentLine >= 136) && (currentLine <= 143)) {
                        d4Map.put(key, value);
                    }
                    if ((currentLine >= 145) && (currentLine <= 152)) {
                        d5Map.put(key, value);
                    }
                    if ((currentLine >= 154) && (currentLine <= 161)) {
                        d6Map.put(key, value);
                    }
                    if ((currentLine >= 163) && (currentLine <= 170)) {
                        d7Map.put(key, value);
                    }
                    if ((currentLine >= 172) && (currentLine <= 179)) {
                        k11Map.put(key, value);
                    }
                    if ((currentLine >= 181) && (currentLine <= 188)) {
                        k12Map.put(key, value);
                    }
                    if ((currentLine >= 190) && (currentLine <= 197)) {
                        k13Map.put(key, value);
                    }
                    if ((currentLine >= 199) && (currentLine <= 206)) {
                        k15Map.put(key, value);
                    }
                    if ((currentLine >= 208) && (currentLine <= 215)) {
                        c1Map.put(key, value);
                    }
					// set the current map as the value for each Item Map object R1-R8;

                    itemW1.setItemMap(w1Map);
                    itemW2.setItemMap(w2Map);
                    itemW3.setItemMap(w3Map);
                    itemW4.setItemMap(w4Map);
                    itemW5.setItemMap(w5Map);
                    itemW6.setItemMap(w6Map);
                    itemW7.setItemMap(w7Map);
                    itema1.setItemMap(a1Map);
                    itema2.setItemMap(a2Map);
                    itema3.setItemMap(a3Map);
                    itema4.setItemMap(a4Map);
                    itema5.setItemMap(a5Map);
                    itemd1.setItemMap(d1Map);
                    itemd2.setItemMap(d2Map);
                    itemd3.setItemMap(d3Map);
                    itemd4.setItemMap(d4Map);
                    itemd5.setItemMap(d5Map);
                    itemd6.setItemMap(d6Map);
                    itemd7.setItemMap(d7Map);
                    itemk11.setItemMap(k11Map);
                    itemk12.setItemMap(k12Map);
                    itemk13.setItemMap(k13Map);
                    itemk15.setItemMap(k15Map);
                    itemc1.setItemMap(c1Map);
                    

               /*     w1Map,
                    w2Map,
                    w3Map,
                    w4Map,
                    w5Map,
                    w6Map,
                    w7Map,
                    a1Map,
                    a2Map,
                    a3Map,
                    a4Map,
                    a5Map,
                    d1Map,
                    d2Map,
                    d3Map,
                    d4Map,
                    d5Map,
                    d6Map,
                    d7Map,
                    k11Map,
                    k12Map,
                    k13Map,
                    k15Map,
                    c1Map*/



                    

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
            Item[] itemObjects = {itemW1, itemW2,itemW3,itemW4, itemW5,itemW6,itemW7,
            	    itema1,itema2,itema3,itema4,itema5,itemd1,itemd2,itemd3,itemd4,itemd5,itemd6,itemd7,
            	    itemk11, itemk12, itemk13, itemk15, itemc1};

            
			Map []  itemLinkedHashMapObjects = {
                    itemW1.getItemMap(), itemW2.getItemMap(), itemW3.getItemMap(), itemW4.getItemMap(), itemW5.getItemMap() , itemW6.getItemMap()  , itemW7.getItemMap(),
                    itema1.getItemMap(),itema2.getItemMap(),itema3.getItemMap(),itema4.getItemMap(),itema5.getItemMap(),itemd1.getItemMap(),itemd2.getItemMap(),itemd3.getItemMap(),itemd4.getItemMap(),itemd5.getItemMap(),itemd6.getItemMap(),itemd7.getItemMap(),
                    itemk11.getItemMap(), itemk12.getItemMap(), itemk13.getItemMap(), itemk15.getItemMap(), itemc1.getItemMap()        
            };
            
        	// print key and value side by side as seperate entities
    	for (String keyItem : itemW1.getItemMap().keySet()) {

    			//String key = keyItem.toString();
    			//String value = itemW1.getItemMap().get(keyItem).toString();
    			//System.out.println( key + " " + value);
    			//System.out.println("");

    		}
          
    		for (int i = 0; i < itemObjects.length; i++) {
    			for (String keyItem : itemObjects[i].getItemMap().keySet()) {

    				String key = keyItem.toString();
    				String value = itemObjects[i].getItemMap().get(keyItem).toString();
    				System.out.println( key + " " + value);
    				// System.out.println("");

    			}
    		}
    	
    		

         try {
                for (int i = 0; i < itemLinkedHashMapObjects.length; i++) {
                    itemObjects[i].setItemCategory(itemLinkedHashMapObjects[i].get("ItemCategory").toString());
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


	public static Item getItemW1() {
		return itemW1;
	}


	public static void setItemW1(Item itemW1) {
		ItemController.itemW1 = itemW1;
	}


	public static Item getItemW2() {
		return itemW2;
	}


	public static void setItemW2(Item itemW2) {
		ItemController.itemW2 = itemW2;
	}


	public static Item getItemW3() {
		return itemW3;
	}


	public static void setItemW3(Item itemW3) {
		ItemController.itemW3 = itemW3;
	}


	public static Item getItemW4() {
		return itemW4;
	}


	public static void setItemW4(Item itemW4) {
		ItemController.itemW4 = itemW4;
	}


	public static Item getItemW5() {
		return itemW5;
	}


	public static void setItemW5(Item itemW5) {
		ItemController.itemW5 = itemW5;
	}


	public static Item getItemW6() {
		return itemW6;
	}


	public static void setItemW6(Item itemW6) {
		ItemController.itemW6 = itemW6;
	}


	public static Item getItemW7() {
		return itemW7;
	}


	public static void setItemW7(Item itemW7) {
		ItemController.itemW7 = itemW7;
	}


	public static Item getItema1() {
		return itema1;
	}


	public static void setItema1(Item itema1) {
		ItemController.itema1 = itema1;
	}


	public static Item getItema2() {
		return itema2;
	}


	public static void setItema2(Item itema2) {
		ItemController.itema2 = itema2;
	}


	public static Item getItema3() {
		return itema3;
	}


	public static void setItema3(Item itema3) {
		ItemController.itema3 = itema3;
	}


	public static Item getItema4() {
		return itema4;
	}


	public static void setItema4(Item itema4) {
		ItemController.itema4 = itema4;
	}


	public static Item getItema5() {
		return itema5;
	}


	public static void setItema5(Item itema5) {
		ItemController.itema5 = itema5;
	}


	public static Item getItemd1() {
		return itemd1;
	}


	public static void setItemd1(Item itemd1) {
		ItemController.itemd1 = itemd1;
	}


	public static Item getItemd2() {
		return itemd2;
	}


	public static void setItemd2(Item itemd2) {
		ItemController.itemd2 = itemd2;
	}


	public static Item getItemd3() {
		return itemd3;
	}


	public static void setItemd3(Item itemd3) {
		ItemController.itemd3 = itemd3;
	}


	public static Item getItemd4() {
		return itemd4;
	}


	public static void setItemd4(Item itemd4) {
		ItemController.itemd4 = itemd4;
	}


	public static Item getItemd5() {
		return itemd5;
	}


	public static void setItemd5(Item itemd5) {
		ItemController.itemd5 = itemd5;
	}


	public static Item getItemd6() {
		return itemd6;
	}


	public static void setItemd6(Item itemd6) {
		ItemController.itemd6 = itemd6;
	}


	public static Item getItemd7() {
		return itemd7;
	}


	public static void setItemd7(Item itemd7) {
		ItemController.itemd7 = itemd7;
	}


	public static Item getItemk11() {
		return itemk11;
	}


	public static void setItemk11(Item itemk11) {
		ItemController.itemk11 = itemk11;
	}


	public static Item getItemk12() {
		return itemk12;
	}


	public static void setItemk12(Item itemk12) {
		ItemController.itemk12 = itemk12;
	}


	public static Item getItemk13() {
		return itemk13;
	}


	public static void setItemk13(Item itemk13) {
		ItemController.itemk13 = itemk13;
	}


	public static Item getItemk15() {
		return itemk15;
	}


	public static void setItemk15(Item itemk15) {
		ItemController.itemk15 = itemk15;
	}


	public static Item getItemc1() {
		return itemc1;
	}


	public static void setItemc1(Item itemc1) {
		ItemController.itemc1 = itemc1;
	}

    
    
    //getters and setters for the item objects

  
}




