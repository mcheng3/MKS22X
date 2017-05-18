public class QueueFrontier implements Frontier{
    Queue locations = new Queue<Location>();
   
    public void add(Location n){
	locations.add(n);
    }
    public Location next(){
	return locations.poll();
    }

}
