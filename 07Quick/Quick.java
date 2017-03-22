import java.util.*;

public class Quick{
    public static int[] part(int[] data, int start, int end){
	
      
	int random = (int)(Math.random() * (end - start -1 ) + start + 1);
	//System.out.println(random);
	int pivot = data[random];
	//System.out.println(pivot);
	data = swap(data, start, random);
	int i = start + 1;
        int lt = start;
	int gt = end;
	while(i <= gt){
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
	int[] val = {lt, gt};
	return val;
	
	
    }
    
    private static void quicksortHelper(int[] a, int start, int end){
	if(end - start <= 1) return;
	else{
	    int[] result = part(a, start, end);
	    quicksortHelper(a, start, result[0]);
	    quicksortHelper(a, result[1], end);
	}
    }

    public static void quicksort(int[] a){
	quicksortHelper(a, 0, a.length - 1);
    }

    public static int quickselectHelper(int[] a , int start, int end, int k){
	if(k > 0 && k <= end - start + 1){
		int[] pivots = part(a, start, end);
		if(pivots[0] - start <= k - 1  && k - 1  <= pivots[1] - start) return a[pivots[0]];
		if(pivots[0] - start > k - 1 ) return quickselectHelper(a, start, pivots[0] - 1, k);
		else return quickselectHelper(a, pivots[1] + 1, end, k-pivots[1] + start - 1);
	}
	return -1;
    }

    private static int quickselect(int[] a, int k){
    	if(k > a.length) throw new IndexOutOfBoundsException();
    	int[] copy = a;
		return quickselectHelper(copy, 0, a.length - 1, k);
    }

    
 
    

    private static int[] swap(int[] a, int i, int j){
	int hold = a[i];
	a[i] = a[j];
	a[j] = hold;
	return a;
    }

    public static void main(String[] args){
	int[] data = {999,999, 999, 4, 3, 2, 1, 0, 55, 999, 999, 999, 999, 999, 999, 999, 55, 55, 55, 654 ,6546,54654,6612 ,135,546,4354,384,384};
	System.out.println(quickselect(data, 10));
	int[] a = new int[100];
	for(int i = 1; i < a.length; i++){
	    a[i -1] = i;
	}
	System.out.println(Arrays.toString(a));
	System.out.println(quickselect(a, 24));
	quicksort(data);
	//System.out.println(Arrays.toString(data));
	quicksort(a);
	//System.out.println(Arrays.toString(a));
    }
}
