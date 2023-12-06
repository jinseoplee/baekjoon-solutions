import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] stack = new int[1000001];
	static int top = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		int result = 0;
		while (t-- > 0) {
			String[] op = br.readLine().split(" ");
			switch (op[0]) {
			case "1":
				stack[++top] = Integer.parseInt(op[1]);
				break;
			case "2":
				if (top == -1) result = -1;
				else result = stack[top--];
				break;
			case "3":
				result = top + 1;
				break;
			case "4":
				if (top == -1) result = 1;
				else result = 0;
				break;
			case "5":
				if (top == -1) result = -1;
				else result = stack[top];
				break;
			}

			if (!op[0].equals("1")) answer.append(result).append("\n");
		}
		System.out.println(answer);
	}
}