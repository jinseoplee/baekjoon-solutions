import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1]; // dp 테이블
		int[] arr = new int[n + 1]; // 경로를 저장하는 배열

		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			arr[i] = i - 1;

			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				arr[i] = i / 3;
			}

			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				arr[i] = i / 2;
			}
		}

		// 결과 출력
		sb.append(dp[n]).append("\n");
		while (n > 0) {
			sb.append(n).append(" ");
			n = arr[n];
		}
		System.out.println(sb);
	}
}