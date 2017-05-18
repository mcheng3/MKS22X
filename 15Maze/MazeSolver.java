public class MazeSolver{
	private Maze board;
	private boolean animate;
	private String filename;
	private Frontier front;

	public MazeSolver(String filename){
		this(filename, false);
	}

	public MazeSolver(String filename, boolean animate){
		this.filename = filename;
		this.animate = animate;
	}

	public void solve(){
		solve(1);
	}

	public void solve(int style){
		if(style = 0){
            front = new FrontierStack();
        }
        if(style = 1){
            //front = new FrontierQueue();
        }
        if(style = 2){
            front = new FrontierPriorityQueue();
        }
        if(style = 3){
            front = new FrontierStack();
        }
	}

	public String toString(){
		return board.toString();
	}
}


