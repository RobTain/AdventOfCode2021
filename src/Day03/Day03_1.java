package Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03_1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day03/input_1");
		
		ArrayList<boolean[]> list = new ArrayList<boolean[]>();
		
		int size = 0;
		
		try (Scanner sc = new Scanner(file)) {
			
			while (sc.hasNextLine()) {
				String tmp = sc.nextLine();
				size = tmp.length();
				boolean[] b = new boolean[size];
				
				for (int i = 0; i < size; i++) {
					b[i] = (tmp.charAt(i) == '1');
				}
				
						
				list.add(b);
			}
		}
		
		boolean[] mostCommon = new boolean[size];
		boolean[] leastCommon = new boolean[size];
		
		int countZeros = 0, countOnes = 0;
		for (int i = 0; i < size; i++) {
			for (boolean[] b : list) {
				if (b[i]) {
					countOnes++;
				} else {
					countZeros++;
				}
			}
			

			
			if (countOnes > countZeros) {
				mostCommon[i] = true;
				leastCommon[i] = !mostCommon[i];
			} else {
				mostCommon[i] = false;
				leastCommon[i] = !mostCommon[i];
			}
			
			countZeros = countOnes = 0;
		}
		
		String mostCommonDecimal = "", leastCommonDecimal = "";
		
		for (boolean b : mostCommon) {
			mostCommonDecimal += b ? 1 : 0;
		}
		
		for (boolean b : leastCommon) {
			leastCommonDecimal += b ? 1 : 0;
		}
					
		System.out.println("Solution " + (Integer.parseInt(mostCommonDecimal, 2)*(Integer.parseInt(leastCommonDecimal,2))));
		
	}

}
