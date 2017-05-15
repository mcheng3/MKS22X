import java.util.PriorityQueue;
public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue<Location> locations;

    public void add (Location n){
	locations.add(n);
    }

    public Location next(){
	return locations.peek();
    }
}
