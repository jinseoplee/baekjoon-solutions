import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] stack = new int[k];
		int sum = 0;

		for (int top = -1, i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				sum -= stack[top--];
				continue;
			}
			stack[++top] = n;
			sum += n;
		}

		System.out.println(sum);
	}
}