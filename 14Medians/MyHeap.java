import java.util.*;

public class MyHeap{
	private ArrayList<Integer> heap;
	private boolean isMax;
	private int size = 0;

	public MyHeap(){
		heap = new ArrayList<Integer>();
		heap.add(0);
		isMax = true;
	}
	
	public MyHeap(boolean heapStatus){
		heap = new ArrayList<Integer>();
		isMax = heapStatus;
		heap.add(0);
	}
	
	private boolean pushUp(int index){
		while(index > 1 && heap.get(index) > heap.get(index/2) && isMax){
			int temp = heap.get(index);
			heap.set(index, heap.get(index/2));
			heap.set(index/2, temp);
			index /= 2;
		}
		while(index > 1 && heap.get(index) < heap.get(index/2) && !isMax){
			int temp = heap.get(index);
			heap.set(index, heap.get(index/2));
			heap.set(index/2, temp);
			index /= 2;
		}
		return true;
	}
	
	private boolean pushDown(int index){
	    int child = index * 2;
	    while(index * 2 < heap.size() && isMax){
		if(index * 2 + 1 < heap.size()  && heap.get(index * 2 + 1) > heap.get(index * 2)){
		    child = index * 2 + 1;
		}
		if(heap.get(child) > heap.get(index)){
		    int temp = heap.get(child);
		    heap.set(child, heap.get(index));
		    heap.set(index, temp);
		}
		else{
		    index = heap.size() ;
		}
	    }
	    while(index * 2 < heap.size() && !isMax){
		if(index * 2 + 1 < heap.size() && heap.get(index * 2 + 1) < heap.get(index * 2)){
		    child = index * 2 + 1;
		}
		if(heap.get(child) < heap.get(index)){
		    int temp = heap.get(child);
		    heap.set(child, heap.get(index));
		    heap.set(index, temp);
		}
		else{
		    index = heap.size() ;
		}
	    }
	    return true;
	}

	public int size(){
		return size;
	}
	
	public void add(int s){
		heap.add(s);
		pushUp(heap.size() - 1);
		size++;
	}

	public int remove(){
		int temp = heap.get(1);
		heap.set(1, heap.remove(heap.size() - 1));
		pushDown(1);
		size--;
		return temp;	
	}

	public int peek(){
		return heap.get(1);
	}

	public String toString(){
		return(Arrays.toString(heap.toArray()));
	}
	public static void main(String[] args){
		MyHeap heap = new MyHeap(false);
		heap.add(1);
		heap.add(0);
		heap.add(4);
		heap.add(100);
		heap.add(-4);
		heap.add(3);
		heap.remove();
		heap.remove();
		System.out.println(heap);
	}
}	
