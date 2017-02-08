public class Recursion{
	public static String name(){
		return "Cheng,Michael";
	}
	public static double sqrt(double n){
		if(n < 0){
			throw new IllegalArgumentException("Input cannot be negative");
		}
		return sqrtGuess(n, n/2);
	}
	public static double sqrtGuess(double n, double guess){
		if(Math.abs(guess * guess - n) <= n * 0.00000000000001){
			return guess;
		}
		else{
			double betterGuess = ((n / guess + guess) / 2);
			return sqrtGuess(n, betterGuess);
		}
	}

	public static void main(String[] args){
		System.out.println(name());
		System.out.println(sqrt(0));
		System.out.println(sqrt(100));
		System.out.println(sqrt(2));
		//System.out.println(sqrt(-64));
		System.out.println(sqrt(64));
		System.out.println(sqrt(100003.2));
		System.out.println(sqrt(123.49921*123.49921));
		System.out.println(sqrt(990123412341234003.212341234));
		System.out.println(sqrt(-990123412341234003.212341234));
	}
}