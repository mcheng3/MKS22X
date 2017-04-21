public class Postfix{
	
	public int eval(String eq){
		String[] ary = eq.split(" ");
		Stack s = new Stack();
		for(int i = 0; i < ary.length; i++){
			String c = ary[i];
			if(isOperation(c)){
				s.push(applyOperation(operation, s.pop(), s.pop()));
			}
			else{
				s.push(c);
			}
		}
	}

}
