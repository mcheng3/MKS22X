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
	isMax = heapStatus;
    }
    
    private boolean pushUp(int index){
	while(index > 1 && heap.get(index).compareTo(heap.get(index/2)) > 0){
	    String temp = heap.get(index);
	    heap.set(index, heap.get(index/2));
	    heap.set(index/2, temp);
	    index /= 2;
	}
	return true;
    }
    
    private void pushDown(int index){
    }
    
    public void add(String s){
	heap.add(s);
	pushUp(heap.size() - 1);
    }

    public String toString(){
	String ans = "[";
	for(String element : heap){
	    ans += element + ", ";
	    }
	ans +=  "]";
	return ans;
    }
    public static void main(String[] args){
	MyHeap heap = new MyHeap();
	heap.add("wow");
	heap.add("a");
	heap.add("c");
	heap.add("d");
	heap.add("b");
	heap.add("zzz");
	System.out.println(heap);
    }
}	
