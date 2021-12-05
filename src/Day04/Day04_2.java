package Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04_2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/day04/input_1");
		
		ArrayList<String> input = new ArrayList<String>();
	
		try (Scanner sc = new Scanner(file)) {	
			while (sc.hasNextLine()) {
				input.add(sc.nextLine());
			}
		}	
		
		ArrayList<Integer[][]> boards = new ArrayList<Integer[][]>();
		
		
		// boards befuellen und in boards hauen
		int size = 5;
		Integer[][] board = new Integer[size][size];
		int row = 0;
		
		for (int i = 2; i < input.size(); i++) {
			String tmp = input.get(i);
			if (tmp.equals("")) {
				row = 0;
				boards.add(board);
				board = new Integer[size][size];
				
			} else {
				tmp = tmp.replaceAll("\\\s+", " ");
				if (tmp.charAt(0) == ' ') {
					tmp = tmp.substring(1,tmp.length());
				}
				
				String[] split = tmp.split(" ");
				for (int j = 0; j < split.length; j++) {
					board[j][row] = Integer.parseInt(split[j]);
				}
				row++;
			}
		}
		
		String[] winningNumbers = input.get(0).split(",");
		boolean check = false;
		int lastNumber = 0;
	
		for (int i = 0; i < winningNumbers.length; i++) {
			
			if (check) {
				break;
			}
			
			int number = Integer.parseInt(winningNumbers[i]);
			
			for (Integer[][] b : boards) {
				for (int j = 0; j < b.length; j++) {
					for (int k = 0; k < b[j].length; k++) {
						if (b[j][k] == number) {
							b[j][k] = -1;
						}
					}
				}
			}
			
			for (int x = 0; x < boards.size(); x++) {
				Integer[][] b = boards.get(x);
				for (int j = 0; j < b.length; j++) {
					if ((b[j][0] == b[j][1] && b[j][1] == b[j][2] && b[j][2] == b[j][3] && b[j][3] == b[j][4]) || (b[0][j] == b[1][j] && b[1][j] == b[2][j] && b[2][j] == b[3][j] && b[3][j] == b[4][j])) {
						if (boards.size() > 1) {
							boards.remove(x);
						} else if (boards.size() == 1) {
							check = true;
							lastNumber = number;
							break;
						}
					}
				}
			}
		}
		
		int result = 0;
		Integer[][] winner = boards.get(0);
		for (int i = 0; i < winner.length; i++) {
			for (int j = 0; j < winner[i].length; j++) {
				if (winner[i][j] != -1) {
					result += winner[i][j];
				}
			}		
		}
		System.out.println("Solution: " + (result*lastNumber));
	}	
}