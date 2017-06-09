import java.util.Stack;
public class StackCalc{
	
	public static double eval(String eq){
		String[] ary = eq.split(" ");
		Stack<Double> s = new Stack<Double>();
		for(int i = 0; i < ary.length; i++){
			String c = ary[i];
			if(isOperation(c)){
				s.push(applyOperation(c, s.pop(), s.pop()));
			}
			else{
				s.push(Double.parseDouble(c));
			}
		}
		double ans = s.pop();
		return ans;
	}

	private static boolean isOperation(String character){
		if(character.charAt(0) >= '0' && character.charAt(0) <='9'){
			//System.out.println(character);
			return false;
		}
		else return true;
	}

	private static double applyOperation(String op, double num2, double num1){
		double result = 0.0;
		switch (op) {
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "*":
					result = num1 * num2;
					break;
				case "/":
					result = num1 / num2;
					break;
				case "%":
					result = num1 % num2;
					break;
		}
		//System.out.println("result: " + result);
		return result;
	}

	public static void main(String[] args){

	}
}
