import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
	String file = "";
	try{
	    Scanner s = new Scanner(new File(filename));
	    String line = "";
	    int numberOfRows = 0;
	    while (s.hasNextLine()){
		line = s.nextLine();
		file += "\n" + line;
		numberOfRows++;
		
	    }
	    //System.out.println(line.length());
	    maze = new char[numberOfRows][line.length()];
	    s.close();
	}
	catch (Exception e){
	    System.out.println("File not found.");
	}
	//System.out.println(file);

	int charCount = 0;

	for(int r = 0; r<maze.length; r++){
	    for(int c = 0; c<maze[0].length; c++){
		if(file.charAt(charCount) == '\n') charCount++;

			maze[r][c] = file.charAt(charCount);
			charCount++;
	

	    }
	}
	
	/*for(int r = 0; r<maze.length; r++){
		for(int c = 0; c<maze[0].length; c++){
			System.out.print(maze[r][c]);
		}
		System.out.println();
	}*/	
	//System.out.println(Arrays.deepToString(maze));
	//    
    }

    
    
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;
            boolean notFound = true;
            for(int r = 0; r<maze.length && notFound; r++){
				for(int c = 0; c<maze[0].length; c++){
					if(maze[r][c] == 'S'){
						startr = r;
						startc = c;
						notFound = false;
					}
				}
			}
			//System.out.println(startr);
			//System.out.println(startc);
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
        	clearTerminal();
            System.out.println("\033[2J\033[1;1H"+this);
            for(int r = 0; r<maze.length; r++){
		for(int c = 0; c<maze[0].length; c++){
			System.out.print(maze[r][c]);
		}
		System.out.println();
	}	
            wait(20);
        }
        if(maze[row][col] == 'E') return true;
        if(maze[row][col] != '#' && maze[row][col] != '@'){
        	maze[row][col] = '@';
        	if(solve(row + 1, col)||
        		solve(row - 1, col)||
        		solve(row, col + 1)||
        		solve(row, col -1)){

        		return true;
        	}
        	maze[row][col] = '.';
        }

        //COMPLETE SOLVE
        return false; //so it compiles
    }

    public static void main(String[] args){
	Maze m = new Maze("data1.dat");
	Maze m2 = new Maze("data2.dat");
	Maze m3 = new Maze("data3.dat");
	m.setAnimate(true);
	m.solve();
	m2.setAnimate(true);
	m2.solve();
	m3.setAnimate(true);
	m3.solve();
    }
}
