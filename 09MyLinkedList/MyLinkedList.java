import java.util.Iterator;
import java.util.NoSuchElementException;
public class MyLinkedList<T> implements Iterable<Integer>{
	public class LNode{
		int value;
		LNode next;
		LNode prev;
		public LNode(){}

		public LNode(int value){
			this.value = value;
		}

		public LNode(int value, LNode next, LNode prev){
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

		public String toString(){
			return value + "";
		}

	}

	LNode head,tail;
	int size;

	public MyLinkedList(){
	}

	public Iterator<Integer> iterator(){
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements Iterator<Integer>{
		private LNode current;
		public MyLinkedListIterator(){
			current = MyLinkedList.this.head;
		}

		public boolean hasNext(){
			return current != null;
		}

		public Integer next(){
			if(this.hasNext()){
				int x = current.value;
				current = current.next;
				return x;
			}
			throw new NoSuchElementException();
		}

		public void remove(){
			throw new UnsupportedOperationException();
		}
	}


	public int size(){
		return size;
	}

	private LNode getNthNode(int n){
		if(n > size - 1 || n < 0){
			throw new IndexOutOfBoundsException();
		}
		else{
			LNode current = head;
			for(int i = 0; i < n; i++){
				current = current.next;
			}
			return current;
		}
	}



	public boolean add(int value){
		LNode n = new LNode(value, null, tail);
		if(tail != null) tail.next = n;
		tail = n;
		if(head == null) head = n;
		size++;
		return true;
	}

	public int get(int index){
		return getNthNode(index).value;
	}

	public int set(int index, int value){
		if(index >= size) throw new IndexOutOfBoundsException();
		else{
			int temp = getNthNode(index).value;
			getNthNode(index).value = value;
			return temp;
		}
	}

	public int indexOf(int value){
		for(int i = 0; i < size; i++){
			if(get(i) == value) return i;
		}
		return -1;
	}

	public int remove(int index){
		LNode n = getNthNode(index);
		int temp = n.value;
		if(n.prev != null){
			n.prev.next = n.next;
		}
		else head = n.next;
		if(n.next != null) n.next.prev = n.prev;
		else tail = n.prev;
		size--;
		return temp;
	}

	public void add(int index, int value){
		LNode temp = getNthNode(index);
		LNode n = new LNode(value);
		if(temp != head) temp.prev.next = n;
		else head = n;
		n.prev = temp.prev;
		temp.prev = n;
		n.next = temp; 
		size++;
	}

	public String toString(){
		LNode current = head;
		String ans = "[";
		//System.out.println(current.value);
		for(int i = 0; i < size; i++){
			String p = "null";
			String n = "null";
			if(current.prev != null) p = current.prev.value + "";
			if(current.next != null) n = current.next.value + "";
			ans += "(" + p + ")" +  current.value + "(" + n + ")" + ", " ;
			current = current.next;
		}
		return ans + "]";
	}


	public static void main(String[] args){
		MyLinkedList<Integer> x = new MyLinkedList<Integer>();
		x.add(5);
		x.add(2);
		x.add(10);
		x.add(9999);
		System.out.println(x.toString());
		System.out.println(x.get(0));
		System.out.println(x.get(1));
		System.out.println(x.get(2));
		System.out.println(x.get(3));
		for(Integer i : x){
			System.out.println(i);
		}
		System.out.println(x.toString());
		x.remove(2);
		System.out.println(x.toString());
		System.out.println(x.indexOf(6));
		x.remove(2);
		System.out.println(x.toString());
		System.out.println(x.set(0, 9123232));
		System.out.println(x.toString());
		x.add(1, 3);
		System.out.println(x.toString());
		//System.out.println(x.getNthNode(4).toString());	
		
	}
}


