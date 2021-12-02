package Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01_2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day01/input_1");
		try (Scanner sc = new Scanner(file)) {
			
			ArrayList<Integer> inputList = new ArrayList<Integer>();
			ArrayList<Integer> savedResults = new ArrayList<Integer>();

			while (sc.hasNextLine()) {
				inputList.add(sc.nextInt());
			}
			
			int x = 0;
			int y = 0;
			int z = 0;
			
			for (int i = 0; i < inputList.size(); i++) {
				if (i % 3 == 0 || i % 3 == 1 || i % 3 == 2) {
					x+= inputList.get(i);	
				} 
				if (i % 3 == 2 ) {
					savedResults.add(x);
					x = 0;
				}
				
				
				if ((i % 3 == 1 || i % 3 == 2 || i % 3 == 0) && i >= 1) {
					y+= inputList.get(i);
				} 
				
				if (( i % 3 == 0)  && i > 0) {
					savedResults.add(y);
					y = 0;
				}
				
				if ((i % 3 == 2 || i % 3 == 0 || i % 3 == 1) && i>= 2) {
					z+= inputList.get(i);
				} 
				
				if (i % 3 == 1 && i > 1) {
					savedResults.add(z);
					z = 0;											
				}
			}
			
			boolean check = false;
			int depth = 0, count = 0;
			
			for (int i = 0; i < savedResults.size(); i++) {
				
				if (!check) {
					depth = savedResults.get(i);
					check = true;
				} else {
					int temp = savedResults.get(i);

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
