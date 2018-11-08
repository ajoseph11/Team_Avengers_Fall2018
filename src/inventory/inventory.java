package inventory;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;



public class inventory {

	private static Object scan;


	Item item0 = new Item();
       item.setItemName("Map");


	Item item1 = new Item();
      item1.setItemName("Sword");

	Item[] itemize  = new Item[2];
	itemize[0] = item0;
	itemize[1] = item1;
	List<String> inv = new ArrayList<String>();
      System.out.println("You see a rusty axe on the floor next to a bone of the fallen ones.");
	Object choice1 = ((Object) scan).nextLine();
}

	private List<String> inv1;
	private Object choice;{

		if (choice.equals("take axe")) {
		System.out.println("You pick up the axe");
		inv.add("axe");
		}
		System.out.println(inv);
		System.out.println("You walk for awhile and start to become thirsty");
		System.out.println(inv);
		choice = ((Object) scan).nextLine();

		if (choice.equals("drink")) {
		if (inv.contains("Water")) {
		System.out.println("You drink the Water");
		inv.remove("pepsi");
		}
		if (inv.contains("Water")) {
		System.out.println("You drank Water");
		inv.remove("water");
		} else if (!inv.contains("water")) {
		System.out.println("You have nothing to drink!");
		}
		}
		}
		}

		}
