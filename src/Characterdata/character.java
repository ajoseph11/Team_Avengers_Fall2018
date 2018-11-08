package Characterdata;

import java.util.Random;

import com.sun.java_cup.internal.runtime.Scanner;

public class character {

	private static Object charclass;
	private static String playerName;
	private static String playerhp;
	private static String playermeleedmg;
	private static String mana;
	private static String enemyhp;
	private static String enemymeleedmg;
	private static String xp;


	class driver {
		static Scanner scan = new Scanner(System.in);
		static Random rand = new Random();
		public static String playerName;
		public static int playerhp;
		public static int maxhp;
		public static int maxmana;
		public static int mana;
		public static int playermeleedmg;
		public static int xp;
		public static int enemyhp;
		public static int enemymeleedmg;
		public static int Level;
		public static String charclass;
		public static boolean fighting = false; //globals for player stats & enemy stats
	}
	private static void printStats() {
		if(charclass.equals("mage")){
			System.out.println(playerName + "\nhp: " + playerhp + "\nmana: " + mana + "\ndamage: " + playermeleedmg + "\nxp: " + xp + "\n");
		}else{
			System.out.println(playerName + "\nhp: " + playerhp + "\ndamage: " + playermeleedmg + "\nxp: " + xp + "\n");
		}
	}
	private static void printEnemyStats() {
		System.out.println("Enemy "+"\nhp: " + enemyhp + "\ndmg: " + enemymeleedmg + "\n");
	}
}


