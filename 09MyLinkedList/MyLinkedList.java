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
	}
	
    }

    private LNode start;
    private int size;

    public MyLinkedList(int size){
	this.size = size;
	start = new LNode(0);
	LNode current = start;
        for(int i = 0; i < size; i++){
	    current.next = new LNode(0, null, current);
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
	    String p = "null";
	    String n = "null";
	    if(current.prev != null) p = Integer.toString(current.prev.value);
	    if(current.next != null) p = Integer.toString(current.next.value);
	    ans += "(" + p + ")" +  current.value + "(" + n + ")" + ", " ;
	    current = current.next;
	}
	ans += "(" + current.prev.value  + ")"+ current.value +"(" + "null"  + ")" + "]";
	return ans;
    }
	    

    public static void main(String[] args){
	MyLinkedList x = new MyLinkedList(3);
	x.add(5);
	System.out.println(x.toString());

    }
}
	

