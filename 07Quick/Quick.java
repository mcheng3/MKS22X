import java.util.*;

public class Quick{
    public static int part(int[] data, int start, int end){
	int random = (int)(Math.random() * (end - start -1 ) + start + 1);
	System.out.println(random);
	int pivot = data[random];
	while(start <= end){
	    while(data[start] < pivot) start++;
	    while(data[end] > pivot) end++;
	    if( start <= end){
		int hold = data[start++];
		data[start++] = data[end--];
		data[end--] = hold;
	    }
	}
	System.out.println(Arrays.toString(data));
	return pivot;
	
    }
    public static void main(String[] args){
	int[] data = {5, 4, 3, 2, 1, 0};
	System.out.println(part(data, 0, 3));
    }
}
