
public class Player {
	public Signs sign;
	public String name;

	public Player(String name, Signs sign) {
		this.name = name;
		this.sign = sign;
	}

	public boolean SetMove(Board board, int x1) {
		int i = (x1 - 1) / 3;
		int j = x1 - 3 * i - 1;
		if (board.board[i][j] == ' ') {
			board.board[i][j] = sign.toString().charAt(0);
			return true;
		} else
			return false;
	}

}
