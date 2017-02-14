public class QueenBoard{
	private int[][] board;
	private int solutionCount;
	private boolean hasCounted = false;
	
	public QueenBoard(int n){
		board = new int[n][n];
	}

	public boolean solve(){
		if(solveHelper(0)){
			return true;
		} 
		else return false;
	}

	private boolean solveHelper(int row){
		if(row == board.length){
			return true;
		}
		else{	
			for(int c = 0; c < board.length; c ++){
					if(board[row][c] == 0){
						addQueen(row, c);
						if(solveHelper(row + 1)){
							return true;
						}
						removeQueen(row, c);
					}	

			}
			return false;
		}
	}

	public void countSolutions(){
		board = new int[board.length][board.length]; //reset board
		solutionCount = countHelper(0);
		hasCounted = true;
	}


	private int countHelper(int row){
		int sum = 0;
		if(row == board.length){
			return 1;
		}
		else{	
			for(int c = 0; c < board.length; c ++){
					if(board[row][c] == 0){
						addQueen(row, c);
						if(true){ //I have no idea why this works. I just randomly put it there for testing purposes and it actuallyworked.
							sum += countHelper(row + 1);
						}
						removeQueen(row, c);
					}	

			}
			return sum;
		}
	}

	public int getSolutionCount(){
		if(!hasCounted) return -1;
		else return solutionCount;
	}

	private void addQueen(int row, int col){
		int i = 1;
		board[row][col] = 1;
		for(int r = row + 1; r < board.length; r++){
			if(col - i >= 0){
				board[r][col - i] += 2;
			}
			if(col + i < board.length){
				board[r][col + i] += 2;
			}
			board[r][col] += 2;
			i ++;
		}
		//System.out.println("Add\n" + toStringDebug());
	}

	private void removeQueen(int row, int col){
		int i = 1;
		board[row][col] = 0;
		for(int r = row + 1; r < board.length; r++){
			if(col - i >= 0){
				board[r][col - i] -= 2;
			}
			if(col + i < board.length){
				board[r][col + i] -= 2;
			}
			board[r][col] -= 2;
			i ++;
		}
		//System.out.println("Remove\n" + toStringDebug());
	}

	private String toStringDebug(){
		String ary = "";
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board.length; c ++){
				ary += board[r][c] + " ";
			}
			ary += "\n";
		}
		return ary;
	}

	public String toString(){
		String ary = "";
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board.length; c ++){
				if(board[r][c] == 1) ary += 'Q';
				else ary += '_';
			}
			ary += "\n";
		}
		return ary;
	}

	public static void main(String[] args){
		QueenBoard q1 = new QueenBoard(1);
		System.out.println(q1.solve());
		System.out.println(q1.toString());
		System.out.println("Count: " + q1.getSolutionCount());
		q1.countSolutions();
		System.out.println("Count: " + q1.getSolutionCount());
		System.out.println(q1.toString());
		QueenBoard q2 = new QueenBoard(2);
		System.out.println(q2.solve());
		System.out.println(q2.toString());
		System.out.println("Count: " + q2.getSolutionCount());
		q2.countSolutions();
		System.out.println("Count: " + q2.getSolutionCount());
		System.out.println(q2.toString());
		QueenBoard q3 = new QueenBoard(3);
		System.out.println(q3.solve());
		System.out.println(q3.toString());
		System.out.println("Count: " + q3.getSolutionCount());
		q3.countSolutions();
		System.out.println("Count: " + q3.getSolutionCount());
		System.out.println(q3.toString());
		QueenBoard q4 = new QueenBoard(4);
		System.out.println(q4.solve());
		System.out.println(q4.toString());
		System.out.println("Count: " + q4.getSolutionCount());
		q4.countSolutions();
		System.out.println("Count: " + q4.getSolutionCount());
		System.out.println(q4.toString());
		QueenBoard q5 = new QueenBoard(9);
		System.out.println(q5.solve());
		System.out.println(q5.toString());
		System.out.println("Count: " + q5.getSolutionCount());
		q5.countSolutions();
		System.out.println("Count: " + q5.getSolutionCount());
		System.out.println(q5.toString());
		/*QueenBoard q9 = new QueenBoard(9);
		System.out.println(q9.solve());
		System.out.println(q9.toString());
		System.out.println("Count: " + q9.getSolutionCount());
		q9.countSolutions();
		System.out.println("Count: " + q9.getSolutionCount());
		System.out.println(q9.toString());

		*/
	}
}
