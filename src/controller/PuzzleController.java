package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import model.Puzzle;

public class PuzzleController {

	public static Map<String, String> r1Map = new LinkedHashMap<>();
	public static Map<String, String> r2Map = new LinkedHashMap<>();
	public static Map<String, String> r3Map = new LinkedHashMap<>();
	public static Map<String, String> r4Map = new LinkedHashMap<>();
	public static Map<String, String> r5Map = new LinkedHashMap<>();
	public static Map<String, String> r6Map = new LinkedHashMap<>();
	public static Map<String, String> r7Map = new LinkedHashMap<>();
	public static Map<String, String> r8Map = new LinkedHashMap<>();

	public static String errorMessage;
	public static Puzzle puzzleR1;
	public static Puzzle puzzleR2;
	public static Puzzle puzzleR3;
	public static Puzzle puzzleR4;
	public static Puzzle puzzleR5;
	public static Puzzle puzzleR6;
	public static Puzzle puzzleR7;
	public static Puzzle puzzleR8;

	public static void setPuzzleFromText() throws IOException {
		// track which line you are currently reading
		int currentLine = 0;
		String lineNumber = "";

		// concrete instantiation of maps to store information for each puzzle
		r1Map = new LinkedHashMap<>();
		r2Map = new LinkedHashMap<>();
		r3Map = new LinkedHashMap<>();
		r4Map = new LinkedHashMap<>();
		r5Map = new LinkedHashMap<>();
		r6Map = new LinkedHashMap<>();
		r7Map = new LinkedHashMap<>();
		r8Map = new LinkedHashMap<>();

		// concrete instantiation of puzzle object to store information for each puzzle

		puzzleR1 = new Puzzle();
		puzzleR2 = new Puzzle();
		puzzleR3 = new Puzzle();
		puzzleR4 = new Puzzle();
		puzzleR5 = new Puzzle();
		puzzleR6 = new Puzzle();
		puzzleR7 = new Puzzle();
		puzzleR8 = new Puzzle();

		String puzzleFile = "Puzzle.txt";
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(puzzleFile));
		while ((line = reader.readLine()) != null) {
			currentLine++;
			String[] lineContent = line.split(":", 2);
			// Print key and value seperately

			// print key and value as a set
			try {
				if (lineContent.length >= 2) {
					lineNumber = String.valueOf(currentLine);
					String key = lineContent[0];
					String value = lineContent[1];
					if ((currentLine > 0) && (currentLine <= 5)) {
						r1Map.put(key, value);
					}
					if ((currentLine > 5) && (currentLine <= 10)) {
						r2Map.put(key, value);
					}

					if ((currentLine > 10) && (currentLine <= 15)) {
						r3Map.put(key, value);
					}
					if ((currentLine > 15) && (currentLine <= 20)) {
						r4Map.put(key, value);
					}
					if ((currentLine > 20) && (currentLine <= 25)) {
						r5Map.put(key, value);
					}

					if ((currentLine > 25) && (currentLine <= 30)) {
						r6Map.put(key, value);
					}
					if ((currentLine > 30) && (currentLine <= 35)) {
						r7Map.put(key, value);
					}
					if ((currentLine > 35) && (currentLine <= 40)) {
						r8Map.put(key, value);
					}

					// set the current map as the value for each Puzzle Map object R1-R8;
					puzzleR1.setPuzzleMap(r1Map);
					puzzleR2.setPuzzleMap(r2Map);
					puzzleR3.setPuzzleMap(r3Map);
					puzzleR4.setPuzzleMap(r4Map);
					puzzleR5.setPuzzleMap(r5Map);
					puzzleR6.setPuzzleMap(r6Map);
					puzzleR7.setPuzzleMap(r7Map);
					puzzleR8.setPuzzleMap(r8Map);

				} else {
					errorMessage = "Puzzle Class :: Program Beginning.....";
					System.out.println(errorMessage);
				}
			} catch (Exception e) {
				// errorMessage = "One or more line may be empty and giving null String:: Please
				// checck";
				System.out.print(errorMessage);
			     e.printStackTrace();
			}
		}

