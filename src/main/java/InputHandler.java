import java.util.Scanner;

public class InputHandler {
	private static Scanner sc = new Scanner(System.in);

	public static Signs askUserSign() {
		Signs sign = null;
		System.out.print("Select whom you want to play X or O: ");
		while (sign == null) {
			try {
				sign = Signs.valueOf(sc.nextLine());
			} catch (IllegalArgumentException e) {
				System.out.print("Please enter valid sign X or O. ");
			}
		}
		return sign;
	}

	public static String askUserName() {
		System.out.print("Enter your name: ");
		return sc.nextLine();
	}

	public static Signs assignSignThatIsLeft(Signs signPlayer1) {
		// Checks what sign has been selected by 1st player and assign left sign
		// for 2nd user
		if (signPlayer1 == Signs.O)
			return Signs.X;
		else
			return Signs.O;
	}

	public static int askForNextMove() {

		int x1 = 0;
		while (!(x1>0 && x1<=9)) {
			Scanner sc = new Scanner(System.in);
			try {
				x1 = sc.nextInt();
				if (x1 == 0 || x1 >9)
					System.out.println("Enter valid value from 1..9");
			} catch (Exception e) {
				System.out.println("Enter valid value from 1..9");
			}
		}
		return x1;
	}
}
