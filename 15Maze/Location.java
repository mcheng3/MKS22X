public class Location implements Comparable<Location>{
    private int distToGoal, distToStart;
    private boolean aStar;
    private int row, col;
    private Location previous;
    
    public Location(int r, int c, Location previous, int distToStart, int distToGoal){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	aStar = false;
    }

    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public int getDistToGoal(){
	return distToGoal;
    }

    public int getDistToStart(){
	return distToStart;
    }

    public int row(){
	return row;
    }

    public int col(){
	return col;
    }

    public Location previous(){
	return previous;
    }

    public int compareTo(Location other){
	if(aStar){
	    


    
