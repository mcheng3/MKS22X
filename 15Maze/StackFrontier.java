import java.util.Stack;
public class StackFrontier implements Frontier{
	
	private Stack<Location> locations;

	public FrontierStack(){
		locations = new Stack<Location>();
	}

	public void add(Location n){
		locations.push(n);
	}

	public Location next(){
		return locations.pop();
	}

}
