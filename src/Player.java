
public class Player {

	private final char id;
	private int wins;

	public Player(char id) {
		this.id = id;
		setWins(0);
	}

	public char getId() {
		return id;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
}
