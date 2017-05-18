import java.util.*;

public class MyHeap{
	private ArrayList<String> heap;
	private boolean isMax;

	public MyHeap(){
		heap = new ArrayList<String>();
		heap.add("null");
		isMax = true;
	}
	
	public MyHeap(boolean heapStatus){
		heap = new ArrayList<String>();
		isMax = heapStatus;
		heap.add("null");
	}
	
	private boolean pushUp(int index){
		while(index > 1 && heap.get(index).compareTo(heap.get(index/2)) > 0 && isMax){
			String temp = heap.get(index);
			heap.set(index, heap.get(index/2));
			heap.set(index/2, temp);
			index /= 2;
		}
		while(index > 1 && heap.get(index).compareTo(heap.get(index/2)) < 0 && !isMax){
			String temp = heap.get(index);
			heap.set(index, heap.get(index/2));
			heap.set(index/2, temp);
			index /= 2;
		}
		return true;
	}
	
	private boolean pushDown(int index){
		while(index * 2 < heap.size() && isMax){
			int child = index * 2;
			if(index * 2 + 1 < heap.size()  && heap.get(index * 2 + 1).compareTo(heap.get(index * 2)) > 0){
				child = index * 2 + 1;
			}
			if(heap.get(child).compareTo(heap.get(index)) > 0) {
				String temp = heap.get(child);
				heap.set(child, heap.get(index));
				heap.set(index, temp);
				index = child;
			}
			else{
				index = heap.size() ;
			}
		}
		while(index * 2 < heap.size() && !isMax){
			int child = index * 2;
			if(index * 2 + 1 < heap.size() && heap.get(index * 2 + 1).compareTo(heap.get(index * 2)) < 0) {
				child = index * 2 + 1;
			}
			if(heap.get(child).compareTo(heap.get(index)) < 0) {
				String temp = heap.get(child);
				heap.set(child, heap.get(index));
				heap.set(index, temp);
				index = child;
			}
			else{
				index = heap.size();
			}
		}
		return true;
	}
	
	public void add(String s){
		heap.add(s);
		pushUp(heap.size() - 1);
	}

	public String remove(){
		String temp = heap.get(1);
		heap.set(1, heap.remove(heap.size() - 1));
		pushDown(1);
		return temp;
	}

	public String peek(){
		return heap.get(1);
	}

	public String toString(){
		return(Arrays.toString(heap.toArray()));
	}
	public static void main(String[] args){
		MyHeap heap = new MyHeap(false);
		heap.add("wow");
		heap.add("a");
		heap.add("c");
		heap.add("d");
		heap.add("b");
		heap.add("zzz");
		heap.remove();
		heap.remove();
		System.out.println(heap);
	}
}	
