public class KnightBoard{
    private int[][] board;
    private boolean hasSolved = false;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	/*
	  for(int r = 0; r<board.length; r++){
	    for(int c = 0; c<board[0].length; c++){
		board[r][c] = 10;
	    }
	}
	*/
    }

    private void clear(){
	for(int r = 0; r<board.length; r++){
	    for(int c = 0; c<board[0].length; c++){
		board[r][c] = 0;
	    }
	}
    }

    public String toString(){
	String ary = "";
	int number;
	if(!hasSolved) return ary;
	for(int r = 0; r < board.length; r++){
	    number = board[r][0];
		if(number < 10){
		    ary += " " + number;
		}
		else{
		    ary += number;
		} 
	    for(int c = 1; c < board[0].length; c++){
		number = board[r][c];
		if(number < 10){
		    ary += "  " + number;
		}
		else{
		    ary += " " +  number;
		}
	    }
	    ary += "\n";
	}
	return ary;
    }
	 

    public void solve(){
	boolean dontStop = true;
	for(int r = 0; r < board.length || dontStop; r++){
	    for(int c = 0; c<board[0].length || dontStop; c++){
		if(solveH(r, c, 1)){
		    hasSolved = true;
		    dontStop = false;
		}
		else clear();
	    }
	}     
    }

    public boolean solveH(int row, int col, int level){
        if(level == board.length * board[0].length){
	    return true;
	}
	else{
	    try{
		if(board[row][col] == 0){
		board[row][col] = level;
		return 
	    }
	    return false;
    }


    public static void main(String[] args){
	KnightBoard k = new KnightBoard(4, 5);
	k.solve();
	System.out.println(k.toString());
    }
}
