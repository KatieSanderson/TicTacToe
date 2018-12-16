import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeTest {

	private static final char X = 'X';
	private static final char O = 'O';
	private static final char I = '_';

	private TicTacToe ticTacToe;
	private Player playerX = new Player(X);
	private Player playerO = new Player(O);

	@Before
	public void setup() {
		Scanner scanner = new Scanner(System.in);
		ticTacToe = new TicTacToe(scanner);
	}

	@Test
	public void testPlayerWinsForwardDiagonal() {
		char[][] tempBoard = {{O, I, I}, {I, O, I}, {I, I, O}};
		Assert.assertTrue(ticTacToe.checkWon(tempBoard, playerO));
	}

	@Test
	public void testPlayerWinsBackwardDiagonal() {
		char[][] tempBoard = {{I, I, O}, {I, O, I}, {O, I, I}};
		Assert.assertTrue(ticTacToe.checkWon(tempBoard, playerO));
	}

	@Test
	public void testNotWon() {
		char[][] tempBoard = {{X, I, O}, {I, O, I}, {I, I, O}};
		Assert.assertFalse(ticTacToe.checkWon(tempBoard, playerO));
	}

	@Test
	public void testRow() {
		char[][] tempBoard = {{X, X, X}, {I, I, I}, {I, I, I}};
		Assert.assertTrue(ticTacToe.checkWon(tempBoard, playerX));
	}

	@Test
	public void testColumn() {
		char[][] tempBoard = {{X, I, I}, {X, I, I}, {X, I, I}};
		Assert.assertTrue(ticTacToe.checkWon(tempBoard, playerX));
	}
}
