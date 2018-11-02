package game_object;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        java.io.File file= new java.io.File("Rooms.txt");
        try{
            Scanner input = new Scanner (file) ;
            while (input.hasNext()){
                // read each line from the text file
                String nums = input.nextLine();

                // process each line read
                // file has this format:
                // ID:  ##
                // Desc: $$$$
                // Exits: $-$# $-$# $-$# ...
                // endRoom;

                System.out.println(nums);

                // nums = "ID A2"
                // use the split method from Scanner to parse in the String read

                String[] words = nums.split(" ");

                for (String word : words)
                {
                    // print word to Console for debugging purpose
                    System.out.println(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.format("File does not exist\n");
            //e.printStackTrace();
        }

    }
}