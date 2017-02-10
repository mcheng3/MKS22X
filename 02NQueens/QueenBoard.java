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
	    for(int col = board.length, col > 0, col++){
		if(board[row][col] == 0){
		    board[row][col] = 1;
		}
	    }
	}
		    
		
    }
    private void fill(int row, int col){
	if(

