package Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02_1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day02/input_1");
		try (Scanner sc = new Scanner(file)) {
			int depth = 0, horizontal = 0;
			while (sc.hasNextLine()) {
				String[] split = sc.nextLine().split(" ");
				int value = Integer.parseInt(split[1]);
				if (split[0].equals("forward")) {
					horizontal += value;
				} else if (split[0].equals("down")) {
					depth += value;
				} else if (split[0].equals("up")) {
					depth -= value;
				}
			
			}
			
			System.out.println("Solution: " + (depth * horizontal));
		}
	}

}
