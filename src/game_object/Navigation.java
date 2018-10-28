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
          room.a1();
        }
        
        else if(choice==2){
           room.b2();
        }
    }
    public void readB1(){
        
       room.b1();
        
           choice = myScanner.nextInt();

           if(choice==2){
             room.c1();
           }
           
           else if(choice==3){
              room.b2();
           }
           else if(choice==4){
               room.a1();
            }
       }
    public void readB2(){
        
        room.b1();
         
            choice = myScanner.nextInt();

            if(choice==2){
              room.c1();
            }
            
            else if(choice==3){
               room.b2();
            }
            else if(choice==4){
                room.a1();
             }
        }
    public void readC1(){
        
        room.c1();
         
            choice = myScanner.nextInt();

            if(choice==3){
              room.c2();
            }
            
            else if(choice==4){
               room.b1();
            }
        }
public void readC2(){
        
        room.c2();
         
            choice = myScanner.nextInt();

            if(choice==1){
              room.c1();
            }
            
            else if(choice==2){
               room.d2();
            }
            else if(choice==3){
            	room.a2();
            	//update this B1F
               // room.c3(); 
             }
            else if(choice==4){
                room.b2();
             }
        }
public void readA3(){
    
    room.a3();
     
        choice = myScanner.nextInt();

        if(choice==2){
          room.b3();
        }
        
        else if(choice==3){
           room.a4();
        }
    }
public void readA4(){
    
    room.a4();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.a3();
        }
        
        else if(choice==2){
           room.b4();
        }
        else if(choice==3){
        	room.a5();
         }
}
public void readB3(){
    
    room.b3();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.b2();
        }
        
        else if(choice==2){
           room.a2();
         //update this B1F
           // room.c3();
        }
        else if(choice==3){
        	room.b4();
         }
        else if(choice==4){
        	room.a3();
         }
}
public void readB4(){
    
    room.b4();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.b3();
        }
        
        else if(choice==2){
           room.c4();
         //update this B1F
           // room.c3();
        }
        else if(choice==3){
        	room.b5();
         }
        else if(choice==4){
        	room.a4();
         }
}
public void readB5(){
    
    room.b5();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.b4();
        }
        
        else if(choice==2){
           room.a5();
        }
}
public void readD1(){
    
    room.d1();
     
        choice = myScanner.nextInt();

        if(choice==2){
          room.e1();
        }
        
        else if(choice==3){
           room.d2();
        }
}
public void readD2(){
    
    room.d2();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.d1();
        }
        
        else if(choice==2){
           room.e2();
        }
        else if(choice==3){
        	room.d3();
         }
        else if(choice==4){
        	room.c2();
         }
}
public void readD3(){
    
    room.d3();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.d2();
        }
        
        else if(choice==2){
           room.e3();
        }
        else if(choice==3){
        	room.d4();
         }
        else if(choice==4){
        	room.a2();
        	//update this B1F
            // room.c3();
         }
}
public void readE2(){
    
    room.e2();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.e1();
        }
        else if(choice==3){
        	room.e3();
         }
        else if(choice==4){
        	room.d2();
         }
}
public void readE3(){
    
    room.e3();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.e2();
        }
        else if(choice==4){
        	room.d3();
         }
}
public void readC4(){
    
    room.c4();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.a2();
        //update this B1F
          // room.c3();
        }
        else if(choice==2){
           room.d4();
        }
        else if(choice==3){
        	room.c5();
         }
        else if(choice==4){
        	room.b4();
         }
}
public void readC5(){
    
    room.c5();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.c4();
        }
        else if(choice==2){
           room.d5(); 
        }
}
public void readD4(){
    
    room.d4();
     
        choice = myScanner.nextInt();

        if(choice==1){
          room.d3();
        }
        else if(choice==2){
          // room.e4(); 
        }
        else if(choice==3){
            room.d5(); 
         }
        else if(choice==4){
            room.c4(); 
         }
}
}
