import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX_SIZE = 123456;
	static boolean[] visited = new boolean[MAX_SIZE * 2 + 1];

	static void findPrimeNums() {
		for (int i = 2; i <= MAX_SIZE * 2; i++) {
			for (int j = i + i; j <= MAX_SIZE * 2; j += i) {
				visited[j] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		// 소수를 찾는다.
		findPrimeNums();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			int cnt = 0; // 소수의 개수
			for (int i = n + 1; i <= 2 * n; i++) {
				if (!visited[i])
					cnt++;
			}
			answer.append(cnt).append("\n");
		}
		System.out.println(answer);
	}
}