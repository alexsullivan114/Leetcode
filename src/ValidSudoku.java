import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void test() {
		char[][] array = {
				{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
				{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
				{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
				{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
				{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
				{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '4', '.', '.', '.', '.', '.'}
		};
		boolean valid = new ValidSudoku().isValidSudoku(array);
		System.out.println("Valid: " + valid);
	}
	public boolean isValidSudoku(char[][] board) {
		boolean validRows = checkRows(board);
		if (!validRows) return false;
		boolean validColumns = checkColumns(board);
		if (!validColumns) return false;
		return checkSubBoxes(board);
	}

	private boolean checkSubBoxes(char[][] board) {
		for (int xOffset = 0; xOffset <= 6; xOffset += 3) {
			for (int yOffset = 0; yOffset <= 6; yOffset += 3) {
				Set<Character> subBoxSet = new HashSet<>();
				for (int i = xOffset; i < xOffset + 3; i++) {
					for (int j = yOffset; j < yOffset + 3; j++) {
						char cell = board[i][j];
						if (cell == '.') continue;
						if (subBoxSet.contains(cell)) {
							return false;
						}
						subBoxSet.add(cell);
					}
				}
			}
		}
		return true;
	}

	private boolean checkColumns(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> columnSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char cell = board[j][i];
				if (cell == '.') continue;
				if (columnSet.contains(cell)) {
					return false;
				}
				columnSet.add(cell);
			}
		}
		return true;
	}

	private boolean checkRows(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> rowSet = new HashSet<>();
			char[] row = board[i];
			for (int j = 0; j < 9; j++) {
				char cell = row[j];
				if (cell == '.') continue;
				if (rowSet.contains(cell)) {
					return false;
				}
				rowSet.add(cell);
			}
		}
		return true;
	}
}
