public class Row{
	private int[][] board;
	private int solutionCount;
	
	public Row(int n){
		board = new int[n][n];
	}

	public boolean solve(){
		return solveHelper(0); 

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
		System.out.println("Add\n" + toString());
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
		System.out.println("Remove\n" + toString());
	}

	public String toString(){
		String ary = "";
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board.length; c ++){
				ary += board[r][c] + " ";
			}
			ary += "\n";
		}
		return ary;
	}

	public static void main(String[] args){
		Row q = new Row(4);
		System.out.println(q.solve());
		System.out.println(q.toString());

	}
}
