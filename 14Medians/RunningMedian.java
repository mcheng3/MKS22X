import java.util.*;

public class RunningMedian{
	private double median = 0;
	private MyHeap left;
	private MyHeap right;

	public RunningMedian(){
		left = new MyHeap(true);
		right = new MyHeap(false); 
	}

	private double mediate(){
		if(left.size() > right.size()){
			return left.peek();
		}
		else if(left.size() < right.size()){
			return right.peek();
		}
		else{
			return((left.peek() + right.peek())/2.0);
		}
	}

	public void add(int n){
		if(n > median){
			right.add(n);
			if(right.size() > left.size() + 1){
				left.add(right.remove());
			}
		}

		else{
			left.add(n);
			if(left.size() > right.size() + 1){
				right.add(left.remove());
			}
		}

		median = mediate();
	}

	public double getMedian(){
		//System.out.println(left + " " + right);
		return median;
	}

	public static void main(String[] args){
		RunningMedian a = new RunningMedian();
	for (int i = 0; i < 10; i ++) {
	    a.add(new Integer(i));
	    System.out.println("" + i + " " + a.getMedian());
	}
	}


}