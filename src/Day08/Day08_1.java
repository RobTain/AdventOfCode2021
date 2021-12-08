package Day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day08_1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day08/input_1");
		ArrayList<String> input = new ArrayList<String>();

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				input.add(sc.nextLine());
			}
		}
		
		int countNumbers = 0;
		
		for (String string : input) {
			String[] entry = string.split("\\|");

			String[] splitEntry = entry[1].split(" ");
			for (String string2 : splitEntry) {
				int length = string2.length();
				if (length == 2 || length == 4 || length == 3 || length == 7) {
					countNumbers++;
				}
			}
		}
		
		System.out.println("Solution: " + countNumbers);
	}

}
