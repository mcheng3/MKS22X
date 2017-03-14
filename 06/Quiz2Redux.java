import java.util.*;
public class Quiz2Redux{  
	/*Returns an ArrayList<String> that contains all subsets of the
	 *characters of String s. Assume s has no duplicate characters.
	 *the characters should appear in the same order that they occur 
	 *in the original string.
	 */
	public static ArrayList<String> combinations(String s){
			ArrayList<String>words = new ArrayList<String>();
			words.add("");
			help( words , s, 0);
			Collections.sort(words);
			return words;
	}
	
	private static void help( ArrayList<String> words, String s, int position){
		if(position == s.length()) return;
		else{
			int size = words.size();
			for(int i = 0; i < size; i++){
				words.add(words.get(i) + s.charAt(position));
			}
			help(words, s, position + 1);
		}
	}

	public static void main(String[] args){
		System.out.println(Arrays.toString(combinations("abcd").toArray()));
		System.out.println(Arrays.toString(combinations("").toArray()));
		System.out.println(Arrays.toString(combinations("a").toArray()));
		System.out.println(Arrays.toString(combinations("fdswpioj").toArray()));
		System.out.println(Arrays.toString(combinations("abc").toArray()));
	}
}
