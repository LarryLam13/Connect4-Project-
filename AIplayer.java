public class AIPlayer implements Player{

	int row;
	int col;
	int playerID;
	Board board;
	int foe; 

	public AIPlayer(int playerID, int row, int col){
		this.playerID=playerID;
		this.row=row; 
		this.col=col;
		board = new Board(row,col);
		
		if( playerID==1){ 
	    foe=2;
}
		if (playerID==2){
	    foe=1; 
}
		
	}

	
	
	
	public void lastMove(int c) {
		board.play(foe , c);
	}
	
	
	public int playToken(){
		int column=0; 
		for (int i = 0 ; i < col; i++){
			if (board.play(playerID,i)){
				column=i;
				break;
			}
		}
	
		
		
		return column;
	}


	
	
	
