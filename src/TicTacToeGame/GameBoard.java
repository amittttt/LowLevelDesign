package TicTacToeGame;

public class GameBoard {
	private final int row;
	private final int col;
	private MoveEnum[][] board;
	private int countMove=0;
	private MoveEnum winningPlayerSymbol;
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public MoveEnum[][] getBoard() {
		return board;
	}

	public int getCountMove() {
		return countMove;
	}

	public MoveEnum getWinningPlayerSymbol() {
		return winningPlayerSymbol;
	}

	public GameBoard() {
		row=col=3;
		board = new MoveEnum[row][col];
	}
	
	public GameBoard(int row, int col) {
		this.row=row;
		this.col=col;
		board = new MoveEnum[row][col];
	}
	
	public boolean resetGameBoard() {
		board = new MoveEnum[row][col];
		return true;
	}
		
	public boolean undoMove() {
		return true;
	}
	
	protected GameStatus doMove(Move move, Player player) {
		if(isMovePossible(move)) {
			countMove++;
			board[move.getX()][move.getY()]= player.getSymbol();
		}
		if(countMove>4) {
			GameStatus gameStatus = getBoardStatus();
			return gameStatus;
		}
		
		return GameStatus.OnProgress;
	}
	
	private boolean isMovePossible(Move m) {
		if(board[m.getX()][m.getY()]==null) {
			return true;
		}
		else if(countMove>9) {
			System.out.println("Move is not possible, board is full.");
		}else {
			System.out.println("Move is already occupied ");
		}
		return false;
	}

	protected int PlayerTurn() {
		if(countMove%2==0)
			return 1;
		return 2;
	}
	
	public GameStatus getBoardStatus() {
		if(countMove==9)
			return GameStatus.Tie;	
		// Check cross conditions
		if(board[0][0]!=null&& board[1][1]!=null && board[2][2]!=null
				&& board[2][0]!=null && board[2][2]!=null
				&& (board[0][0]==board[1][1])&&(board[1][1]==board[2][2]) 
				&& (board[0][2]==board[1][1])&&(board[1][1]==board[2][0])) {
			winningPlayerSymbol = board[1][1];
 			return GameStatus.Winner;
		}
		// Check Coloums
		for(int c=0; c<col;c++) {
			if(board[c][0]!=null&& board[c][1]!=null && board[c][2]!=null 
					&& (board[c][0]==board[c][1] && board[c][1]==board[c][2])) {
				winningPlayerSymbol = board[c][0];
				return  GameStatus.Winner;
			}

		}
		// Check Cols
		for(int r=0; r<col;r++) {
			if(board[0][r]!=null&& board[1][r]!=null && board[2][r]!=null 
					&& board[0][r]==board[1][r] && board[1][r]==board[2][r]) {
				winningPlayerSymbol = board[0][r];
				return  GameStatus.Winner;
			}
		}
		return GameStatus.OnProgress;	
	}
	
}
