import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		char[][] boardGame = {{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '}};
		
		try (Scanner scan = new Scanner(System.in)) {
			boolean running = true;
			int times = 0;
			printBoardGame(boardGame);
			
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
				}
				
				if (winCheck(boardGame, currPlayerMarker)) {
					System.out.println(currPlayer + " won the match Congratulation!!");
					running = false;
				} else if (times > 8) {
					System.out.println("Oops it's a draw");
					running = false;
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


	public static boolean notFilled(char[][] boardGame, int pos) {
		
		int a, b;
		switch (pos) {
			case 1:
				a = 0; b = 0;
				break;
			case 2:
				a = 0; b = 2;
				break;
			case 3:
				a = 0; b = 4;
				break;
			case 4:
				a = 2; b = 0;
				break;
			case 5:
				a = 2; b = 2;
				break;
			case 6:
				a = 2; b = 4;
				break;
			case 7:
				a = 4; b = 0;
				break;
			case 8:
				a = 4; b = 2;
				break;
			case 9:
				a = 4; b = 4;
				break;
			default:
				return false;
		}
		return boardGame[a][b] == ' ';
	}


	public static char playerMarker(int times) {
		if (times % 2 == 0) {
			return 'X';
		} else {
			return 'O';
		}
		
	}


	public static void placePiece(char[][] boardGame, int pos, char symbol) {
		
		switch (pos) {
			case 1:
				boardGame[0][0] = symbol;
				break;
			case 2:
				boardGame[0][2] = symbol;
				break;
			case 3:
				boardGame[0][4] = symbol;
				break;
			case 4:
				boardGame[2][0] = symbol;
				break;
			case 5:
				boardGame[2][2] = symbol;
				break;
			case 6:
				boardGame[2][4] = symbol;
				break;
			case 7:
				boardGame[4][0] = symbol;
				break;
			case 8:
				boardGame[4][2] = symbol;
				break;
			case 9:
				boardGame[4][4] = symbol;
				break;
			default:
				break;
		}
	}


	public static boolean winCheck(char[][] boardGame, char marker) {
		boolean top = (boardGame[0][0] == marker) && (boardGame[0][2] == marker) && (boardGame[0][4] == marker);
		boolean middle = (boardGame[2][0] == marker) && (boardGame[2][2] == marker) && (boardGame[2][4] == marker);
		boolean bottom = (boardGame[4][0] == marker) && (boardGame[4][2] == marker) && (boardGame[4][4] == marker);
		
		boolean right = (boardGame[0][4] == marker) && (boardGame[2][4] == marker) && (boardGame[4][4] == marker);
		boolean left = (boardGame[0][0] == marker) && (boardGame[2][0] == marker) && (boardGame[4][0] == marker);
		boolean column_middle = (boardGame[0][2] == marker) && (boardGame[2][2] == marker) && (boardGame[4][2] == marker);
		
		boolean diagonal1 = (boardGame[0][0] == marker) && (boardGame[2][2] == marker) && (boardGame[4][4] == marker);
		boolean diagonal2 = (boardGame[0][4] == marker) && (boardGame[2][2] == marker) && (boardGame[4][0] == marker);
		
		return top || middle || bottom || right || left || column_middle || diagonal1 ||diagonal2;
		
	}


	public static void printBoardGame(char[][] boardGame) {
		for (char[] a : boardGame) {
			for (char b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}
}
