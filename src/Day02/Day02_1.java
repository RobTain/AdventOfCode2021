package Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02_1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day01/input_1");
		try (Scanner sc = new Scanner(file)) {
			boolean check = false;
			int depth = 0, count = 0;
			while (sc.hasNextLine()) {
				if (!check) {
					depth = sc.nextInt();
					check = true;
				} else {
					int temp = sc.nextInt();
					if (temp > depth) {
						count++;
					}
					depth = temp;
				}
			}
			
			System.out.println("Solution: " + count);
		}
	}

}
