import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		boolean checkWinCombination = true;
		Board board = new Board();
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player(InputHandler.askUserName(), InputHandler.askUserSign()));
		playerList
				.add(new Player(InputHandler.askUserName(), InputHandler.assignSignThatIsLeft(playerList.get(0).sign)));
		board.printBoard();
		while (Board.isNextMove) {
			for (Player player : playerList) {
				userMovement(board, player);
				checkWinCombination=checkWin(board, player.sign);
				if (checkWinCombination) {
					System.out.println("Hurra! You, " + player.name + " have WON the round!");
					Board.isNextMove = false;
					break;
				}
			}
			if (!(Board.isNextMove)&&(!(checkWinCombination))){
				System.out.println("Draw");
				break;
			}
		}
	}

	public static boolean userMovement(Board board, Player player) {
		int x;
		do {
			System.out.println("Your turn, " + player.sign + " . Select free place and enter it's number");
			x = InputHandler.askForNextMove();
		} while (!player.SetMove(board, x) && Board.isNextMove);
		board.printBoard();
		return board.isNextMove;
	}

	public static boolean checkWin(Board board, Signs signUser) {
		int[][] winWays = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 }, { 1, 5, 9 },
				{ 3, 5, 7 } };
		for (int i = 0; i < 8; i++) {
			int matches = 0;
			for (int j = 0; j < 3; j++) {
				int x = (winWays[i][j] - 1) / 3;
				int y = winWays[i][j] - 3 * x - 1;
				if (board.board[x][y] != signUser.toString().charAt(0))
					continue;
				else
					matches++;
				if (matches == 3)
					return true;
			}
		}
		return false;
	}

}
