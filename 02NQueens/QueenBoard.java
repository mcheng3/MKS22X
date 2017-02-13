public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int n){
	board = int[n][n];
    }

    public boolean solve(){
	return solveHelper(board.length); 
    }

    private boolean solveHelper(int row){
	if(row == 0){
	    return true;
	}
	else if(row > 0 && row <= board.length){
	    for(int col = 0; col = board.length; col++){
		fill(row, col);
	}
		    
		
    }
    private void fill(int row, int col){
	int i = 1;
	for(int c = col + 1; c < board.length; c++){

	    if(row - i >= 0 || col - i >= 0){
		board[row - 1][c] = 1;
	    }
	    if(row + i < board.length || col - i >= 0){
		board[row + 1][c] = 1;
	    }
	    board[row][c] = 1;
	    i ++;
	}


		
	    

