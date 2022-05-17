package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidSudoko {

	public boolean isValidSudoku(char[][] board) {

		// row
		// column
		Map<Integer, List<Character>> rowMap = new HashMap<>();
		Map<Integer, List<Character>> columnMap = new HashMap<>();
		Set<Character> uniqueCharacters = null;
		for (int row = 3; row <= 9; row = row + 3) {
			for (int col = 3; col <= 9; col = col + 3) {
				uniqueCharacters = new HashSet<>();
				int totalCharsCount = 0;
				for (int i = row - 3; i < row; i++) {
					for (int j = col - 3; j < col; j++) {
						if (board[i][j] != '.') {
							uniqueCharacters.add(board[i][j]);
							totalCharsCount++;

							// row Validation
							List<Character> columnValuesPerRow = rowMap.get(i);
							if (columnValuesPerRow != null && columnValuesPerRow.contains(board[i][j])) {
								return false;
							} else {
								rowMap.computeIfAbsent(i, (key) -> new ArrayList<>()).add(board[i][j]);
							}
							// column Validation
							List<Character> rowValuesPerColumn = columnMap.get(j);
							if (rowValuesPerColumn != null && rowValuesPerColumn.contains(board[i][j])) {
								return false;
							} else {
								columnMap.computeIfAbsent(j, (key) -> new ArrayList<>()).add(board[i][j]);
							}
						}
					}
				}
				// Grid Validation
				if (totalCharsCount != uniqueCharacters.size()) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoko vs = new ValidSudoko();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(vs.isValidSudoku(board)); // true
		board = new char[][] { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
				{ '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
				{ '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
				{ '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };

		System.out.println(vs.isValidSudoku(board)); // false
	}

}
