package game_object;
import java.util.Scanner;
public class Navigation {
	Scanner myScanner = new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);
    Room room = new Room();
//    int playerHP;
//    String playerName;
//    String playerWeapon;
    int choice;
//    int monsterHP;
//
//    int silverRing;


    
    public static void main(String[] args) {

        Navigation citadelofstorms;
        citadelofstorms = new Navigation();

        citadelofstorms.playerSetUp();
        citadelofstorms.readA2();
    }

    public void playerSetUp(){

        room = new Room();
        room.playerHP = 20;

        room.monsterHP = 15;

        room.playerWeapon = "Knife";

        System.out.println("Your HP: "+ room.playerHP);
        System.out.println("Your Weapon: "+ room.playerWeapon);

        System.out.println("Please enter your name:");

        room.playerName = myScanner.nextLine();

        System.out.println("Hello " + room.playerName + ", let's start the game!");


    }

    public void readA2(){
     
     room.a2();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.c1();
            
            
         // get.rooms.a2();
            //if(rooms.silverRing==1){
                //ending();
           // }
            //else{
               // System.out.println("(As you enter the chamber, your attention is drawn to the far \ncorner, where a hulking form breathes softly.) On the floor around you lie\n the discarded bodies of once-living minions.\n Is this where all these experiments came to a head?");
               // enterScanner.nextLine();
               // readCrossRoad();
            
           //readb2();
        }
        
        else if(choice==2){
            System.out.println("The door falls open, a gust of wind comes in the room, and the candles\n mounted against the walls flames flicker. Stomachs are growling:\n the pig people are on the prowl. A smell of desperation is in the air. The closest object seems to be a crate;\n there could still be something in there. There is a tool bench, as well as a work table. \nThis room is filled with opportunity – or defeat.");
            //System.out.println("Your HP: " + playerHP);
            enterScanner.nextLine();
            readA2();
        }
    }
}
