import java.util.*;
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
	Frontier front;
	ArrayList visited = new ArrayList();
	if(style = 0){
            front = new StackFrontier();
        }
        if(style = 1){
            front = new QueueFrontier();
	    front.add(board.getStart());
	    Location current = board.getStart());
	    while(current != board.getEnd()){

	}
		
	    
        }
        if(style = 2){
            front = new PriorityQueueFrontier();
        }
        if(style = 3){
            front = new PriorityQueueFrontier();
        }
    }

    public String toString(){
	return board.toString();
    }
}


