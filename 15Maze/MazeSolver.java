public class MazeSolver{
    private Maze board;
    private boolean animate;
    private String filename;

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
    }

    public String toString(){
	return board.toString();
    }
}

  
