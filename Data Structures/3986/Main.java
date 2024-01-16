import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0; // 좋은 단어의 수
		int n = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		while (n-- > 0) {
			char[] word = br.readLine().toCharArray();
			for (int i = 0; i < word.length; i++) {
				if (stack.isEmpty() || stack.peek() != word[i]) {
					stack.push(word[i]);
				} else {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				count++;
			}
			stack.clear();
		}
		System.out.println(count);
	}
}