package TicTacToeGame;

public class Move {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean validateMove() {
		if(this.x<3 && this.x>=0 && this.y<3 && this.y>=0)
			return true;
		return false;
	}
}
