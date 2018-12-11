import java.util.Scanner;

public class TicTacToe {
	
	private static final char PLAYER1 = 'X';
	private static final char PLAYER2 = 'O';
	
	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.play();
	}
	
	public void play() {
		int rounds = 0;
		int rows = getRowCol("row");
		int columns = getRowCol("column");
		char[][] board = makeBlankBoard(rows, columns);
		while (true) {
			int[] xCoords = getCoordinates(PLAYER1, board, rows, columns);
			board[xCoords[0]][xCoords[1]] = PLAYER1;
			rounds++;
			printBoard(board);
			if (checkWon(board, PLAYER1)) {
				System.out.println("Player " + PLAYER1 + " won the game!");
				return;
			}
			if (rounds >= rows * columns) {
				System.out.println("It's a tie, nobody wins!");
				return;
			}
			printBoard(board);
			int[] oCoords = getCoordinates(PLAYER2, board, rows, columns);
			board[oCoords[0]][oCoords[1]] = PLAYER2;
			rounds++;
			printBoard(board);
			if (checkWon(board, PLAYER2)) {
				System.out.println("Player " + PLAYER2 + " won the game!");
				return;
			}
			if (rounds >= rows * columns) {
				System.out.println("It's a tie, nobody wins!");
				return;
			}
		}
	}

	private int getRowCol(String input) {
		System.out.println("Enter the desired " + input + " :");
		while (true) {
			try {
				Scanner reader = new Scanner(System.in);
				int rowCol = reader.nextInt();
				if (rowCol < 0 || rowCol > 50) {
					throw new IllegalArgumentException();
				}
				return rowCol;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please enter an integer. Re-enter: ");
			} catch (IllegalArgumentException f) {
				System.out.println("Please enter an integer between 0 and 50. Re-enter: ");
			}
		}
	}

	public char[][] makeBlankBoard(int rows, int columns) {
		char[][] board = new char[rows][columns];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '_';
			}
		}
		return board;
	}
	
	public boolean checkWon(char[][] board, char player) {
		int columnCount = 0;
		int rowCount = 0;
		int backslashDiagonalCount = 0;
		int forwardslashDiagonalCount = 0;
		int winCount = board.length;
		for (int i = 0; i < board.length; i++) {
			rowCount = 0;
			columnCount = 0;
			for (int j = 0; j < board[0].length; j++) {
				rowCount += board[i][j] == player ? 1 : 0;
				columnCount += board[j][i] == player ? 1 : 0;
			}
			if (rowCount == winCount || columnCount == winCount) {
				return true;
			}
			backslashDiagonalCount += board[i][i] == player ? 1 : 0;
			forwardslashDiagonalCount += board[winCount - 1 - i][i] == player ? 1 : 0;
		}
		if (backslashDiagonalCount == winCount || forwardslashDiagonalCount == winCount) {
			return true;
		}
		return false;
	}
	
	public void printBoard(char[][] board) {
		System.out.println("Current board: ");
		System.out.println();
		for (int i = 0; i < board.length; i++) { 
			System.out.print("|");
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
	}
	
	private int getInt(char player, String input, int rowOrCol) {
		while (true) {
			try {
				Scanner reader = new Scanner(System.in);
				int coord = reader.nextInt();
				if ((coord >= rowOrCol) || (coord < 0)) {
					throw new IndexOutOfBoardException();
				}
				return coord;
		    } catch (java.util.InputMismatchException e) {
		    	System.out.println("Please enter a valid integer. Player " + player + " enter " + input + ":");
		    } catch (IndexOutOfBoardException f) {
		    	System.out.println("Cell is outside play board. Please choose valid cell. Player " + player + " enter " + input + ":");
		    }
		}
	}
	
	public int[] getCoordinates(char player, char[][] board, int rows, int columns) {
		while (true) {
			int[] coords = new int[2];
			System.out.println("Player " + player + " enter row: ");
			coords[0] = getInt(player, "row", rows);
			System.out.println("Player " + player + " enter column: ");
			coords[1] = getInt(player, "column", columns);
			if (isValid(board, coords)) {
				return coords;
			}
		}
	}

	public boolean isValid(char[][] board, int[] coords) {
		if (board[coords[0]][coords[1]] != '_') {
			System.out.println("Cell is already used. Please choose another cell");
			return false;
		}
		return true;
	}
}