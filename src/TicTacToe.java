import java.util.Scanner;

/* TODO :
 * track and print wins 
 * add extremes: option to explode 1 time per game, if there's a box around a value, it explodes, etc.
 */

public class TicTacToe {
	
	private static final char PLAYER1 = 'X';
	private static final char PLAYER2 = 'O';
	
	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		while (true) {
			ticTacToe.play();
			if (!playAgain()) {
				return;
			}
		}
	}
	
	private static boolean playAgain() {
		System.out.println("Would you like to play again? Type Y or N: ");
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				String line = scanner.nextLine();
				if (line.equals("N") || line.equals("No")) {
					System.out.println("Tic Tac Toe is finished. Hope you had fun playing!");
					return false;
				} else if (line.equals("Y") || line.equals("Yes")) {
					System.out.println("Next round.");
					return true;
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Expected a Y if want to play again or N for finished. Re-enter: ");
			}

		}
	}

	public void play() {
		int rounds = 0;
		int rows = getRowCol("row");
		int columns = getRowCol("column");
		char[][] board = makeBlankBoard(rows, columns);
		while (true) {
			rounds = playerTurn(PLAYER1, rounds, rows, columns, board);
			if (checkWon(board, PLAYER1)) {
				System.out.println("Player " + PLAYER1 + " won the game!");
				return;
			}
			if (rounds >= rows * columns) {
				//printScore(xWins, oWins);
				//System.out.println("Current score is Player X with " xWins + " wins and Player O with " + oWins");
				System.out.println("It's a tie, nobody wins!");
				return;
			}
			playerTurn(PLAYER2, rounds, rows, columns, board);
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

	public int playerTurn(char player, int rounds, int rows, int columns, char[][] board) {
		int[] xCoords = getCoordinates(player, board, rows, columns);
		board[xCoords[0]][xCoords[1]] = player;
		printBoard(board);
		return rounds++;
	}

	private int getRowCol(String input) {
		System.out.println("Enter the desired " + input + " :");
		while (true) {
			try {
				Scanner reader = new Scanner(System.in);
				int rowCol = reader.nextInt();
				if (rowCol < 2 || rowCol > 50) {
					throw new IllegalArgumentException();
				}
				return rowCol;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please enter an integer. Re-enter: ");
			} catch (IllegalArgumentException f) {
				System.out.println("Please enter an integer between 1 and 50. Re-enter: ");
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