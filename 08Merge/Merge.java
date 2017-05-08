import java.util.*;
public class Merge{

	public static void mergesort(int[] ary){
		int[]  temp = mergesortHelper(ary);
		for(int i = 0; i<ary.length; i ++){
			ary[i] = temp[i];
		}
	}
	private static int[] mergesortHelper(int[] ary){
		//System.out.println(Arrays.toString(ary));
		if(ary.length <= 1) return ary;
		else{
			int[] left = new int[ary.length/2];
			int[] right = new int[ary.length - ary.length/2];
			for(int i = 0; i<left.length; i++){
				left[i] = ary[i];
			}
			for(int i = 0; i<right.length; i++){
				right[i] = ary[i + ary.length / 2];
			}

			return merge(mergesortHelper(left), mergesortHelper(right));

		}
	}

	private static int[] merge(int[] left, int[] right){
		int[] ary = new int[left.length + right.length];
		int a = 0;
		int b = 0;
		for(int i = 0; i < ary.length; i++){
			if(a >= left.length){
				ary[i] = right[b++];
			}
			else if(b >= right.length){
				ary[i] = left[a++];
			}
			else if(left[a] <= right[b]){
				ary[i] = left[a++];
			}
			else{
				ary[i] = right[b++];
			}

		}
		return ary;
	}

	public static void main(String[] args){
		int[] a = new int[100];
		for(int i = 0; i < a.length; i++){
	    	a[i] = (int)(Math.random()*100);
		}
		System.out.println(Arrays.toString(a));
		mergesort(a);
		System.out.println(Arrays.toString(a));
	}
}

