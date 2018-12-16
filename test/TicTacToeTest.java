import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeTest {

	private TicTacToe ticTacToe;
	Player playerX = new Player('X');
	Player playerO = new Player('O');
	
	@Before
	public void setup() {
		ticTacToe = new TicTacToe();
	}

	@Test
	public void test0() {
		char[][] tempBoard = {{'O', ' ', 'O'}, {' ', 'O', ' '},{' ', ' ', 'O'}};
		Assert.assertTrue(ticTacToe.checkWon(tempBoard, playerO));
	}

	@Test
	public void test1() {
		char[][] tempBoard = {{'X', ' ', 'O'}, {' ', 'O', ' '},{' ', ' ', 'O'}};
		Assert.assertFalse(ticTacToe.checkWon(tempBoard, playerO));
	}

	@Test
	public void test2() {
		char[][] tempBoard = {{'X', 'X', 'X'}, {' ', 'O', ' '},{' ', ' ', 'O'}};
		Assert.assertTrue(ticTacToe.checkWon(tempBoard, playerX));
	}

	@Test
	public void testXDiagonal() {
		char[][] tempBoard = {{'O', 'O', 'X'}, {' ', 'X', 'O'},{'X', ' ', 'X'}};
		Assert.assertTrue(ticTacToe.checkWon(tempBoard, playerX));
	}
}
