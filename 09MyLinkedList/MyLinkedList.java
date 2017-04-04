public class MyLinkedList{
    public class LNode{
	int value;
	LNode next;
	LNode prev;

	private LNode(int value){
	    this.value = value;
	    
	}

	private LNode(int value, LNode next, LNode prev){
	    this.value = value;
	    this.next = next;
	    this.prev = prev;
	    next.prev = this;
	    prev.next = this;
	}
	
    }

    private LNode start;
    private int size;

    public MyLinkedList(int size){
	this.size = size;
	start = new LNode(0);
	LNode current = start.next;
        for(int i = 0; i < size; i++){
	    current = new LNode(0, current.next, current.prev);
	    current = current.next;
	}
    }
  
    public boolean add(int value){
	start.value = value;
	return true;
    }

    public String toString(){
	LNode current = start;
        String ans = "[";
	System.out.println(current.value);
	for(int i = 0; i < size - 1; i++){
	    ans += current.value + ", ";
	    current = current.next;
	}
	ans += current.value + "]";
	return ans;
    }
	    

    public static void main(String[] args){
	MyLinkedList x = new MyLinkedList(3);
	x.add(5);
	System.out.println(x.toString());
    }
}
	

