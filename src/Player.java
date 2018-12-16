
public class Player {
	private char id;
	private int wins;
	
	public Player(char id) {
		setWins(0);
		setId(id);
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
}
