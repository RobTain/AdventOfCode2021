package Day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Day06_1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day06/input_1");
		
		String lanternfish = "";
	
		try (Scanner sc = new Scanner(file)) {	
			while (sc.hasNextLine()) {
				lanternfish = sc.nextLine();
			}
		}	
		
		String[] split = lanternfish.split(",");
		
		// save fishies into a list
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (String s : split) {
			list.add(Integer.parseInt(s));
		}
		
		// make a lot of fishies - uff
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < list.size(); j++) {
				int tmp = list.get(j);
				if (tmp == 0) {
					list.set(j, 6);
					list.add(9);
				} else {
					list.set(j, list.get(j) - 1);
				}
			}
		}

		System.out.println("Solution: " + list.size());
	}

}
