package game_object2;

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //declare a collection of rooms
        HashMap<String, Room> rooms = new HashMap<>();

        //temporary / current room
        Room currentRoom = new Room();
        String currentID = "";

        //read in information about rooms
        File file = new File("Rooms.txt");
        try {
            Scanner input = new Scanner(new FileInputStream("Rooms.txt"), "UTF-8");
            while (input.hasNext()) {
                // read each line from the text file
                String line = input.nextLine();

                // process each line read
                // file has this format:
                // ID:  ##
                // Desc: $$$$
                // Exits: $-$# $-$# $-$# ...
                // endRoom;

                //first: is this an end room line?
                if (line.startsWith("endRoom;")) {
                    //submit this room to our hash map
                    rooms.put(currentID, currentRoom);

                    //and start a new current room
                    currentRoom = new Room();
                    currentRoom.setPuzzle(null);
                }
                //must be a room information line
                else {
                    String[] colonDelimited = line.split(":");

                    String id = "ID";
                    // ID?
                    if (colonDelimited[0].equals("ID")) {
                        currentID = colonDelimited[1].trim();
                    }
                    // Description?
                    else if (colonDelimited[0].equals("Desc")) {
                        currentRoom.setDescription(colonDelimited[1].trim());
                    }
                    //Exits?
                    else if (colonDelimited[0].equals("Exits")) {
                        currentRoom.setExits(colonDelimited[1].trim());
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.err.format("File does not exist\n");
            //e.printStackTrace();
            return;
        }

        try {
            Scanner input = new Scanner(new FileInputStream("Puzzle.txt"), "UTF-8");
            Puzzle puzzle = null;
            while (input.hasNext()) {
                // read each line from the text file
                String line = input.nextLine();
                if("".equals(line)){
                    continue;
                }
                else {
                    String[] colonDelimited = line.split(":");

                    if (colonDelimited[0].equals("ID")) {
                        puzzle = new Puzzle();
                        puzzle.id = colonDelimited[1].trim();
                    }
                    else if (colonDelimited[0].equals("Riddle")) {
                        puzzle.riddle = colonDelimited[1].trim();
                    }
                    else if (colonDelimited[0].equals("Hint")) {
                        puzzle.hint = colonDelimited[1].trim();
                    }
                    else if (colonDelimited[0].equals("Answer")) {
                        puzzle.answer = colonDelimited[1].trim();
                    }
                    else if (colonDelimited[0].equals("Room-ID")) {
                        currentRoom = rooms.get(colonDelimited[1].trim());
                        currentRoom.setPuzzle(puzzle);
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.err.format("File does not exist\n");
            //e.printStackTrace();
            return;
        }

        //now poll the user for input
        Scanner input = new Scanner(System.in);

        //start in A2
        currentID = "A2";
        currentRoom = rooms.get(currentID);
        while (true) {
            //print description
            System.out.println(currentRoom.getDescription());
            if(currentRoom.getPuzzle() != null){
                System.out.println("This room has a puzzle to solve: ");
                System.out.println(currentRoom.getPuzzle().riddle);
                System.out.println("Do you want hint? (y/n): ");
                String line = input.nextLine();

                if("y".equals(line) || "Y".equals(line)){
                    System.out.println(currentRoom.getPuzzle().hint);
                }

                while(true){
                    System.out.println("Enter your answer: ");
                    line = input.nextLine();
                    if(line.equals(currentRoom.getPuzzle().answer)){
                        System.out.println("You got it right!");
                        break;
                    }
                    else{
                        System.out.println("Wrong answer! Please retry.");
                    }
                }
            }

            System.out.println("Which way would you like to go?");

            HashMap<String, String> currentExits = currentRoom.getExits();

            //loop through all possible room exits
            for (String key : currentExits.keySet()) {
                System.out.println("Go " + key);
            }
            String line = input.nextLine();
            if (currentExits.containsKey(line)) {
                //traverse to the chosen room
                currentID = currentExits.get(line);
                currentRoom = rooms.get(currentID);
            }
            else {
                System.out.println("Please enter a valid room exit.");
            }
        }
    }
}