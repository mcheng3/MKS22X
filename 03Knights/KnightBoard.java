public class KnightBoard{
    private int[][] board;
    private boolean hasSolved = true;

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
	solveH(0, 0, 1);    
    }

    public boolean solveH(int row, int col, int level){
        if(level == board.length * board[0].length){
	    board[row][col] = level;
	    return true;
	}
	else{
	    try{
		if(board[row][col] == 0){
		board[row][col] = level;
		if(solveH(row + 2, col + 1, level + 1)||
		    solveH(row + 2, col - 1, level + 1)||
		    solveH(row - 2, col + 1, level + 1)||
		    solveH(row - 2, col - 1, level + 1)||
		    solveH(row + 1, col + 2, level + 1)||
		    solveH(row + 1, col - 2, level + 1)||
		    solveH(row - 1, col + 2, level + 1)||
		   solveH(row - 1, col - 2, level + 1)){
		    return true;
		}
		board[row][col] = 0;
		}
		System.out.println(toString());
	    }
	    catch(IndexOutOfBoundsException e){
		return false;
	    }
		
	    return false;
	}
    }


    public static void main(String[] args){
	KnightBoard k = new KnightBoard(4, 5);
	k.solve();
	System.out.println(k.toString());
    }
}
