import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);

		// 에라토스테네스의 체
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;

		for (int i = 2; i <= n; i++) {
			for (int j = i + i; j <= n; j += i) {
				visited[j] = true;
			}
		}

		// 소수 구하기
		for (int i = m; i <= n; i++) {
			if (!visited[i]) {
				answer.append(i).append("\n");
			}
		}
		System.out.println(answer);
	}
}