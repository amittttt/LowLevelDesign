package TicTacToeGame;
import java.util.ArrayList;

public class PlayGame {
	private ArrayList<Player> playerList;
	private GameBoard gameBoard;
	
	public PlayGame(String playerName1, String playerName2) {
		playerList = new ArrayList<Player>();
		playerList.add(new Player(playerName1,1,MoveEnum.CROSS));
		playerList.add(new Player(playerName2,2,MoveEnum.CIRCLE));
		gameBoard = new GameBoard();
	}
	
	public GameStatus play(Move move, Player player) {
		player.setPlayerMoveHistory(move);
		return gameBoard.doMove(move,player);
	}
	
	public Player playerChance() {
		Player playerDetails = null;
		int playerId = gameBoard.PlayerTurn();
		for (Player player : playerList) {
			if(player.getId()==playerId)
				playerDetails=player;
		}
		return playerDetails;
	}
	
	public Player getWinnerPlayerDetails() {
		MoveEnum symbol = gameBoard.getWinningPlayerSymbol();
		Player winner = new Player();
	 	for(Player pl : playerList) {
			if(pl.getSymbol()==symbol)
				winner= pl;
		}
	 	return winner;
	}
	
}