		// Create an array of puzzle objects
		Puzzle[] puzzleObjects = { puzzleR1, puzzleR2, puzzleR3, puzzleR4, puzzleR5, puzzleR6, puzzleR7, puzzleR8 };
		// Create an array of puzzle linked hash map objects from which you are calling
		// values for the fields of the hashmap above
		Map[] puzzleLinkedhashMapObjects = { puzzleR1.getPuzzleMap(), puzzleR2.getPuzzleMap(), puzzleR3.getPuzzleMap(),
				puzzleR4.getPuzzleMap(), puzzleR5.getPuzzleMap(), puzzleR6.getPuzzleMap(), puzzleR7.getPuzzleMap(),
				puzzleR8.getPuzzleMap() };

		// print key and value side by side as seperate entities
		for (String keyItem : puzzleR1.getPuzzleMap().keySet()) {

			String key = keyItem.toString();
			String value = puzzleR1.getPuzzleMap().get(keyItem).toString();
			// System.out.println( key + " " + value);
			// System.out.println("");

		}

		for (int i = 0; i < puzzleObjects.length; i++) {
			for (String keyItem : puzzleObjects[i].getPuzzleMap().keySet()) {

				String key = keyItem.toString();
				String value = puzzleObjects[i].getPuzzleMap().get(keyItem).toString();
				// System.out.println( key + " " + value);
				// System.out.println("");

			}
		}

		try {
			for (int i = 0; i < puzzleLinkedhashMapObjects.length; i++) {
				puzzleObjects[i].setId(puzzleLinkedhashMapObjects[i].get("ID").toString());
				puzzleObjects[i].setRoom_id(puzzleLinkedhashMapObjects[i].get("Room-ID").toString());
				puzzleObjects[i].setRiddle(puzzleLinkedhashMapObjects[i].get("Riddle").toString());
				puzzleObjects[i].setHint(puzzleLinkedhashMapObjects[i].get("Hint").toString());
				puzzleObjects[i].setAnswer(puzzleLinkedhashMapObjects[i].get("Answer").toString());
				// System.out.println(puzzleObjects[i].toString());
			}
		} catch (Exception e) {
			errorMessage = "One or more lines is/are null/empty:: please check";
			e.printStackTrace();
			// System.out.println(errorMessage + " " + e);
		}
		//puzzleR2.setAnswer(puzzleR2.getPuzzleMap().get("Answer"));

	}

	public static Puzzle getPuzzleR1() {
		return puzzleR1;
	}

	public static void setPuzzleR1(Puzzle puzzleR1) {
		PuzzleController.puzzleR1 = puzzleR1;
	}

	public static Puzzle getPuzzleR2() {
		return puzzleR2;
	}

	public static void setPuzzleR2(Puzzle puzzleR2) {
		PuzzleController.puzzleR2 = puzzleR2;
	}

	public static Puzzle getPuzzleR3() {
		return puzzleR3;
	}

	public static void setPuzzleR3(Puzzle puzzleR3) {
		PuzzleController.puzzleR3 = puzzleR3;
	}

	public static Puzzle getPuzzleR4() {
		return puzzleR4;
	}

	public static void setPuzzleR4(Puzzle puzzleR4) {
		PuzzleController.puzzleR4 = puzzleR4;
	}

	public static Puzzle getPuzzleR5() {
		return puzzleR5;
	}

	public static void setPuzzleR5(Puzzle puzzleR5) {
		PuzzleController.puzzleR5 = puzzleR5;
	}

	public static Puzzle getPuzzleR6() {
		return puzzleR6;
	}

	public static void setPuzzleR6(Puzzle puzzleR6) {
		PuzzleController.puzzleR6 = puzzleR6;
	}

	public static Puzzle getPuzzleR7() {
		return puzzleR7;
	}

	public static void setPuzzleR7(Puzzle puzzleR7) {
		PuzzleController.puzzleR7 = puzzleR7;
	}

	public static Puzzle getPuzzleR8() {
		return puzzleR8;
	}

	public static void setPuzzleR8(Puzzle puzzleR8) {
		PuzzleController.puzzleR8 = puzzleR8;
	}

}