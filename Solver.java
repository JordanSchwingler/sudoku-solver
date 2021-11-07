public class Solver {
	
	static int[][] board = {{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
							
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
							
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0}};
	
	
	public static void main(String[] args) {
	
		printBoard(board);
		
		solveBoard(board);
		
		printBoard(board);
		
	}
	
	
	public static boolean solveBoard(int[][]board) {
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (board[r][c] == 0) {
					//solve coordinate (r,c)
					for (int i = 1; i < 10; i++) {
						if (checkValidity(i, r, c)) {
							board[r][c] = i;
							
							if (solveBoard(board)) {
								return true;
							}
							else {
								board[r][c] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		
		//if successfully changed number
		return true;
	}
	
	//returns true if number is a valid entry for box at (row, column)
	public static boolean checkValidity(int number, int row, int column) {

		if (checkRow(number, row, column) &&
			checkColumn(number, row, column) &&
			checkSubgrid(number, row, column)) {
			return true;
		}
		return false;
	}
	
	//returns true if num is not already in that row
	public static boolean checkRow(int num, int row, int column) {
		for (int c = 0; c < 9; c++) {
			if (board[row][c] == num) {
				return false;
			}
		}
		return true;
	}
	
	//returns true if num is not already in that column
	public static boolean checkColumn(int num, int row, int column) {
		for (int r = 0; r < 9; r++) {
			if (board[r][column] == num) {
				return false;
			}
		}
		return true;
	}
	
	//returns true if num is not already in that 3x3 subgrid
	public static boolean checkSubgrid(int num, int row, int column) {
		int UpperLeftRow = row - (row % 3);
		int UpperLeftColumn = column - (column % 3);
		for (int r = UpperLeftRow; r < UpperLeftRow + 3; r++) {
			for (int c = UpperLeftColumn; c < UpperLeftColumn + 3; c++) {
				if (board[r][c] == num) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void printBoard(int[][] BoardToPrint) {
		String toPrint = "";
		for(int row = 0; row < 9; row++) {
			for(int column = 0; column < 9; column++) {
				toPrint += BoardToPrint[row][column] + " ";
				if (column % 3 == 2) {
					toPrint += "  ";
				}
			}
			toPrint += "\n";
			if (row % 3 == 2) {
				toPrint += "\n";
			}
		}
		System.out.println(toPrint);
	}
	
}
