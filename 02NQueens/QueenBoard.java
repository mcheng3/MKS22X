public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int n){
	board = int[n][n];
    }

    public boolean solve(){
	return solveHelper(board.length); 
    }

    public boolean solveHelper(int queensRemaining){
	if(queensRemaining == 0) return true;
	else if(
    }

