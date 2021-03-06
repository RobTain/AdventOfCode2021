package Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day07_2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day07/input_1");
		ArrayList<Integer> crabs = new ArrayList<Integer>();

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String tmp = sc.nextLine();
				String[] split = tmp.split(",");
				for (String string : split) {
					crabs.add(Integer.parseInt(string));
				}
			}
		}

		// find max Value;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (Integer integer : crabs) {
			if (max < integer) {
				max = integer;
			}

			if (min > integer) {
				min = integer;
			}
		}

		// find best way
		int bestValue = Integer.MAX_VALUE;

		for (int i = min; i <= max; i++) {
			int tmp = 0;
			for (Integer integer : crabs) {
				// Gauss Algo (1 + 2 + 3 + 4 + 5 -> n * (n + 1)/ 2
				int n = (Math.max(integer, i) - Math.min(integer, i));
				tmp += (n * (n + 1)) / 2;

			}
			if (bestValue > tmp) {
				bestValue = tmp;
			}
		}
		System.out.println("Solution: " + bestValue);
	}

}
