import java.lang.Math;
public class Recursion{
	public static String name(){
		return "Cheng,Michael";
	}
	public static double sqrt(double n){
		return sqrtGuess(n, n/2);
	}
	public static double sqrtGuess(double n, double guess){
		if(Math.abs(guess * guess- n) < 0.001){
			return guess;
		}
		else{
			double betterGuess = ((n / guess + guess) / 2);
			return sqrtGuess(n, betterGuess);
		}
	}

	public static void main(String[] args){
		System.out.println(name());
		System.out.println(sqrt(100));
	}
}