import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder log = new StringBuilder(); // 명령어 처리 결과
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] stack = new int[n];
		int top = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				stack[++top] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				log.append(isEmpty(top) == 1 ? -1 : stack[top--]).append("\n");
				break;
			case "size":
				log.append(top + 1).append("\n");
				break;
			case "empty":
				log.append(isEmpty(top)).append("\n");
				break;
			case "top":
				log.append(isEmpty(top) == 1 ? -1 : stack[top]).append("\n");
				break;
			}
		}

		System.out.println(log);
	}

	static int isEmpty(int top) {
		return top == -1 ? 1 : 0;
	}
}