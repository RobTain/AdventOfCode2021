package Day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Day06_2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day05/input_1");
		
		ArrayList<String> input = new ArrayList<String>();
	
		try (Scanner sc = new Scanner(file)) {	
			while (sc.hasNextLine()) {
				input.add(sc.nextLine());
			}
		}	
		
		// find array bounds
		int maxX = 0, maxY = 0;
		
		for (int i = 0; i < input.size(); i++) {
			String tmp = input.get(i);
			tmp = tmp.replace(" -> ", ",");
			input.set(i, tmp);
			String[] split = tmp.split(",");
			
			
			int maxValueX = Math.max(Integer.parseInt(split[0]), Integer.parseInt(split[2]));
			int maxValueY = Math.max(Integer.parseInt(split[1]), Integer.parseInt(split[3]));
			
			if (maxValueX > maxX) {
				maxX = maxValueX;
			}
			
			if (maxValueY > maxY) {
				maxY = maxValueY;
			}
		}
		
		maxX++; maxY++;

		
		Integer[][] grid = new Integer[maxX][maxY];
		for (Integer[] integers : grid) {
			for (int i = 0; i < integers.length; i++) {
				integers[i] = 0;
			}
		}
		
		for (String string : input) {
			String[] split = string.split(",");
			
			int x1 = Integer.parseInt(split[0]);
			int x2 = Integer.parseInt(split[2]);
			int y1 = Integer.parseInt(split[1]);
			int y2 = Integer.parseInt(split[3]);
			
			if (x1 == x2) {
				for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
					grid[i][x1]++;
				}
			} else if (y1 == y2) {			
				for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
					grid[y1][i]++;
				}
			} else {
				int difference = Math.max(x1, x2) - Math.min(x1, x2) + 1;
				
				if (x1 < x2 && y1 < y2) {
					while( difference > 0) {
						grid[y1][x1]++;
						x1++;
						y1++;
						difference--;
					}
					
				} else if (x1 < x2 && y1 > y2) {
					while( difference > 0) {
						grid[y1][x1]++;
						x1++;
						y1--;
						difference--;
					}
					
				} else if (x1 > x2 && y1 < y2) {
					while( difference > 0) {
						grid[y1][x1]++;
						x1--;
						y1++;
						difference--;
					}
				} else if (x1 > x2 && y1 > y2) {
					while( difference > 0) {
						grid[y1][x1]++;
						x1--;
						y1--;
						difference--;
					}
					
				}
				
			}	
		}
		
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] >= 2) {
					count++;
				}
			}
		}
		
		

		
		System.out.println("Solution: " + count);
	}

}
