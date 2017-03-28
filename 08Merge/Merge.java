public class Merge{
    public void mergesort(int[] ary){
	if(ary.length <= 1) return;
	else{
	    int i = 0;
	    int[]left = new int[ary.length/2];
	    for(; i<ary.length / 2; i++){
		left[i] = ary[i];
	    }
	    for(; i<ary.length; i++){

	    mergesort(ary.length / 2);
	    megesort(
