package game_object;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        java.io.File file= new java.io.File("Rooms.txt");
        try{
            Scanner input = new Scanner (file) ;
            while (input.hasNext()){
                String nums = input.nextLine();
                System.out.println(nums);
            }
        } catch (FileNotFoundException e) {
            System.err.format("File does not exist\n");
            //e.printStackTrace();
        }

    }
}
