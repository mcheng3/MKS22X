import java.util.*;

public class Quick{
    public static int part(int[] data, int start, int end){
	int random = (int)(Math.random() * (end - start -1 ) + start + 1);
	System.out.println(random);
	int pivot = data[random];
	System.out.println(pivot);
	data = swap(data, start, random);
	int i = start + 1;
        int lt = start;
	int gt = end;
	while(i <= gt){
	    /*
	    while(data[start] < pivot) start++;
	    while(data[end] > pivot) end--;
	    if( start <= end){
		data = swap(data, start, end);
		start++;
		end--;
	    }*/
	    if(data[i] == pivot) i++;
	    else if(data[i] < pivot){
		data = swap(data, i, lt);
		lt++;
		i++;
	    }
	    else{
		data = swap(data, i, gt);
		gt--;
	    }
	}
	System.out.println(Arrays.toString(data));
	return pivot;
	
    }

    private static int[] swap(int[] a, int i, int j){
	int hold = a[i];
	a[i] = a[j];
	a[j] = hold;
	return a;
    }

    public static void main(String[] args){
	int[] data = {5, 4, 3, 2, 1, 0, 55, 999, 999, 999, 999, 999, 999, 999, 55, 55, 55};
	System.out.println(part(data, 0, data.length - 1));
    }
}
