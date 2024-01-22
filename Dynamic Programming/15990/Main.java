import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int MAX_SIZE = 100_000;
	static final int MOD = 1_000_000_009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// dp 테이블 생성 및 초기화
		long[][] dp = new long[MAX_SIZE + 1][4];
		dp[1][1] = 1; // 1
		dp[2][2] = 1; // 2
		dp[3][1] = dp[3][2] = dp[3][3] = 1; // 2 + 1, 1 + 2, 3

		for (int i = 4; i <= MAX_SIZE; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
		}

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % MOD).append("\n");
		}
		System.out.println(sb);
	}
}