import java.util.Scanner;

public class TicTacToe {
	
	static final char[] boardRef = {'$', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	public static void main(String[] args) {
		char[] boardGame = {'$', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		
		try (Scanner scan = new Scanner(System.in)) {
			boolean running = true;
			int times = 0;
			
			System.out.println("This is the keymaps of input : ");
			printBoardGame(boardRef);
			
			while (running) {
				String currPlayer = playerTurn(times);
				char currPlayerMarker = playerMarker(times);
				System.out.println("It's " + currPlayer + " turn now.");
				System.out.println("Enter the position (1-9):");
				int pos = scan.nextInt();
				
				for (int i = 0; i < 50; i++) System.out.println();
				
				if (notFilled(boardGame, pos)) {
					placePiece(boardGame, pos, currPlayerMarker);
					printBoardGame(boardGame);
					times ++;
				} else {
					System.out.println("The entered position is invalid or already filled.");
					printBoardGame(boardGame);
				}
				
				if (winCheck(boardGame, currPlayerMarker)) {
					System.out.println(currPlayer + " won the match Congratulation!!");
					System.out.print("Do you want to play again (Y|N) :");
					String response = scan.next();
					if (response.startsWith("Y") || response.startsWith("y")) {
						running = true;
					} else {
						running = false;
					}
				} else if (times > 8) {
					System.out.println("Oops it's a draw");
					System.out.print("Do you want to play again (Y|N) :");
					String response = scan.next();
					if (response.startsWith("Y") || response.startsWith("y")) {
						running = true;
					} else {
						running = false;
					}
				}
			}
		}
	}


	public static String playerTurn(int times) {
		if (times % 2 == 0) {
			return "Player1";
		} else {
			return "Player2";
		}
	}


	public static boolean notFilled(char[] boardGame, int pos) {
		
		return boardGame[pos] == ' ';
	}


	public static char playerMarker(int times) {
		if (times % 2 == 0) {
			return 'X';
		} else {
			return 'O';
		}
		
	}


	public static void placePiece(char[] boardGame, int pos, char symbol) {
		
		boardGame[pos] = symbol;
		
	}


	public static boolean winCheck(char[] boardGame, char marker) {
		boolean top = (boardGame[1] == marker) && (boardGame[2] == marker) && (boardGame[3] == marker);
		boolean middle = (boardGame[4] == marker) && (boardGame[5] == marker) && (boardGame[6] == marker);
		boolean bottom = (boardGame[7] == marker) && (boardGame[8] == marker) && (boardGame[9] == marker);
		
		boolean left = (boardGame[1] == marker) && (boardGame[4] == marker) && (boardGame[7] == marker);
		boolean right = (boardGame[3] == marker) && (boardGame[6] == marker) && (boardGame[9] == marker);
		boolean column_middle = (boardGame[2] == marker) && (boardGame[5] == marker) && (boardGame[8] == marker);
		
		boolean diagonal1 = (boardGame[1] == marker) && (boardGame[5] == marker) && (boardGame[9] == marker);
		boolean diagonal2 = (boardGame[3] == marker) && (boardGame[5] == marker) && (boardGame[7] == marker);
		
		return top || middle || bottom || right || left || column_middle || diagonal1 ||diagonal2;
		
	}


	public static void printBoardGame(char[] boardGame) {
		System.out.println("       |       |");
		System.out.println("   " + boardGame[1] + "   |" + "   " + boardGame[2] + "   |" + "   " + boardGame[3]);
		System.out.println("       |       |");
		System.out.println("-------+-------+-------");
		System.out.println("       |       |");
		System.out.println("   " + boardGame[4] + "   |" + "   " + boardGame[5] + "   |" + "   " + boardGame[6]);
		System.out.println("       |       |");
		System.out.println("-------+-------+-------");
		System.out.println("       |       |");
		System.out.println("   " + boardGame[7] + "   |" + "   " + boardGame[8] + "   |" + "   " + boardGame[9]); 
		System.out.println("       |       |");
	}
}
