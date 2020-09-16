package TicTacToeGame;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	private String name;
	private int id;
	private MoveEnum symbol;
	private ArrayList<Move> playerMoveHistory;
	private HashMap<Integer, Move> playerMoves = new HashMap<Integer, Move>();
	
	public Player() {
		
	}
	
	public Player(String name, int id, MoveEnum symbol) {
		this.name = name;
		this.id = id;
		this.symbol = symbol;
		playerMoveHistory= new ArrayList<Move>();
	}
	
	public void setPlayerMoveHistory(Move m) {
		this.playerMoveHistory.add(m);
	}
	
	public ArrayList<Move> getPlayerMoveHistory(Move m) {
		return this.playerMoveHistory;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public MoveEnum getSymbol() {
		return this.symbol;
	}
}
