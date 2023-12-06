import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			char[] ps = br.readLine().toCharArray();
			int top = -1;

			for (int i = 0; i < ps.length; i++) {
				if (ps[i] == '(') {
					++top;
					continue;
				}
				if (--top < -1) break;
			}

			// 스택이 비어있을 경우
			if (top == -1) {
				answer.append("YES\n");
			}
			// 스택이 비어있지 않을 경우
			else {
				answer.append("NO\n");
			}
		}

		System.out.println(answer);
	}
}