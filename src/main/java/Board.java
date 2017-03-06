/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Board {

	public static boolean isNextMove = true; // value to check if there are
												// still free spaces. If there
												// is any - it will have status
												// true
	public static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

	public void printBoard() {
		int seat = 0;
		int freeSeats = 0;
		for (int i = 0; i < 3; i++) {
			seat = 3 * i + 1;
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					System.out.print(seat + " |");
					freeSeats += 1;
				} else
					System.out.print(" " + board[i][j] + "|");
				seat++;

			}
			System.out.println();
		}
		checkForNextMoveFreeSpace(freeSeats);
	}

	private void checkForNextMoveFreeSpace(int freeSeats) {
		if (freeSeats >= 1)
			this.isNextMove = true;
		else
			this.isNextMove = false;
	}

}
