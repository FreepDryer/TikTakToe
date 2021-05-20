package TikTakToe;

/**
 * 
 * @author Xander
 *
 */

public class TicTacToe {
	
	    private final String[][] board;
	    private int turn;
	    /**
	     * Creates a new Tic Tac Toe board.  Instantiates the 3x3 board
	     * with all dashes or other place holders.
	     * 
	     * initializes number of turns taken to equal 0
	     */
	    
	    public TicTacToe() {
	      board = new String[][]{
				{
					"-", "-", "-"
				},
				{
					"-", "-", "-"
				},
				{
					"-", "-", "-"
				}
			};
	      turn = 0;
		}
	    
	    
	   
	    /**
	     * Getter method for current turn number
	     * @return number of turns taken
	     */
	    
	    public int getTurn() {
	    	return turn;
	    }
	    
	    
	    
	   
	   /**
	    * This method prints out the board array on to the console
	    */
	    
	   public void printBoard()
	   {
		   for (String[] strings : board) {
			   for (String string : strings) {
				   System.out.print(string);
			   }
			   System.out.println();
		   }
	       
	   }
	   
	   /**
	    * 
	    * This method determines if space row, col is an available space to choose
	    * @return: true if the board[row][col] is available, false otherwise
	    * 
	    */
	   
	   public boolean pickLocation(int row, int col)
	   {
		   return board[row][col].equals("-");
	   }
	   
	   /**
	    * 
	    * This method places an X or O at board[row][col] based on the int turn
	    */
	   
	   public void takeTurn(int row, int col)
	   {
	      if(turn % 2 == 1){
	      	board[row][col] = "O";
		  }
	      else{
	      	board[row][col] = "X";
		  }
		   turn++;
	   }
	   
	   /**
	    * 
	    * This method checks if any row has all X's or all Os
	    * @return: true if there is a row with all the same value, false otherwise. 
	    */
	   
	   
	   public boolean checkRow()
	   {
	   		int count = 0;
		   for (String[] strings : board) {
			   for (String c : strings) {
				   if (c.equals("X")) {
					   count++;
				   } else if (c.equals("O")) {
					   count--;
				   }
			   }
			   if (count == 3 || count == -3) {
				   return true;
			   } else {
				   count = 0;
			   }
		   }
	   		return false;
	   }
	   
	   
	   /**
	    * 
	    * This method checks if any col has all X's or all Os
	    * @return: true if there is a col with all the same value, false otherwise. 
	    */
	   
	   public boolean checkCol()
	   {
		   int count = 0;
		   for(int c = 0; c < board[0].length; c++){
			   for (String[] strings : board) {
				   if (strings[c].equals("X")) {
					   count++;
				   } else if (strings[c].equals("O")) {
					   count--;
				   }
			   }
			   if(count == 3 || count == -3){
				   return true;
			   }
			   else{
				   count = 0;
			   }
		   }
		   return false;
	   }
	   
	   
	   /**
	    * 
	    * This method checks if either diagonal has all X's or all Os
	    * @return: true if either diagonal with all the same value, false otherwise. 
	    */
	   
	   public boolean checkDiag()
	   {
	   		int count = 0;
			for(int r = 0; r < board.length; r++){
				if(board[r][r].equals("X")){
					count++;
				}
				else if(board[r][r].equals("O")){
					count--;
				}
				if(count == 3 || count == -3) {
					return true;
				}

			}
			count = 0;
		   for(int r = board.length - 1; r >= 0; r--){
			   if(board[r][r].equals("X")){
				   count++;
			   }
			   else if(board[r][r].equals("O")){
				   count--;
			   }
			   if(count == 3 || count == -3) {
				   return true;
			   }

		   }
		   return false;

	   }
	   
	   /**
	    * 
	    * This method checks if a player has won the game via a row, col, or diagonal
	    * @return: true if the game is won, false otherwise
	    */
	   public boolean checkWin()
	   {
		   return checkRow() || checkCol() || checkDiag();
	   }

}
