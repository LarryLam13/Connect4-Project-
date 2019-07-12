import java.awt.Color;

public class ConnectFour {
	
public static void main(String[] args){
		
		String p1c;
		String p2c;		
		String Answer;
		String AnswerAI;
		String YES = null;
		String NO =null;
		int row= 6;
		int col=7;
		Board board;
		ChipColor temp2;
		AIPlayer p2 = new AIPlayer(2, 6, 7);

		
//=============================================================================================================================		
		System.out.println("Would you like the default board size? ENTER 'YES' OR 'NO'");
		Answer=IO.readString();
		Answer=Answer.toUpperCase();		
		if( Answer.equals("YES")){
		 board = new Board();
		}
		else {
			
		System.out.print("Enter the number of rows: ");
		 row= IO.readInt();
		System.out.print("Enter the number of cols: ");
		 col=IO.readInt();
			 board= new Board(row,col);
		}
//====================================================================================================================
		
			System.out.print("Enter the color chip for player 1: ");
			p1c=IO.readString();
			p1c = p1c.toUpperCase();
			while (!(p1c.equals("BLACK")) && (!(p1c.equals("RED")) && (!(p1c.equals("BLUE")) && (!(p1c.equals("PURPLE")) && (!(p1c.equals("GREEN"))))))){ 
				System.out.println("Color is not valid. Enter a new color: ");
				p1c=IO.readString();
				p1c=p1c.toUpperCase();
			}
			ChipColor temp1;
			temp1 = ChipColor.valueOf(p1c);
			
//=========================================================================================================
			System.out.println("Would you like to play aganist a computer? Enter YES or NO: ");
			AnswerAI=IO.readString();
			AnswerAI=AnswerAI.toUpperCase();
			if(AnswerAI.equals("YES")){
				temp2=ChipColor.valueOf("RED");
				if (p1c.equals("RED")){
					temp2=ChipColor.valueOf("BLACK");
				}
			}
			//===========================================================================================================
			
			else {
				System.out.print("Enter the color chip for player 2: ");
				p2c=IO.readString();
				p2c = p2c.toUpperCase(); 
				while (!(p2c.equals("BLACK")) && (!(p2c.equals("RED")) && (!(p2c.equals("BLUE")) && (!(p2c.equals("PURPLE")) && (!(p2c.equals("GREEN"))))))){ 
					System.out.println("Color is not valid. Enter a new color: ");
					p1c=IO.readString();
				}
					while((p2c.equals(p1c))) { 
						System.out.print("Re-Enter the color chip for player 2 (cannot be the same as player one) : ");
						p2c=IO.readString();
						p2c = p2c.toUpperCase(); 
					}
					
				temp2 = ChipColor.valueOf(p2c);
			}
			
			
//======================================================================================================================
			CFGUI t = new CFGUI(board,temp1,temp2);
			t.redraw();
//======================================================================================================================		
		//game 
			int p=1; 
			while (board.isFinished() == -1 && p==1){
				System.out.print("PLayer One insert what column you would like to play your chip: ");
				int c=IO.readInt();
				if( c >= board.getNumCols() || c < 0 ){
					System.out.print("BAD INPUT (OUT OF BOUNDS) TRY AGAIN: ");
					c= IO.readInt();
				}
				if ( board.board[0][c] !=' '){
					System.out.print("Bad input (out of bounds) TRY AGAIN: "); 
				}
				
				board.play(1, c);
				p2.board.play(1, c);
				t.redraw();
				if (board.isFinished()==1){
					System.out.print("winner:Player ONE!");
					t.close();
					break;
				}
				
					p++;
//======================================================================================
				if(p==2 && AnswerAI.equals("YES")){
					board.play(2,p2.playToken());
					t.redraw();
					p=1;
				}
				if( p==2){
					System.out.print("Player Two insert what column you would like to play your chip: ");
					c= IO.readInt();
					if( c >=board.getNumCols() || c< 0 ){
						System.out.print("BAD INPUT (OUT OF BOUNDS) TRY AGAIN: ");
						c= IO.readInt();
					}
					if ( board.board[0][c] !=' '){
						System.out.print("Bad input (out of bounds) TRY AGAIN: "); 
					}
					board.play(2, c);
					if (board.isFinished()==2)
						System.out.print("winner:PLayer TWO!");	
						t.redraw();
						p++;
					if (p==3){
						p=1;
					}
				}
				if( board.isFinished()==0){
					System.out.print("TIE GAME");
					t.close();
				}
			}
			}
}