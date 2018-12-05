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
		int rows = 3;
		int columns = 3;
		char[][] board = makeBlankBoard(rows, columns);
		while (true) {
			int[] xCoords = getCoordinates(PLAYER1);
			board[xCoords[0]][xCoords[1]] = PLAYER1;
			rounds++;
			if (checkWon(board, PLAYER1)) {
				System.out.println("Player " + PLAYER1 + " won the game!");
				printBoard(board);
				return;
			}
			if (rounds >= rows * columns) {
				System.out.println("It's a tie, nobody wins!");
				return;
			}
			printBoard(board);
			int[] oCoords = getCoordinates(PLAYER2);
			rounds++;
			board[oCoords[0]][oCoords[1]] = PLAYER2;
			if (checkWon(board, PLAYER2)) {
				System.out.println("Player " + PLAYER2 + " won the game!");
				printBoard(board);
				return;
			}
			printBoard(board);
			if (rounds >= rows * columns) {
				System.out.println("It's a tie, nobody wins!");
				return;
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
			forwardslashDiagonalCount += board[winCount - 1 - i][winCount - 1 - i] == player ? 1 : 0;
		}
		if (backslashDiagonalCount == winCount || forwardslashDiagonalCount == winCount) {
			return true;
		}
		return false;
	}
	
	public void printBoard(char[][] board) {
		System.out.println("Current board: ");
		System.out.println();
		//System.out.println("_______");
		for (int i = 0; i < board.length; i++) { 
			System.out.print("|");
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
	}

	public int[] getCoordinates(char player) {
		int[] coords = new int[2];
		Scanner reader = new Scanner(System.in);
		System.out.println("Player " + player + " enter row: ");
		coords[0] = reader.nextInt();
		System.out.println("Player " + player + " enter column: ");
		coords[1] = reader.nextInt();
		//reader.close();
		return coords;
	}
}
