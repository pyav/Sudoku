/**
 * Following code demonstrates the solution of a given Sudoku problem.
 * 
 * @author pyav
 */

public class SudokuSolver {

	private static boolean isValid(int[][] matrix, int row, int col, int val) {

		// Check the columns in the given row for the existence of the value provided.
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[row][j] == val) {
				// A match found, return false
				return false;
			}
		}

		// Check the rows for the value, if value exists already then return false.
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][col] == val) {
				// A match found, return false
				return false;
			}
		}
		
		// Return true indicating the row and column doesn't have that value.
		return true;
	}
	
	public static boolean isUniqueMatrix(int[][] matrix, int size) {
		
		int sum = 0;
		int totalSum = size * (size + 1) / 2;
		
		/*
		 * Sum of each row and each column must be equal to n*(n+1)/2. Another method to
		 * do this could be to track the count of each element in a row or a column and
		 * do this for all the rows and columns.
		 */
		for (int i = 0; i < size; i++) {
			sum = 0;
			for (int j = 0; j < size; j++) {
				
				if (matrix[i][j] < 1 || matrix[i][j] > size) {
					return false;
				}
				
				sum += matrix[i][j];
			}
			
			if (sum != totalSum) {
				return false;
			}
		}
		
		for (int j = 0; j < size; j++) {
			sum = 0;
			for (int i = 0; i < size; i++) {
				sum += matrix[i][j];
			}
			
			if (sum != totalSum) {
				return false;
			}
		}
		
		// All checks done, matrix is having unique values between 1 and size.
		return true;
	}
	
	private static boolean isSolutionPossible(int[][] matrix, int size) {
		
		int row = -1;
		int col = -1;
		boolean needOperation = false;
		
		// First find what position to check a value for.
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (matrix[i][j] == 0) {
					row = i;
					col = j;
					needOperation = true;
					break;
				}
			}
			
			if (needOperation) {
				// A grid found which a value should be checked for.
				break;
			}
		}
		
		// Check if no grid found above.
		if (!needOperation) {
			
			// Final uniqueness check, also handles the testcase of already filled matrix. 
			if (!isUniqueMatrix(matrix, matrix.length)) {
				return false;
			}
			
			// Solution possible, method return.
			return true;
		}
		
		/*
		 * Iterate over each value and see whether the matrix can be completed by
		 * putting that value in the above grid.
		 */  
		for (int i = 1; i <= size; i++) {
			/*
			 * Put the value in the grid and recurse for further values to be put into rest
			 * of the grids, if valid. Else, reset this grid and try again with next value.
			 */
			if (isValid(matrix, row, col, i)) {
				matrix[row][col] = i;
				// Current state of the matrix needs to be tried upon for further grids.
				if (isSolutionPossible(matrix, size)) {
					return true;
				} else {
					matrix[row][col] = 0;
				}
			}
		}
		
		return false;
	}
	
	private static void printMatrix(int[][] matrix, int size) {
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.printf("%d ", matrix[i][j]);
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
        	int size = Character.getNumericValue(args[0].charAt(0));
		int[][] matrix = new int[size][size];
		int val_index = 2;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int value = Character.getNumericValue(args[0].charAt(val_index));
				matrix[i][j] = value;
				// Consider space in args value
				val_index += 2;
			}
		}
		
		if (isSolutionPossible(matrix, matrix.length)) {
			System.out.printf(" %s ", "Solution is possible :)");
			printMatrix(matrix, matrix.length);
		} else {
			System.out.printf(" %s ", "Solution is not possible :(");
		}
		
	}

}
