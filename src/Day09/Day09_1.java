package Day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day09_1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day09/input_1");
		ArrayList<Integer[]> input = new ArrayList<Integer[]>();

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String string = sc.nextLine();
				Integer[] i = new Integer[string.length()];
				for (int j = 0; j < i.length; j++) {
					i[j] = Character.getNumericValue(string.charAt(j));
				}
				input.add(i);
			}
		}
		
		// matrix befüllen
		Integer[][] matrix = new Integer[input.size()][input.get(0).length];
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = input.get(i)[j];
			}
		}
		
		ArrayList<Integer> lowPoints = new ArrayList<Integer>();
		
		// Durch iterieren :/
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int tmp = matrix[i][j];
				
				int uLeft, uMiddle, uRight, mLeft, mRight, bLeft, bMiddle, bRight;
				
				
				// Brudi, gar kein bock auf die kack Aufgabe :D 
				// aka ja gibt bessere Algos, ich kann matrix gedönse nicht leiden
				try {
					uLeft = matrix[i-1][j-1];
				} catch (ArrayIndexOutOfBoundsException e) {
					uLeft = Integer.MAX_VALUE;
				}
				
				try {
					uMiddle = matrix[i][j-1];
				} catch (ArrayIndexOutOfBoundsException e) {
					uMiddle = Integer.MAX_VALUE;
				}
				
				try {
					uRight = matrix[i+1][j-1];
				} catch (ArrayIndexOutOfBoundsException e) {
					uRight = Integer.MAX_VALUE;
				}
				
				try {
					mLeft = matrix[i-1][j];
				} catch (ArrayIndexOutOfBoundsException e) {
					mLeft = Integer.MAX_VALUE;
				}
				
				try {
					mRight = matrix[i+1][j];
				} catch (ArrayIndexOutOfBoundsException e) {
					mRight = Integer.MAX_VALUE;
				}
				
				try {
					bLeft = matrix[i-1][j+1];
				} catch (ArrayIndexOutOfBoundsException e) {
					bLeft = Integer.MAX_VALUE;
				}
				
				try {
					bMiddle = matrix[i][j+1];
				} catch (ArrayIndexOutOfBoundsException e) {
					bMiddle = Integer.MAX_VALUE;
				}
				
				try {
					bRight = matrix[i+1][j+1];
				} catch (ArrayIndexOutOfBoundsException e) {
					bRight = Integer.MAX_VALUE;
				}
				
				
				if (tmp < uLeft && tmp < uMiddle && tmp < uRight && tmp < mLeft && tmp < mRight && tmp < bLeft && tmp < bMiddle && tmp < bRight) {
					lowPoints.add(tmp);
				}
			}
		}
		
		int countNumbers = 0;
		for (Integer integer : lowPoints) {
			countNumbers += ++integer;
		}
 		
		
		System.out.println("Solution: " + countNumbers);
	}

}
