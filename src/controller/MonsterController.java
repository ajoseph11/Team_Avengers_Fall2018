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
        while ((line = reader.readLine())!= null) {
            currentLine++;
            String[] lineContent = line.split(":", 2);

            try {
                if (lineContent.length >= 2) {
                    String key = lineContent[0];
                    String value = lineContent[1];
                    if ((currentLine > 0) && (currentLine <= 11)) {
                        m1Map.put(key, value);
                    }
                    if ((currentLine >= 13) && (currentLine <= 23)) {
                        m2Map.put(key, value);
                    }
                    if ((currentLine >= 25) && (currentLine <= 35)) {
                        m3Map.put(key, value);
                    }
                    if ((currentLine >= 37) && (currentLine <= 47)) {
                        m4Map.put(key, value);
                    }
                    if ((currentLine >= 49) && (currentLine <= 59)) {
                        m5Map.put(key, value);
                    }
                    if ((currentLine >= 61) && (currentLine <= 71)) {
                        m6Map.put(key, value);
                    }
                    if ((currentLine >= 73) && (currentLine <= 83)) {
                        m7Map.put(key, value);
                    }
                    if ((currentLine >= 85) && (currentLine <= 95)) {
                        m8Map.put(key, value);
                    }

                    m1Monster.setMonsterMap(m1Map);
                    m2Monster.setMonsterMap(m2Map);
                    m3Monster.setMonsterMap(m3Map);
                    m4Monster.setMonsterMap(m4Map);
                    m5Monster.setMonsterMap(m5Map);
                    m6Monster.setMonsterMap(m6Map);
                    m7Monster.setMonsterMap(m7Map);
                    m8Monster.setMonsterMap(m8Map);


                } else {
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
        Monster[] monsterObjects = {m1Monster, m2Monster, m3Monster, m4Monster, m5Monster, m6Monster, m7Monster, m8Monster};

        Map []  monsterLinkedHashMapObjects = { m1Monster.getMonsterMap(), m2Monster.getMonsterMap(), m3Monster.getMonsterMap(),
                m4Monster.getMonsterMap(), m5Monster.getMonsterMap(), m6Monster.getMonsterMap(), m7Monster.getMonsterMap(),
                m8Monster.getMonsterMap()};
        for (String keyItem : m1Monster.getMonsterMap().keySet()) {

        }

        for (int i = 0; i < monsterObjects.length; i++) {
            for (String keyItem : monsterObjects[i].getMonsterMap().keySet()) {

                String key = keyItem.toString();
                String value = monsterObjects[i].getMonsterMap().get(keyItem).toString();

            }
        }
        try {
            for (int i = 0; i < monsterLinkedHashMapObjects.length; i++) {
                monsterObjects[i].setMonsterName(monsterLinkedHashMapObjects[i].get("MonsterName").toString());
                monsterObjects[i].setRoomLocation(monsterLinkedHashMapObjects[i].get("RoomLocation").toString());
                monsterObjects[i].setItemsDrop(monsterLinkedHashMapObjects[i].get("ItemsDrop").toString());
                monsterObjects[i].setValueGain(monsterLinkedHashMapObjects[i].get("ValueGain").toString());
                monsterObjects[i].setArmor(monsterLinkedHashMapObjects[i].get("Armor").toString());
                monsterObjects[i].setMonsterHealth(monsterLinkedHashMapObjects[i].get("MonsterHealth").toString());
                monsterObjects[i].setCanAttack(Boolean.parseBoolean(monsterLinkedHashMapObjects[i].get("Attack").toString()));
                monsterObjects[i].setCanDefend(Boolean.parseBoolean(monsterLinkedHashMapObjects[i].get("Defend").toString()));
                monsterObjects[i].setHealthLoss(monsterLinkedHashMapObjects[i].get("HealthLoss").toString());
                monsterObjects[i].setValueLoss(monsterLinkedHashMapObjects[i].get("ValueLoss").toString());
                monsterObjects[i].setMonsterDesc(monsterLinkedHashMapObjects[i].get("MonsterDesc").toString());




            }
        } catch (Exception a) {
            a.printStackTrace();
            System.out.print("Error in lines 72++");
        }

        // itemW1.setItemCategory(w1Map.get("ItemCategory"));

    }

    public static Monster getM1Monster() {
        return m1Monster;
    }

    public static void setM1Monster(Monster m1Monster) {
        MonsterController.m1Monster = m1Monster;
    }

    public static Monster getM2Monster() {
        return m2Monster;
    }

    public static void setM2Monster(Monster m2Monster) {
        MonsterController.m2Monster = m2Monster;
    }

    public static Monster getM3Monster() {
        return m3Monster;
    }

    public static void setM3Monster(Monster m3Monster) {
        MonsterController.m3Monster = m3Monster;
    }

    public static Monster getM4Monster() {
        return m4Monster;
    }

    public static void setM4Monster(Monster m4Monster) {
        MonsterController.m4Monster = m4Monster;
    }

    public static Monster getM5Monster() {
        return m5Monster;
    }

    public static void setM5Monster(Monster m5Monster) {
        MonsterController.m5Monster = m5Monster;
    }

    public static Monster getM6Monster() {
        return m6Monster;
    }

    public static void setM6Monster(Monster m6Monster) {
        MonsterController.m6Monster = m6Monster;
    }

    public static Monster getM7Monster() {
        return m7Monster;
    }

    public static void setM7Monster(Monster m7Monster) {
        MonsterController.m7Monster = m7Monster;
    }

    public static Monster getM8Monster() {
        return m8Monster;
    }

    public static void setM8Monster(Monster m8Monster) {
        MonsterController.m8Monster = m8Monster;
    }
}


