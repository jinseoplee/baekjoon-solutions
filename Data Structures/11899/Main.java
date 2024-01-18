import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		char[] str = br.readLine().toCharArray();
		for (char ch : str) {
			if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		System.out.println(stack.size());
	}
}