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

    public static int quickselect(int[]a , int k){
	for(int i = 0, i <= k){
	    part(a, 0, a.lenth - 1);
	}
    }
    
    private static int quick
    

    private static int[] swap(int[] a, int i, int j){
	int hold = a[i];
	a[i] = a[j];
	a[j] = hold;
	return a;
    }

    public static void main(String[] args){
	int[] data = {999,999, 999, 4, 3, 2, 1, 0, 55, 999, 999, 999, 999, 999, 999, 999, 55, 55, 55, 654 ,6546,54654,6612 ,135,546,4354,384,384};
	quicksort(data);
	System.out.println(Arrays.toString(data));
    }
}
