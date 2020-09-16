package TicTacToeGame;

public enum MoveEnum {
	CIRCLE ("O"),
	CROSS ("X");
	
	private String symbol;
	
	private MoveEnum(String symbol) {
		this.symbol = symbol;
	}
	
	// Getter Method :
	public String toString() {
		return this.symbol;
	}
}
