import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeTest {
	
	private TicTacToe ticTacToe;
	
	@Before
	public void setup() {
		ticTacToe = new TicTacToe();
	}

	@Test
	public void test0() {
		char[][] tempBoard = {{'O', ' ', 'O'}, {' ', 'O', ' '},{' ', ' ', 'O'}};
		Assert.assertTrue(ticTacToe.checkWon(tempBoard, 'O'));
	}
	
	@Test
	public void test1() {
	}
	
	@Test
	public void test2() {
		//char[][] tempBoard = {{'O',' ' , 'O'}, {' ', 'O',' '},{' ', ' ', 'O'}};
		
	}
	
}
