public class Board{
  char player1;
  char player2;
char [][] board;  

    public Board(){
    	board = new char [6] [7];
        for ( int i = 0; i < board.length; i++){
        	
            for ( int j = 0; j < board[0].length; j++){
            	
                board[i][j] = ' ';
            }
        }
        player1 = '1';
        
        player2 = '2';
    }  
	
    public Board(int row, int col){
    	
    	board = new char [row] [col];
    	
		for ( int i = 0; i < board.length; i++){
			
            for ( int j = 0; j < board[0].length; j++){
            	
            	board[i][j] = ' ';
            } 
		}
        player1 = '1';
        
        player2 = '2';    
    } 
	
	public int getNumRows(){
		
		return board.length;
	} 
	public int getNumCols(){
		
		return board[0].length;
	} 


	public char getPlayerOne(){
		return player1;
	} 
	public char getPlayerTwo(){
		return player2;
	} 

	public void setPlayerOne(char o){
		player1 = o;
	} 
	public void setPlayerTwo(char t){
		player2 = t;
	} 
  
	public char getToken(int row, int col){
		if (row >= 0 && row < board.length && col >= 0 && col < board[0].length)
			return board[row][col];
		else 
			return '\0';
		} 

	public boolean canPlay(){
		for ( int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				if ( board[i][j] == ' ')
					return true;
				}
			}		
		return false;           
		} 
  

	public boolean play(int p, int c){
		int numcols=getNumCols();
		
		if (c <numcols && c>= 0){
			
			for (int row = board.length -1; row > -1; row--){
				
				if (board[row][c] == ' ' && canPlay()== true){
					
					if (p == 1) {
						 board[row][c]= player1;
						return true;
					}
					
					else if (p == 2){ 
						board[row][c]= player2;                             
						return true;
					}
				}
			}
		} 
		return false; 
	}


	private boolean outOfBounds(int x, int y) {
		if((x>= board.length || x<0)||(y>= board[0].length || y<0)){
			return true;
			}
			return false;	
			}
					
	 public int isFinished(){
		int count = 1;

		for ( int i = 0; i < board.length; i++){	
			count = 1;		
				for ( int j = 0; j < board[0].length-1; j++){						
					if (board[i][j] != ' ' && board[i][j+1] == board[i][j]){
						count++;
						if (count>= 4){
							
							if (board[i][j] == player1){
								return 1;
							}
							else
								return 2;
							}
						}
					else 
						count = 1;
					}
				}
		
		for (int j = 0; j < board[0].length; j++){
			count = 1;
				for (int i = 0; i < board.length-1; i++){					
					if (board[i][j] != ' ' && board[i+1][j] == board[i][j]){
						count++;
						if (count>= 4){
							
							if (board[i][j] == player1){
								return 1;
							}
							else
								return 2;
							}
							}
						else 
							count = 1;
						}
				}
		
		for (int i = 0; i < board.length-1; i++){
			count = 1;
				for (int j = 0; j < board[0].length; j++){
					count = 1;
						for (int k = 1; k < board.length; k++){
							if(this.outOfBounds(i+k,j+k)){
								break;
							}
							if (board[i][j] != ' ' && board[i][j] == board[i+k][j+k]){
								count++;
								if (count>= 4){
									
									if (board[i][j] == player1)
										{
									return 1;
								}
									else
										return 2;
									}
									}
									else 
										count = 1;								
							}
							
						}					
					}
				
		for (int i = board.length-1; i > -1; i--){
			count = 1;
				for (int j = 0; j < board[0].length; j++){
					count = 1;
						for (int k = 1; k < board.length; k++){
							if(this.outOfBounds(i-k,j+k)){
								break;
							}
							if (board[i][j] != ' ' && board[i][j] == board[i-k][j+k]){
								count++;
								if (count>= 4){
									
									if (board[i][j] == player1){
									return 1;
								}
									else
										return 2;
								}
							}
								else 
									count = 1;							
						}
				}					
		}
		if (canPlay()== false)
			return 0;
		else 
			return -1;
			
	}
}
 