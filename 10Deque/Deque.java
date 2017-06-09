import java.util.Arrays;
public class Deque{
	private String[] elements;
	private int size;

	public Deque(){
		elements = new String[10];
		size = 0;
	}

	public void addFirst(String n){
		if(n == null){
			throw new NullPointerException();
		}
		String[] temp;
		if(size == elements.length){
			temp = new String[elements.length * 2];
		}
		else{
			temp = new String[elements.length];
		}
		temp[0] = n;
		for(int i = 0; i < size; i++){
			temp[i + 1] = elements[i];
		}
		elements = temp;
		size++;
	}

	public void addLast(String n){
		if(n == null){
			throw new NullPointerException();
		}
		String[] temp;
		if(size == elements.length){
			temp = new String[elements.length * 2];
		}
		else{
			temp = new String[elements.length];
		}
		for(int i = 0; i < elements.length ; i++){
			temp[i] = elements[i];
		}
		temp[size] = n;
		elements = temp;
		size++;
	}

	public String removeFirst(){
		String[] temp;
		String hold = elements[0];
		if(size == elements.length / 2 + 1){
			temp = new String[elements.length / 2];
		}
		else{
			temp = new String[elements.length];
		}
		for(int i = 0; i < size - 1; i++){
			temp[i] = elements[i + 1];
		}
		elements = temp;
		size--;
		return hold;
	}

	public String removeLast(){
		String[] temp;
		String hold = elements[size - 1];
		if(size == elements.length / 2 + 1){
			temp = new String[elements.length / 2];
		}
		else{
			temp = new String[elements.length];
		}
		for(int i = 0; i < size - 1; i++){
			temp[i] = elements[i];
		}
		elements = temp;
		size--;
		return hold;
	}

	public String getFirst(){
		return elements[0];
	}

	public String getLast(){
		return elements[size - 1];
	}

	public String toString(){
		return Arrays.toString(elements);
	} 

	public static void main(String[] args){
		Deque x = new Deque();
		x.addFirst("xd");
		x.addFirst("a");
		x.addFirst("a");
		x.addFirst("c");
		x.addFirst("c");
		x.addFirst("c");
		x.addFirst("c");
		x.addFirst("c");
		x.addFirst("c");
		x.addFirst("c");
		x.addLast("d");
		System.out.println(x.removeFirst());
		System.out.println(x.removeLast());
		System.out.println(x.removeLast());
		System.out.println(x.removeLast());
		System.out.println(x.removeLast());
		System.out.println(x.removeLast());
		System.out.println(x.removeLast());

		

		System.out.println(x);

	}
}