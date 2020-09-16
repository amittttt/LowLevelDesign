package TicTacToeGame;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to our Tic Tac Toe Play Zone....");
		Scanner sc = new Scanner(System.in);
		PlayGame playGame = new PlayGame("Amit Mishra","Mohak Soni");
		System.out.println("Start New Game or Reset Game plase press R");
		Move move = new Move();
		GameStatus gameStatus;
		Player player;
		
		while(1==1) {
			try {
				player = playGame.playerChance();
				System.out.println( player.getName() +"'s Chance");
				move.setX(sc.nextInt());
				move.setY(sc.nextInt());
				if(move.validateMove()) {
					gameStatus = playGame.play(move,player);
					if(gameStatus==GameStatus.Tie) {
						System.out.println("Game Tie ... ");
						break;
					}else if(gameStatus == GameStatus.Winner) {
						System.out.println("Game Winner "+ playGame.getWinnerPlayerDetails().getName());
						break;
					}
				}else {
					System.out.println("OOPs "+player.getName()+" !!This is not a valid move.");
				}
			}catch(Exception ex) {
				// Log the Exception
				System.out.println("Error: "+ex.getMessage());
			}
			
		}
		sc.close();
		
	}
}
